/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.production.presentation;

import com.application.premierpaints.util.BaseSessionListener;
import com.application.premierpaints.util.JsfUtil;
import com.application.premierpaints.util.PremierConnection;
import com.application.premierpaints.warehouse.data.Warehouse;
import com.application.premierpaints.warehouse.ejb.WarehouseEJB;
import com.application.premierpaints.warehouse.presentation.WarehouseManagedBean;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author ollaollu
 * @date 29/09/2014
 * 
 * this class is used to check the current production quantity from our new
 * production frontend, deduct from the warehouse value of that particular
 * input code, save the remainder back to our warehouse and return
 * our initially gotten production quantity to be persisted into the database
 * 
 */
@Named(value = "ProductionWarehouseRemoval")
@ViewScoped
public class ProductionWarehouseRemoval implements Serializable{
    
    private PremierConnection conman = null;
    WarehouseManagedBean wBean = new WarehouseManagedBean();
    private BaseSessionListener bsl;
    //private List oldValue;
    private String name;
    private String particulars;
    private double issued;
    private double received;
    private String createdby;
    private Date createdate;
    private double oldstockbalance;
    private double stockbalance;
    
    private Warehouse stock = new Warehouse();
    
    @EJB
    private WarehouseEJB ejb;
    
        public double getStockQty(String inputCode) throws SQLException{
            conman = new PremierConnection();
            String sql = "select quantity from warehouse where rwcode like ?";
            Connection conn = null;
            PreparedStatement stm = null;           
            //List result = new ArrayList();
            double result = 0;

            try {
                conn = conman.getDBConnection();
                stm = conn.prepareStatement(sql);
                stm.setString(1, inputCode + "%");
                //stm.setString(2, searchValue + "%");
                String output = MessageFormat.format("{0}", inputCode);
                            System.out.println(output);
                
                ResultSet rs = stm.executeQuery();
                
                while (rs.next()) {                    
                    //Warehouse ws = new Warehouse();
                    //ws.setQuantity(rs.getDouble("quantity"));
                    //result.add(ws);
                    result = rs.getDouble("quantity");
                    if(rs.wasNull()){
                        result = 0.0;
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JsfUtil.addErrorMessage("Error fetching value");
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
        
        public int getStockId(String inputCode) throws SQLException{
            conman = new PremierConnection();
            String sql = "select stockid from warehouse where rwcode like ?";
            Connection conn = null;
            PreparedStatement stm = null;           
            //List result = new ArrayList();
            int id = 0;

            try {
                conn = conman.getDBConnection();
                stm = conn.prepareStatement(sql);
                stm.setString(1, inputCode + "%");
                //stm.setString(2, searchValue + "%");
                String output = MessageFormat.format("{0}", inputCode);
                            System.out.println(output);
                
                ResultSet rs = stm.executeQuery();
                
                while (rs.next()) {                    
                    //Warehouse ws = new Warehouse();
                    //ws.setQuantity(rs.getDouble("quantity"));
                    //result.add(ws);
                    id = rs.getInt("stockid");
                    
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JsfUtil.addErrorMessage("Error fetching value");
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            return id;
            
        }
        
        public List getOldValueforEdit(int batch) throws SQLException{
            conman = new PremierConnection();
            String sql = "select * from production where productionbatch = ?";
            Connection conn = null;
            PreparedStatement stm = null;           
            List result = new ArrayList();
            //double result = 0;

            try {
                conn = conman.getDBConnection();
                stm = conn.prepareStatement(sql);
                stm.setInt(1, batch);
                //stm.setString(2, searchValue + "%");
                String output = MessageFormat.format("{0}", batch);
                            System.out.println(output);
                
                ResultSet rs = stm.executeQuery();
                
                while (rs.next()) {                    
                    //Warehouse ws = new Warehouse();
                    //ws.setQuantity(rs.getDouble("quantity"));
                    //result.add(ws);
                    //result = rs.getDouble("quantity");
                    result.add(rs.getDouble("productionqty1"));
                    result.add(rs.getDouble("productionqty2"));
                    result.add(rs.getDouble("productionqty3"));
                    result.add(rs.getDouble("productionqty4"));
                    result.add(rs.getDouble("productionqty5"));
                    result.add(rs.getDouble("productionqty6"));
                    result.add(rs.getDouble("productionqty7"));
                    result.add(rs.getDouble("productionqty8"));
                    result.add(rs.getDouble("productionqty9"));
                    result.add(rs.getDouble("productionqty10"));
                    result.add(rs.getDouble("productionqty11"));
                    result.add(rs.getDouble("productionqty12"));
                    result.add(rs.getDouble("productionqty13"));
                    result.add(rs.getDouble("productionqty14"));
                    result.add(rs.getDouble("productionqty15"));
                    result.add(rs.getDouble("productionqty16"));
                    result.add(rs.getDouble("productionqty17"));
                    result.add(rs.getDouble("productionqty18"));
                    result.add(rs.getDouble("productionqty19"));
                    result.add(rs.getDouble("productionqty20"));
                    result.add(rs.getDouble("addprodqty1"));
                    result.add(rs.getDouble("addprodqty2"));
                    result.add(rs.getDouble("addprodqty3"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JsfUtil.addErrorMessage("Error fetching value");
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
        
        public double getInputCodeCost(String code) throws SQLException{
            conman = new PremierConnection();
            String sql = "select cost from warehouse where rwcode = ?";
            Connection conn = null;
            PreparedStatement stm = null;           
            //List result = new ArrayList();
            double result = 0;

            try {
                conn = conman.getDBConnection();
                stm = conn.prepareStatement(sql);
                stm.setString(1, code);
                //stm.setDouble(1, x);
                //stm.setInt(1, batch);
                //stm.setString(2, searchValue + "%");
                String output = MessageFormat.format("{0}", code);
                            System.out.println(output);
                
                ResultSet rs = stm.executeQuery();
                
                while (rs.next()) {                    
                    //Warehouse ws = new Warehouse();
                    //ws.setQuantity(rs.getDouble("quantity"));
                    //result.add(ws);
                    result = rs.getDouble("cost");
                    if(rs.wasNull()){
                        result = 0.0;
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JsfUtil.addErrorMessage("Error fetching value");
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            System.out.println(result);
            return result;
            
        }         
    
    
    public void updateWarehouse(double newDbQty, int sBatch) throws SQLException{
    conman = new PremierConnection();
    String sql = "UPDATE warehouse SET quantity = ? WHERE stockid = ?";
    Connection conn = null;
    PreparedStatement stm = null;
        try
        {
          conn = conman.getDBConnection();
          stm = conn.prepareStatement(sql);
          stm.setDouble(1, newDbQty);
          stm.setInt(2, sBatch);
          stm.executeUpdate();
          
          String output = MessageFormat.format("{0} as primary key, {1} as new qty value", sBatch, newDbQty);
          System.out.println(output);

        }
        catch (SQLException e) {
            JsfUtil.addErrorMessage("Error performing update");
        }finally
        {
          if (stm != null) {
            stm.close();
          }
          if (conn != null) {
            conn.close();
          }
        }
  }
    
    public void populateWarehouseIssue(String name, String particulars, double issued, String createdBy, Date created, double oldstockbalance, double stockbalance) throws SQLException{
        conman = new PremierConnection();
        String sql = "insert into warehouseissue (rwcode, rwname, issued, createdby, createdate, oldstockbalance, stockbalance) values (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = conman.getDBConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, particulars);
            stm.setDouble(3, issued);
            stm.setString(4, createdBy);
            stm.setDate(5, new java.sql.Date(created.getTime()));
            stm.setDouble(6, oldstockbalance);
            stm.setDouble(7, stockbalance);
            stm.executeUpdate();
            
            String output = MessageFormat.format("{0} is raw material name, {1} is particulars, {2} is quantity issued/used, {3} is who applied for issue, {4} date it was issued, {5} is old stock balance, {6} is new stock balance", name, particulars, issued, createdBy, created, oldstockbalance, stockbalance);
            System.out.println(output);
        } catch (SQLException e) {
                System.out.println(e.getMessage());
                JsfUtil.addErrorMessage("Error updating issue record(s)");
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
        
    }
    
    public void populateWarehouseIssueOpeningStock(String name, String particulars, String createdBy, Date created, double stockbalance) throws SQLException{
        conman = new PremierConnection();
        String sql = "insert into warehouseissue (rwcode, rwname, createdby, createdate, stockbalance) values (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = conman.getDBConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, particulars);
            //stm.setDouble(3, issued);
            stm.setString(3, createdBy);
            stm.setDate(4, new java.sql.Date(created.getTime()));
            //stm.setDouble(6, oldstockbalance);
            stm.setDouble(5, stockbalance);
            stm.executeUpdate();
            
            String output = MessageFormat.format("{0} is raw material name, {1} is particulars, {2} is who applied for issue, {3} date it was issued, {4} is new stock balance", name, particulars, createdBy, created, stockbalance);
            System.out.println(output);
        } catch (SQLException e) {
                System.out.println(e.getMessage());
                JsfUtil.addErrorMessage("Error updating issue record(s)");
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
        
    }
    
    public void populateWarehouseIssueEditOpeningStock(String name, String particulars, String editedBy, Date created, double stockbalance) throws SQLException{
        conman = new PremierConnection();
        String sql = "insert into warehouseissue (rwcode, rwname, editedby, editdate, stockbalance) values (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = conman.getDBConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, particulars);
            //stm.setDouble(3, issued);
            stm.setString(3, editedBy);
            stm.setDate(4, new java.sql.Date(created.getTime()));
            //stm.setDouble(6, oldstockbalance);
            stm.setDouble(5, stockbalance);
            stm.executeUpdate();
            
            String output = MessageFormat.format("{0} is raw material name, {1} is particulars, {2} is who applied for issue, {3} date it was issued, {4} is new stock balance", name, particulars, editedBy, created, stockbalance);
            System.out.println(output);
        } catch (SQLException e) {
                System.out.println(e.getMessage());
                JsfUtil.addErrorMessage("Error updating issue record(s)");
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
        
    }    
    
    public String updateStock(){
        try {
            String uName = stock.getRwcode();
            //String uParticulars = stock.getRwname();
            double uStockbalance = stock.getQuantity();
            //int id = getStockId(name);
            //updateWarehouseandReceivedWarehouse(stockbalance, id);
            ejb.miniEdit(stock);
            updateWarehouseandReceived(uName, particulars, received, oldstockbalance, uStockbalance);
            JsfUtil.addSuccessMessage("Stock updated successfully");
        } catch (SQLException ex) {
            Logger.getLogger(ProductionWarehouseRemoval.class.getName()).log(Level.SEVERE, null, ex);
            JsfUtil.addErrorMessage("Error updating stock");
        }
        
        return "Warehouse.xhtml";
    }
    
    
    public void updateWarehouseandReceived(String name, String particulars, double received, double oldstockbalance, double stockbalance) throws SQLException{
        conman = new PremierConnection();
        bsl = new BaseSessionListener();
        Date created = new Date();
        String createdBy = bsl.remoteUser();
        //String sql1 = "update warehouse set quantity = ? where rwcode = ?";
        String sql2 = "insert into warehouseissue (rwcode, rwname, received, createdby, createdate, oldstockbalance, stockbalance) values (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        //PreparedStatement stm1 = null;
        PreparedStatement stm2 = null;
        
        try {
            conn = conman.getDBConnection();
            //stm1 = conn.prepareStatement(sql1);
            stm2 = conn.prepareStatement(sql2);
            //stm1.setDouble(1, stockbalance);
            //stm1.setString(2, name);
            stm2.setString(1, name);
            stm2.setString(2, particulars);
            stm2.setDouble(3, received);
            stm2.setString(4, createdBy);
            stm2.setDate(5, new java.sql.Date(created.getTime()));
            stm2.setDouble(6, oldstockbalance);
            stm2.setDouble(7, stockbalance);
            //stm1.executeUpdate();
            stm2.executeUpdate();
            
            String output = MessageFormat.format("{0} is raw material name, {1} is particulars, {2} is quantity issued/used, {3} is who applied for issue, {4} date it was issued, {5} is old stock balance, {6} is new stock balance", name, particulars, received, createdBy, created, oldstockbalance, stockbalance);
            System.out.println(output);            
        } catch (SQLException e) {
                System.out.println(e.getMessage());
                JsfUtil.addErrorMessage("Error updating issue record(s)");
            } finally {
                if (stm2 !=null) {
                    //stm1.close();
                    stm2.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
        }
    
    public void updateWarehouseandReceivedWarehouse(double stockbalance, int id) throws SQLException{
        conman = new PremierConnection();
        String sql = "update warehouse set quantity = ? where stockid = ?";
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = conman.getDBConnection();
            stm = conn.prepareStatement(sql);
            stm.setDouble(1, stockbalance);
            stm.setInt(2, id);
            stm.executeUpdate();
            
            String output = MessageFormat.format("{0} is raw material name, {1} is particulars, {2} is quantity issued/used, {3} is who applied for issue, {4} date it was issued, {5} is old stock balance, {6} is new stock balance", stockbalance, name);
            System.out.println(output);            
        } catch (SQLException e) {
                System.out.println(e.getMessage());
                JsfUtil.addErrorMessage("Error updating issue record(s)");
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
        }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public double getIssued() {
        return issued;
    }

    public void setIssued(double issued) {
        this.issued = issued;
    }

    public double getReceived() {
        return received;
    }

    public void setReceived(double received) {
        this.received = received;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public double getOldstockbalance() {
        return oldstockbalance;
    }

    public void setOldstockbalance(double oldstockbalance) {
        this.oldstockbalance = oldstockbalance;
    }

    public double getStockbalance() {
        return stockbalance;
    }

    public void setStockbalance(double stockbalance) {
        this.stockbalance = stockbalance;
    }

    public Warehouse getStock() {
        return stock;
    }

    public void setStock(Warehouse stock) {
        this.stock = stock;
    }
        
    }

  
