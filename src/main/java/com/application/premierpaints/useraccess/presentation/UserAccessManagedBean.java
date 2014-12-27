/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.useraccess.presentation;

import com.application.premierpaints.useraccess.data.Useraccess;
import com.application.premierpaints.useraccess.ejb.UseraccessEJB;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import net.sf.jasperreports.engine.JasperPrint;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author ollaollu
 */
@Named(value = "userAccessManagedBean")
@RequestScoped
public class UserAccessManagedBean implements Serializable {

    private Useraccess user = new Useraccess();
    private List<Useraccess> useraccessList;
    private LazyDataModel<Useraccess> lazyModel;
    private String searchValue;
    JasperPrint jasperPrint;

    @EJB
    private UseraccessEJB ejb;
    
    
    @PostConstruct
    public void init() {
        lazyModel = new LazyUserAccessDataModel(ejb);
        useraccessList = ejb.findAll();
    }

    public LazyDataModel<Useraccess> getLazyModel() {
        return lazyModel;
    }

    public Useraccess getUser() {
        return user;
    }

    public void setUser(Useraccess user) {
        this.user = user;
    }

    public List<Useraccess> getUseraccessList() {
        return useraccessList;
    }

    public void setUseraccessList(List<Useraccess> useraccessList) {
        this.useraccessList = useraccessList;
    }
    
    
    
}
