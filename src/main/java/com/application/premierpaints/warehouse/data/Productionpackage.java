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
@Table(name = "productionpackage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productionpackage.findAll", query = "SELECT p FROM Productionpackage p"),
    @NamedQuery(name = "Productionpackage.findByIdpackage", query = "SELECT p FROM Productionpackage p WHERE p.idpackage = :idpackage"),
    @NamedQuery(name = "Productionpackage.findByPackagetype", query = "SELECT p FROM Productionpackage p WHERE p.packagetype = :packagetype"),
    @NamedQuery(name = "Productionpackage.findByContainertype", query = "SELECT p FROM Productionpackage p WHERE p.containertype = :containertype"),
    @NamedQuery(name = "Productionpackage.findByPrice", query = "SELECT p FROM Productionpackage p WHERE p.price = :price"),
    @NamedQuery(name = "Productionpackage.findByCreatedby", query = "SELECT p FROM Productionpackage p WHERE p.createdby = :createdby"),
    @NamedQuery(name = "Productionpackage.findByEditedby", query = "SELECT p FROM Productionpackage p WHERE p.editedby = :editedby"),
    @NamedQuery(name = "Productionpackage.findByTimecreated", query = "SELECT p FROM Productionpackage p WHERE p.timecreated = :timecreated"),
    @NamedQuery(name = "Productionpackage.findByTimeedited", query = "SELECT p FROM Productionpackage p WHERE p.timeedited = :timeedited")})
public class Productionpackage implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpackage")
    private Integer idpackage;
    @Size(max = 50)
    @Column(name = "packagetype")
    private String packagetype;
    @Size(max = 50)
    @Column(name = "containertype")
    private String containertype;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Size(max = 50)
    @Column(name = "createdby")
    private String createdby;
    @Size(max = 50)
    @Column(name = "editedby")
    private String editedby;
    @Column(name = "timecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timecreated;
    @Column(name = "timeedited")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeedited;

    public Productionpackage() {
    }

    public Productionpackage(Integer idpackage) {
        this.idpackage = idpackage;
    }

    public Integer getIdpackage() {
        return idpackage;
    }

    public void setIdpackage(Integer idpackage) {
        this.idpackage = idpackage;
    }

    public String getPackagetype() {
        return packagetype;
    }

    public void setPackagetype(String packagetype) {
        this.packagetype = packagetype;
    }

    public String getContainertype() {
        return containertype;
    }

    public void setContainertype(String containertype) {
        this.containertype = containertype;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
        hash += (idpackage != null ? idpackage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productionpackage)) {
            return false;
        }
        Productionpackage other = (Productionpackage) object;
        if ((this.idpackage == null && other.idpackage != null) || (this.idpackage != null && !this.idpackage.equals(other.idpackage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "com.application.premierpaints.warehouse.data.Productionpackage[ idpackage=" + idpackage + " ]";
        return getPackagetype();
    }
    
}
