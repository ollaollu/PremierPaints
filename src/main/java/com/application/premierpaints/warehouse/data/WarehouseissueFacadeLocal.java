/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.warehouse.data;

import com.application.premierpaints.warehouse.data.Warehouseissue;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ollaollu
 */
@Local
public interface WarehouseissueFacadeLocal {

    void create(Warehouseissue warehouseissue);

    void edit(Warehouseissue warehouseissue);

    void remove(Warehouseissue warehouseissue);

    Warehouseissue find(Object id);

    List<Warehouseissue> findAll();

    List<Warehouseissue> findRange(int[] range);

    int count();
    
}
