package model;
// Generated Sep 28, 2024 10:31:33 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Book generated by hbm2java
 */
public class Book  implements java.io.Serializable {


     private Integer bookId;
     private Author author;
     private String title;
     private String isbn;
     private Integer publishedYear;
     private String genre;
     private Set bookTransactions = new HashSet(0);

    public Book() {
    }
    
    public Book(Author author, String title, String isbn, Integer publishedYear, String genre, Set bookTransactions) {
       this.author = author;
       this.title = title;
       this.isbn = isbn;
       this.publishedYear = publishedYear;
       this.genre = genre;
       this.bookTransactions = bookTransactions;
    }
    
    public Integer getBookId() {
        return this.bookId;
    }
    
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
    public Author getAuthor() {
        return this.author;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIsbn() {
        return this.isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Integer getPublishedYear() {
        return this.publishedYear;
    }
    
    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }
    public String getGenre() {
        return this.genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Set getBookTransactions() {
        return this.bookTransactions;
    }
    
    public void setBookTransactions(Set bookTransactions) {
        this.bookTransactions = bookTransactions;
    }




}


