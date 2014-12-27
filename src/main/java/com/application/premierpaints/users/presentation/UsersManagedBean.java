/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.users.presentation;

import com.application.premierpaints.users.data.Users;
import com.application.premierpaints.users.ejb.UsersEJB;
import com.application.premierpaints.util.JsfUtil;
import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.LazyDataModel;
//import org.omnifaces.cdi.ViewScoped;


/**
 *
 * @author ollaollu
 */
@Named(value = "usersManagedBean")
@ViewScoped
public class UsersManagedBean implements Serializable {
    
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(UsersManagedBean.class); 
    
    private Users user = new Users();
    private List<Users> usersList;
    private transient DataModel<Users> userModel;
    private LazyDataModel<Users> lazyUserModel;
    private String searchValue;
    private UserDAO dao = new UserDAO();
    JasperPrint jasperPrint;

    @EJB
    private UsersEJB ejb;
    
    
    @PostConstruct
    public void init() {
        lazyUserModel = new LazyUserDataModel(ejb);
    }

    public LazyDataModel<Users> getLazyUserModel() {
        return lazyUserModel;
    }

    
        public void searchResult(){
            try {
                    usersList = dao.getSearchByUsername(searchValue);
                    getUserModel();
            } catch (SQLException ex) {
                Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error fetching Results"));
                JsfUtil.addErrorMessage("Error fetching Results");
            }
        }

    
    public String newUser(){
        try {
            user = ejb.create(user);
            JsfUtil.addSuccessMessage("User created successfully");
        } catch (EJBException e){
                JsfUtil.addErrorMessage("Username already exists");
                return "AddUser.xhtml";
        }catch (Exception e) {
                Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, "Error creating new user", e);               
        }
        return "ViewUsers.xhtml";
    }
    
    public String newNextUser(){
        try {
            user = ejb.create(user);
        } catch (EJBException e){
                //context.addMessage(null, new FacesMessage("Username already exists"));
                JsfUtil.addErrorMessage("Username already exists");
                return "AddUser.xhtml";
        }catch (Exception e) {
                Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, "Error creating new user", e);
                //context.addMessage(null, new FacesMessage("Username already exists"));
        }
        return "AddUser.xhtml";
    }

       
    public void deleteUser(Users user){
        try {
            ejb.remove(user);
            usersList.remove(lazyUserModel.getRowData(user.getFirstname()));
            JsfUtil.addSuccessMessage("User deleted successfully");
        } catch (EJBException e){
                JsfUtil.addErrorMessage("Error deleting user");          
        } catch (Exception e) {
                Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, "Error deleting user", e);

        }
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public DataModel<Users> getUserModel() {
        if(userModel == null){
            userModel = new ListDataModel<Users>(usersList);           
        }
        return userModel;
    }
    
    public void Jasperinit() throws JRException, MalformedURLException{
        usersList = ejb.findAll();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(usersList);
        String  reportPath=  FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/UserReport.jasper");
        //InputStream reportPath = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/reports/UserReport.jasper");
        //jasperPrint = JasperFillManager.fillReport("C:\\Users\\ollaollu\\UserReport.jasper", new HashMap(), beanCollectionDataSource); 
        jasperPrint=JasperFillManager.fillReport(reportPath, new HashMap(),beanCollectionDataSource);
    }
    
    public void Pdf() throws JRException, IOException{ 
        
        Jasperinit();
        
        HttpServletResponse servletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        servletResponse.addHeader("Content-disposition", "attachment; filename=UserPDFreport.pdf");
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        outputStream.flush();
        outputStream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    public void Docx(ActionEvent actionEvent) throws JRException, IOException{ 
        
        Jasperinit();
        
        HttpServletResponse servletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        servletResponse.addHeader("Content-disposition", "attachment; filename=UserDOCreport.docx");
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        JRDocxExporter docxExporter=new JRDocxExporter();
        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
        docxExporter.exportReport();
        outputStream.flush();
        outputStream.close();
        FacesContext.getCurrentInstance().responseComplete();
    
    }
    
    public void Xlsx(ActionEvent actionEvent) throws JRException, IOException{ 
        
        Jasperinit();
        
        HttpServletResponse servletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        servletResponse.addHeader("Content-disposition", "attachment; filename=UserEXCELreport.xlsx");
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        JRXlsxExporter docxExporter=new JRXlsxExporter();
        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
        docxExporter.exportReport();
        outputStream.flush();
        outputStream.close();
        FacesContext.getCurrentInstance().responseComplete();
    
    }  

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }    

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public UserDAO getDao() {
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }
    
              
}
