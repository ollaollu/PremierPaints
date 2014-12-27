/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.products.data;

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
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProductName", query = "SELECT p FROM Products p WHERE p.productName = :productName"),
    @NamedQuery(name = "Products.findByProductSG", query = "SELECT p FROM Products p WHERE p.productSG = :productSG"),
    @NamedQuery(name = "Products.findByProductShade", query = "SELECT p FROM Products p WHERE p.productShade = :productShade"),
    @NamedQuery(name = "Products.findByInputCode1", query = "SELECT p FROM Products p WHERE p.inputCode1 = :inputCode1"),
    @NamedQuery(name = "Products.findByProductId", query = "SELECT p FROM Products p WHERE p.productId = :productId"),
    @NamedQuery(name = "Products.findByInputCode2", query = "SELECT p FROM Products p WHERE p.inputCode2 = :inputCode2"),
    @NamedQuery(name = "Products.findByInputCode3", query = "SELECT p FROM Products p WHERE p.inputCode3 = :inputCode3"),
    @NamedQuery(name = "Products.findByInputCode4", query = "SELECT p FROM Products p WHERE p.inputCode4 = :inputCode4"),
    @NamedQuery(name = "Products.findByInputCode5", query = "SELECT p FROM Products p WHERE p.inputCode5 = :inputCode5"),
    @NamedQuery(name = "Products.findByInputCode6", query = "SELECT p FROM Products p WHERE p.inputCode6 = :inputCode6"),
    @NamedQuery(name = "Products.findByInputCode7", query = "SELECT p FROM Products p WHERE p.inputCode7 = :inputCode7"),
    @NamedQuery(name = "Products.findByInputCode8", query = "SELECT p FROM Products p WHERE p.inputCode8 = :inputCode8"),
    @NamedQuery(name = "Products.findByInputCode9", query = "SELECT p FROM Products p WHERE p.inputCode9 = :inputCode9"),
    @NamedQuery(name = "Products.findByInputCode10", query = "SELECT p FROM Products p WHERE p.inputCode10 = :inputCode10"),
    @NamedQuery(name = "Products.findByInputCode11", query = "SELECT p FROM Products p WHERE p.inputCode11 = :inputCode11"),
    @NamedQuery(name = "Products.findByInputCode12", query = "SELECT p FROM Products p WHERE p.inputCode12 = :inputCode12"),
    @NamedQuery(name = "Products.findByInputCode13", query = "SELECT p FROM Products p WHERE p.inputCode13 = :inputCode13"),
    @NamedQuery(name = "Products.findByInputCode14", query = "SELECT p FROM Products p WHERE p.inputCode14 = :inputCode14"),
    @NamedQuery(name = "Products.findByInputCode15", query = "SELECT p FROM Products p WHERE p.inputCode15 = :inputCode15"),
    @NamedQuery(name = "Products.findByInputCode16", query = "SELECT p FROM Products p WHERE p.inputCode16 = :inputCode16"),
    @NamedQuery(name = "Products.findByInputCode17", query = "SELECT p FROM Products p WHERE p.inputCode17 = :inputCode17"),
    @NamedQuery(name = "Products.findByInputCode18", query = "SELECT p FROM Products p WHERE p.inputCode18 = :inputCode18"),
    @NamedQuery(name = "Products.findByInputCode19", query = "SELECT p FROM Products p WHERE p.inputCode19 = :inputCode19"),
    @NamedQuery(name = "Products.findByInputCode20", query = "SELECT p FROM Products p WHERE p.inputCode20 = :inputCode20"),
    @NamedQuery(name = "Products.findByInputCodeQTY1", query = "SELECT p FROM Products p WHERE p.inputCodeQTY1 = :inputCodeQTY1"),
    @NamedQuery(name = "Products.findByInputCodeQTY2", query = "SELECT p FROM Products p WHERE p.inputCodeQTY2 = :inputCodeQTY2"),
    @NamedQuery(name = "Products.findByInputCodeQTY3", query = "SELECT p FROM Products p WHERE p.inputCodeQTY3 = :inputCodeQTY3"),
    @NamedQuery(name = "Products.findByInputCodeQTY4", query = "SELECT p FROM Products p WHERE p.inputCodeQTY4 = :inputCodeQTY4"),
    @NamedQuery(name = "Products.findByInputCodeQTY5", query = "SELECT p FROM Products p WHERE p.inputCodeQTY5 = :inputCodeQTY5"),
    @NamedQuery(name = "Products.findByInputCodeQTY6", query = "SELECT p FROM Products p WHERE p.inputCodeQTY6 = :inputCodeQTY6"),
    @NamedQuery(name = "Products.findByInputCodeQTY7", query = "SELECT p FROM Products p WHERE p.inputCodeQTY7 = :inputCodeQTY7"),
    @NamedQuery(name = "Products.findByInputCodeQTY8", query = "SELECT p FROM Products p WHERE p.inputCodeQTY8 = :inputCodeQTY8"),
    @NamedQuery(name = "Products.findByInputCodeQTY9", query = "SELECT p FROM Products p WHERE p.inputCodeQTY9 = :inputCodeQTY9"),
    @NamedQuery(name = "Products.findByInputCodeQTY10", query = "SELECT p FROM Products p WHERE p.inputCodeQTY10 = :inputCodeQTY10"),
    @NamedQuery(name = "Products.findByInputCodeQTY11", query = "SELECT p FROM Products p WHERE p.inputCodeQTY11 = :inputCodeQTY11"),
    @NamedQuery(name = "Products.findByInputCodeQTY12", query = "SELECT p FROM Products p WHERE p.inputCodeQTY12 = :inputCodeQTY12"),
    @NamedQuery(name = "Products.findByInputCodeQTY13", query = "SELECT p FROM Products p WHERE p.inputCodeQTY13 = :inputCodeQTY13"),
    @NamedQuery(name = "Products.findByInputCodeQTY14", query = "SELECT p FROM Products p WHERE p.inputCodeQTY14 = :inputCodeQTY14"),
    @NamedQuery(name = "Products.findByInputCodeQTY15", query = "SELECT p FROM Products p WHERE p.inputCodeQTY15 = :inputCodeQTY15"),
    @NamedQuery(name = "Products.findByInputCodeQTY16", query = "SELECT p FROM Products p WHERE p.inputCodeQTY16 = :inputCodeQTY16"),
    @NamedQuery(name = "Products.findByInputCodeQTY17", query = "SELECT p FROM Products p WHERE p.inputCodeQTY17 = :inputCodeQTY17"),
    @NamedQuery(name = "Products.findByInputCodeQTY18", query = "SELECT p FROM Products p WHERE p.inputCodeQTY18 = :inputCodeQTY18"),
    @NamedQuery(name = "Products.findByInputCodeQTY19", query = "SELECT p FROM Products p WHERE p.inputCodeQTY19 = :inputCodeQTY19"),
    @NamedQuery(name = "Products.findByInputCodeQTY20", query = "SELECT p FROM Products p WHERE p.inputCodeQTY20 = :inputCodeQTY20"),
    @NamedQuery(name = "Products.findByCreatedby", query = "SELECT p FROM Products p WHERE p.createdby = :createdby"),
    @NamedQuery(name = "Products.findByEditedby", query = "SELECT p FROM Products p WHERE p.editedby = :editedby"),
    @NamedQuery(name = "Products.findByTimecreated", query = "SELECT p FROM Products p WHERE p.timecreated = :timecreated"),
    @NamedQuery(name = "Products.findByTimeedited", query = "SELECT p FROM Products p WHERE p.timeedited = :timeedited")})
