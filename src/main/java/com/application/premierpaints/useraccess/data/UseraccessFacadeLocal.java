/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.useraccess.data;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ollaollu
 */
@Local
public interface UseraccessFacadeLocal {

    void create(Useraccess useraccess);

    void edit(Useraccess useraccess);

    void remove(Useraccess useraccess);

    Useraccess find(Object id);

    List<Useraccess> findAll();

    List<Useraccess> findRange(int[] range);

    int count();
    
}
