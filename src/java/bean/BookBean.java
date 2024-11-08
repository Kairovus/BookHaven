/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.BookDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Book;

/**
 *
 * @author Z
 */
@ManagedBean(name = "bookBean")
@SessionScoped

public class BookBean {

    private Book book = new Book();
    private List<Book> books;
    private BookDAO bookDAO = new BookDAO();
    private String searchtitle;

    public List<Book> getBooks() {
        if (searchtitle != null && !searchtitle.isEmpty()) {
            books = bookDAO.getBookByTitle(searchtitle);
        } else {
            books = bookDAO.getAllBooks();
        }
        return books;
    }

    public String saveBook() {
        bookDAO.saveBook(book);
        book = new Book();
        return "books";
    }

    public String updateBook() {
        bookDAO.updateBook(book);
        book = new Book();
        return "books";
    }

    public String editBook(Book book) {
        this.book = book;
        return "editBook.xhtml";
    }

    public String deleteBook(int bookId) {
        bookDAO.deleteBook(bookId);
        books = bookDAO.getAllBooks();
        return "books";
    }

    public String clearBook() {
        this.book = new Book();
        return "books";
    }

    public void search() {
        getBooks();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getSearchTitle() {
        return searchtitle;
    }

    public void setSearchTitle(String searchtitle) {
        this.searchtitle = searchtitle;
    }
    
    public void setBookDAO(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }
}
