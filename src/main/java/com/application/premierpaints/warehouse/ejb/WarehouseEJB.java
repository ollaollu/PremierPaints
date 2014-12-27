/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.warehouse.ejb;

import com.application.premierpaints.production.presentation.ProductionWarehouseRemoval;
import com.application.premierpaints.util.BaseSessionListener;
import com.application.premierpaints.warehouse.data.Warehouse;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author ollaollu
 */
@Stateless
public class WarehouseEJB {
    @PersistenceContext(unitName = "premierPaintsPU")
    private EntityManager entityManager;
    private BaseSessionListener bsl;
    private final ProductionWarehouseRemoval pwr = new ProductionWarehouseRemoval();

    protected EntityManager getEntityManager() {
        return entityManager;
    }


    public int count() {
        return ((Long) entityManager.createQuery("select count(w) from Warehouse as w").getSingleResult()).intValue();
    }

    
    public List<Warehouse> findRange(int[] range) {
        return null;
    }
    

    public List<Warehouse> findAll(int startingAt, int maxPerPage, String filterValue) {
        String sql = "select w from Warehouse w where w.rwcode like ?1";    
        Query query = entityManager.createQuery(sql);
        query.setParameter(1, filterValue + "%");
        query.setFirstResult(startingAt);
        query.setMaxResults(maxPerPage);
        
        return query.getResultList();        
    }    

    
    public List<Warehouse> findAll() {
        TypedQuery query = entityManager.createNamedQuery("Warehouse.findAll", Warehouse.class);
        return query.getResultList();
    }

    
    public Warehouse find(Object id) {
        return entityManager.find(Warehouse.class, id);
    }

    
    public void remove(Warehouse stock) {
        entityManager.remove(entityManager.merge(stock));
    }

    
    public void edit(Warehouse stock) throws SQLException {
            bsl = new BaseSessionListener();
            String name = stock.getRwcode();
            String editParticulars = "Edit: " + name + " " + stock.getRwname();
        
            Date dateEdited = new Date();
            String editedBy = bsl.remoteUser();
            
            stock.setEditedby(editedBy);
            stock.setTimeedited(dateEdited);
            //pwr.populateWarehouseIssueOpeningStock(name, editParticulars, editedBy, dateEdited, stock.getQuantity());
            pwr.populateWarehouseIssueEditOpeningStock(name, editParticulars, editedBy, dateEdited, stock.getQuantity());
        entityManager.merge(stock);
    }
    
    public void miniEdit(Warehouse stock) throws SQLException{
            String uName = stock.getRwcode();
            //int uID = stock.getStockid();
            //double uStockbalance = stock.getQuantity();
            int id = pwr.getStockId(uName);
            stock.setStockid(id);
            //System.out.println(uName);
            //pwr.updateWarehouseandReceivedWarehouse(uStockbalance, id);        
        entityManager.merge(stock);
    }

    
    public Warehouse create(Warehouse stock) throws SQLException {
            bsl = new BaseSessionListener();
        
            Date dateCreated = new Date();
            String createdBy = bsl.remoteUser();
            
            stock.setCreatedby(createdBy);
            stock.setTimecreated(dateCreated);
            
            //pwr.updateWarehouseandReceived(createdBy, createdBy, received, createdBy, dateCreated, oldstockbalance, stockbalance);
            pwr.populateWarehouseIssueOpeningStock(stock.getRwcode(), stock.getRwname(), createdBy, dateCreated, stock.getQuantity());
        entityManager.persist(stock);
        Warehouse newWarehouse = null;
        return newWarehouse;
        
    }
    
    
    
}
