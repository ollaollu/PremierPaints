/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.warehouse.presentation;

import com.application.premierpaints.util.JsfUtil;
import com.application.premierpaints.util.PremierConnection;
import com.application.premierpaints.warehouse.data.Warehouseissue;
import com.application.premierpaints.warehouse.ejb.WarehouseissueEJB;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
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
@Named(value = "warehouseissueManagedBean")
@ViewScoped
public class WarehouseissueManagedBean implements Serializable{

    private LazyDataModel<Warehouseissue> lazyModel;    
    private Warehouseissue stock = new Warehouseissue();
    private LazyWarehouseissueDataModel sourceList;
    private List<Warehouseissue> warehouseList;
    private transient DataModel<Warehouseissue> warehouseModel;
    JasperPrint jasperPrint;

    @EJB
    private WarehouseissueEJB ejb;
    
    @PostConstruct
    public void init(){
        lazyModel = new LazyWarehouseissueDataModel(ejb);
    }

    public LazyDataModel<Warehouseissue> getLazyModel() {
        return lazyModel;
    }
    
    public void Jasperinit() throws JRException, MalformedURLException{ 
        warehouseList = ejb.findAll();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(warehouseList);
        String  reportPath=  FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/WarehouseissueReport.jasper");
        //InputStream reportPath = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/reports/UserReport.jasper");
        //jasperPrint = JasperFillManager.fillReport("C:\\Users\\ollaollu\\UserReport.jasper", new HashMap(), beanCollectionDataSource); 
        jasperPrint=JasperFillManager.fillReport(reportPath, new HashMap(),beanCollectionDataSource);
    }
    
    public void Pdf(ActionEvent actionEvent) throws JRException, IOException{ 
        
        Jasperinit();
        
        HttpServletResponse servletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        servletResponse.addHeader("Content-disposition", "attachment; filename=WarehousePDFreport.pdf");
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }    
        
        public void Docx(ActionEvent actionEvent) throws JRException, IOException{ 
        
        Jasperinit();
        
        HttpServletResponse servletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        servletResponse.addHeader("Content-disposition", "attachment; filename=WarehouseDOCreport.docx");
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
        servletResponse.addHeader("Content-disposition", "attachment; filename=WarehouseEXCELreport.xlsx");
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        JRXlsxExporter docxExporter=new JRXlsxExporter();
        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
        docxExporter.exportReport();
        FacesContext.getCurrentInstance().responseComplete();
    
    }
    
    public void IssueJasperinit() throws JRException, MalformedURLException{
        //usersList = ejb.findAll();
        warehouseList = ejb.findAll();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(warehouseList);
        String  reportPath=  FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/WarehouseissueReport.jasper");
        //InputStream reportPath = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/reports/UserReport.jasper");
        //jasperPrint = JasperFillManager.fillReport("C:\\Users\\ollaollu\\UserReport.jasper", new HashMap(), beanCollectionDataSource); 
        jasperPrint=JasperFillManager.fillReport(reportPath, new HashMap(),beanCollectionDataSource);
    }    
    
    public void issueSearchPdf(ActionEvent actionEvent) throws JRException, IOException{ 
        
        IssueJasperinit();
        
        HttpServletResponse servletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        servletResponse.addHeader("Content-disposition", "attachment; filename=WarehouseIssueReport.pdf");
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        outputStream.flush();
        outputStream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }    
    
    public String newStock(){
        try {
            stock = ejb.create(stock);
            warehouseList = ejb.findAll();
            JsfUtil.addSuccessMessage("Stock created successfully");
        } catch (EJBException e){
            JsfUtil.addErrorMessage("Raw material exists");
            return "";
        } catch (Exception e) {
                Logger.getLogger(WarehouseissueManagedBean.class.getName()).log(Level.SEVERE, "Error creating new stock", e);            
        }
        return "WarehouseIssue.xhtml";
    }
    
    public String newNextStock(){
        try {
            stock = ejb.create(stock);
            warehouseList = ejb.findAll();
            JsfUtil.addSuccessMessage("Stock created successfully");            
        } catch (EJBException e){
            JsfUtil.addErrorMessage("Raw material exists");
            return "";
        } catch (Exception e) {
                Logger.getLogger(WarehouseissueManagedBean.class.getName()).log(Level.SEVERE, "Error creating new stock", e);            
        }
        return "";
    }
    
    public String saveStock(){
        try {
            ejb.edit(stock);
            //warehouseList = ejb.findAll();
            JsfUtil.addSuccessMessage("Stock updated successfully");
        } catch (EJBException e){
            JsfUtil.addErrorMessage("Error updating stock");
            return "EditStock.xhtml";
        } catch (Exception e) {
                Logger.getLogger(WarehouseissueManagedBean.class.getName()).log(Level.SEVERE, "Error updating stock", e);            
        }
        return "Warehouseissue.xhtml";
        //return "ViewUsers.xhtml";
    }
    
    public void deleteStock(Warehouseissue stock){
        try {
            ejb.remove(stock);
            //warehouseList.remove(lazyModel.getRowData(stock.getRwcode()));
            //warehouseList.remove(stock);
            JsfUtil.addSuccessMessage("Stock deleted successfully");            
        } catch (EJBException e){
            JsfUtil.addErrorMessage("Error deleting stock");
        }catch (Exception e) {
                Logger.getLogger(WarehouseissueManagedBean.class.getName()).log(Level.SEVERE, "Error deleting stock", e);            
        }
    }

    public Warehouseissue getStock() {
        return stock;
    }

    public List<Warehouseissue> getWarehouseList() {
        return warehouseList;
    }

    public DataModel<Warehouseissue> getWarehouseModel() {
        if(warehouseModel == null){
            warehouseModel = new ListDataModel<Warehouseissue>(warehouseList);           
        }        
        return warehouseModel;
    }

    public LazyWarehouseissueDataModel getSourceList() {
        return sourceList;
    }

    public void setSourceList(LazyWarehouseissueDataModel sourceList) {
        this.sourceList = sourceList;
    }  
    
}
