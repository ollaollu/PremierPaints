/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.warehouse.data;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ollaollu
 */
@Local
public interface ProductionpackageFacadeLocal {

    void create(Productionpackage productionpackage);

    void edit(Productionpackage productionpackage);

    void remove(Productionpackage productionpackage);

    Productionpackage find(Object id);

    List<Productionpackage> findAll();

    List<Productionpackage> findRange(int[] range);

    int count();
    
}
