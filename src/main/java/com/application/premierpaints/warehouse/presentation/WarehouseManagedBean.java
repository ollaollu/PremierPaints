/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.warehouse.presentation;

import com.application.premierpaints.util.JsfUtil;
import com.application.premierpaints.util.PremierConnection;
import com.application.premierpaints.warehouse.data.Warehouse;
import com.application.premierpaints.warehouse.ejb.WarehouseEJB;
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
import javax.enterprise.context.RequestScoped;
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
@Named(value = "warehouseManagedBean")
@ViewScoped
public class WarehouseManagedBean implements Serializable{
    
    private PremierConnection conman = null;
    private LazyDataModel<Warehouse> lazyModel;    
    private Warehouse stock = new Warehouse();
    private LazyWarehouseDataModel sourceList;
    private List<Warehouse> warehouseList;
    private transient DataModel<Warehouse> warehouseModel;
    JasperPrint jasperPrint;

    @EJB
    private WarehouseEJB ejb;
    
    @PostConstruct
    public void init(){
        lazyModel = new LazyWarehouseDataModel(ejb);
    }
    
    public void recall(){
        lazyModel = new LazyWarehouseDataModel(ejb);
        System.out.println("worked");
    }

    public LazyDataModel<Warehouse> getLazyModel() {
        return lazyModel;
    }
    
    public void Jasperinit() throws JRException, MalformedURLException{ 
        warehouseList = ejb.findAll();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(warehouseList);
        String  reportPath=  FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/WarehouseReport.jasper");
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
    
    public String newStock(){
        try {
            stock = ejb.create(stock);
            warehouseList = ejb.findAll();
            JsfUtil.addSuccessMessage("Stock created successfully");
        } catch (EJBException e){
            JsfUtil.addErrorMessage("Raw material exists");
            return "AddStock.xhtml";
        } catch (Exception e) {
                Logger.getLogger(WarehouseManagedBean.class.getName()).log(Level.SEVERE, "Error creating new stock", e);            
        }
        return "Warehouse.xhtml";
    }
    
    public String newNextStock(){
        try {
            stock = ejb.create(stock);
            warehouseList = ejb.findAll();
            JsfUtil.addSuccessMessage("Stock created successfully");            
        } catch (EJBException e){
            JsfUtil.addErrorMessage("Raw material exists");
            return "AddStock.xhtml";
        } catch (Exception e) {
                Logger.getLogger(WarehouseManagedBean.class.getName()).log(Level.SEVERE, "Error creating new stock", e);            
        }
        return "AddStock.xhtml";
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
                Logger.getLogger(WarehouseManagedBean.class.getName()).log(Level.SEVERE, "Error updating stock", e);            
        }
        return "Warehouse.xhtml";
        //return "ViewUsers.xhtml";
    }
    
    public void deleteStock(Warehouse stock){
        try {
            ejb.remove(stock);
            //warehouseList.remove(lazyModel.getRowData(stock.getRwcode()));
            //warehouseList.remove(stock);
            JsfUtil.addSuccessMessage("Stock deleted successfully");            
        } catch (EJBException e){
            JsfUtil.addErrorMessage("Error deleting stock");
        }catch (Exception e) {
                Logger.getLogger(WarehouseManagedBean.class.getName()).log(Level.SEVERE, "Error deleting stock", e);            
        }
    }

    public Warehouse getStock() {
        return stock;
    }

    public List<Warehouse> getWarehouseList() {
        return warehouseList;
    }

    public DataModel<Warehouse> getWarehouseModel() {
        if(warehouseModel == null){
            warehouseModel = new ListDataModel<Warehouse>(warehouseList);           
        }        
        return warehouseModel;
    }

    public LazyWarehouseDataModel getSourceList() {
        return sourceList;
    }

    public void setSourceList(LazyWarehouseDataModel sourceList) {
        this.sourceList = sourceList;
    }
    
    
}
