/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.useraccess.presentation;

import com.application.premierpaints.useraccess.data.Useraccess;
import com.application.premierpaints.useraccess.ejb.UseraccessEJB;
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

public class LazyUserAccessDataModel extends LazyDataModel<Useraccess> implements Serializable{
    
    private List<Useraccess> datasource;
    private UseraccessEJB ejb;    

    public LazyUserAccessDataModel(UseraccessEJB ejb) {
        this.ejb = ejb;
    }

    @Override
    public Object getRowKey(Useraccess object) {
        return object.getId();
    }

    @Override
    public Useraccess getRowData(String rowKey) {
        
        for(Useraccess access: datasource){
            if(access.getId().equals(rowKey)){
                return access;
            }    
        }
        return null;
    }

    @Override
    public List<Useraccess> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
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
                Collections.sort(datasource, new UserAccessSorter(sortField, sortOrder));
            }
 
        // set the page size
        setPageSize(pageSize);
 
        return datasource;
    }
    
    
}
