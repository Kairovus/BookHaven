/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import dao.AuthorDAO;
import model.Author;
import bean.AuthorBean;
import model.Book;

public class AuthorBeanTest {

    private AuthorBean authorBean;
    private AuthorDAO authorDAO;

    @Before
    public void setUp() {
        authorBean = new AuthorBean();
        authorDAO = mock(AuthorDAO.class); // Mocking AuthorDAO
        authorBean.setAuthorDAO(authorDAO); // Injecting the mock AuthorDAO
    }

    @Test
    public void testSaveAuthor() {
        Author author = new Author();
        authorBean.setBook(author);  // Setting the author in the bean
        String result = authorBean.saveAuthor();  // Calling saveAuthor method
        verify(authorDAO).saveAuthor(author);  // Verifying that the saveAuthor method in DAO is called
        assertEquals("authors", result);  // Checking if the correct navigation outcome is returned
    }

    @Test
    public void testUpdateAuthor() {
        Author author = new Author();
        authorBean.setBook(author);  // Setting the author in the bean
        String result = authorBean.updateAuthor();  // Calling updateAuthor method
        verify(authorDAO).updateAuthor(author);  // Verifying that the updateAuthor method in DAO is called
        assertEquals("authors", result);  // Checking if the correct navigation outcome is returned
    }

    @Test
    public void testDeleteAuthor() {
        int authorId = 1;
        String result = authorBean.deleteAuthor(authorId);  // Calling deleteAuthor method
        verify(authorDAO).deleteAuthors(authorId);  // Verifying that the deleteAuthors method in DAO is called
        assertEquals("authors", result);  // Checking if the correct navigation outcome is returned
    }

    @Test
    public void testGetAuthors_SearchByName() {
        String searchName = "Smith";
        authorBean.setSearchName(searchName);
        authorBean.getAuthors();
        verify(authorDAO).getAuthorByLastname(searchName);  // Verifying search by name is executed
    }

    @Test
    public void testGetAuthors_AllAuthors() {
        authorBean.setSearchName("");  // No search term provided
        authorBean.getAuthors();
        verify(authorDAO).getAllAuthors();  // Verifying all authors retrieval is executed
    }

    @Test
    public void testEditAuthor() {
        // Given: A new author object to edit
        Author author = new Author();
        author.setAuthorId(1);  // Example author ID
        author.setFirstName("John");
        author.setLastName("Doe");
        // When: editAuthor method is called
        String result = authorBean.editAuthor(author);
        // Then: The author's values should be set in the bean, and the correct navigation string returned
        assertEquals(author, authorBean.getAuthor());  // The author in the bean should match the one passed in
        assertEquals("editAuthor", result);  // The returned string should be "editAuthor"
    }

    @Test
    public void testSearch() {
        System.out.println("search");
        AuthorBean instance = new AuthorBean();
        instance.search();

    }

    @Test
    public void testGetAuthor() {
        Author author = new Author();
        author.setAuthorId(1);  // Example author ID
        author.setFirstName("Jane");
        author.setLastName("Smith");

        // When: The author is set in the bean
        authorBean.setBook(author);

        // Then: The getAuthor method should return the same author object
        Author result = authorBean.getAuthor();
        assertEquals(author, result);  // Check if the correct author is returned
        assertEquals(Integer.valueOf(1), result.getAuthorId());  // Verify the author ID
        assertEquals("Jane", result.getFirstName());  // Verify the first name
        assertEquals("Smith", result.getLastName());  // Verify the last name
    }

    @Test
    public void testGetSearchName() {
        // Given: Set a search name in the AuthorBean
        String expectedSearchName = "Smith";
        authorBean.setSearchName(expectedSearchName);

        // When: Calling getSearchName()
        String result = authorBean.getSearchName();

        // Then: The result should match the expected search name
        assertEquals(expectedSearchName, result);  // Verify the search name
    }
}
