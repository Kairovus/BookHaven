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
public class AuthorDAOTest {

    private AuthorDAO authorDAO;
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction tx;

    public AuthorDAOTest() {
    }

    @Before
    public void setUp() {
        sessionFactory = mock(SessionFactory.class);
        session = mock(Session.class);
        tx = mock(Transaction.class);

        when(sessionFactory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(tx);

        HibernateUtil.setSessionFactory(sessionFactory);
        authorDAO = new AuthorDAO();
    }

    @After
    public void tearDown() {
        HibernateUtil.setSessionFactory(null);
    }

    /**
     * Test of saveAuthor method, of class AuthorDAO.
     */
    @Test
    public void testSaveAuthor() {
        System.out.println("saveAuthor");
        Author author = new Author();

        authorDAO.saveAuthor(author);
        verify(session).save(author);
        verify(tx).commit();
    }

    @Test
    public void testSaveAuthorException() {
        System.out.println("testSaveAuthorException");
        doThrow(new RuntimeException("Error")).when(session).save(any(Author.class));

        Author author = new Author();

        authorDAO.saveAuthor(author);
        verify(tx).rollback();
    }

    /**
     * Test of updateAuthor method, of class AuthorDAO.
     */
    @Test
    public void testUpdateAuthor() {
        System.out.println("updateAuthor");
        Author author = new Author();
        author.setAuthorId(1);

        authorDAO.updateAuthor(author);
        verify(session).merge(author);
        verify(tx).commit();
    }

    @Test
    public void testUpdateAuthorException() {
        System.out.println("testSaveAuthorException");
        doThrow(new RuntimeException("Error")).when(session).merge(any(Author.class));

        Author author = new Author();

        authorDAO.updateAuthor(author);
        verify(tx).rollback();
    }

    /**
     * Test of getAllAuthors method, of class AuthorDAO.
     */
    @Test
    public void testGetAllAuthors() {
        System.out.println("getAllAuthors");
        List<Author> expAuthor = new ArrayList<>();
        expAuthor.add(new Author());

        Criteria criteria = mock(Criteria.class);
        when(session.createCriteria(Author.class)).thenReturn(criteria);
        when(criteria.list()).thenReturn(expAuthor);

        List<Author> result = authorDAO.getAllAuthors();
        assertEquals(expAuthor, result);
    }

    @Test
    public void testGetAllAuthorsException() {
        when(session.createCriteria(Author.class)).thenThrow(new RuntimeException("Error"));

        List<Author> result = authorDAO.getAllAuthors();
        assertEquals(null, result);
    }

    /**
     * Test of getAuthorByLastname method, of class AuthorDAO.
     */
    @Test
    public void testGetAuthorByLastname() {
        System.out.println("getAuthorByLastname");
        List<Author> expAuthor = new ArrayList<>();
        expAuthor.add(new Author());

        Query mockQuery = mock(Query.class);
        when(session.createQuery("from Author where lastName like :lastName")).thenReturn(mockQuery);
        when(mockQuery.setParameter("lastName", "%John%")).thenReturn(mockQuery);
        when(mockQuery.list()).thenReturn(expAuthor);

        List<Author> result = authorDAO.getAuthorByLastname("John");
        assertEquals(expAuthor, result);

    }

    @Test
    public void testGetAuthorByLastnameException() {
        System.out.println("testGetAuthorByLastnameException");
        when(session.createQuery("from Author where lastName like :lastName")).thenThrow(new RuntimeException("Error"));

        List<Author> result = authorDAO.getAuthorByLastname("John");
        assertEquals(null, result);
    }

    /**
     * Test of deleteAuthors method, of class AuthorDAO.
     */
    @Test
    public void testDeleteAuthors() {
        System.out.println("deleteAuthors");
        Author author = new Author();
        author.setAuthorId(1);

        when(session.get(Author.class, 1)).thenReturn(author);

        authorDAO.deleteAuthors(1);

        verify(session).delete(author);
        verify(tx).commit();
    }
    
    @Test
    public void testDeleteAuthorsException() {
        System.out.println("testDeleteAuthorsException");
        Author author = new Author();
        author.setAuthorId(1);

        when(session.get(Author.class, 1)).thenThrow(new RuntimeException("Error"));

        authorDAO.deleteAuthors(1);
        verify(tx).rollback();
    }
}
