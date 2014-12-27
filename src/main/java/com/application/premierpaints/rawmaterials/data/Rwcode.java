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
@Table(name = "rwcode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rwcode.findAll", query = "SELECT r FROM Rwcode r"),
    @NamedQuery(name = "Rwcode.findByRwcodeid", query = "SELECT r FROM Rwcode r WHERE r.rwcodeid = :rwcodeid"),
    @NamedQuery(name = "Rwcode.findByRwcodeclass", query = "SELECT r FROM Rwcode r WHERE r.rwcodeclass = :rwcodeclass"),
    @NamedQuery(name = "Rwcode.findByRwcodename", query = "SELECT r FROM Rwcode r WHERE r.rwcodename = :rwcodename"),
    @NamedQuery(name = "Rwcode.findByRwcodedescription", query = "SELECT r FROM Rwcode r WHERE r.rwcodedescription = :rwcodedescription"),
    @NamedQuery(name = "Rwcode.findByCreatedby", query = "SELECT r FROM Rwcode r WHERE r.createdby = :createdby"),
    @NamedQuery(name = "Rwcode.findByEditedby", query = "SELECT r FROM Rwcode r WHERE r.editedby = :editedby"),
    @NamedQuery(name = "Rwcode.findByTimecreated", query = "SELECT r FROM Rwcode r WHERE r.timecreated = :timecreated"),
    @NamedQuery(name = "Rwcode.findByTimeedited", query = "SELECT r FROM Rwcode r WHERE r.timeedited = :timeedited")})
public class Rwcode implements Serializable, Comparable<Rwcode> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rwcodeid")
    private Integer rwcodeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rwcodeclass")
    private String rwcodeclass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rwcodename")
    private String rwcodename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rwcodedescription")
    private String rwcodedescription;
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

    public Rwcode() {
    }

    public Rwcode(String s){
        rwcodename = s;
    }

    public Rwcode(Integer rwcodeid) {
        this.rwcodeid = rwcodeid;
    }

    public Rwcode(Integer rwcodeid, String rwcodeclass, String rwcodename, String rwcodedescription) {
        this.rwcodeid = rwcodeid;
        this.rwcodeclass = rwcodeclass;
        this.rwcodename = rwcodename;
        this.rwcodedescription = rwcodedescription;
    }

    public Integer getRwcodeid() {
        return rwcodeid;
    }

    public void setRwcodeid(Integer rwcodeid) {
        this.rwcodeid = rwcodeid;
    }

    public String getRwcodeclass() {
        return rwcodeclass;
    }

    public void setRwcodeclass(String rwcodeclass) {
        this.rwcodeclass = rwcodeclass;
    }

    public String getRwcodename() {
        return rwcodename;
    }

    public void setRwcodename(String rwcodename) {
        this.rwcodename = rwcodename;
    }

    public String getRwcodedescription() {
        return rwcodedescription;
    }

    public void setRwcodedescription(String rwcodedescription) {
        this.rwcodedescription = rwcodedescription;
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
        hash += (rwcodeid != null ? rwcodeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rwcode)) {
            return false;
        }
        Rwcode other = (Rwcode) object;
        if ((this.rwcodeid == null && other.rwcodeid != null) || (this.rwcodeid != null && !this.rwcodeid.equals(other.rwcodeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return ""+ rwcodename +"";
        return getRwcodename();//+"    "+""+"["+"--" +rwcodedescription+ "--"+"]" +"";
    }

    @Override
    public int compareTo(Rwcode o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return getRwcodename().compareTo(o.getRwcodename());
    }

    
}
