/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.BookTransactionDAO;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Staff;

/**
 *
 * @author Z
 */
@FacesConverter("staffConverter")
public class StaffConverter implements Converter {

    private BookTransactionDAO booktransactionDAO = new BookTransactionDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        // You should implement a method to fetch the author by id
        return booktransactionDAO.getStaffById(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || !(value instanceof Staff)) {
            return "";
        }

        return String.valueOf(((Staff) value).getStaffId());
    }
}
