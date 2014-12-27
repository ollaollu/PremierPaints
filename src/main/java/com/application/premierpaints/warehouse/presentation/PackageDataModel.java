/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.warehouse.presentation;

import com.application.premierpaints.warehouse.data.Productionpackage;
import com.application.premierpaints.warehouse.ejb.ProductionpackageEJB;
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
public class PackageDataModel extends LazyDataModel<Productionpackage> implements Serializable{
    
    private List<Productionpackage> datasource;
    private ProductionpackageEJB ejb;
    
    public PackageDataModel(ProductionpackageEJB ejb){
        this.ejb = ejb;   
    }
    
    @Override
    public Productionpackage getRowData(String rowKey){
          
        for(Productionpackage packaging : datasource){
            if(packaging.getIdpackage().equals(rowKey)){
                return packaging;
            }   
        }
        return null;
    }
    
    @Override
    public Object getRowKey(Productionpackage packaging){
        return packaging.getIdpackage();
    }
    
    public List<Productionpackage> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters){
        //filter
        String filterValue = (String) filters.get("globalFilter");
        Set set = filters.entrySet();
        Iterator i = set.iterator();
        if(i.hasNext()){
            Map.Entry me = (Map.Entry) i.next();
            filterValue = (String) me.getValue();
        }
        
        datasource = ejb.findAll(first, pageSize, filterValue);
        
        // set the total of players
        if(getRowCount() <= 0){
            setRowCount(ejb.count());
        }
        
        
            if(sortField != null) {
                Collections.sort(datasource, new PackageSorter(sortField, sortOrder));
            }
 
        // set the page size
        setPageSize(pageSize);
 
        return datasource;
    }   

    public List<Productionpackage> getDatasource() {
        return datasource;
    }

    public void setDatasource(List<Productionpackage> datasource) {
        this.datasource = datasource;
    }     
    
}
