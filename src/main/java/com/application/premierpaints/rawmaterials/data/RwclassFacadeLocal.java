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
public interface RwclassFacadeLocal {

    void create(Rwclass rwclass);

    void edit(Rwclass rwclass);

    void remove(Rwclass rwclass);

    Rwclass find(Object id);

    List<Rwclass> findAll();

    List<Rwclass> findRange(int[] range);

    int count();
    
}
