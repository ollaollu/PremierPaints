/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.reports;

import com.application.premierpaints.production.data.Production;
import com.application.premierpaints.util.JsfUtil;
import com.application.premierpaints.util.PremierConnection;
import com.application.premierpaints.warehouse.data.Warehouseissue;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author ollaollu
 */
@Named(value = "ReportsDAO")
@ViewScoped
public class ReportsDAO implements Serializable{
    private PremierConnection conman;
    private List<Production> productionList;
    private List<Warehouseissue> issueList;
    JasperPrint jasperPrint;
    private String product;
    private Date searchValue_1;
    private Date searchValue_2;
    private String productValue;
    private String clientValue;
    private String productname;
    private int productionbatch;
    private String client;
    private double requiredqty;
    private String status;
    private Date strdate;
    private Date enddate;
    
    //reports for warehouse using list search and date range search
    //reports for products using list search and date range search
    //reports for production using list search and date range search
        public List getProductionByDateRange(Date searchValue_1, Date searchValue_2) throws SQLException{
            //bean = new UsersManagedBean();
            conman = new PremierConnection();
            String sql = "select * from production where strdate between ? and ?";
            //searchValue = bean.getSearchValue();
            Connection conn = null;
            PreparedStatement stm = null;           
            List result = new ArrayList();

            try {
                conn = conman.getDBConnection();
                stm = conn.prepareStatement(sql);
                stm.setDate(1, new java.sql.Date(searchValue_1.getTime()));
                stm.setDate(2, new java.sql.Date(searchValue_2.getTime()));
                String output = MessageFormat.format("From {0} to {1}", searchValue_1, searchValue_2);
                            System.out.println(output);
                
                ResultSet rs = stm.executeQuery();
                
                while (rs.next()) {                    
                    Production us = new Production();
                    us.setProductname(rs.getString("productname"));
                    us.setProductionbatch(rs.getInt("productionbatch"));
                    us.setRequiredqty(rs.getDouble("requiredqty"));
                    us.setClient(rs.getString("client"));
                    us.setStatus(rs.getString("status"));
                    us.setStrdate(rs.getDate("strdate"));
                    us.setEnddate(rs.getDate("enddate"));
                    us.setCreatedby(rs.getString("createdby"));
                    result.add(us);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JsfUtil.addErrorMessage("Error fetching record(s)");
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            return result;
            
        }
        
        public List getProductionByProduct(String productValue) throws SQLException{
            //bean = new UsersManagedBean();
            conman = new PremierConnection();
            String sql = "select * from production where productname like ?";
            //searchValue = bean.getSearchValue();
            Connection conn = null;
            PreparedStatement stm = null;           
            List result = new ArrayList();

            try {
                conn = conman.getDBConnection();
                stm = conn.prepareStatement(sql);
                stm.setString(1, productValue + "%");
                String output = MessageFormat.format("{0}", productValue);
                            System.out.println(output);
                
                ResultSet rs = stm.executeQuery();
                
                while (rs.next()) {                    
                    Production us = new Production();
                    us.setProductname(rs.getString("productname"));
                    us.setProductionbatch(rs.getInt("productionbatch"));
                    us.setRequiredqty(rs.getDouble("requiredqty"));
                    us.setClient(rs.getString("client"));
                    us.setStatus(rs.getString("status"));
                    us.setStrdate(rs.getDate("strdate"));
                    us.setEnddate(rs.getDate("enddate"));
                    us.setCreatedby(rs.getString("createdby"));
                    result.add(us);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JsfUtil.addErrorMessage("Error fetching record(s)");
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            return result;
            
        }        
        
        
        public List getProductionByClient(String clientValue) throws SQLException{
            //bean = new UsersManagedBean();
            conman = new PremierConnection();
            String sql = "select * from production where client like ?";
            //searchValue = bean.getSearchValue();
            Connection conn = null;
            PreparedStatement stm = null;           
            List result = new ArrayList();

            try {
                conn = conman.getDBConnection();
                stm = conn.prepareStatement(sql);
                stm.setString(1, clientValue + "%");
                String output = MessageFormat.format("{0}", clientValue);
                            System.out.println(output);
                
                ResultSet rs = stm.executeQuery();
                
                while (rs.next()) {                    
                    Production us = new Production();
                    us.setProductname(rs.getString("productname"));
                    us.setProductionbatch(rs.getInt("productionbatch"));
                    us.setRequiredqty(rs.getDouble("requiredqty"));
                    us.setClient(rs.getString("client"));
                    us.setStatus(rs.getString("status"));
                    us.setStrdate(rs.getDate("strdate"));
                    us.setEnddate(rs.getDate("enddate"));
                    us.setCreatedby(rs.getString("createdby"));
                    result.add(us);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JsfUtil.addErrorMessage("Error fetching record(s)");
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            return result;
            
        }
        
        public List getWarehouseIssueDate(String product, Date searchValue_1, Date searchValue_2) throws SQLException{
            //bean = new UsersManagedBean();
            conman = new PremierConnection();
            String sql = "select * from warehouseissue where rwcode like ? and createdate between ? and ?";
            //searchValue = bean.getSearchValue();
            Connection conn = null;
            PreparedStatement stm = null;           
            List result = new ArrayList();

            try {
                conn = conman.getDBConnection();
                stm = conn.prepareStatement(sql);
                stm.setString(1, product+"%");
                stm.setDate(2, new java.sql.Date(searchValue_1.getTime()));
                stm.setDate(3, new java.sql.Date(searchValue_2.getTime()));
                String output = MessageFormat.format("Product {0} From {1} to {2}", product, searchValue_1, searchValue_2);
                            System.out.println(output);
                
                ResultSet rs = stm.executeQuery();
                
                while (rs.next()) {                    
                    Warehouseissue us = new Warehouseissue();
                    us.setRwcode(rs.getString("rwcode"));
                    us.setRwname(rs.getString("rwname"));
                    us.setIssued(rs.getDouble("issued"));
                    us.setReceived(rs.getDouble("received"));
                    us.setOldstockbalance(rs.getDouble("oldstockbalance"));
                    us.setStockbalance(rs.getDouble("stockbalance"));
                    us.setCreatedate(rs.getDate("createdate"));
                    us.setCreatedby(rs.getString("createdby"));
                    result.add(us);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JsfUtil.addErrorMessage("Error fetching record(s)");
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            return result;
            
        }
        
        public List getWarehouseIssueParticulars(String product, Date searchValue_1, Date searchValue_2) throws SQLException{
            //bean = new UsersManagedBean();
            conman = new PremierConnection();
            String sql = "select * from warehouseissue where rwname like ? and createdate between ? and ?";
            //searchValue = bean.getSearchValue();
            Connection conn = null;
            PreparedStatement stm = null;           
            List result = new ArrayList();

            try {
                conn = conman.getDBConnection();
                stm = conn.prepareStatement(sql);
                stm.setString(1, product+"%");
                stm.setDate(2, new java.sql.Date(searchValue_1.getTime()));
                stm.setDate(3, new java.sql.Date(searchValue_2.getTime()));
                String output = MessageFormat.format("Product {0} From {1} to {2}", product, searchValue_1, searchValue_2);
                            System.out.println(output);
                
                ResultSet rs = stm.executeQuery();
                
                while (rs.next()) {                    
                    Warehouseissue us = new Warehouseissue();
                    us.setRwcode(rs.getString("rwcode"));
                    us.setRwname(rs.getString("rwname"));
                    us.setIssued(rs.getDouble("issued"));
                    us.setReceived(rs.getDouble("received"));
                    us.setOldstockbalance(rs.getDouble("oldstockbalance"));
                    us.setStockbalance(rs.getDouble("stockbalance"));
                    us.setCreatedate(rs.getDate("createdate"));
                    us.setCreatedby(rs.getString("createdby"));
                    result.add(us);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JsfUtil.addErrorMessage("Error fetching record(s)");
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            return result;
            
        }        

        
        public List resukt(){
            try {
                    //searchValue = getSearchValue();
                    productionList = getProductionByDateRange(searchValue_1,searchValue_2);
                    JsfUtil.addSuccessMessage("Results updated");
            } catch (SQLException ex) {
                Logger.getLogger(ReportsDAO.class.getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage("Error fetching Results");
            }            
            return productionList;
        }
        
        public List productresukt(){
            try {
                    //searchValue = getSearchValue();
                    productionList = getProductionByProduct(productValue);
                    JsfUtil.addSuccessMessage("Results updated");
            } catch (SQLException ex) {
                Logger.getLogger(ReportsDAO.class.getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage("Error fetching Results");
            }            
            return productionList;
        }
        
        public List clientresukt(){
            try {
                    //searchValue = getSearchValue();
                    productionList = getProductionByClient(clientValue);
                    JsfUtil.addSuccessMessage("Results updated");
            } catch (SQLException ex) {
                Logger.getLogger(ReportsDAO.class.getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage("Error fetching Results");
            }            
            return productionList;
        }
        
        public List warehouseissueresukt(){
            try {
                    //searchValue = getSearchValue();
                    issueList = getWarehouseIssueDate(product, searchValue_1, searchValue_2);
                    JsfUtil.addSuccessMessage("Results updated");
            } catch (SQLException ex) {
                Logger.getLogger(ReportsDAO.class.getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage("Error fetching Results");
            }            
            return issueList;
        }
        
        public List warehouseissueParticularsresukt(){
            try {
                    //searchValue = getSearchValue();
                    issueList = getWarehouseIssueParticulars(product, searchValue_1, searchValue_2);
                    JsfUtil.addSuccessMessage("Results updated");
            } catch (SQLException ex) {
                Logger.getLogger(ReportsDAO.class.getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage("Error fetching Results");
            }            
            return issueList;
        }        
        
    public void Jasperinit() throws JRException, MalformedURLException{
        //usersList = ejb.findAll();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(productionList);
        String  reportPath=  FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/ProductionReport.jasper");
        //InputStream reportPath = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/reports/UserReport.jasper");
        //jasperPrint = JasperFillManager.fillReport("C:\\Users\\ollaollu\\UserReport.jasper", new HashMap(), beanCollectionDataSource); 
        jasperPrint=JasperFillManager.fillReport(reportPath, new HashMap(),beanCollectionDataSource);
    }
    
    public void IssueJasperinit() throws JRException, MalformedURLException{
        //usersList = ejb.findAll();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(issueList);
        String  reportPath=  FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/WarehouseissueReport.jasper");
        //InputStream reportPath = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/reports/UserReport.jasper");
        //jasperPrint = JasperFillManager.fillReport("C:\\Users\\ollaollu\\UserReport.jasper", new HashMap(), beanCollectionDataSource); 
        jasperPrint=JasperFillManager.fillReport(reportPath, new HashMap(),beanCollectionDataSource);
    }    
    
    public void dateSearchPdf(ActionEvent actionEvent) throws JRException, IOException{ 
        
        Jasperinit();
        
        HttpServletResponse servletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        servletResponse.addHeader("Content-disposition", "attachment; filename=ProductionAdvancedReport.pdf");
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        outputStream.flush();
        outputStream.close();
        FacesContext.getCurrentInstance().responseComplete();
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

    public Date getSearchValue_1() {
        return searchValue_1;
    }

    public void setSearchValue_1(Date searchValue_1) {
        this.searchValue_1 = searchValue_1;
    }

    public Date getSearchValue_2() {
        return searchValue_2;
    }

    public void setSearchValue_2(Date searchValue_2) {
        this.searchValue_2 = searchValue_2;
    }

    public List<Production> getProductionList() {
        return productionList;
    }

    public void setProductionList(List<Production> productionList) {
        this.productionList = productionList;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getProductionbatch() {
        return productionbatch;
    }

    public void setProductionbatch(int productionbatch) {
        this.productionbatch = productionbatch;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStrdate() {
        return strdate;
    }

    public void setStrdate(Date strdate) {
        this.strdate = strdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public double getRequiredqty() {
        return requiredqty;
    }

    public void setRequiredqty(double requiredqty) {
        this.requiredqty = requiredqty;
    }

    public String getProductValue() {
        return productValue;
    }

    public void setProductValue(String productValue) {
        this.productValue = productValue;
    }

    public String getClientValue() {
        return clientValue;
    }

    public void setClientValue(String clientValue) {
        this.clientValue = clientValue;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public List<Warehouseissue> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<Warehouseissue> issueList) {
        this.issueList = issueList;
    }
   
}
