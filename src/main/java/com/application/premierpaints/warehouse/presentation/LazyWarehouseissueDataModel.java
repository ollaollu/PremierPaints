/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.warehouse.presentation;

import com.application.premierpaints.warehouse.data.Warehouseissue;
import com.application.premierpaints.warehouse.ejb.WarehouseissueEJB;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author ollaollu
 */
public class LazyWarehouseissueDataModel extends LazyDataModel<Warehouseissue> implements Serializable{
    
    private List<Warehouseissue> datasource;
    private WarehouseissueEJB ejb;
    JasperPrint jasperPrint;
    
    public LazyWarehouseissueDataModel(WarehouseissueEJB ejb){
        this.ejb = ejb;   
    }
    
    @Override
    public Warehouseissue getRowData(String rowKey){
          
        for(Warehouseissue warehouse : datasource){
            if(warehouse.getId().equals(rowKey)){
                return warehouse;
            }   
        }
        return null;
    }
    
    @Override
    public Object getRowKey(Warehouseissue warehouse){
        return warehouse.getId();
    }
    
    public List<Warehouseissue> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters){
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
                Collections.sort(datasource, new WarehouseissueSorter(sortField, sortOrder));
            }
 
        // set the page size
        setPageSize(pageSize);
 
        return datasource;
    }   

    public List<Warehouseissue> getDatasource() {
        return datasource;
    }

    public void setDatasource(List<Warehouseissue> datasource) {
        this.datasource = datasource;
    }
    
    public void Jasperinit() throws JRException, MalformedURLException{
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(datasource);
        String  reportPath=  FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/WarehouseReport.jasper");
        //InputStream reportPath = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/reports/UserReport.jasper");
        //jasperPrint = JasperFillManager.fillReport("C:\\Users\\ollaollu\\UserReport.jasper", new HashMap(), beanCollectionDataSource); 
        jasperPrint=JasperFillManager.fillReport(reportPath, new HashMap(),beanCollectionDataSource);
    }    
          
    public void Pdf(ActionEvent actionEvent) throws JRException, IOException{ 
        
        Jasperinit();
        
        HttpServletResponse servletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        servletResponse.addHeader("Content-disposition", "attachment; filename=WarehousePDFreport.pdf");
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        FacesContext.getCurrentInstance().responseComplete();
    } 
    
}
