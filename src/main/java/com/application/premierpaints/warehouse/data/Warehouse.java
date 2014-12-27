/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.warehouse.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ollaollu
 */
@Entity
@Table(name = "warehouse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Warehouse.findAll", query = "SELECT w FROM Warehouse w"),
    @NamedQuery(name = "Warehouse.findByStockid", query = "SELECT w FROM Warehouse w WHERE w.stockid = :stockid"),
    @NamedQuery(name = "Warehouse.findByRwcode", query = "SELECT w FROM Warehouse w WHERE w.rwcode = :rwcode"),
    @NamedQuery(name = "Warehouse.findByRwclass", query = "SELECT w FROM Warehouse w WHERE w.rwclass = :rwclass"),
    @NamedQuery(name = "Warehouse.findByRwname", query = "SELECT w FROM Warehouse w WHERE w.rwname = :rwname"),
    @NamedQuery(name = "Warehouse.findByQuantity", query = "SELECT w FROM Warehouse w WHERE w.quantity = :quantity"),
    @NamedQuery(name = "Warehouse.findByCost", query = "SELECT w FROM Warehouse w WHERE w.cost = :cost"),
    @NamedQuery(name = "Warehouse.findByStockValue", query = "SELECT w FROM Warehouse w WHERE w.stockValue = :stockValue"),
    @NamedQuery(name = "Warehouse.findByStockbatchid", query = "SELECT w FROM Warehouse w WHERE w.stockbatchid = :stockbatchid"),
    @NamedQuery(name = "Warehouse.findByCreatedby", query = "SELECT w FROM Warehouse w WHERE w.createdby = :createdby"),
    @NamedQuery(name = "Warehouse.findByEditedby", query = "SELECT w FROM Warehouse w WHERE w.editedby = :editedby"),
    @NamedQuery(name = "Warehouse.findByTimecreated", query = "SELECT w FROM Warehouse w WHERE w.timecreated = :timecreated"),
    @NamedQuery(name = "Warehouse.findByTimeedited", query = "SELECT w FROM Warehouse w WHERE w.timeedited = :timeedited")})
public class Warehouse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stockid")
    private Integer stockid;
    @Size(max = 45)
    @Column(name = "rwcode")
    private String rwcode;
    @Size(max = 45)
    @Column(name = "rwclass")
    private String rwclass;
    @Size(max = 100)
    @Column(name = "rwname")
    private String rwname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "cost")
    private Double cost;
    @Column(name = "stockValue")
    private Double stockValue;
    @Column(name = "stockbatchid")
    private Integer stockbatchid;
    @Size(max = 45)
    @Column(name = "createdby")
    private String createdby;
    @Size(max = 45)
    @Column(name = "editedby")
    private String editedby;
    @Column(name = "timecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timecreated;
    @Column(name = "timeedited")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeedited;

    public Warehouse() {
    }

    public Warehouse(Integer stockid) {
        this.stockid = stockid;
    }

    public Integer getStockid() {
        return stockid;
    }

    public void setStockid(Integer stockid) {
        this.stockid = stockid;
    }

    public String getRwcode() {
        return rwcode;
    }

    public void setRwcode(String rwcode) {
        this.rwcode = rwcode;
    }

    public String getRwclass() {
        return rwclass;
    }

    public void setRwclass(String rwclass) {
        this.rwclass = rwclass;
    }

    public String getRwname() {
        return rwname;
    }

    public void setRwname(String rwname) {
        this.rwname = rwname;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getStockValue() {
        return stockValue;
    }

    public void setStockValue(Double stockValue) {
        this.stockValue = stockValue;
    }

    public Integer getStockbatchid() {
        return stockbatchid;
    }

    public void setStockbatchid(Integer stockbatchid) {
        this.stockbatchid = stockbatchid;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getEditedby() {
        return editedby;
    }

    public void setEditedby(String editedby) {
        this.editedby = editedby;
    }

    public Date getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(Date timecreated) {
        this.timecreated = timecreated;
    }

    public Date getTimeedited() {
        return timeedited;
    }

    public void setTimeedited(Date timeedited) {
        this.timeedited = timeedited;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockid != null ? stockid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warehouse)) {
            return false;
        }
        Warehouse other = (Warehouse) object;
        if ((this.stockid == null && other.stockid != null) || (this.stockid != null && !this.stockid.equals(other.stockid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.application.premierpaints.warehouse.data.Warehouse[ stockid=" + stockid + " ]";
    }
    
}
