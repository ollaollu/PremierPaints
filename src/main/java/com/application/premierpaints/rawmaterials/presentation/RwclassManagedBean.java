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
@Named(value = "rwclassManagedBean")
@ViewScoped
public class RwclassManagedBean implements Serializable {

    private Rwclass rwclass = new Rwclass();
    private List<Rwclass> classList;
    private LazyDataModel<Rwclass> lazyModel;
    private transient DataModel<Rwclass> classModel;
    @EJB
    private RwclassEJB ejb;
    
    @PostConstruct
    public void init(){
        lazyModel = new LazyRwclassDataModel(ejb);
        try {
            classList = ejb.findAll();
            Collections.sort(classList);
        } catch (Exception e) {
                Logger.getLogger(RwclassManagedBean.class.getName()).log(Level.SEVERE, "Error retreiving class code list", e);            
        }
    }

    public LazyDataModel<Rwclass> getLazyModel() {
        return lazyModel;
    }
    
    
    public String newRWClass(){
        try {
            rwclass = ejb.create(rwclass);
            //classList = ejb.findAll();
            JsfUtil.addSuccessMessage("Raw material class created successfully");
        } catch (Exception e) {
                Logger.getLogger(RwclassManagedBean.class.getName()).log(Level.SEVERE, "Error creating class code", e);            
                JsfUtil.addErrorMessage("Error creating Raw material class");
        }
        return "ViewRWClass.xhtml";
    }
    
    public String newNextRWClass(){
        try {
            rwclass = ejb.create(rwclass);
            //classList = ejb.findAll();
            JsfUtil.addSuccessMessage("Raw material class created successfully");
        } catch (Exception e) {
                Logger.getLogger(RwclassManagedBean.class.getName()).log(Level.SEVERE, "Error creating class code", e);            
                JsfUtil.addErrorMessage("Error creating Raw material class");
        }
        return "RWClass.xhtml";
    }
    
    
    public void deleteClass(Rwclass entity){
        try {
            ejb.remove(entity);
            classList.remove(lazyModel.getRowData(entity.getRwclassName()));
            JsfUtil.addSuccessMessage("Raw material class deleted successfully");
        } catch (Exception e) {
                Logger.getLogger(RwclassManagedBean.class.getName()).log(Level.SEVERE, "Error deleting class code", e);            
                JsfUtil.addErrorMessage("Error deleting Raw material class");
        }
    }

    public Rwclass getRwclass() {
        return rwclass;
    }

    public List<Rwclass> getClassList() {
        return classList;
    }

    public DataModel<Rwclass> getClassModel() {
        if(classModel == null){
            classModel = new ListDataModel<Rwclass>(classList);           
        }        
        return classModel;
    }
    
}
