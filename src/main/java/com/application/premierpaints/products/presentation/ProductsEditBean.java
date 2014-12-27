/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.products.presentation;

import com.application.premierpaints.products.data.Products;
import com.application.premierpaints.products.ejb.ProductsEJB;
import com.application.premierpaints.users.data.Users;
import com.application.premierpaints.users.ejb.UsersEJB;
import com.application.premierpaints.util.JsfUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ollaollu
 */
@Named(value = "productseditbean")
@RequestScoped
public class ProductsEditBean implements Serializable{
    
    private Products product = new Products();
    
    @EJB
    private ProductsEJB ejb;
    
    public String saveProduct(){
        try {
            ejb.edit(product);
            JsfUtil.addSuccessMessage("Product updated successfully");
        } catch (EJBException e){
                JsfUtil.addErrorMessage("Error updating product");
                return "EditProduct.xhtml";            
        } catch (Exception e) {
                Logger.getLogger(ProductsEditBean.class.getName()).log(Level.SEVERE, "Error updating product", e);             
        }
        return "Products.xhtml";
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    

}
