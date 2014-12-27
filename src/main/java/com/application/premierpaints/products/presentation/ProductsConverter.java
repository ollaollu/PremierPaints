/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.products.presentation;

import com.application.premierpaints.products.data.Products;
import com.application.premierpaints.products.ejb.ProductsEJB;
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
@Named(value = "productsconverter")
@RequestScoped
public class ProductsConverter implements Converter {

    @EJB
    private ProductsEJB ejb;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        if (!value.matches("[0-9]+")) {
            throw new ConverterException("The value is not a valid Products ID: " + value);
        }

        Integer id = Integer.valueOf(value);
        return ejb.find(id);
    }

    @Override    
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
        if (value == null) {
            return "";
        }

        if (!(value instanceof Products)) {
            throw new ConverterException("The value is not a valid Product instance: " + value);
        }

        Integer id = ((Products) value).getProductId();
        return (id != null) ? String.valueOf(id) : null;
    }

}
