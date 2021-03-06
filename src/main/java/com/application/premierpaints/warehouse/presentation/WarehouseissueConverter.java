/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.warehouse.presentation;

import com.application.premierpaints.warehouse.data.Warehouse;
import com.application.premierpaints.warehouse.data.Warehouseissue;
import com.application.premierpaints.warehouse.ejb.WarehouseEJB;
import com.application.premierpaints.warehouse.ejb.WarehouseissueEJB;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

/**
 *
 * @author ollaollu
 */
@Named(value = "warehouseissueconverter")
@RequestScoped
public class WarehouseissueConverter implements Converter {

    @EJB
    private WarehouseissueEJB ejb;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        if (!value.matches("[0-9]+")) {
            throw new ConverterException("The value is not a valid Stock ID: " + value);
        }

        Integer id = Integer.valueOf(value);
        return ejb.find(id);
    }

    @Override    
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
        if (value == null) {
            return "";
        }

        if (!(value instanceof Warehouseissue)) {
            throw new ConverterException("The value is not a valid Warehouse instance: " + value);
        }

        Integer id = ((Warehouseissue) value).getId();
        return (id != null) ? String.valueOf(id) : null;
    }

}
