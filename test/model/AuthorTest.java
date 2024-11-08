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
public class AuthorTest {
    
    public AuthorTest() {
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
     * Test of getAuthorId method, of class Author.
     */
    @Test
    public void testGetAuthorId() {
        System.out.println("getAuthorId");
        Author instance = new Author();
        instance.setAuthorId(1);
        Integer expResult = 1;
        Integer result = instance.getAuthorId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setAuthorId method, of class Author.
     */
    @Test
    public void testSetAuthorId() {
        System.out.println("setAuthorId");
        Integer authorId = null;
        Author instance = new Author();
        instance.setAuthorId(authorId);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFirstName method, of class Author.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Author instance = new Author();
        instance.setFirstName("test");
        String expResult = "test";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setFirstName method, of class Author.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Author instance = new Author();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getLastName method, of class Author.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Author instance = new Author();
        instance.setLastName("test");
        String expResult = "test";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setLastName method, of class Author.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Author instance = new Author();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getBooks method, of class Author.
     */
    @Test
    public void testGetBooks() {
        System.out.println("getBooks");
        Author instance = new Author();
        instance.setBooks(null);
        Set expResult = null;
        Set result = instance.getBooks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setBooks method, of class Author.
     */
    @Test
    public void testSetBooks() {
        System.out.println("setBooks");
        Set books = null;
        Author instance = new Author();
        instance.setBooks(books);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
