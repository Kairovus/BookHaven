/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.CustomerDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import model.Customer;

/**
 *
 * @author Z
 */
@ManagedBean(name = "customerBean")
@SessionScoped

public class CustomerBean {

    private List<Customer> customers;
    private Customer customer = new Customer();
    private CustomerDAO customerDAO = new CustomerDAO();
    private String searchname;

    public List<Customer> getCustomers() {
        if (searchname != null && !searchname.isEmpty()) {
            customers = customerDAO.getCustomerByName(searchname);
        } else {
            customers = customerDAO.getAllCustomers();
        }
        return customers;
    }

    public String saveCustomer() {
        customerDAO.saveCustomer(customer);
        customer = new Customer();
        return "customers";
    }

    public String updateCustomer() {
        customerDAO.updateCustomer(customer);
        customer = new Customer();
        return "customers";
    }

    public String editCustomer(Customer customer) {
        this.customer = customer;
        return "editCustomer.xhtml";
    }

    public String deleteCustomer(int customerId) {
        customerDAO.deleteCustomer(customerId);
        customers = customerDAO.getAllCustomers();
        return "customers";
    }

    public String clearCustomer() {
        this.customer = new Customer();
        return "customers";
    }

    public void search() {
        getCustomers();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getSearchName() {
        return searchname;
    }

    public void setSearchName(String searchname) {
        this.searchname = searchname;
    }
    
    public void setCustomerDAO(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }
}
