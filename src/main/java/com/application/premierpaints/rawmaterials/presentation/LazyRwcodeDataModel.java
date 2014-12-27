/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.rawmaterials.presentation;

import com.application.premierpaints.rawmaterials.data.Rwcode;
import com.application.premierpaints.rawmaterials.ejb.RwcodeEJB;
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
public class LazyRwcodeDataModel extends LazyDataModel<Rwcode> implements Serializable{
    
    private List<Rwcode> datasource;
    private RwcodeEJB ejb;
    
    public LazyRwcodeDataModel(RwcodeEJB ejb){
        this.ejb = ejb;   
    }
    
    @Override
    public Rwcode getRowData(String rowKey){
          
        for(Rwcode rwcode : datasource){
            if(rwcode.getRwcodeid().equals(rowKey)){
                return rwcode;
            }   
        }
        return null;
    }
    
    @Override
    public Object getRowKey(Rwcode rwcode){
        return rwcode.getRwcodeid();
    }
    
    public List<Rwcode> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters){
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
                Collections.sort(datasource, new RwcodeSorter(sortField, sortOrder));
            }
 
        // set the page size
        setPageSize(pageSize);
 
        return datasource;
    }   

    public List<Rwcode> getDatasource() {
        return datasource;
    }

    public void setDatasource(List<Rwcode> datasource) {
        this.datasource = datasource;
    }
          
    
}
