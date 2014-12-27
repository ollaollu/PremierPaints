/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.warehouse.presentation;

import com.application.premierpaints.production.presentation.ProductionManagedBean;
import com.application.premierpaints.rawmaterials.data.Rwcode;
import com.application.premierpaints.rawmaterials.ejb.RwcodeEJB;
import com.application.premierpaints.util.JsfUtil;
import com.application.premierpaints.warehouse.data.Productionpackage;
import com.application.premierpaints.warehouse.ejb.ProductionpackageEJB;
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
@Named(value = "packageManagedBean")
@ViewScoped
public class PackageManagedBean implements Serializable {

    private Productionpackage packaging = new Productionpackage();
    private ProductionManagedBean bean = new ProductionManagedBean();
    private List<Productionpackage> packageList;
    private List<Productionpackage> containerList;
    private LazyDataModel<Productionpackage> lazyModel;
    private transient DataModel<Productionpackage> codeModel;
    @EJB
    private ProductionpackageEJB ejb;
    
    @PostConstruct
    public void init(){
        lazyModel = new PackageDataModel(ejb);
        try {
            packageList = ejb.findAll();
        } catch (Exception e) {
                Logger.getLogger(PackageManagedBean.class.getName()).log(Level.SEVERE, "Error retrieving package list", e);            
        }
    }

    public LazyDataModel<Productionpackage> getLazyModel() {
        return lazyModel;
    }
    
    
    public String newPackage(){
        try {
            packaging = ejb.create(packaging);
            //codeList = ejb.findAll();
            JsfUtil.addSuccessMessage("Package created successfully");
        } catch (Exception e) {
                Logger.getLogger(PackageManagedBean.class.getName()).log(Level.SEVERE, "Error creating package", e);            
                JsfUtil.addErrorMessage("Error creating Package");
        }
        return "ViewPackage.xhtml";
    }
    
    public String newNextPackage(){
        try {
            packaging = ejb.create(packaging);
            //codeList = ejb.findAll();
            JsfUtil.addSuccessMessage("Package created successfully");
        } catch (Exception e) {
                Logger.getLogger(PackageManagedBean.class.getName()).log(Level.SEVERE, "Error creating package", e);            
                JsfUtil.addErrorMessage("Error creating Package");
        }
        return "AddPackage.xhtml";
    }
    
    
    public void deletePackage(Productionpackage entity){
        try {
            ejb.remove(entity);
            JsfUtil.addSuccessMessage("Package deleted successfully");
        } catch (Exception e) {
                Logger.getLogger(PackageManagedBean.class.getName()).log(Level.SEVERE, "Error deleting package", e);            
                JsfUtil.addErrorMessage("Error creating Package");
        }
    }
    
    public void changeContainer(){
        String packageGotten = bean.getProduction().getPackagetype();
        System.out.println(packageGotten);
        containerList = ejb.findContainer(packageGotten);
    }

    public Productionpackage getPackaging() {
        return packaging;
    }

    public void setPackaging(Productionpackage packaging) {
        this.packaging = packaging;
    }

    public List<Productionpackage> getPackageList() {
        return packageList;
    }

    public void setPackageList(List<Productionpackage> packageList) {
        this.packageList = packageList;
    }

    public DataModel<Productionpackage> getCodeModel() {
        return codeModel;
    }

    public void setCodeModel(DataModel<Productionpackage> codeModel) {
        this.codeModel = codeModel;
    }

    public ProductionManagedBean getBean() {
        return bean;
    }

    public void setBean(ProductionManagedBean bean) {
        this.bean = bean;
    }

    
}
