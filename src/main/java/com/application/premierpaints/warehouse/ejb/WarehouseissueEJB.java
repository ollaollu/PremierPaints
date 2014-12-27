/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.warehouse.ejb;

import com.application.premierpaints.production.presentation.ProductionWarehouseRemoval;
import com.application.premierpaints.util.BaseSessionListener;
import com.application.premierpaints.warehouse.data.Warehouseissue;
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
public class WarehouseissueEJB{
    @PersistenceContext(unitName = "premierPaintsPU")
    private EntityManager entityManager;
    private BaseSessionListener bsl;
    private final ProductionWarehouseRemoval pwr = new ProductionWarehouseRemoval();

        protected EntityManager getEntityManager() {
        return entityManager;
    }


    public int count() {
        return ((Long) entityManager.createQuery("select count(w) from Warehouseissue as w").getSingleResult()).intValue();
        //return super.count(); //To change body of generated methods, choose Tools | Templates.
    }


    public List findRange(int[] range) {
        return null;
        //return super.findRange(range); //To change body of generated methods, choose Tools | Templates.
    }


    public List<Warehouseissue> findAll() {
        TypedQuery query = entityManager.createNamedQuery("Warehouseissue.findAll", Warehouseissue.class);
        return query.getResultList();
        //return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Warehouseissue> findAll(int startingAt, int maxPerPage, String filterValue) {
        String sql = "select w from Warehouseissue w where w.rwcode like ?1 or w.rwname like ?2";    
        Query query = entityManager.createQuery(sql);
        query.setParameter(1, filterValue + "%");
        query.setParameter(2, filterValue + "%");
        query.setFirstResult(startingAt);
        query.setMaxResults(maxPerPage);
        
        return query.getResultList();        
    }    


    public Warehouseissue find(Object id) {
        return entityManager.find(Warehouseissue.class, id);
        //return super.find(id); //To change body of generated methods, choose Tools | Templates.
    }


    public void remove(Object entity) {
        entityManager.remove(entityManager.merge(entity));
        //super.remove(entity); //To change body of generated methods, choose Tools | Templates.
    }


    public void edit(Warehouseissue entity) {
        //super.edit(entity); //To change body of generated methods, choose Tools | Templates.
            bsl = new BaseSessionListener();
        
            Date dateEdited = new Date();
            String editedBy = bsl.remoteUser();

            entity.setEditedby(editedBy);
            entity.setEditdate(dateEdited);            
    }


    public Warehouseissue create(Warehouseissue entity) {
        //super.create(entity); //To change body of generated methods, choose Tools | Templates.
            bsl = new BaseSessionListener();
        
            Date dateCreated = new Date();
            String createdBy = bsl.remoteUser();
            
            entity.setCreatedby(createdBy);
            entity.setCreatedate(dateCreated);
            
        entityManager.persist(entity);
        Warehouseissue newIssue = null;
        return newIssue;        
    }

    
}
