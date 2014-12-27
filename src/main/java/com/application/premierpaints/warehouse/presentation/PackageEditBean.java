/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.warehouse.presentation;

import com.application.premierpaints.util.JsfUtil;
import com.application.premierpaints.warehouse.data.Productionpackage;
import com.application.premierpaints.warehouse.ejb.ProductionpackageEJB;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ollaollu
 */
@Named(value = "packageeditbean")
@RequestScoped
public class PackageEditBean implements Serializable{
    
    private Productionpackage packaging = new Productionpackage();
    
    @EJB
    private ProductionpackageEJB ejb;
    
    public String savePackage(){
        try {
            ejb.edit(packaging);
            JsfUtil.addSuccessMessage("Package updated Successfully");
        } catch (Exception e) {
                Logger.getLogger(PackageEditBean.class.getName()).log(Level.SEVERE, "Error updating package", e);            
                JsfUtil.addErrorMessage("Error updating Package");
        }
        return "ViewPackage.xhtml";
    }

    public Productionpackage getPackaging() {
        return packaging;
    }

    public void setPackaging(Productionpackage packaging) {
        this.packaging = packaging;
    }
    

}
