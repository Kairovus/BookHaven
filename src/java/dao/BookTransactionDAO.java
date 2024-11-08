/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Book;
import Util.HibernateUtil;
import model.BookTransaction;
import model.Customer;
import model.Staff;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Z
 */
public class BookTransactionDAO {

    public void saveBookTransaction(BookTransaction booktransaction) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(booktransaction);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateBookTransaction(BookTransaction booktransaction) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.merge(booktransaction);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<BookTransaction> getAllBookTransactions() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.createCriteria(BookTransaction.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to get a transaction by its ID
    public List<BookTransaction> getBookTransactionById(int customerId) {
        Transaction tx = null;
        List<BookTransaction> booktransaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            booktransaction = session.createQuery("from Booktransaction where customerId = :customerId").setParameter("customerId", customerId).list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return booktransaction;
    }

    public Book getBookById(int id) {
        Transaction tx = null;
        Book book = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            book = (Book) session.get(Book.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return book;
    }

    public Customer getCustomerById(int id) {
        Transaction tx = null;
        Customer customer = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            customer = (Customer) session.get(Customer.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return customer;
    }

    public Staff getStaffById(int id) {
        Transaction tx = null;
        Staff staff = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            staff = (Staff) session.get(Staff.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return staff;
    }

    public void deleteBookTransaction(int transactionId) {
        Transaction tx = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            BookTransaction bookTransaction = (BookTransaction) session.get(BookTransaction.class, transactionId);

            if (bookTransaction != null) {
                session.delete(bookTransaction);
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
