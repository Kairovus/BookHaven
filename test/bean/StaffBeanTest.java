/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bean.StaffBean;
import dao.StaffDAO;
import model.Staff;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class StaffBeanTest {

    private StaffBean staffBean;
    private StaffDAO staffDAOMock;
    private Staff staff;

    @Before
    public void setUp() {
        staffBean = new StaffBean();
        staffDAOMock = Mockito.mock(StaffDAO.class);
        staffBean.setStaffDAO(staffDAOMock); // You might need to create this setter in the StaffBean class
        staff = new Staff();
        staff.setStaffId(1);
        staff.setFirstName("John");
        staff.setLastName("Doe");
        staff.setEmail("john.doe@example.com");
        staff.setPhone("1234567890");
        staff.setPosition("Librarian");
    }

    @Test
    public void testSaveStaff() {
        Staff staff = new Staff();
        staffBean.setStaff(staff);
        String result = staffBean.saveStaff();
        verify(staffDAOMock).saveStaff(staff);  // Verifying that the saveAuthor method in DAO is called
        assertEquals("staffs", result);
    }

    @Test
    public void testUpdateStaff() {
        Staff staff = new Staff();
        staffBean.setStaff(staff);
        String result = staffBean.updateStaff();
        verify(staffDAOMock).updateStaff(staff);  // Verifying that the saveAuthor method in DAO is called
        assertEquals("staffs", result);
    }

    @Test
    public void testDeleteStaff() {
        // Arrange
        int staffId = 1;

        // Act
        staffBean.deleteStaff(staffId);

        // Assert
        verify(staffDAOMock).deleteStaff(staffId);
        // Since the list of staff should be refreshed, assert the expected behavior
        verify(staffDAOMock).getAllStaff();
    }

    @Test
    public void testGetStaffsWithSearch() {
        // Arrange
        String searchName = "Doe";
        staffBean.setSearchName(searchName);
        List<Staff> expectedStaffList = new ArrayList<>();
        expectedStaffList.add(staff);
        when(staffDAOMock.getStaffByName(searchName)).thenReturn(expectedStaffList);

        // Act
        List<Staff> actualStaffList = staffBean.getStaffs();

        // Assert
        assertEquals(expectedStaffList, actualStaffList);
    }

    @Test
    public void testGetAllStaffs() {
        // Arrange
        List<Staff> expectedStaffList = new ArrayList<>();
        expectedStaffList.add(staff);
        when(staffDAOMock.getAllStaff()).thenReturn(expectedStaffList);

        // Act
        List<Staff> actualStaffList = staffBean.getStaffs();

        // Assert
        assertEquals(expectedStaffList, actualStaffList);
    }
    
     @Test
    public void testClearStaff() {
        StaffBean instance = new StaffBean();
        String expResult = "staffs";
        String result = instance.clearStaff();
        assertEquals(expResult, result);
    }
    
     @Test
    public void testEditStaff() {
        // Arrange
        Staff staffToEdit = new Staff();
        staffToEdit.setStaffId(1);
        staffToEdit.setFirstName("John");
        staffToEdit.setLastName("Doe");
        staffToEdit.setEmail("john.doe@example.com");
        staffToEdit.setPhone("1234567890");
        staffToEdit.setPosition("Librarian");

        // Act
        staffBean.editStaff(staffToEdit); // Call the editStaff method

        // Assert
        assertEquals(staffToEdit, staffBean.getStaff()); // Verify the staff was set correctly
    }
    
    @Test
    public void testSearch() {
        System.out.println("search");
        StaffBean instance = new StaffBean();
        instance.search();
    }
    
    @Test
    public void testGetStaff() {
        // Arrange
        Staff expectedStaff = new Staff();
        expectedStaff.setStaffId(1);
        expectedStaff.setFirstName("Jane");
        expectedStaff.setLastName("Doe");
        expectedStaff.setEmail("jane.doe@example.com");
        expectedStaff.setPhone("0987654321");
        expectedStaff.setPosition("Manager");

        // Set the staff in the bean
        staffBean.setStaff(expectedStaff); // You may need a setter for this

        // Act
        Staff actualStaff = staffBean.getStaff(); // Call the getStaff method

        // Assert
        assertEquals(expectedStaff, actualStaff); // Verify that the correct staff is returned
    }
    
        @Test
    public void testGetSearchName() {
        // Arrange
        String expectedSearchName = "John";
        staffBean.setSearchName(expectedSearchName);

        // Act
        String actualSearchName = staffBean.getSearchName();

        // Assert
        assertEquals(expectedSearchName, actualSearchName);
    }
}
