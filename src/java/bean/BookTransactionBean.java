/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.BookTransactionDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import model.BookTransaction;

/**
 *
 * @author Z
 */
@ManagedBean(name = "bookTransactionBean")
@SessionScoped

public class BookTransactionBean {

    private List<BookTransaction> booktransactions;
    private BookTransaction booktransaction = new BookTransaction();
    private BookTransactionDAO booktransactionDAO = new BookTransactionDAO();
    private int searchid;

    public List<BookTransaction> getBookTransactions() {
        if (searchid > 0) {
            booktransactions = booktransactionDAO.getBookTransactionById(searchid);
        } else {
            booktransactions = booktransactionDAO.getAllBookTransactions();
        }
        return booktransactions;
    }

    public String saveBookTransaction() {
        booktransactionDAO.saveBookTransaction(booktransaction);
        booktransaction = new BookTransaction();
        return "transactions";
    }

    public String updateBookTransaction() {
        booktransactionDAO.updateBookTransaction(booktransaction);
        booktransaction = new BookTransaction();
        return "transactions";
    }

    public String editBookTransaction(BookTransaction booktransaction) {
        this.booktransaction = booktransaction;
        return "editTransaction.xhtml";
    }

    public String deleteBookTransaction(int transactionId) {
        booktransactionDAO.deleteBookTransaction(transactionId);
        booktransactions = booktransactionDAO.getAllBookTransactions();
        return "transactions";
    }

    public String clearBookTransaction() {
        this.booktransaction = new BookTransaction();
        return "transactions";
    }

    public void search() {
        getBookTransactions();
    }

    public BookTransaction getBooktransaction() {
        return booktransaction;
    }

    public void setBooktransaction(BookTransaction booktransaction) {
        this.booktransaction = booktransaction;
    }

    public int getSearchId() {
        return searchid;
    }

    public void setSearchId(int searchid) {
        this.searchid = searchid;
    }
    
    public void setBookTransactionDAO(BookTransactionDAO bookTransactionDAO){
        this.booktransactionDAO = bookTransactionDAO;
    }
}
