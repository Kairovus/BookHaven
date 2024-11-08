/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import model.Author;
import model.Book;
import model.BookTransaction;
import model.Customer;
import model.Staff;
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
public class BookTransactionDAOTest {

    private BookTransactionDAO booktransactionDAO;
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction tx;

    public BookTransactionDAOTest() {
    }

    @Before
    public void setUp() {
        sessionFactory = mock(SessionFactory.class);
        session = mock(Session.class);
        tx = mock(Transaction.class);

        when(sessionFactory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(tx);

        HibernateUtil.setSessionFactory(sessionFactory);
        booktransactionDAO = new BookTransactionDAO();
    }

    @After
    public void tearDown() {
        HibernateUtil.setSessionFactory(null);

    }

    /**
     * Test of saveBookTransaction method, of class BookTransactionDAO.
     */
    @Test
    public void testSaveBookTransaction() {
        System.out.println("saveBookTransaction");
        BookTransaction booktrans = new BookTransaction();

        booktransactionDAO.saveBookTransaction(booktrans);
        verify(session).save(booktrans);
        verify(tx).commit();
    }

    @Test
    public void testSaveBookTransactionException() {
        System.out.println("saveBookTransactionException");
        doThrow(new RuntimeException("Error")).when(session).save(any(BookTransaction.class));

        BookTransaction booktrans = new BookTransaction();

        booktransactionDAO.saveBookTransaction(booktrans);
        verify(tx).rollback();
    }

    /**
     * Test of updateBookTransaction method, of class BookTransactionDAO.
     */
    @Test
    public void testUpdateBookTransaction() {
        System.out.println("updateBookTransaction");
        BookTransaction booktrans = new BookTransaction();
        booktrans.setTransactionId(1);

        booktransactionDAO.updateBookTransaction(booktrans);
        verify(session).merge(booktrans);
        verify(tx).commit();
    }

    @Test
    public void testUpdateBookTransactionException() {
        System.out.println("updateBookTransactionException");
        doThrow(new RuntimeException("Error")).when(session).merge(any(BookTransaction.class));

        BookTransaction booktrans = new BookTransaction();

        booktransactionDAO.updateBookTransaction(booktrans);
        verify(tx).rollback();
    }

    /**
     * Test of getAllBookTransactions method, of class BookTransactionDAO.
     */
    @Test
    public void testGetAllBookTransactions() {
        System.out.println("getAllBookTransactions");
        List<BookTransaction> expBookTrans = new ArrayList<>();
        expBookTrans.add(new BookTransaction());

        Criteria criteria = mock(Criteria.class);
        when(session.createCriteria(BookTransaction.class)).thenReturn(criteria);
        when(criteria.list()).thenReturn(expBookTrans);

        List<BookTransaction> result = booktransactionDAO.getAllBookTransactions();
        assertEquals(expBookTrans, result);
    }

    @Test
    public void testGetAllBookTransactionsException() {
        System.out.println("getAllBookTransactionsExceptions");
        when(session.createCriteria(BookTransaction.class)).thenThrow(new RuntimeException("Error"));

        List<BookTransaction> result = booktransactionDAO.getAllBookTransactions();
        assertEquals(null, result);
    }

    /**
     * Test of getBookTransactionById method, of class BookTransactionDAO.
     */
    @Test
    public void testGetBookTransactionById() {
        System.out.println("getBookTransactionById");
        List<BookTransaction> expBookTrans = new ArrayList<>();
        expBookTrans.add(new BookTransaction());

        Query mockQuery = mock(Query.class);
        when(session.createQuery("from Booktransaction where customerId = :customerId")).thenReturn(mockQuery);
        when(mockQuery.setParameter("customerId", 1)).thenReturn(mockQuery);
        when(mockQuery.list()).thenReturn(expBookTrans);

        List<BookTransaction> result = booktransactionDAO.getBookTransactionById(1);
        assertEquals(expBookTrans, result);
    }

    @Test
    public void testGetBookTransactionByIdException() {
        System.out.println("getBookTransactionByIdException");
        when(session.createQuery("from Booktransaction where customerId = :customerId")).thenThrow(new RuntimeException("Error"));

        List<BookTransaction> result = booktransactionDAO.getBookTransactionById(1);
        assertEquals(null, result);
    }

    /**
     * Test of getBookById method, of class BookTransactionDAO.
     */
    @Test
    public void testGetBookById() {
        System.out.println("getBookById");
        int bookId = 1;
        Book mockBook = new Book();
        when(session.get(Book.class, bookId)).thenReturn(mockBook);

        // Act
        Book result = booktransactionDAO.getBookById(bookId);

        // Assert
        assertNotNull(result); // Ensure the result is not null
        assertEquals(mockBook, result); // Ensure the correct Book is returned

        // Verify session and transaction interactions
        verify(session).get(Book.class, bookId); // Verify session.get() was called
        verify(tx).commit(); // Verify transaction.commit() was called
    }

    @Test
    public void testGetBookByIdException() {
        // Arrange
        int bookId = 1;
        when(session.get(Book.class, bookId)).thenThrow(new RuntimeException("Error fetching book"));

        // Act
        Book result = null;
        try {
            result = booktransactionDAO.getBookById(bookId);
        } catch (Exception e) {
            // Handle exception (although the method under test does not re-throw it)
        }

        // Assert
        assertNull(result); // Ensure result is null in case of an exception

        // Verify that rollback is called if an exception occurs
        verify(tx).rollback();
    }

    /**
     * Test of getCustomerById method, of class BookTransactionDAO.
     */
    @Test
    public void testGetCustomerById() {
        System.out.println("getCustomerById");
        int customerId = 1;
        Customer mockCustomer = new Customer();
        when(session.get(Customer.class, customerId)).thenReturn(mockCustomer);

        // Act
        Customer result = booktransactionDAO.getCustomerById(customerId);

        // Assert
        assertNotNull(result); // Ensure the result is not null
        assertEquals(mockCustomer, result); // Ensure the correct Book is returned

        // Verify session and transaction interactions
        verify(session).get(Customer.class, customerId); // Verify session.get() was called
        verify(tx).commit(); // Verify transaction.commit() was called
    }
    
    @Test
    public void testGetCustomerByIdException() {
        // Arrange
        int customerId = 1;
        when(session.get(Customer.class, customerId)).thenThrow(new RuntimeException("Error fetching customer"));

        // Act
        Customer result = null;
        try {
            result = booktransactionDAO.getCustomerById(customerId);
        } catch (Exception e) {
            // Handle exception (although the method under test does not re-throw it)
        }

        // Assert
        assertNull(result); // Ensure result is null in case of an exception

        // Verify that rollback is called if an exception occurs
        verify(tx).rollback();
    }

    /**
     * Test of getStaffById method, of class BookTransactionDAO.
     */
    @Test
    public void testGetStaffById() {
       int staffId = 1;
        Staff mockstaff = new Staff();
        when(session.get(Staff.class, staffId)).thenReturn(mockstaff);

        // Act
        Staff result = booktransactionDAO.getStaffById(staffId);

        // Assert
        assertNotNull(result); // Ensure the result is not null
        assertEquals(mockstaff, result); // Ensure the correct Book is returned

        // Verify session and transaction interactions
        verify(session).get(Staff.class, staffId); // Verify session.get() was called
        verify(tx).commit(); // Verify transaction.commit() was called
    }
    
    @Test
    public void testGetStaffByIdException() {
        // Arrange
       int staffId = 1;
        when(session.get(Staff.class, staffId)).thenThrow(new RuntimeException("Error fetching customer"));

        // Act
        Staff result = null;
        try {
            result = booktransactionDAO.getStaffById(staffId);
        } catch (Exception e) {
            // Handle exception (although the method under test does not re-throw it)
        }

        // Assert
        assertNull(result); // Ensure result is null in case of an exception

        // Verify that rollback is called if an exception occurs
        verify(tx).rollback();
    }

    /**
     * Test of deleteBookTransaction method, of class BookTransactionDAO.
     */
    @Test
    public void testDeleteBookTransaction() {
        System.out.println("deleteBookTransaction");
        BookTransaction booktrans = new BookTransaction();
        booktrans.setTransactionId(1);

        when(session.get(BookTransaction.class, 1)).thenReturn(booktrans);

        booktransactionDAO.deleteBookTransaction(1);

        verify(session).delete(booktrans);
        verify(tx).commit();
    }
    
    @Test
    public void testDeleteBookTransactionException() {
        System.out.println("deleteBookTransactionException");
        BookTransaction booktrans = new BookTransaction();
        booktrans.setTransactionId(1);

        when(session.get(BookTransaction.class, 1)).thenThrow(new RuntimeException("Error"));

        booktransactionDAO.deleteBookTransaction(1);
        verify(tx).rollback();
    }

}
