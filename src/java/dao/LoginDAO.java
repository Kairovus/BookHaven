/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Admin;
import Util.HibernateUtil;

/**
 *
 * @author Z
 */
public class LoginDAO {

    public List<Admin> getBy(String adminId, String password) {
        Admin a = new Admin();
        List<Admin> admin = new ArrayList<>();
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Admin where adminId = :adminId AND password = :password");
            query.setString("adminId", adminId);
            query.setString("password", password);
            a = (Admin) query.uniqueResult();
            admin = query.list();

            tx.commit();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        return admin;
    }
}
