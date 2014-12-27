/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.rawmaterials.ejb;

import com.application.premierpaints.rawmaterials.data.Rwclass;
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
public class RwclassEJB {
    @PersistenceContext(unitName = "premierPaintsPU")
    private EntityManager entityManager;
    private BaseSessionListener bsl;    

        protected EntityManager getEntityManager() {
        return entityManager;
    }

        public int count() {
        //return super.count(); //To change body of generated methods, choose Tools | Templates.
            return ((Long) entityManager.createQuery("select count(r) from Rwclass as r").getSingleResult()).intValue();
    }

        public List<Rwclass> findRange(int[] range) {
        //return super.findRange(range); //To change body of generated methods, choose Tools | Templates.
            return null;
    }

        public List<Rwclass> findAll() {
        //return super.findAll(); //To change body of generated methods, choose Tools | Templates.
        TypedQuery query = entityManager.createNamedQuery("Rwclass.findAll", Rwclass.class);
        return query.getResultList();
    }
        
        public List<Rwclass> findAll(int startingAt, int maxPerPage, String filterValue) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //TypedQuery query = entityManager.createNamedQuery("Users.findAll", Users.class);
        
        //Query query = entityManager.createNamedQuery("Users.findAll");
        String sql = "select r from Rwclass r where r.rwclassName like ?1 or r.rwclassGroup like ?2";    
        Query query = entityManager.createQuery(sql);
        query.setParameter(1, filterValue + "%");
        query.setParameter(2, filterValue + "%");
        query.setFirstResult(startingAt);
        query.setMaxResults(maxPerPage);
        
        return query.getResultList();        
    }        

        public Rwclass find(Object id) {
        //return super.find(id); //To change body of generated methods, choose Tools | Templates.
            return entityManager.find(Rwclass.class, id);
    }

        public void remove(Rwclass entity) {
        //super.remove(entity); //To change body of generated methods, choose Tools | Templates.
        entityManager.remove(entityManager.merge(entity));
    }

        public void edit(Rwclass entity) {
        //super.edit(entity); //To change body of generated methods, choose Tools | Templates.
            bsl = new BaseSessionListener();
        
            Date dateEdited = new Date();
            String editedBy = bsl.remoteUser();
            
            entity.setEditedby(editedBy);
            entity.setTimeedited(dateEdited);
                      
        entityManager.merge(entity);
    }

    
    public Rwclass create(Rwclass entity){
            bsl = new BaseSessionListener();
        
            Date dateCreated = new Date();
            String createdBy = bsl.remoteUser();
            
            entity.setCreatedby(createdBy);
            entity.setTimecreated(dateCreated);
                    
        entityManager.persist(entity);
        Rwclass newEntity = null;
        return newEntity;
    }
    
    
    
}
