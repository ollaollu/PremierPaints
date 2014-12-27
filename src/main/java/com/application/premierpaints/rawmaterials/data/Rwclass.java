/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.rawmaterials.data;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ollaollu
 */
@Entity
@Table(name = "rwclass")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rwclass.findAll", query = "SELECT r FROM Rwclass r"),
    @NamedQuery(name = "Rwclass.findByRwclassName", query = "SELECT r FROM Rwclass r WHERE r.rwclassName = :rwclassName"),
    @NamedQuery(name = "Rwclass.findByRwclassGroup", query = "SELECT r FROM Rwclass r WHERE r.rwclassGroup = :rwclassGroup"),
    @NamedQuery(name = "Rwclass.findByRwclassId", query = "SELECT r FROM Rwclass r WHERE r.rwclassId = :rwclassId"),
    @NamedQuery(name = "Rwclass.findByCreatedby", query = "SELECT r FROM Rwclass r WHERE r.createdby = :createdby"),
    @NamedQuery(name = "Rwclass.findByEditedby", query = "SELECT r FROM Rwclass r WHERE r.editedby = :editedby"),
    @NamedQuery(name = "Rwclass.findByTimecreated", query = "SELECT r FROM Rwclass r WHERE r.timecreated = :timecreated"),
    @NamedQuery(name = "Rwclass.findByTimeedited", query = "SELECT r FROM Rwclass r WHERE r.timeedited = :timeedited")})
public class Rwclass implements Serializable, Comparable<Rwclass> {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rwclassName")
    private String rwclassName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "rwclassGroup")
    private String rwclassGroup;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rwclassid")
    private Integer rwclassId;
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

    public Rwclass() {
    }

    public Rwclass(String s) {
        rwclassName = s;
    }
    
    public Rwclass(Integer rwclassId) {
        this.rwclassId = rwclassId;
    }

    public Rwclass(Integer rwclassId, String rwclassName, String rwclassGroup) {
        this.rwclassId = rwclassId;
        this.rwclassName = rwclassName;
        this.rwclassGroup = rwclassGroup;
    }

    public String getRwclassName() {
        return rwclassName;
    }

    public void setRwclassName(String rwclassName) {
        this.rwclassName = rwclassName;
    }

    public String getRwclassGroup() {
        return rwclassGroup;
    }

    public void setRwclassGroup(String rwclassGroup) {
        this.rwclassGroup = rwclassGroup;
    }

    public Integer getRwclassId() {
        return rwclassId;
    }

    public void setRwclassId(Integer rwclassId) {
        this.rwclassId = rwclassId;
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
        hash += (rwclassId != null ? rwclassId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rwclass)) {
            return false;
        }
        Rwclass other = (Rwclass) object;
        if ((this.rwclassId == null && other.rwclassId != null) || (this.rwclassId != null && !this.rwclassId.equals(other.rwclassId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "" + rwclassName + "" + "["+rwclassGroup+"]";
        return getRwclassName();
    }

    @Override
    public int compareTo(Rwclass o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return getRwclassName().compareTo(o.getRwclassName());
    }
    
}
