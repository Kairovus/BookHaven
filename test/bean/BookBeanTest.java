/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.BookDAO;
import model.Book;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *
 * @author Admin
 */
public class BookBeanTest {

    private BookBean bookBean;
    private BookDAO bookDAO;

    public BookBeanTest() {
    }

    @Before
    public void setUp() {
        bookBean = new BookBean();
        bookDAO = mock(BookDAO.class);
        bookBean.setBookDAO(bookDAO); // Injecting the mock AuthorDAO

    }

    /**
     * Test of getBooks method, of class BookBean.
     */
    @Test
    public void testGetBooks() {
        System.out.println("getBooks");
        bookBean.setSearchTitle("");  // No search term provided
        bookBean.getBooks();
        verify(bookDAO).getAllBooks();  // Verifying all authors retrieval is executed
    }

    @Test
    public void testGetBooks_SearchTitle() {
        String searchTitle = "test";
        bookBean.setSearchTitle(searchTitle);  // No search term provided
        bookBean.getBooks();
        verify(bookDAO).getBookByTitle(searchTitle);  // Verifying all authors retrieval is executed
    }

    /**
     * Test of saveBook method, of class BookBean.
     */
    @Test
    public void testSaveBook() {
        Book book = new Book();
        bookBean.setBook(book);  // Setting the author in the bean
        String result = bookBean.saveBook();
        verify(bookDAO).saveBook(book);  // Verifying that the saveAuthor method in DAO is called
        assertEquals("books", result);  // Checking if the correct navigation outcome is returned
    }

    /**
     * Test of updateBook method, of class BookBean.
     */
    @Test
    public void testUpdateBook() {
        Book book = new Book();
        bookBean.setBook(book);
        String result = bookBean.updateBook();
        verify(bookDAO).updateBook(book);
        assertEquals("books", result);
    }

    /**
     * Test of editBook method, of class BookBean.
     */
    @Test
    public void testEditBook() {
        Book book = new Book();
        bookBean = new BookBean();
        book.setBookId(1);
        book.setTitle("Test Book Title");
        book.setIsbn("123-4567890123");
        book.setPublishedYear(2022);
        book.setGenre("Fiction");
        // When: editAuthor method is called
        String result = bookBean.editBook(book);
        // Then: The author's values should be set in the bean, and the correct navigation string returned
        assertEquals(book, bookBean.getBook());
        assertEquals("editBook.xhtml", result);
    }

    /**
     * Test of deleteBook method, of class BookBean.
     */
    @Test
    public void testDeleteBook() {
        int bookId = 1;
        String result = bookBean.deleteBook(bookId);  // Calling deleteAuthor method
        verify(bookDAO).deleteBook(bookId);  // Verifying that the deleteAuthors method in DAO is called
        assertEquals("books", result);
    }

    /**
     * Test of clearBook method, of class BookBean.
     */
    @Test
    public void testClearBook() {
        System.out.println("clearBook");
        BookBean instance = new BookBean();
        String expResult = "books";
        String result = instance.clearBook();
        assertEquals(expResult, result);
    }

    /**
     * Test of search method, of class BookBean.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        BookBean instance = new BookBean();
        instance.search();

    }

    /**
     * Test of getBook method, of class BookBean.
     */
    @Test
    public void testGetBook() {
        Book book = new Book();
        bookBean = new BookBean();
        book.setBookId(1);
        book.setTitle("Test Book Title");
        book.setIsbn("123-4567890123");
        book.setPublishedYear(2022);
        book.setGenre("Fiction");
        
        bookBean.setBook(book);
        Book result = bookBean.getBook();
        assertEquals(book, result);
    }

    /**
     * Test of setBook method, of class BookBean.
     */
    @Test
    public void testSetBook() {
        System.out.println("setBook");
        Book book = null;
        BookBean instance = new BookBean();
        instance.setBook(book);
    }

    /**
     * Test of getSearchTitle method, of class BookBean.
     */
    @Test
    public void testGetSearchTitle() {
        // Given: Set a search name in the AuthorBean
        String expectedSearchTitle = "Smith";
        bookBean.setSearchTitle(expectedSearchTitle);

        // When: Calling getSearchName()
        String result = bookBean.getSearchTitle();

        // Then: The result should match the expected search name
        assertEquals(expectedSearchTitle, result);  // Verify the search name
    }

    /**
     * Test of setSearchTitle method, of class BookBean.
     */
    @Test
    public void testSetSearchTitle() {
        System.out.println("setSearchTitle");
        String searchtitle = "";
        BookBean instance = new BookBean();
        instance.setSearchTitle(searchtitle);

    }

}
