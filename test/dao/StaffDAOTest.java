/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Staff;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Admin
 */
public class StaffDAOTest {

    private StaffDAO staffDAO;
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction tx;

    public StaffDAOTest() {
    }

    @Before
    public void setUp() {
        sessionFactory = mock(SessionFactory.class);
        session = mock(Session.class);
        tx = mock(Transaction.class);

        when(sessionFactory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(tx);

        HibernateUtil.setSessionFactory(sessionFactory);
        staffDAO = new StaffDAO();
    }

    @After
    public void tearDown() {
        HibernateUtil.setSessionFactory(null);
    }

    /**
     * Test of saveStaff method, of class StaffDAO.
     */
    @Test
    public void testSaveStaff() {
        Staff staff = new Staff();

        staffDAO.saveStaff(staff);
        verify(session).save(staff);
        verify(tx).commit();
    }

    @Test
    public void testSaveStaffException() {
        System.out.println("saveStaffException");
        doThrow(new RuntimeException("Error")).when(session).save(any(Staff.class));

        Staff staff = new Staff();

        staffDAO.saveStaff(staff);
        verify(tx).rollback();
    }

    /**
     * Test of updateStaff method, of class StaffDAO.
     */
    @Test
    public void testUpdateStaff() {
        System.out.println("updateStaff");
        Staff staff = new Staff();
        staff.setStaffId(1);

        staffDAO.updateStaff(staff);
        verify(session).merge(staff);
        verify(tx).commit();
    }

    @Test
    public void testUpdateStaffException() {
        doThrow(new RuntimeException("Error")).when(session).merge(any(Staff.class));

        Staff staff = new Staff();

        staffDAO.updateStaff(staff);
        verify(tx).rollback();
    }

    /**
     * Test of getAllStaff method, of class StaffDAO.
     */
    @Test
    public void testGetAllStaff() {
        System.out.println("getAllStaff");
        List<Staff> expStaff = new ArrayList<>();
        expStaff.add(new Staff());

        Criteria criteria = mock(Criteria.class);
        when(session.createCriteria(Staff.class)).thenReturn(criteria);
        when(criteria.list()).thenReturn(expStaff);

        List<Staff> result = staffDAO.getAllStaff();
        assertEquals(expStaff, result);
    }

    @Test
    public void testGetAllStaffException() {
        when(session.createCriteria(Staff.class)).thenThrow(new RuntimeException("Error"));

        List<Staff> result = staffDAO.getAllStaff();
        assertEquals(null, result);
    }

    /**
     * Test of getStaffByName method, of class StaffDAO.
     */
    @Test
    public void testGetStaffByName() {
        System.out.println("getStaffByName");
        List<Staff> expStaff = new ArrayList<>();
        expStaff.add(new Staff());

        Query mockQuery = mock(Query.class);
        when(session.createQuery("from Staff where lastName like :lastName")).thenReturn(mockQuery);
        when(mockQuery.setParameter("lastName", "%test%")).thenReturn(mockQuery);
        when(mockQuery.list()).thenReturn(expStaff);

        List<Staff> result = staffDAO.getStaffByName("test");
        assertEquals(expStaff, result);
    }

    @Test
    public void testGetStaffByNameException() {
        System.out.println("getStaffByName");
        when(session.createQuery("from Staff where lastName like :lastName")).thenThrow(new RuntimeException("Error"));

        List<Staff> result = staffDAO.getStaffByName("test");
        assertEquals(null, result);
    }

    /**
     * Test of deleteStaff method, of class StaffDAO.
     */
    @Test
    public void testDeleteStaff() {
        System.out.println("deleteStaff");
        Staff staff = new Staff();
        staff.setStaffId(1);

        when(session.get(Staff.class, 1)).thenReturn(staff);

        staffDAO.deleteStaff(1);

        verify(session).delete(staff);
        verify(tx).commit();
    }

    @Test
    public void testDeleteStaffException() {
        System.out.println("deleteStaffException");
        Staff staff = new Staff();
        staff.setStaffId(1);

        when(session.get(Staff.class, 1)).thenThrow(new RuntimeException("Error"));

        staffDAO.deleteStaff(1);
        verify(tx).rollback();
    }
}
