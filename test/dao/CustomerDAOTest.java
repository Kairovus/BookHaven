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
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
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
public class CustomerDAOTest {

    private CustomerDAO customerDAO;
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction tx;

    public CustomerDAOTest() {
    }

    @Before
    public void setUp() {
        sessionFactory = mock(SessionFactory.class);
        session = mock(Session.class);
        tx = mock(Transaction.class);

        when(sessionFactory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(tx);

        HibernateUtil.setSessionFactory(sessionFactory);
        customerDAO = new CustomerDAO();
    }

    @After
    public void tearDown() {
        HibernateUtil.setSessionFactory(null);
    }

    /**
     * Test of saveCustomer method, of class CustomerDAO.
     */
    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer();

        customerDAO.saveCustomer(customer);
        verify(session).save(customer);
        verify(tx).commit();
    }

    @Test
    public void testSaveCustomerException() {
        doThrow(new RuntimeException("Error")).when(session).save(any(Customer.class));

        Customer customer = new Customer();

        customerDAO.saveCustomer(customer);
        verify(tx).rollback();
    }

    /**
     * Test of updateCustomer method, of class CustomerDAO.
     */
    @Test
    public void testUpdateCustomer() {
        System.out.println("updateCustomer");
        Customer customer = new Customer();
        customer.setCustomerId(1);

        customerDAO.updateCustomer(customer);
        verify(session).merge(customer);
        verify(tx).commit();
    }

    @Test
    public void testUpdateCustomerException() {
        doThrow(new RuntimeException("Error")).when(session).merge(any(Customer.class));

        Customer customer = new Customer();

        customerDAO.updateCustomer(customer);
        verify(tx).rollback();
    }

    /**
     * Test of getAllCustomers method, of class CustomerDAO.
     */
    @Test
    public void testGetAllCustomers() {
        System.out.println("getAllCustomers");
        List<Customer> expCustomer = new ArrayList<>();
        expCustomer.add(new Customer());

        Criteria criteria = mock(Criteria.class);
        when(session.createCriteria(Customer.class)).thenReturn(criteria);
        when(criteria.list()).thenReturn(expCustomer);

        List<Customer> result = customerDAO.getAllCustomers();
        assertEquals(expCustomer, result);
    }

    @Test
    public void testGetAllCustomersException() {
        System.out.println("getAllCustomers");
        when(session.createCriteria(Customer.class)).thenThrow(new RuntimeException("Error"));

        List<Customer> result = customerDAO.getAllCustomers();
        assertEquals(null, result);
    }

    /**
     * Test of getCustomerByName method, of class CustomerDAO.
     */
    @Test
    public void testGetCustomerByName() {
        System.out.println("getCustomerByName");
        List<Customer> expCustomer = new ArrayList<>();
        expCustomer.add(new Customer());

        Query mockQuery = mock(Query.class);
        when(session.createQuery("from Customer where lastName like :lastName")).thenReturn(mockQuery);
        when(mockQuery.setParameter("lastName", "%test%")).thenReturn(mockQuery);
        when(mockQuery.list()).thenReturn(expCustomer);

        List<Customer> result = customerDAO.getCustomerByName("test");
        assertEquals(expCustomer, result);
    }

    @Test
    public void testGetCustomerByNameException() {
        System.out.println("getCustomerByNameException");
        when(session.createQuery("from Customer where lastName like :lastName")).thenThrow(new RuntimeException("Error"));

        List<Customer> result = customerDAO.getCustomerByName("test");
        assertEquals(null, result);
    }

    /**
     * Test of deleteCustomer method, of class CustomerDAO.
     */
    @Test
    public void testDeleteCustomer() {
        System.out.println("deleteCustomer");
        Customer customer = new Customer();
        customer.setCustomerId(1);

        when(session.get(Customer.class, 1)).thenReturn(customer);

        customerDAO.deleteCustomer(1);

        verify(session).delete(customer);
        verify(tx).commit();
    }
    
    @Test
    public void testDeleteCustomerException() {
        System.out.println("deleteCustomerException");
        Customer customer = new Customer();
        customer.setCustomerId(1);

        when(session.get(Customer.class, 1)).thenThrow(new RuntimeException("Error"));

        customerDAO.deleteCustomer(1);
        verify(tx).rollback();
    }

}
