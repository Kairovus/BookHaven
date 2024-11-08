package bean;

import dao.BookTransactionDAO;
import model.BookTransaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookTransactionBeanTest {

    private BookTransactionBean bookTransactionBean;
    private BookTransactionDAO mockBookTransactionDAO; // Mock DAO
    private BookTransaction mockBookTransaction;

     @Before
    public void setUp() {
        bookTransactionBean = new BookTransactionBean();
        mockBookTransactionDAO = mock(BookTransactionDAO.class); // Use Mockito to create a mock

        // Set the mock DAO into the bean
        bookTransactionBean.setBookTransactionDAO(mockBookTransactionDAO);

        // Set up a mock BookTransaction object for testing
        mockBookTransaction = new BookTransaction();
        mockBookTransaction.setTransactionId(1); // Example ID
        // Set other attributes as necessary
    }

    @After
    public void tearDown() {
        // Clean up resources if needed
    }

    @Test
    public void testGetBookTransactions() {
        System.out.println("getBookTransactions");

        // Setup mock behavior
        List<BookTransaction> expectedTransactions = new ArrayList<>();
        expectedTransactions.add(mockBookTransaction);

        // Assuming DAO has a method to mock
        when(mockBookTransactionDAO.getAllBookTransactions()).thenReturn(expectedTransactions);
        bookTransactionBean.setSearchId(0); // No search ID set

        // Call the method
        List<BookTransaction> result = bookTransactionBean.getBookTransactions();

        // Verify results
        assertEquals(expectedTransactions, result);
    }

    @Test
    public void testGetBookTransactionsById() {
        System.out.println("getBookTransactions by search id");

        // Setup mock behavior
        List<BookTransaction> expectedTransactions = new ArrayList<>();
        expectedTransactions.add(mockBookTransaction);

        // Assuming DAO has a method to mock
        when(mockBookTransactionDAO.getBookTransactionById(mockBookTransaction.getTransactionId())).thenReturn(expectedTransactions);
        bookTransactionBean.setSearchId(mockBookTransaction.getTransactionId()); // Set search ID

        // Call the method
        List<BookTransaction> result = bookTransactionBean.getBookTransactions();

        // Verify results
        assertEquals(expectedTransactions, result);
    }

    @Test
    public void testSaveBookTransaction() {
        System.out.println("saveBookTransaction");

        // Setup the bean with a transaction to save
        bookTransactionBean.setBooktransaction(mockBookTransaction);

        // Call the method
        String result = bookTransactionBean.saveBookTransaction();

        // Verify that the DAO's save method was called
        assertEquals("Expected page after saving", "transactions", result);
    }

    @Test
    public void testUpdateBookTransaction() {
        System.out.println("updateBookTransaction");

        // Setup the bean with a transaction to update
        bookTransactionBean.setBooktransaction(mockBookTransaction);

        // Call the method
        String result = bookTransactionBean.updateBookTransaction();

        // Verify that the expected result is returned
        assertEquals("Expected page after updating", "transactions", result);
    }

    @Test
    public void testEditBookTransaction() {
        System.out.println("editBookTransaction");

        // Call the method with the mock transaction
        String result = bookTransactionBean.editBookTransaction(mockBookTransaction);

        // Verify that the expected result is returned
        assertEquals("Expected page after editing", "editTransaction.xhtml", result);
    }

    @Test
    public void testDeleteBookTransaction() {
        System.out.println("deleteBookTransaction");
        int transactionId = mockBookTransaction.getTransactionId();

        // Call the method
        String result = bookTransactionBean.deleteBookTransaction(transactionId);

        // Verify that the expected result is returned
        assertEquals("Expected page after deleting", "transactions", result);
    }

    @Test
    public void testClearBookTransaction() {
        System.out.println("clearBookTransaction");

        // Call the method
        String result = bookTransactionBean.clearBookTransaction();

        // Verify that the expected result is returned
        assertEquals("Expected page after clearing", "transactions", result);
    }

    @Test
    public void testSearch() {
        System.out.println("search");

        // Call the method
        bookTransactionBean.search();

        // Verify the behavior of the method
        // This might involve checking if getBookTransactions() was called
    }

    @Test
    public void testGetBooktransaction() {
        System.out.println("getBooktransaction");

        // Set the mock transaction in the bean
        bookTransactionBean.setBooktransaction(mockBookTransaction);

        // Call the method
        BookTransaction result = bookTransactionBean.getBooktransaction();

        // Verify the result
        assertEquals(mockBookTransaction, result);
    }

    @Test
    public void testSetBooktransaction() {
        System.out.println("setBooktransaction");

        // Set a new transaction
        BookTransaction newTransaction = new BookTransaction();
        bookTransactionBean.setBooktransaction(newTransaction);

        // Verify that the new transaction is set correctly
        assertEquals(newTransaction, bookTransactionBean.getBooktransaction());
    }

    @Test
    public void testGetSearchId() {
        System.out.println("getSearchId");

        // Call the method and check the initial value
        int result = bookTransactionBean.getSearchId();
        assertEquals(0, result); // Assuming the default search ID is 0
    }

    @Test
    public void testSetSearchId() {
        System.out.println("setSearchId");

        // Set a new search ID
        int newSearchId = 5;
        bookTransactionBean.setSearchId(newSearchId);

        // Verify that the new search ID is set correctly
        assertEquals(newSearchId, bookTransactionBean.getSearchId());
    }
}
