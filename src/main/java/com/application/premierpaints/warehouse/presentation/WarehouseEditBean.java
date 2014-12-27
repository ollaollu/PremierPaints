/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.warehouse.presentation;

import com.application.premierpaints.util.JsfUtil;
import com.application.premierpaints.warehouse.data.Warehouse;
import com.application.premierpaints.warehouse.ejb.WarehouseEJB;
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
@Named(value = "warehouseeditbean")
@RequestScoped
public class WarehouseEditBean implements Serializable{
    
    private Warehouse stock = new Warehouse();
    
    @EJB
    private WarehouseEJB ejb;
    
    public String saveStock(){
        try {
            ejb.edit(stock);
            JsfUtil.addSuccessMessage("Stock updated Successfully");
        } catch (EJBException e){
                JsfUtil.addErrorMessage("Error updating Stock");
                return "EditStock.xhtml";            
        }catch (Exception e) {
                Logger.getLogger(WarehouseEditBean.class.getName()).log(Level.SEVERE, "Error updating stock", e);
        }
        return "Warehouse.xhtml";
    }

    public Warehouse getStock() {
        return stock;
    }

    public void setStock(Warehouse stock) {
        this.stock = stock;
    }

    
}
