package model;
// Generated Sep 28, 2024 10:31:33 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Staff generated by hbm2java
 */
public class Staff  implements java.io.Serializable {


     private Integer staffId;
     private String firstName;
     private String lastName;
     private String email;
     private String phone;
     private String position;
     private Set bookTransactions = new HashSet(0);

    public Staff() {
    }
   
    public Integer getStaffId() {
        return this.staffId;
    }
    
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    public Set getBookTransactions() {
        return this.bookTransactions;
    }
    
    public void setBookTransactions(Set bookTransactions) {
        this.bookTransactions = bookTransactions;
    }




}

