/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
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
public class BookTransactionTest {
    
    public BookTransactionTest() {
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
     * Test of getTransactionId method, of class BookTransaction.
     */
    @Test
    public void testGetTransactionId() {
        System.out.println("getTransactionId");
        BookTransaction instance = new BookTransaction();
        instance.setTransactionId(1);
        Integer expResult = 1;
        Integer result = instance.getTransactionId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setTransactionId method, of class BookTransaction.
     */
    @Test
    public void testSetTransactionId() {
        System.out.println("setTransactionId");
        Integer transactionId = null;
        BookTransaction instance = new BookTransaction();
        instance.setTransactionId(transactionId);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getBook method, of class BookTransaction.
     */
    @Test
    public void testGetBook() {
        System.out.println("getBook");
        BookTransaction instance = new BookTransaction();
        instance.setBook(null);
        Book expResult = null;
        Book result = instance.getBook();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setBook method, of class BookTransaction.
     */
    @Test
    public void testSetBook() {
        System.out.println("setBook");
        Book book = null;
        BookTransaction instance = new BookTransaction();
        instance.setBook(book);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCustomer method, of class BookTransaction.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        BookTransaction instance = new BookTransaction();
        instance.setCustomer(null);
        Customer expResult = null;
        Customer result = instance.getCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setCustomer method, of class BookTransaction.
     */
    @Test
    public void testSetCustomer() {
        System.out.println("setCustomer");
        Customer customer = null;
        BookTransaction instance = new BookTransaction();
        instance.setCustomer(customer);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getStaff method, of class BookTransaction.
     */
    @Test
    public void testGetStaff() {
        System.out.println("getStaff");
        BookTransaction instance = new BookTransaction();
        instance.setStaff(null);
        Staff expResult = null;
        Staff result = instance.getStaff();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setStaff method, of class BookTransaction.
     */
    @Test
    public void testSetStaff() {
        System.out.println("setStaff");
        Staff staff = null;
        BookTransaction instance = new BookTransaction();
        instance.setStaff(staff);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIssueDate method, of class BookTransaction.
     */
    @Test
    public void testGetIssueDate() {
        System.out.println("getIssueDate");
        BookTransaction instance = new BookTransaction();
        instance.setIssueDate(null);
        Date expResult = null;
        Date result = instance.getIssueDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setIssueDate method, of class BookTransaction.
     */
    @Test
    public void testSetIssueDate() {
        System.out.println("setIssueDate");
        Date issueDate = null;
        BookTransaction instance = new BookTransaction();
        instance.setIssueDate(issueDate);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDueDate method, of class BookTransaction.
     */
    @Test
    public void testGetDueDate() {
        System.out.println("getDueDate");
        BookTransaction instance = new BookTransaction();
        instance.setDueDate(null);
        Date expResult = null;
        Date result = instance.getDueDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setDueDate method, of class BookTransaction.
     */
    @Test
    public void testSetDueDate() {
        System.out.println("setDueDate");
        Date dueDate = null;
        BookTransaction instance = new BookTransaction();
        instance.setDueDate(dueDate);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getReturnDate method, of class BookTransaction.
     */
    @Test
    public void testGetReturnDate() {
        System.out.println("getReturnDate");
        BookTransaction instance = new BookTransaction();
        instance.setReturnDate(null);
        Date expResult = null;
        Date result = instance.getReturnDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setReturnDate method, of class BookTransaction.
     */
    @Test
    public void testSetReturnDate() {
        System.out.println("setReturnDate");
        Date returnDate = null;
        BookTransaction instance = new BookTransaction();
        instance.setReturnDate(returnDate);
        // TODO review the generated test code and remove the default call to fail.
    }
}
