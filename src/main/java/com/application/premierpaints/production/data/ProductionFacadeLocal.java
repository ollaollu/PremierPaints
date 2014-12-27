/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.production.data;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ollaollu
 */
@Local
public interface ProductionFacadeLocal {

    void create(Production production);

    void edit(Production production);

    void remove(Production production);

    Production find(Object id);

    List<Production> findAll();

    List<Production> findRange(int[] range);

    int count();
    
}
