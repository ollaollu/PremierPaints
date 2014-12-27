/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.users.presentation;

import com.application.premierpaints.users.data.Users;
import com.application.premierpaints.users.ejb.UsersEJB;
import com.application.premierpaints.util.JsfUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ollaollu
 */
@Named(value = "usereditbean")
@RequestScoped
public class UserEditBean implements Serializable{
    
    private Users user = new Users();
    
    @EJB
    private UsersEJB ejb;
    
    public String saveUser(){
        try {
            ejb.edit(user);
            JsfUtil.addSuccessMessage("User updated Successfully");
        } catch (EJBException e){
                JsfUtil.addErrorMessage("Error updating user");
                return "EditUser.xhtml";            
        }catch (Exception e) {
                Logger.getLogger(UserEditBean.class.getName()).log(Level.SEVERE, "Error updating user", e);
        }
        return "ViewUsers.xhtml";
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    

}
