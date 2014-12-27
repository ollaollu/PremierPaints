/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.products.presentation;

import com.application.premierpaints.products.data.Products;
import com.application.premierpaints.products.ejb.ProductsEJB;
import com.application.premierpaints.util.JsfUtil;
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
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
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

/**
 *
 * @author ollaollu
 */
@Named(value = "productsManagedBean")
@ViewScoped
public class ProductsManagedBean implements Serializable{

    private Products product = new Products();
    private LazyDataModel<Products> lazyModel;    
    private List<Products> productsList;
    private transient DataModel<Products> productsModel;
    JasperPrint jasperPrint;
    
    @EJB
    private ProductsEJB ejb;
    
    @PostConstruct
    public void init(){
            lazyModel = new LazyProductsDataModel(ejb);
    }

    public LazyDataModel<Products> getLazyModel() {
        return lazyModel;
    }
    
    
    public String newProduct(){
        try {
            product = ejb.create(product);
            productsList = ejb.findAll();
            JsfUtil.addSuccessMessage("Product created successfully");
        } catch (EJBException e){
                JsfUtil.addErrorMessage("Error creating product");
                return "AddProduct.xhtml";
        } catch (Exception e) {
                Logger.getLogger(ProductsManagedBean.class.getName()).log(Level.SEVERE, "Error creating product", e);             
                JsfUtil.addErrorMessage("Error creating product");
                return "AddProduct.xhtml";
        }
        //ProductsManagedBean bean = new ProductsManagedBean();
        return "Products.xhtml?faces-redirect=true";
    }
    
    public String newNextProduct(){
        try {
            product = ejb.create(product);
            productsList = ejb.findAll();
            JsfUtil.addSuccessMessage("Product created successfully");
        } catch (EJBException e){
                JsfUtil.addErrorMessage("Error creating product");
                return "AddProduct.xhtml";
        } catch (Exception e) {
                Logger.getLogger(ProductsManagedBean.class.getName()).log(Level.SEVERE, "Error creating product", e);             
                JsfUtil.addErrorMessage("Error creating product");
                return "AddProduct.xhtml";
        }
        return "AddProduct.xhtml";
    }
    
    
    public String preProduction(){
        product = lazyModel.getRowData(product.getProductName());
        
        return "NewProduction.xhtml";
    }
    
    
    public void deleteProduct(Products product){
        try {
            ejb.remove(product);
            productsList.remove(lazyModel.getRowData(product.getProductName()));
            JsfUtil.addSuccessMessage("Product deleted successfully");
        } catch (EJBException e){
                JsfUtil.addErrorMessage("Error deleting product");            
        } catch (Exception e) {
                Logger.getLogger(ProductsManagedBean.class.getName()).log(Level.SEVERE, "Error deleting product", e);             
        }
    }
    
    public void Jasperinit() throws JRException, MalformedURLException{
        productsList = ejb.findAll();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(productsList);
        String  reportPath=  FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/ProductReport.jasper");
        //InputStream reportPath = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/reports/UserReport.jasper");
        //jasperPrint = JasperFillManager.fillReport("C:\\Users\\ollaollu\\UserReport.jasper", new HashMap(), beanCollectionDataSource); 
        jasperPrint=JasperFillManager.fillReport(reportPath, new HashMap(),beanCollectionDataSource);
    }
    
    public void Pdf(ActionEvent actionEvent) throws JRException, IOException{ 
        
        Jasperinit();
        
        HttpServletResponse servletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        servletResponse.addHeader("Content-disposition", "attachment; filename=ProductsPDFreport.pdf");
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    public void Docx(ActionEvent actionEvent) throws JRException, IOException{ 
        
        Jasperinit();
        
        HttpServletResponse servletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        servletResponse.addHeader("Content-disposition", "attachment; filename=ProductsDOCreport.docx");
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
        servletResponse.addHeader("Content-disposition", "attachment; filename=ProductsEXCELreport.xlsx");
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        JRXlsxExporter docxExporter=new JRXlsxExporter();
        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
        docxExporter.exportReport();
        FacesContext.getCurrentInstance().responseComplete();
    
    }  
    

    public Products getProduct() {
        return product;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public DataModel<Products> getProductsModel() {
        if(productsModel == null){
            productsModel = new ListDataModel<Products>(productsList);           
        }        
        return productsModel;
    }   
    
}
