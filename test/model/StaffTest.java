/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class StaffTest {
    
    public StaffTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getStaffId method, of class Staff.
     */
    @Test
    public void testGetStaffId() {
        System.out.println("getStaffId");
        Staff instance = new Staff();
        instance.setStaffId(1);
        Integer expResult = 1;
        Integer result = instance.getStaffId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setStaffId method, of class Staff.
     */
    @Test
    public void testSetStaffId() {
        System.out.println("setStaffId");
        Integer staffId = null;
        Staff instance = new Staff();
        instance.setStaffId(staffId);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFirstName method, of class Staff.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Staff instance = new Staff();
        instance.setFirstName("test");
        String expResult = "test";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setFirstName method, of class Staff.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Staff instance = new Staff();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getLastName method, of class Staff.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Staff instance = new Staff();
        instance.setLastName("test");
        String expResult = "test";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setLastName method, of class Staff.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Staff instance = new Staff();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmail method, of class Staff.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Staff instance = new Staff();
        instance.setEmail("test@gmail.com");
        String expResult = "test@gmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmail method, of class Staff.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Staff instance = new Staff();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPhone method, of class Staff.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Staff instance = new Staff();
        instance.setPhone("123-123-1234");
        String expResult = "123-123-1234";
        String result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPhone method, of class Staff.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        Staff instance = new Staff();
        instance.setPhone(phone);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPosition method, of class Staff.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Staff instance = new Staff();
        instance.setPosition("test");
        String expResult = "test";
        String result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPosition method, of class Staff.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        String position = "";
        Staff instance = new Staff();
        instance.setPosition(position);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getBookTransactions method, of class Staff.
     */
    @Test
    public void testGetBookTransactions() {
        System.out.println("getBookTransactions");
        Staff instance = new Staff();
        instance.setBookTransactions(null);
        Set expResult = null;
        Set result = instance.getBookTransactions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setBookTransactions method, of class Staff.
     */
    @Test
    public void testSetBookTransactions() {
        System.out.println("setBookTransactions");
        Set bookTransactions = null;
        Staff instance = new Staff();
        instance.setBookTransactions(bookTransactions);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
