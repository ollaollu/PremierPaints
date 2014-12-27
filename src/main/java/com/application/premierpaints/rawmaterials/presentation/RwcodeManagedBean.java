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
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author ollaollu
 */
@Named(value = "rwcodeManagedBean")
@ViewScoped
public class RwcodeManagedBean implements Serializable {

    private Rwcode rwcode = new Rwcode();
    private List<Rwcode> codeList;
    private LazyDataModel<Rwcode> lazyModel;
    private transient DataModel<Rwcode> codeModel;
    @EJB
    private RwcodeEJB ejb;
    
    @PostConstruct
    public void init(){
        lazyModel = new LazyRwcodeDataModel(ejb);
        try {
            codeList = ejb.findAll();
            Collections.sort(codeList);
        } catch (Exception e) {
                Logger.getLogger(RwcodeManagedBean.class.getName()).log(Level.SEVERE, "Error retrieving code list", e);            
        }
    }

    public LazyDataModel<Rwcode> getLazyModel() {
        return lazyModel;
    }
    
    
    public String newRWCode(){
        try {
            rwcode = ejb.create(rwcode);
            //codeList = ejb.findAll();
            JsfUtil.addSuccessMessage("Raw material code created successfully");
        } catch (Exception e) {
                Logger.getLogger(RwcodeManagedBean.class.getName()).log(Level.SEVERE, "Error creating code", e);            
                JsfUtil.addErrorMessage("Error creating Raw material code");
        }
        return "ViewRWCode.xhtml";
    }
    
    public String newNextRWCode(){
        try {
            rwcode = ejb.create(rwcode);
            //codeList = ejb.findAll();
            JsfUtil.addSuccessMessage("Raw material code created successfully");
        } catch (Exception e) {
                Logger.getLogger(RwcodeManagedBean.class.getName()).log(Level.SEVERE, "Error creating code", e);            
                JsfUtil.addErrorMessage("Error creating Raw material code");
        }
        return "RWCode.xhtml";
    }
    
    
    public void deleteCode(Rwcode entity){
        try {
            ejb.remove(entity);
            codeList.remove(lazyModel.getRowData(entity.getRwcodename()));
            JsfUtil.addSuccessMessage("Raw material code deleted successfully");
        } catch (Exception e) {
                Logger.getLogger(RwcodeManagedBean.class.getName()).log(Level.SEVERE, "Error deleting code", e);            
                JsfUtil.addErrorMessage("Error creating Raw material code");
        }
    }

    public Rwcode getRwcode() {
        return rwcode;
    }

    public List<Rwcode> getCodeList() {
        return codeList;
    }

    public DataModel<Rwcode> getCodeModel() {
        if(codeModel == null){
            codeModel = new ListDataModel<Rwcode>(codeList);           
        }        
        return codeModel;
    }
    
}
