/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.rawmaterials.presentation;

import com.application.premierpaints.rawmaterials.data.Rwclass;
import com.application.premierpaints.rawmaterials.ejb.RwclassEJB;
import com.application.premierpaints.users.data.Users;
import com.application.premierpaints.users.ejb.UsersEJB;
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
public class LazyRwclassDataModel extends LazyDataModel<Rwclass> implements Serializable{
    
    private List<Rwclass> datasource;
    private RwclassEJB ejb;
    
    public LazyRwclassDataModel(RwclassEJB ejb){
        this.ejb = ejb;   
    }
    
    @Override
    public Rwclass getRowData(String rowKey){
          
        for(Rwclass rwclass : datasource){
            if(rwclass.getRwclassId().equals(rowKey)){
                return rwclass;
            }   
        }
        return null;
    }
    
    @Override
    public Object getRowKey(Rwclass rwclass){
        return rwclass.getRwclassId();
    }
    
    public List<Rwclass> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters){
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
                Collections.sort(datasource, new RwclassSorter(sortField, sortOrder));
            }
 
        // set the page size
        setPageSize(pageSize);
 
        return datasource;
    }   

    public List<Rwclass> getDatasource() {
        return datasource;
    }

    public void setDatasource(List<Rwclass> datasource) {
        this.datasource = datasource;
    }
          
    
}
