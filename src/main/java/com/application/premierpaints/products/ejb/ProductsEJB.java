/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.products.ejb;

import com.application.premierpaints.products.data.Products;
import com.application.premierpaints.util.BaseSessionListener;
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
public class ProductsEJB {
    @PersistenceContext(unitName = "premierPaintsPU")
    private EntityManager entityManager;
    private BaseSessionListener bsl;    

        protected EntityManager getEntityManager() {
        return entityManager;
    }

    public int count() {
        return ((Long) entityManager.createQuery("select count(p) from Products as p").getSingleResult()).intValue();
    }

    public List<Products> findRange(int[] range) {
        return null;
    }

    public List<Products> findAll() {
        TypedQuery query = entityManager.createNamedQuery("Products.findAll", Products.class);
        return query.getResultList();        
    }
    
    public List<Products> findAll(int startingAt, int maxPerPage, String filterValue) {
        String sql = "select p from Products p where p.productName like ?1";    
        Query query = entityManager.createQuery(sql);
        query.setParameter(1, filterValue + "%");
        query.setFirstResult(startingAt);
        query.setMaxResults(maxPerPage);
        
        return query.getResultList();        
    }    

    public Products find(Object id) {
        return entityManager.find(Products.class, id);
    }

    public void remove(Products entity) {
        entityManager.remove(entityManager.merge(entity));        
    }

    public void edit(Products entity) {
            bsl = new BaseSessionListener();
        
            Date dateEdited = new Date();
            String editedBy = bsl.remoteUser();
            
            entity.setEditedby(editedBy);
            entity.setTimeedited(dateEdited);
                  
        entityManager.merge(entity);        
    }

    public Products create(Products entity) {
            bsl = new BaseSessionListener();
        
            Date dateCreated = new Date();
            String createdBy = bsl.remoteUser();
            
            entity.setCreatedby(createdBy);
            entity.setTimecreated(dateCreated);
                    
        entityManager.persist(entity);
        Products newEntity = null;
        return newEntity;        
    }
    
    
    
}
