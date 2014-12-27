/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.util;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 *
 * @author ollaollu
 */
public class BaseSessionListener implements HttpSessionBindingListener{
    
    private static Map<BaseSessionListener, HttpSession> logins = new HashMap<BaseSessionListener, HttpSession>();
    private static Logger log = Logger.getLogger(BaseSessionListener.class.getName());    
   
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    HttpSession session = request.getSession(); 
    
    public String remoteUser(){
        String remoteUser = request.getRemoteUser();
        return remoteUser;    
    }
    
    public Date creationTime(){
        Date creationTime = new Date(session.getCreationTime());
        return creationTime;      
    }
    
    public Date lastAccessed(){
        //do db search for most recent login from user access table
        return null;     
    }
    
    public String localAddress(){
        String localAddress = request.getLocalAddr();
        return localAddress;
    }
    
    public String localName(){
        String localName = request.getLocalName();
        return localName;
    }
    
    public String remoteAddress(){
        String remoteAddress = request.getRemoteAddr();
        return remoteAddress;
    }
    
    public int localPort(){
        int localPort = request.getLocalPort();
        return localPort;
    }
    
    public int remotePort(){
        int remotePort = request.getRemotePort();
        return remotePort;
    }
    
    public String remoteHost(){
        String remoteHost = request.getRemoteHost();
        return remoteHost;
    }
    
    public String userSession(){
        String sessionid = session.getId();
        return sessionid;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        HttpSession session = logins.remove(this);
        if (session != null) {
            session.invalidate();
        }
        logins.put(this, event.getSession());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        logins.remove(this);
    }

  
}
