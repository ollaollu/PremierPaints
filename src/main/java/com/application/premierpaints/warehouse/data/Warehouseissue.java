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
@Table(name = "warehouseissue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Warehouseissue.findAll", query = "SELECT w FROM Warehouseissue w"),
    @NamedQuery(name = "Warehouseissue.findById", query = "SELECT w FROM Warehouseissue w WHERE w.id = :id"),
    @NamedQuery(name = "Warehouseissue.findByRwcode", query = "SELECT w FROM Warehouseissue w WHERE w.rwcode = :rwcode"),
    @NamedQuery(name = "Warehouseissue.findByRwname", query = "SELECT w FROM Warehouseissue w WHERE w.rwname = :rwname"),
    @NamedQuery(name = "Warehouseissue.findByIssued", query = "SELECT w FROM Warehouseissue w WHERE w.issued = :issued"),
    @NamedQuery(name = "Warehouseissue.findByReceived", query = "SELECT w FROM Warehouseissue w WHERE w.received = :received"),
    @NamedQuery(name = "Warehouseissue.findByStockbalance", query = "SELECT w FROM Warehouseissue w WHERE w.stockbalance = :stockbalance"),
    @NamedQuery(name = "Warehouseissue.findByCreatedate", query = "SELECT w FROM Warehouseissue w WHERE w.createdate = :createdate"),
    @NamedQuery(name = "Warehouseissue.findByEditdate", query = "SELECT w FROM Warehouseissue w WHERE w.editdate = :editdate"),
    @NamedQuery(name = "Warehouseissue.findByCreatedby", query = "SELECT w FROM Warehouseissue w WHERE w.createdby = :createdby"),
    @NamedQuery(name = "Warehouseissue.findByEditedby", query = "SELECT w FROM Warehouseissue w WHERE w.editedby = :editedby"),
    @NamedQuery(name = "Warehouseissue.findByOldstockbalance", query = "SELECT w FROM Warehouseissue w WHERE w.oldstockbalance = :oldstockbalance")})
public class Warehouseissue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "rwcode")
    private String rwcode;
    @Size(max = 200)
    @Column(name = "rwname")
    private String rwname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "issued")
    private Double issued;
    @Column(name = "received")
    private Double received;
    @Column(name = "stockbalance")
    private Double stockbalance;
    @Column(name = "createdate")
    @Temporal(TemporalType.DATE)
    private Date createdate;
    @Column(name = "editdate")
    @Temporal(TemporalType.DATE)
    private Date editdate;
    @Size(max = 45)
    @Column(name = "createdby")
    private String createdby;
    @Size(max = 45)
    @Column(name = "editedby")
    private String editedby;
    @Column(name = "oldstockbalance")
    private Double oldstockbalance;

    public Warehouseissue() {
    }

    public Warehouseissue(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRwcode() {
        return rwcode;
    }

    public void setRwcode(String rwcode) {
        this.rwcode = rwcode;
    }

    public String getRwname() {
        return rwname;
    }

    public void setRwname(String rwname) {
        this.rwname = rwname;
    }

    public Double getIssued() {
        return issued;
    }

    public void setIssued(Double issued) {
        this.issued = issued;
    }

    public Double getReceived() {
        return received;
    }

    public void setReceived(Double received) {
        this.received = received;
    }

    public Double getStockbalance() {
        return stockbalance;
    }

    public void setStockbalance(Double stockbalance) {
        this.stockbalance = stockbalance;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
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

    public Double getOldstockbalance() {
        return oldstockbalance;
    }

    public void setOldstockbalance(Double oldstockbalance) {
        this.oldstockbalance = oldstockbalance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warehouseissue)) {
            return false;
        }
        Warehouseissue other = (Warehouseissue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.application.premierpaints.warehouse.presentation.Warehouseissue[ id=" + id + " ]";
    }
    
}
