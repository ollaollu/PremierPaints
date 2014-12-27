/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.warehouse.ejb;

import com.application.premierpaints.util.BaseSessionListener;
import com.application.premierpaints.warehouse.data.AbstractFacade;
import com.application.premierpaints.warehouse.data.Productionpackage;
import com.application.premierpaints.warehouse.data.ProductionpackageFacadeLocal;
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
public class ProductionpackageEJB {
    @PersistenceContext(unitName = "premierPaintsPU")
    private EntityManager entityManager;
    private BaseSessionListener bsl;

    protected EntityManager getEntityManager() {
        return entityManager;
    }


    public int count() {
        return ((Long) entityManager.createQuery("select count(p) from Productionpackage as p").getSingleResult()).intValue();
    }

    public List<Productionpackage> findRange(int[] range) {
        return null;
    }

    public List<Productionpackage> findAll() {
        TypedQuery query = entityManager.createNamedQuery("Productionpackage.findAll", Productionpackage.class);
        return query.getResultList();
    }
    
        public List<Productionpackage> findContainer(String value) {
            System.out.println(value);
        String sql = "select p.containertype from Productionpackage p where p.packagetype = ?1";
        Query q = entityManager.createQuery(sql);
        q.setParameter(1, value);
            System.out.println(q.getResultList());
        return q.getResultList();
    }
    
        public List<Productionpackage> findAll(int startingAt, int maxPerPage, String filterValue) {
        String sql = "select p from Productionpackage p where p.packagetype like ?1 or p.containertype like ?2";    
        Query query = entityManager.createQuery(sql);
        query.setParameter(1, filterValue + "%");
        query.setParameter(2, filterValue + "%");
        query.setFirstResult(startingAt);
        query.setMaxResults(maxPerPage);
        
        return query.getResultList();        
    }    

    public Productionpackage find(Object id) {
        return entityManager.find(Productionpackage.class, id);
    }

    public void remove(Productionpackage entity) {
        entityManager.remove(entityManager.merge(entity));
    }

    public void edit(Productionpackage entity) {
                    bsl = new BaseSessionListener();
        
            Date dateEdited = new Date();
            String editedBy = bsl.remoteUser();
            
            entity.setEditedby(editedBy);
            entity.setTimeedited(dateEdited);
                      
        entityManager.merge(entity);
    }

    public Productionpackage create(Productionpackage entity) {
            bsl = new BaseSessionListener();
        
            Date dateCreated = new Date();
            String createdBy = bsl.remoteUser();
            
            entity.setCreatedby(createdBy);
            entity.setTimecreated(dateCreated);
                    
        entityManager.persist(entity);
        Productionpackage newPackage = null;
        return newPackage;
    }
    
}
