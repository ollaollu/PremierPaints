/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.production.presentation;

import com.application.premierpaints.production.data.Production;
import com.application.premierpaints.production.ejb.ProductionEJB;
import com.application.premierpaints.util.JsfUtil;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
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

/**
 *
 * @author ollaollu
 */
@Named(value = "productionManagedBean")
@ViewScoped
public class ProductionManagedBean implements Serializable{

    private Production production = new Production();
    private LazyDataModel<Production> lazyProductionModel;    
    private List<Production> productionList;
    private transient DataModel<Production> productionModel;
    JasperPrint jasperPrint;
    
    @EJB
    private ProductionEJB ejb;
    
    @PostConstruct
    public void init(){
        lazyProductionModel = new LazyProductionDataModel(ejb);
    }

    public LazyDataModel<Production> getLazyProductionModel() {
        return lazyProductionModel;
    }
    
    
    public String newProduction(){
        try {
            production = ejb.create(production);            
        } catch (EJBException e){
                //context.addMessage(null, new FacesMessage("Username already exists"));
                JsfUtil.addErrorMessage("Error creating production");
                return "/Protected/Pages/Users/PreProduction.xhtml";
        } catch (Exception e) {
                Logger.getLogger(ProductionManagedBean.class.getName()).log(Level.SEVERE, "Error creating production", e);             
        }
        return "/Protected/Pages/Users/Production.xhtml";
    }
    
    public String newNextProduction(){
        try {
            production = ejb.create(production);
            JsfUtil.addSuccessMessage("Production created successfully");            
        } catch (EJBException e){
                //context.addMessage(null, new FacesMessage("Username already exists"));
                JsfUtil.addErrorMessage("Error creating new production");
                return "/Protected/Pages/Users/PreProduction.xhtml";
        } catch (Exception e) {
                Logger.getLogger(ProductionManagedBean.class.getName()).log(Level.SEVERE, "Error creating production", e);             
        }
        return "/Protected/Pages/Users/PreProduction.xhtml";
    }
    
    public void deleteProduction(Production production){
        try {
            ejb.remove(production);
            productionList.remove(lazyProductionModel.getRowData(production.getProductname()));
            JsfUtil.addSuccessMessage("Production deleted successfully");
        } catch (EJBException e){
                JsfUtil.addErrorMessage("Error deleting production");            
        } catch (Exception e) {
                Logger.getLogger(ProductionManagedBean.class.getName()).log(Level.SEVERE, "Error deleting production", e);             
        }
    }
    
    public void Jasperinit() throws JRException, MalformedURLException{
        productionList = ejb.findAll();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(productionList);
        String  reportPath=  FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/ProductionReport.jasper");
        //InputStream reportPath = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/reports/UserReport.jasper");
        //jasperPrint = JasperFillManager.fillReport("C:\\Users\\ollaollu\\UserReport.jasper", new HashMap(), beanCollectionDataSource); 
        jasperPrint=JasperFillManager.fillReport(reportPath, new HashMap(),beanCollectionDataSource);
    }
    
    public void Pdf(ActionEvent actionEvent) throws JRException, IOException{ 
        
        Jasperinit();
        
        HttpServletResponse servletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        servletResponse.addHeader("Content-disposition", "attachment; filename=ProductionPDFreport.pdf");
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    public void Docx(ActionEvent actionEvent) throws JRException, IOException{ 
        
        Jasperinit();
        
        HttpServletResponse servletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        servletResponse.addHeader("Content-disposition", "attachment; filename=ProductionDOCreport.docx");
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        JRDocxExporter docxExporter=new JRDocxExporter();
        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
        docxExporter.exportReport();
        FacesContext.getCurrentInstance().responseComplete();
    
    }
    
    public void Xlsx(ActionEvent actionEvent) throws JRException, IOException{ 
        
        Jasperinit();
        
        HttpServletResponse servletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        servletResponse.addHeader("Content-disposition", "attachment; filename=ProductionEXCELreport.xlsx");
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        JRXlsxExporter docxExporter=new JRXlsxExporter();
        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
        docxExporter.exportReport();
        FacesContext.getCurrentInstance().responseComplete();
    
    }  
    

    public Production getProduction() {
        return production;
    }

    public List<Production> getProductionList() {
        return productionList;
    }

    public DataModel<Production> getProductionModel() {
        if(productionModel == null){
            productionModel = new ListDataModel<Production>(productionList);           
        }        
        return productionModel;
    }   
    
}
