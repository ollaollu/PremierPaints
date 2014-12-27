/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.products.presentation;

import com.application.premierpaints.products.data.Products;
import com.application.premierpaints.products.ejb.ProductsEJB;
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
public class LazyProductsDataModel extends LazyDataModel<Products> implements Serializable{
    
    private List<Products> datasource;
    private ProductsEJB ejb;
    
    public LazyProductsDataModel(ProductsEJB ejb){
        this.ejb = ejb;   
    }
    
    @Override
    public Products getRowData(String rowKey){
          
        for(Products products : datasource){
            if(products.getProductId().equals(rowKey)){
                return products;
            }   
        }
        return null;
    }
    
    @Override
    public Object getRowKey(Products products){
        return products.getProductId();
    }
    
    public List<Products> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters){
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
                Collections.sort(datasource, new ProductsSorter(sortField, sortOrder));
            }
 
        // set the page size
        setPageSize(pageSize);
 
        return datasource;
    }   

    public List<Products> getDatasource() {
        return datasource;
    }

    public void setDatasource(List<Products> datasource) {
        this.datasource = datasource;
    }
          
    
}
