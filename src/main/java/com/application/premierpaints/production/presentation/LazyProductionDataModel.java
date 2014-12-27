/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.production.presentation;

import com.application.premierpaints.production.data.Production;
import com.application.premierpaints.production.ejb.ProductionEJB;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author ollaollu
 */
public class LazyProductionDataModel extends LazyDataModel<Production> implements Serializable {
    
    private List<Production> prodSource;
    private ProductionEJB ejb;
    
    public LazyProductionDataModel(ProductionEJB ejb){
        this.ejb = ejb;   
    }
    
    @Override
    public Production getRowData(String rowKey){
          
        for(Production production : prodSource){
            if(production.getProductionbatch().equals(rowKey)){
                return production;
            }   
        }
        return null;
    }
    
    @Override
    public Object getRowKey(Production production){
        return production.getProductionbatch();
    }
    
    public List<Production> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters){
        //filter
        String filterValue = (String) filters.get("globalFilter");
        Set set = filters.entrySet();
        Iterator i = set.iterator();
        if(i.hasNext()){
            Map.Entry me = (Map.Entry) i.next();
            filterValue = (String) me.getValue();
        }
        
        prodSource = ejb.findAll(first, pageSize, filterValue);
        
        
        // set the total of players
        if(getRowCount() <= 0){
            setRowCount(ejb.count());
        }
        
        
            if(sortField != null) {
                Collections.sort(prodSource, new ProductionSorter(sortField, sortOrder));
            }
 
        // set the page size
        setPageSize(pageSize);
 
        return prodSource;
    }   

    public List<Production> getProdSource() {
        return prodSource;
    }

    public void setProdSource(List<Production> prodSource) {
        this.prodSource = prodSource;
    }
          
    
}
