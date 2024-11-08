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
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Admin
 */
public class BookDAOTest {

    public BookDAOTest() {
    }

    private BookDAO bookDAO;
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction tx;

    @Before
    public void setUp() {
        sessionFactory = mock(SessionFactory.class);
        session = mock(Session.class);
        tx = mock(Transaction.class);

        when(sessionFactory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(tx);

        HibernateUtil.setSessionFactory(sessionFactory);
        bookDAO = new BookDAO();
    }

    @After
    public void tearDown() {
        HibernateUtil.setSessionFactory(null);
    }

    /**
     * Test of saveBook method, of class BookDAO.
     */
    @Test
    public void testSaveBook() {
        System.out.println("saveBook");
        Book book = new Book();

        bookDAO.saveBook(book);
        verify(session).save(book);
        verify(tx).commit();
    }

    @Test
    public void testSaveBookException() {
        System.out.println("saveBookException");
        doThrow(new RuntimeException("Error")).when(session).save(any(Book.class));

        Book book = new Book();

        bookDAO.saveBook(book);
        verify(tx).rollback();
    }

    /**
     * Test of updateBook method, of class BookDAO.
     */
    @Test
    public void testUpdateBook() {
        System.out.println("updateBook");
        Book book = new Book();
        book.setBookId(1);

        bookDAO.updateBook(book);
        verify(session).merge(book);
        verify(tx).commit();
    }

    @Test
    public void testUpdateBookException() {
        System.out.println("updateBookException");
        doThrow(new RuntimeException("Error")).when(session).merge(any(Book.class));

        Book book = new Book();

        bookDAO.updateBook(book);
        verify(tx).rollback();
    }

    /**
     * Test of getAllBooks method, of class BookDAO.
     */
    @Test
    public void testGetAllBooks() {
        System.out.println("getAllBooks");
        List<Book> expBook = new ArrayList<>();
        expBook.add(new Book());

        Criteria criteria = mock(Criteria.class);
        when(session.createCriteria(Book.class)).thenReturn(criteria);
        when(criteria.list()).thenReturn(expBook);

        List<Book> result = bookDAO.getAllBooks();
        assertEquals(expBook, result);
    }

    @Test
    public void testGetAllBooksException() {
        System.out.println("getAllBooksException");
        when(session.createCriteria(Book.class)).thenThrow(new RuntimeException("Error"));

        List<Book> result = bookDAO.getAllBooks();
        assertEquals(null, result);
    }

    /**
     * Test of getBookByTitle method, of class BookDAO.
     */
    @Test
    public void testGetBookByTitle() {
        System.out.println("getBookByTitle");
        List<Book> expBook = new ArrayList<>();
        expBook.add(new Book());

        Query mockQuery = mock(Query.class);
        when(session.createQuery("from Book where title like :title")).thenReturn(mockQuery);
        when(mockQuery.setParameter("title", "%test%")).thenReturn(mockQuery);
        when(mockQuery.list()).thenReturn(expBook);

        List<Book> result = bookDAO.getBookByTitle("test");
        assertEquals(expBook, result);
    }

    @Test
    public void testGetBookByTitleException() {
        System.out.println("getBookByTitleException");
        when(session.createQuery("from Book where title like :title")).thenThrow(new RuntimeException("Error"));

        List<Book> result = bookDAO.getBookByTitle("test");
        assertEquals(null, result);
    }

    /**
     * Test of getAuthorById method, of class BookDAO.
     */
    @Test
    public void testGetAuthorById() {
        System.out.println("getAuthorById");
        // Arrange
        int authorId = 1;
        Author mockAuthor = new Author();
        when(session.get(Author.class, authorId)).thenReturn(mockAuthor);

        // Act
        Author result = bookDAO.getAuthorById(authorId);

        // Assert
        assertNotNull(result); // Ensure the result is not null
        assertEquals(mockAuthor, result); // Ensure the correct Author is returned

        // Verify session and transaction interactions
        verify(session).get(Author.class, authorId); // Verify session.get() was called
        verify(tx).commit(); // Verify transaction.commit() was called
    }

    @Test
    public void testGetAuthorByIdException() {
        // Arrange
        int authorId = 1;
        when(session.get(Author.class, authorId)).thenThrow(new RuntimeException("Error fetching author"));

        // Act
        Author result = null;
        try {
            result = bookDAO.getAuthorById(authorId);
        } catch (Exception e) {
            // Handle exception (although the method under test does not re-throw it)
        }

        // Assert
        assertNull(result); // Ensure result is null in case of an exception

        // Verify that rollback is called if an exception occurs
        verify(tx).rollback();
    }

    /**
     * Test of deleteBook method, of class BookDAO.
     */
    @Test
    public void testDeleteBook() {
        System.out.println("deleteBook");
        Book book = new Book();
        book.setBookId(1);

        when(session.get(Book.class, 1)).thenReturn(book);

        bookDAO.deleteBook(1);

        verify(session).delete(book);
        verify(tx).commit();
    }

    @Test
    public void testDeleteBookException() {
        System.out.println("deleteBookException");
        Book book = new Book();
        book.setBookId(1);

        when(session.get(Book.class, 1)).thenThrow(new RuntimeException("Error"));

        bookDAO.deleteBook(1);
        verify(tx).rollback();
    }

}
