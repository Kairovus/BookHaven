/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import Util.HibernateUtil;
import model.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Z
 */
public class CustomerDAO {

    public void saveCustomer(Customer customer) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(customer);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateCustomer(Customer customer) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.merge(customer);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        Transaction tx = null;
        List<Customer> customers = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            customers = session.createCriteria(Customer.class).list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return customers;
    }

    public List<Customer> getCustomerByName(String lastName) {
        Transaction tx = null;
        List<Customer> customers = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            customers = session.createQuery("from Customer where lastName like :lastName").setParameter("lastName", "%" + lastName + "%").list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return customers;
    }

    public void deleteCustomer(int customerId) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Customer customer = (Customer) session.get(Customer.class, customerId);
            if (customer != null) {
                session.delete(customer);
                tx.commit();
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}
