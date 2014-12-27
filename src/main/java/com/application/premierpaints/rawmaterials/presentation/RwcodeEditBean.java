/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.rawmaterials.presentation;

import com.application.premierpaints.rawmaterials.data.Rwcode;
import com.application.premierpaints.rawmaterials.ejb.RwcodeEJB;
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
@Named(value = "rwcodeeditbean")
@RequestScoped
public class RwcodeEditBean implements Serializable{
    
    private Rwcode rwcode = new Rwcode();
    
    @EJB
    private RwcodeEJB ejb;
    
    public String saveCode(){
        try {
            ejb.edit(rwcode);
            JsfUtil.addSuccessMessage("Raw Material code updated Successfully");
        } catch (Exception e) {
                Logger.getLogger(RwcodeManagedBean.class.getName()).log(Level.SEVERE, "Error updating code", e);            
                JsfUtil.addErrorMessage("Error updating Raw material code");
        }
        return "ViewRWCode.xhtml";
        //return "ViewUsers.xhtml";
    }    

    public Rwcode getRwcode() {
        return rwcode;
    }

    public void setRwcode(Rwcode rwcode) {
        this.rwcode = rwcode;
    }




    

}
