/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.useraccess.ejb;

import com.application.premierpaints.useraccess.data.Useraccess;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author ollaollu
 */
@Stateless
public class UseraccessEJB{
    @PersistenceContext(unitName = "premierPaintsPU")
    private EntityManager entityManager;


    public int count() {
        return ((Long) entityManager.createQuery("select count(u) from Useraccess as u").getSingleResult()).intValue();
    }

    public List<Useraccess> findRange(int[] range) {
        return null;
    }

    public List<Useraccess> findAll() {
        return null;
    }
    
    public List<Useraccess> findAll(int startingAt, int maxPerPage, String filterValue) {
        String sql = "select u from Useraccess u where u.username like ?1";    
        Query query = entityManager.createQuery(sql);
        query.setParameter(1, filterValue + "%");
        //query.setParameter(null, null, TemporalType.DATE);
        query.setFirstResult(startingAt);
        query.setMaxResults(maxPerPage);
        
        return query.getResultList();        
    }

    public Useraccess find(Object id) {
        return entityManager.find(Useraccess.class, id);
    }

    public void remove(Useraccess entity) {
        //super.remove(entity); //To change body of generated methods, choose Tools | Templates.
    }

    public void edit(Useraccess entity) {
        //super.edit(entity); //To change body of generated methods, choose Tools | Templates.
    }

    public void create(Useraccess entity) {
        //super.create(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
}
