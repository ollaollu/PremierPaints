/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.production.presentation;

import com.application.premierpaints.production.data.Production;
import com.application.premierpaints.production.ejb.ProductionEJB;
import com.application.premierpaints.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ollaollu
 */
@Named(value = "productionEditBean")
@RequestScoped
public class ProductionEditBean {

    /**
     * Creates a new instance of ProductionEditBean
     */
    private Production production = new Production();
    
    @EJB
    private ProductionEJB ejb;
    
    public String saveProduction(){
        try {
            ejb.edit(production);
            //JsfUtil.addSuccessMessage("Production updated successfully");
        } catch (EJBException e){
                JsfUtil.addErrorMessage("Error updating production");
                return "/Protected/Pages/Admin/EditProduction.xhtml";            
        } catch (Exception e) {
                Logger.getLogger(ProductionEditBean.class.getName()).log(Level.SEVERE, "Error updating production", e);             
        }
        return "/Protected/Pages/Users/Production.xhtml";
    }     

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }
    
}
