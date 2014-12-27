/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.users.presentation;

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
public class LazyUserDataModel extends LazyDataModel<Users> implements Serializable{
    
    private List<Users> datasource;
    private UsersEJB ejb;
    
    public LazyUserDataModel(UsersEJB ejb){
        this.ejb = ejb;   
    }
    
    @Override
    public Users getRowData(String rowKey){
          
        for(Users user : datasource){
            if(user.getId().equals(rowKey)){
                return user;
            }   
        }
        return null;
    }
    
    @Override
    public Object getRowKey(Users user){
        return user.getId();
    }
    
    public List<Users> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters){
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
                Collections.sort(datasource, new UserSorter(sortField, sortOrder));
            }
 
        // set the page size
        setPageSize(pageSize);
 
        return datasource;
    }   

    public List<Users> getDatasource() {
        return datasource;
    }

    public void setDatasource(List<Users> datasource) {
        this.datasource = datasource;
    }
          
    
}
