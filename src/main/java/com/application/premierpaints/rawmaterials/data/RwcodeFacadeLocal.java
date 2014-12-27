/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.rawmaterials.data;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ollaollu
 */
@Local
public interface RwcodeFacadeLocal {

    void create(Rwcode rwcode);

    void edit(Rwcode rwcode);

    void remove(Rwcode rwcode);

    Rwcode find(Object id);

    List<Rwcode> findAll();

    List<Rwcode> findRange(int[] range);

    int count();
    
}
