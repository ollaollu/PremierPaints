/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.rawmaterials.presentation;

import com.application.premierpaints.rawmaterials.data.Rwclass;
import com.application.premierpaints.rawmaterials.ejb.RwclassEJB;
import com.application.premierpaints.util.JsfUtil;
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
@Named(value = "rwclasseditbean")
@RequestScoped
public class RwclassEditBean implements Serializable{
    
    private Rwclass rwclass = new Rwclass();
    
    @EJB
    private RwclassEJB ejb;
    
    public String saveClass(){
        try {
            ejb.edit(rwclass);
            JsfUtil.addSuccessMessage("Raw Material Class updated Successfully");
        } catch (Exception e) {
                Logger.getLogger(RwclassEditBean.class.getName()).log(Level.SEVERE, "Error updating class code", e);            
                JsfUtil.addErrorMessage("Error updating Raw material class");
        }
        return "ViewRWClass.xhtml";
        //return "ViewUsers.xhtml";
    }

    public Rwclass getRwclass() {
        return rwclass;
    }

    public void setRwclass(Rwclass rwclass) {
        this.rwclass = rwclass;
    }


    

}
