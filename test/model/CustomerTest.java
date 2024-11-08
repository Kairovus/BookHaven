/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
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
public class CustomerTest {
    
    public CustomerTest() {
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
     * Test of getCustomerId method, of class Customer.
     */
    @Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId");
        Customer instance = new Customer();
        instance.setCustomerId(1);
        Integer expResult = 1;
        Integer result = instance.getCustomerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setCustomerId method, of class Customer.
     */
    @Test
    public void testSetCustomerId() {
        System.out.println("setCustomerId");
        Integer customerId = null;
        Customer instance = new Customer();
        instance.setCustomerId(customerId);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFirstName method, of class Customer.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Customer instance = new Customer();
        instance.setFirstName("test");
        String expResult = "test";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setFirstName method, of class Customer.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Customer instance = new Customer();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getLastName method, of class Customer.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Customer instance = new Customer();
        instance.setLastName("test");
        String expResult = "test";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setLastName method, of class Customer.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Customer instance = new Customer();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmail method, of class Customer.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Customer instance = new Customer();
        instance.setEmail("test@gmail.com");
        String expResult = "test@gmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmail method, of class Customer.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Customer instance = new Customer();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPhone method, of class Customer.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Customer instance = new Customer();
        instance.setPhone("123-123-1234");
        String expResult = "123-123-1234";
        String result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPhone method, of class Customer.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        Customer instance = new Customer();
        instance.setPhone(phone);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMembershipDate method, of class Customer.
     */
    @Test
    public void testGetMembershipDate() {
        System.out.println("getMembershipDate");
        Customer instance = new Customer();
        instance.setMembershipDate(null);
        Date expResult = null;
        Date result = instance.getMembershipDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setMembershipDate method, of class Customer.
     */
    @Test
    public void testSetMembershipDate() {
        System.out.println("setMembershipDate");
        Date membershipDate = null;
        Customer instance = new Customer();
        instance.setMembershipDate(membershipDate);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getBookTransactions method, of class Customer.
     */
    @Test
    public void testGetBookTransactions() {
        System.out.println("getBookTransactions");
        Customer instance = new Customer();
        Set bookTransactions = null;
        instance.setBookTransactions(bookTransactions);
        Set expResult = null;
        Set result = instance.getBookTransactions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setBookTransactions method, of class Customer.
     */
    @Test
    public void testSetBookTransactions() {
        System.out.println("setBookTransactions");
        Set bookTransactions = null;
        Customer instance = new Customer();
        instance.setBookTransactions(bookTransactions);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
