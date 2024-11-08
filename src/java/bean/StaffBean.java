/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.StaffDAO;
import java.util.List;
import model.Staff;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Z
 */
@ManagedBean(name = "staffBean")
@SessionScoped

public class StaffBean {

    private List<Staff> staffs;
    private Staff staff = new Staff();
    private StaffDAO staffDAO = new StaffDAO();
    private String searchname;

    public List<Staff> getStaffs() {
        if (searchname != null && !searchname.isEmpty()) {
            staffs = staffDAO.getStaffByName(searchname);
        } else {
            staffs = staffDAO.getAllStaff();
        }
        return staffs;
    }

    public String saveStaff() {
        staffDAO.saveStaff(staff);
        staff = new Staff();
        return "staffs";
    }

    public String updateStaff() {
        staffDAO.updateStaff(staff);
        staff = new Staff();
        return "staffs";
    }

    public String editStaff(Staff staff) {
        this.staff = staff;
        return "editStaff.xhtml";
    }

    public String deleteStaff(int staffId) {
        staffDAO.deleteStaff(staffId);
        staffs = staffDAO.getAllStaff();
        return "staffs";
    }

    public String clearStaff() {
        this.staff = new Staff();
        return "staffs";
    }

    public void search() {
        getStaffs();
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getSearchName() {
        return searchname;
    }

    public void setSearchName(String searchname) {
        this.searchname = searchname;
    }
    
    public void setStaffDAO(StaffDAO staffDAO){
        this.staffDAO = staffDAO;
    }
}
