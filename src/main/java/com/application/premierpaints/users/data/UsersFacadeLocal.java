/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.users.data;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author ollaollu
 */
@Local
public interface UsersFacadeLocal {

   public Users create(Users users);

   public Users edit(Users users);

   public void remove(Users users);

   public Users find(Object id);

   public List<Users> findAll();

   public List<Users> findRange(int[] range);

    int count();
    
}
