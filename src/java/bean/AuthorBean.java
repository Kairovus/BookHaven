/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AuthorDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Author;

/**
 *
 * @author Z
 */
@ManagedBean(name = "authorBean")
@SessionScoped

public class AuthorBean {

    private Author author = new Author();
    private List<Author> authors;
    private AuthorDAO authorDAO = new AuthorDAO();
    private String searchname;

    public List<Author> getAuthors() {
        if (searchname != null && !searchname.isEmpty()) {
            authors = authorDAO.getAuthorByLastname(searchname);
        } else {
            authors = authorDAO.getAllAuthors();
        }
        return authors;
    }

    public String saveAuthor() {
        authorDAO.saveAuthor(author);
        author = new Author();
        return "authors";
    }

    public String updateAuthor() {
        authorDAO.updateAuthor(author);
        author = new Author();
        return "authors";
    }

    public String editAuthor(Author author) {
        this.author = author;
        author = new Author();
        return "editAuthor";
    }

    public String deleteAuthor(int authorId) {
        authorDAO.deleteAuthors(authorId);
        authors = authorDAO.getAllAuthors();
        return "authors";
    }


    public void search() {
        getAuthors();
    }

    public Author getAuthor() {
        return author;
    }

    public void setBook(Author book) {
        this.author = book;
    }

    public String getSearchName() {
        return searchname;
    }

    public void setSearchName(String searchname) {
        this.searchname = searchname;
    }
    
    public void setAuthorDAO(AuthorDAO authorDAO){
        this.authorDAO = authorDAO;
    }
}
