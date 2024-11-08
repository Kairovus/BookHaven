/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class AdminTest {

    public AdminTest() {
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
     * Test of validateAdmin method, of class Admin.
     */
    @Test
    public void testValidateAdmin() {
        System.out.println("validateAdmin");
        Admin instance = new Admin();
        instance.setAdminId("1");
        instance.setPassword("1");
        String expResult = "dashboard";
        String result = instance.validateAdmin();
        assertEquals(expResult, result);
    }
    
//    @Test
//    public void testValidateAdminerror() {
//        System.out.println("validateAdminerror");
//        Admin instance = new Admin();
//        instance.setAdminId(null);
//        instance.setPassword(null);
//        String expResult = "index";
//        String result = instance.validateAdmin();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of logout method, of class Admin.
     */
//    @Test
//    public void testLogout() {
//        System.out.println("logout");
//        Admin instance = new Admin();
//        instance.logout();
//        String expResult = null;
//        String result = instance.logout();
//        assertEquals(expResult, result);
//    }
    
    @Test
    public void testAdminConst() {
        System.out.println("Admin Construct");
        Admin instance = new Admin("2", "2");
        String expectedID = "2";
        String expectedPass = "2";
        assertEquals(expectedID, instance.getAdminId());
        assertEquals(expectedPass, instance.getPassword());
    }
    
    /**
     * Test of getAdminId method, of class Admin.
     */
    @Test
    public void testGetAdminId() {
        System.out.println("getAdminId");
        Admin instance = new Admin();
        instance.setAdminId("1");
        String expResult = "1";
        String result = instance.getAdminId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setAdminId method, of class Admin.
     */
    @Test
    public void testSetAdminId() {
        System.out.println("setAdminId");
        String adminId = "";
        Admin instance = new Admin();
        instance.setAdminId(adminId);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPassword method, of class Admin.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Admin instance = new Admin();
        instance.setPassword("1");
        String expResult = "1";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPassword method, of class Admin.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Admin instance = new Admin();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
    }

}
