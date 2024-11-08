/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bean.CustomerBean;
import dao.CustomerDAO;
import model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerBeanTest {

    private CustomerBean customerBean;
    private CustomerDAO customerDAOMock;

    @Before
    public void setUp() {
        customerBean = new CustomerBean();
        customerDAOMock = Mockito.mock(CustomerDAO.class);
        customerBean.setCustomerDAO(customerDAOMock); // Assuming you have a setter for CustomerDAO
    }

    @Test
    public void testGetCustomers_WithSearchName() {
        // Arrange
        String searchName = "Doe";
        customerBean.setSearchName(searchName);

        List<Customer> expectedCustomers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setLastName("Doe");
        expectedCustomers.add(customer);

        when(customerDAOMock.getCustomerByName(searchName)).thenReturn(expectedCustomers);

        // Act
        List<Customer> result = customerBean.getCustomers();

        // Assert
        assertEquals(expectedCustomers.size(), result.size());
        assertEquals(expectedCustomers.get(0).getLastName(), result.get(0).getLastName());
    }

    @Test
    public void testGetCustomers_WithoutSearchName() {
        // Arrange
        customerBean.setSearchName(null);
        List<Customer> expectedCustomers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setLastName("Smith");
        expectedCustomers.add(customer);

        when(customerDAOMock.getAllCustomers()).thenReturn(expectedCustomers);

        // Act
        List<Customer> result = customerBean.getCustomers();

        // Assert
        assertEquals(expectedCustomers.size(), result.size());
        assertEquals(expectedCustomers.get(0).getLastName(), result.get(0).getLastName());
    }

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer();
        customerBean.setCustomer(customer);
        String result = customerBean.saveCustomer();
        verify(customerDAOMock).saveCustomer(customer);  // Verifying that the saveAuthor method in DAO is called
        assertEquals("customers", result);  // Checking if the correct navigation outcome is returned
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = new Customer();
        customerBean.setCustomer(customer);
        String result = customerBean.updateCustomer();
        verify(customerDAOMock).updateCustomer(customer);
        assertEquals("customers", result);
    }

    @Test
    public void testEditCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("test");
        customer.setLastName("test");

        // Act
        String result = customerBean.editCustomer(customer);

        // Assert
        assertEquals("editCustomer.xhtml", result);
        assertEquals(customer, customerBean.getCustomer());
    }

    @Test
    public void testDeleteCustomer() {
        // Arrange
        int customerId = 1;

        // Act
        customerBean.deleteCustomer(customerId);

        // Assert
        verify(customerDAOMock).deleteCustomer(customerId);
    }

    @Test
    public void testClearCustomer() {
        CustomerBean instance = new CustomerBean();
        String expResult = "customers";
        String result = instance.clearCustomer();
        assertEquals(expResult, result);
    }
    
      @Test
    public void testGetSearchName() {
        // Arrange
        String expectedSearchName = "John Doe"; // Set an expected value for the search name
        customerBean.setSearchName(expectedSearchName); // Use the setter to set the search name

        // Act
        String actualSearchName = customerBean.getSearchName(); // Call the method to test

        // Assert
        assertEquals(expectedSearchName, actualSearchName); // Verify that the returned value matches the expected value
    }
    
      @Test
    public void testSearch() {
        System.out.println("search");
        CustomerBean instance = new CustomerBean();
        instance.search();
    }
}
