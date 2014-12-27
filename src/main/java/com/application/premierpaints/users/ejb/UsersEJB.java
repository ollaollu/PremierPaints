/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.users.ejb;

import com.application.premierpaints.users.data.Users;
import com.application.premierpaints.util.BaseSessionListener;
import com.application.premierpaints.util.HashedPasswordGenerator;
import com.application.premierpaints.util.PremierConnection;
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
public class UsersEJB{
    
    @PersistenceContext(unitName = "premierPaintsPU")
    private EntityManager entityManager;
    private HashedPasswordGenerator gen;
    private BaseSessionListener bsl;
    private PremierConnection conman = null;
    //private UsersManagedBean bean;
    String hashedPass;
    
        public Users create(Users user) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //if(gen.generateHash(users.getPassword()))
        //{
            //newPass = gen.generateHash(users.getPassword());
            //users.setPassword(gen);
           // users.setPassword(gen.generateHash(users.getPassword()));
            bsl = new BaseSessionListener();
            gen = new HashedPasswordGenerator();
            
            Date dateCreated = new Date();
            String createdBy = bsl.remoteUser();           
            String oldPassword = user.getPassword();
            hashedPass = gen.generateHash(oldPassword);
            
            user.setPassword(hashedPass);
            user.setCreatedby(createdBy);
            user.setTimecreated(dateCreated);
            
        entityManager.persist(user);
        Users newUser = null;
        //}
        return newUser;
    }       

        public void edit(Users user) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //Users e = entityManager.find(Users.class, "username");
            gen = new HashedPasswordGenerator();
            bsl = new BaseSessionListener();
            
            Date dateEdited = new Date();
            String editedBy = bsl.remoteUser();
            String oldPassword = user.getPassword();
            hashedPass = gen.generateHash(oldPassword);
            
            user.setPassword(hashedPass);
            user.setEditedby(editedBy);
            user.setTimeedited(dateEdited);
        entityManager.merge(user);
    }

        public void remove(Users user) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //entityManager.remove(user);
        entityManager.remove(entityManager.merge(user));
        //this.msg = "User deleted successfully";
        //bean.setMsg(hashedPass); = "";
        //getEntityManager().remove(getEntityManager().merge(entity));
        //return users;
    }
    
        public Users find(Object id) {
        return entityManager.find(Users.class, id);
	//return e;
    } 
        
        public List<Users> findAll(){
          TypedQuery query = entityManager.createNamedQuery("Users.findAll", Users.class);
          return query.getResultList();
        }

        public List<Users> findAll(int startingAt, int maxPerPage) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //TypedQuery query = entityManager.createNamedQuery("Users.findAll", Users.class);
        
        Query query = entityManager.createNamedQuery("Users.findAll");
        query.setFirstResult(startingAt);
        query.setMaxResults(maxPerPage);
        
        return query.getResultList();        
    }
        
        public List<Users> findAll(int startingAt, int maxPerPage, String filterValue) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //TypedQuery query = entityManager.createNamedQuery("Users.findAll", Users.class);
        
        //Query query = entityManager.createNamedQuery("Users.findAll");
        String sql = "select u from Users u where u.username like ?1 or u.firstname like ?2 or u.lastname like ?3 or u.groupname like ?4";    
        Query query = entityManager.createQuery(sql);
        query.setParameter(1, filterValue + "%");
        query.setParameter(2, filterValue + "%");
        query.setParameter(3, filterValue + "%");
        query.setParameter(4, filterValue + "%");
        query.setFirstResult(startingAt);
        query.setMaxResults(maxPerPage);
        
        return query.getResultList();        
    }
        
        /*    public List<Users> findUsersEntities() {
        return findUsersEntities(true, -1, -1);
        }
        
        public List<Users> findUsersEntities(int maxResults, int firstResult) {
        return findUsersEntities(false, maxResults, firstResult);
        }
        
        private List<Users> findUsersEntities(boolean all, int maxResults, int firstResult) {
        
        Query q = entityManager.createQuery("select object(o) from users as o");
        if (!all) {
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        }
        return q.getResultList();
        }*/
        
    public List<Users> findRange(int[] range) {
            javax.persistence.criteria.CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Users.class));
            javax.persistence.Query q = entityManager.createQuery(cq);
            q.setMaxResults(range[1] - range[0]);
            q.setFirstResult(range[0]);
            return q.getResultList();
        }        
    
    public List<Users> findRange(int start, int end) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        TypedQuery query = entityManager.createNamedQuery("Users.findAll", Users.class);
        //Query q = entityManager.createNamedQuery("Users.findAll");
        query.setMaxResults(end - start);
        query.setFirstResult(start);
        return query.getResultList();
    }

    public int count() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        /*	Query query = entityManager.createNamedQuery("Users.count");
        return ((Long) query.getSingleResult()).intValue();*/
        return ((Long) entityManager.createQuery("select count(o) from Users as o").getSingleResult()).intValue();
    }     

    
}