public class Products implements Serializable{
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "productName")
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "productSG")
    private String productSG;
    @Size(max = 50)
    @Column(name = "productShade")
    private String productShade;
    @Size(max = 45)
    @Column(name = "inputCode1")
    private String inputCode1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productId")
    private Integer productId;
    @Size(max = 45)
    @Column(name = "inputCode2")
    private String inputCode2;
    @Size(max = 45)
    @Column(name = "inputCode3")
    private String inputCode3;
    @Size(max = 45)
    @Column(name = "inputCode4")
    private String inputCode4;
    @Size(max = 45)
    @Column(name = "inputCode5")
    private String inputCode5;
    @Size(max = 45)
    @Column(name = "inputCode6")
    private String inputCode6;
    @Size(max = 45)
    @Column(name = "inputCode7")
    private String inputCode7;
    @Size(max = 45)
    @Column(name = "inputCode8")
    private String inputCode8;
    @Size(max = 45)
    @Column(name = "inputCode9")
    private String inputCode9;
    @Size(max = 45)
    @Column(name = "inputCode10")
    private String inputCode10;
    @Size(max = 45)
    @Column(name = "inputCode11")
    private String inputCode11;
    @Size(max = 45)
    @Column(name = "inputCode12")
    private String inputCode12;
    @Size(max = 45)
    @Column(name = "inputCode13")
    private String inputCode13;
    @Size(max = 45)
    @Column(name = "inputCode14")
    private String inputCode14;
    @Size(max = 45)
    @Column(name = "inputCode15")
    private String inputCode15;
    @Size(max = 45)
    @Column(name = "inputCode16")
    private String inputCode16;
    @Size(max = 45)
    @Column(name = "inputCode17")
    private String inputCode17;
    @Size(max = 45)
    @Column(name = "inputCode18")
    private String inputCode18;
    @Size(max = 45)
    @Column(name = "inputCode19")
    private String inputCode19;
    @Size(max = 45)
    @Column(name = "inputCode20")
    private String inputCode20;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inputCodeQTY1")
    private Double inputCodeQTY1;
    @Column(name = "inputCodeQTY2")
    private Double inputCodeQTY2;
    @Column(name = "inputCodeQTY3")
    private Double inputCodeQTY3;
    @Column(name = "inputCodeQTY4")
    private Double inputCodeQTY4;
    @Column(name = "inputCodeQTY5")
    private Double inputCodeQTY5;
    @Column(name = "inputCodeQTY6")
    private Double inputCodeQTY6;
    @Column(name = "inputCodeQTY7")
    private Double inputCodeQTY7;
    @Column(name = "inputCodeQTY8")
    private Double inputCodeQTY8;
    @Column(name = "inputCodeQTY9")
    private Double inputCodeQTY9;
    @Column(name = "inputCodeQTY10")
    private Double inputCodeQTY10;
    @Column(name = "inputCodeQTY11")
    private Double inputCodeQTY11;
    @Column(name = "inputCodeQTY12")
    private Double inputCodeQTY12;
    @Column(name = "inputCodeQTY13")
    private Double inputCodeQTY13;
    @Column(name = "inputCodeQTY14")
    private Double inputCodeQTY14;
    @Column(name = "inputCodeQTY15")
    private Double inputCodeQTY15;
    @Column(name = "inputCodeQTY16")
    private Double inputCodeQTY16;
    @Column(name = "inputCodeQTY17")
    private Double inputCodeQTY17;
    @Column(name = "inputCodeQTY18")
    private Double inputCodeQTY18;
    @Column(name = "inputCodeQTY19")
    private Double inputCodeQTY19;
    @Column(name = "inputCodeQTY20")
    private Double inputCodeQTY20;
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

    public Products() {
    }

    public Products(String s) {
        productName = s;
    }
    
    public Products(Integer productId) {
        this.productId = productId;
    }

    public Products(Integer productId, String productName, String productSG) {
        this.productId = productId;
        this.productName = productName;
        this.productSG = productSG;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSG() {
        return productSG;
    }

    public void setProductSG(String productSG) {
        this.productSG = productSG;
    }

    public String getProductShade() {
        return productShade;
    }

    public void setProductShade(String productShade) {
        this.productShade = productShade;
    }

    public String getInputCode1() {
        return inputCode1;
    }

    public void setInputCode1(String inputCode1) {
        this.inputCode1 = inputCode1;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getInputCode2() {
        return inputCode2;
    }

    public void setInputCode2(String inputCode2) {
        this.inputCode2 = inputCode2;
    }

    public String getInputCode3() {
        return inputCode3;
    }

    public void setInputCode3(String inputCode3) {
        this.inputCode3 = inputCode3;
    }

    public String getInputCode4() {
        return inputCode4;
    }

    public void setInputCode4(String inputCode4) {
        this.inputCode4 = inputCode4;
    }

    public String getInputCode5() {
        return inputCode5;
    }

    public void setInputCode5(String inputCode5) {
        this.inputCode5 = inputCode5;
    }

    public String getInputCode6() {
        return inputCode6;
    }

    public void setInputCode6(String inputCode6) {
        this.inputCode6 = inputCode6;
    }

    public String getInputCode7() {
        return inputCode7;
    }

    public void setInputCode7(String inputCode7) {
        this.inputCode7 = inputCode7;
    }

    public String getInputCode8() {
        return inputCode8;
    }

    public void setInputCode8(String inputCode8) {
        this.inputCode8 = inputCode8;
    }

    public String getInputCode9() {
        return inputCode9;
    }

    public void setInputCode9(String inputCode9) {
        this.inputCode9 = inputCode9;
    }

    public String getInputCode10() {
        return inputCode10;
    }

    public void setInputCode10(String inputCode10) {
        this.inputCode10 = inputCode10;
    }

    public String getInputCode11() {
        return inputCode11;
    }

    public void setInputCode11(String inputCode11) {
        this.inputCode11 = inputCode11;
    }

    public String getInputCode12() {
        return inputCode12;
    }

    public void setInputCode12(String inputCode12) {
        this.inputCode12 = inputCode12;
    }

    public String getInputCode13() {
        return inputCode13;
    }

    public void setInputCode13(String inputCode13) {
        this.inputCode13 = inputCode13;
    }

    public String getInputCode14() {
        return inputCode14;
    }

    public void setInputCode14(String inputCode14) {
        this.inputCode14 = inputCode14;
    }

    public String getInputCode15() {
        return inputCode15;
    }

    public void setInputCode15(String inputCode15) {
        this.inputCode15 = inputCode15;
    }

    public String getInputCode16() {
        return inputCode16;
    }

    public void setInputCode16(String inputCode16) {
        this.inputCode16 = inputCode16;
    }

    public String getInputCode17() {
        return inputCode17;
    }

    public void setInputCode17(String inputCode17) {
        this.inputCode17 = inputCode17;
    }

    public String getInputCode18() {
        return inputCode18;
    }

    public void setInputCode18(String inputCode18) {
        this.inputCode18 = inputCode18;
    }

    public String getInputCode19() {
        return inputCode19;
    }

    public void setInputCode19(String inputCode19) {
        this.inputCode19 = inputCode19;
    }

    public String getInputCode20() {
        return inputCode20;
    }

    public void setInputCode20(String inputCode20) {
        this.inputCode20 = inputCode20;
    }

    public Double getInputCodeQTY1() {
        return inputCodeQTY1;
    }

    public void setInputCodeQTY1(Double inputCodeQTY1) {
        this.inputCodeQTY1 = inputCodeQTY1;
    }

    public Double getInputCodeQTY2() {
        return inputCodeQTY2;
    }

    public void setInputCodeQTY2(Double inputCodeQTY2) {
        this.inputCodeQTY2 = inputCodeQTY2;
    }

    public Double getInputCodeQTY3() {
        return inputCodeQTY3;
    }

    public void setInputCodeQTY3(Double inputCodeQTY3) {
        this.inputCodeQTY3 = inputCodeQTY3;
    }

    public Double getInputCodeQTY4() {
        return inputCodeQTY4;
    }

    public void setInputCodeQTY4(Double inputCodeQTY4) {
        this.inputCodeQTY4 = inputCodeQTY4;
    }

    public Double getInputCodeQTY5() {
        return inputCodeQTY5;
    }

    public void setInputCodeQTY5(Double inputCodeQTY5) {
        this.inputCodeQTY5 = inputCodeQTY5;
    }

    public Double getInputCodeQTY6() {
        return inputCodeQTY6;
    }

    public void setInputCodeQTY6(Double inputCodeQTY6) {
        this.inputCodeQTY6 = inputCodeQTY6;
    }

    public Double getInputCodeQTY7() {
        return inputCodeQTY7;
    }

    public void setInputCodeQTY7(Double inputCodeQTY7) {
        this.inputCodeQTY7 = inputCodeQTY7;
    }

    public Double getInputCodeQTY8() {
        return inputCodeQTY8;
    }

    public void setInputCodeQTY8(Double inputCodeQTY8) {
        this.inputCodeQTY8 = inputCodeQTY8;
    }

    public Double getInputCodeQTY9() {
        return inputCodeQTY9;
    }

    public void setInputCodeQTY9(Double inputCodeQTY9) {
        this.inputCodeQTY9 = inputCodeQTY9;
    }

    public Double getInputCodeQTY10() {
        return inputCodeQTY10;
    }

    public void setInputCodeQTY10(Double inputCodeQTY10) {
        this.inputCodeQTY10 = inputCodeQTY10;
    }

    public Double getInputCodeQTY11() {
        return inputCodeQTY11;
    }

    public void setInputCodeQTY11(Double inputCodeQTY11) {
        this.inputCodeQTY11 = inputCodeQTY11;
    }

    public Double getInputCodeQTY12() {
        return inputCodeQTY12;
    }

    public void setInputCodeQTY12(Double inputCodeQTY12) {
        this.inputCodeQTY12 = inputCodeQTY12;
    }

    public Double getInputCodeQTY13() {
        return inputCodeQTY13;
    }

    public void setInputCodeQTY13(Double inputCodeQTY13) {
        this.inputCodeQTY13 = inputCodeQTY13;
    }

    public Double getInputCodeQTY14() {
        return inputCodeQTY14;
    }

    public void setInputCodeQTY14(Double inputCodeQTY14) {
        this.inputCodeQTY14 = inputCodeQTY14;
    }

    public Double getInputCodeQTY15() {
        return inputCodeQTY15;
    }

    public void setInputCodeQTY15(Double inputCodeQTY15) {
        this.inputCodeQTY15 = inputCodeQTY15;
    }

    public Double getInputCodeQTY16() {
        return inputCodeQTY16;
    }

    public void setInputCodeQTY16(Double inputCodeQTY16) {
        this.inputCodeQTY16 = inputCodeQTY16;
    }

    public Double getInputCodeQTY17() {
        return inputCodeQTY17;
    }

    public void setInputCodeQTY17(Double inputCodeQTY17) {
        this.inputCodeQTY17 = inputCodeQTY17;
    }

    public Double getInputCodeQTY18() {
        return inputCodeQTY18;
    }

    public void setInputCodeQTY18(Double inputCodeQTY18) {
        this.inputCodeQTY18 = inputCodeQTY18;
    }

    public Double getInputCodeQTY19() {
        return inputCodeQTY19;
    }

    public void setInputCodeQTY19(Double inputCodeQTY19) {
        this.inputCodeQTY19 = inputCodeQTY19;
    }

    public Double getInputCodeQTY20() {
        return inputCodeQTY20;
    }

    public void setInputCodeQTY20(Double inputCodeQTY20) {
        this.inputCodeQTY20 = inputCodeQTY20;
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
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "com.application.premierpaints.products.data.Products[ productId=" + productId + " ]";
        return getProductName();
    }
    
}
