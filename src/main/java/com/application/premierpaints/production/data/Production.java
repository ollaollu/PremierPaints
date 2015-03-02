/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.production.data;

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
@Table(name = "production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Production.findAll", query = "SELECT p FROM Production p"),
    @NamedQuery(name = "Production.findByProductionbatch", query = "SELECT p FROM Production p WHERE p.productionbatch = :productionbatch"),
    @NamedQuery(name = "Production.findByProductclass", query = "SELECT p FROM Production p WHERE p.productclass = :productclass"),
    @NamedQuery(name = "Production.findByProductname", query = "SELECT p FROM Production p WHERE p.productname = :productname"),
    @NamedQuery(name = "Production.findByRequiredqty", query = "SELECT p FROM Production p WHERE p.requiredqty = :requiredqty"),
    @NamedQuery(name = "Production.findByProductcode1", query = "SELECT p FROM Production p WHERE p.productcode1 = :productcode1"),
    @NamedQuery(name = "Production.findByProductcode2", query = "SELECT p FROM Production p WHERE p.productcode2 = :productcode2"),
    @NamedQuery(name = "Production.findByProductcode3", query = "SELECT p FROM Production p WHERE p.productcode3 = :productcode3"),
    @NamedQuery(name = "Production.findByProductcode4", query = "SELECT p FROM Production p WHERE p.productcode4 = :productcode4"),
    @NamedQuery(name = "Production.findByProductcode5", query = "SELECT p FROM Production p WHERE p.productcode5 = :productcode5"),
    @NamedQuery(name = "Production.findByProductcode6", query = "SELECT p FROM Production p WHERE p.productcode6 = :productcode6"),
    @NamedQuery(name = "Production.findByProductcode7", query = "SELECT p FROM Production p WHERE p.productcode7 = :productcode7"),
    @NamedQuery(name = "Production.findByProductcode8", query = "SELECT p FROM Production p WHERE p.productcode8 = :productcode8"),
    @NamedQuery(name = "Production.findByProductcode9", query = "SELECT p FROM Production p WHERE p.productcode9 = :productcode9"),
    @NamedQuery(name = "Production.findByProductcode10", query = "SELECT p FROM Production p WHERE p.productcode10 = :productcode10"),
    @NamedQuery(name = "Production.findByProductcode11", query = "SELECT p FROM Production p WHERE p.productcode11 = :productcode11"),
    @NamedQuery(name = "Production.findByProductcode12", query = "SELECT p FROM Production p WHERE p.productcode12 = :productcode12"),
    @NamedQuery(name = "Production.findByProductcode13", query = "SELECT p FROM Production p WHERE p.productcode13 = :productcode13"),
    @NamedQuery(name = "Production.findByProductcode14", query = "SELECT p FROM Production p WHERE p.productcode14 = :productcode14"),
    @NamedQuery(name = "Production.findByProductcode15", query = "SELECT p FROM Production p WHERE p.productcode15 = :productcode15"),
    @NamedQuery(name = "Production.findByProductcode16", query = "SELECT p FROM Production p WHERE p.productcode16 = :productcode16"),
    @NamedQuery(name = "Production.findByProductcode17", query = "SELECT p FROM Production p WHERE p.productcode17 = :productcode17"),
    @NamedQuery(name = "Production.findByProductcode18", query = "SELECT p FROM Production p WHERE p.productcode18 = :productcode18"),
    @NamedQuery(name = "Production.findByProductcode19", query = "SELECT p FROM Production p WHERE p.productcode19 = :productcode19"),
    @NamedQuery(name = "Production.findByProductcode20", query = "SELECT p FROM Production p WHERE p.productcode20 = :productcode20"),
    @NamedQuery(name = "Production.findByActualqty1", query = "SELECT p FROM Production p WHERE p.actualqty1 = :actualqty1"),
    @NamedQuery(name = "Production.findByActualqty2", query = "SELECT p FROM Production p WHERE p.actualqty2 = :actualqty2"),
    @NamedQuery(name = "Production.findByActualqty3", query = "SELECT p FROM Production p WHERE p.actualqty3 = :actualqty3"),
    @NamedQuery(name = "Production.findByActualqty4", query = "SELECT p FROM Production p WHERE p.actualqty4 = :actualqty4"),
    @NamedQuery(name = "Production.findByActualqty5", query = "SELECT p FROM Production p WHERE p.actualqty5 = :actualqty5"),
    @NamedQuery(name = "Production.findByActualqty6", query = "SELECT p FROM Production p WHERE p.actualqty6 = :actualqty6"),
    @NamedQuery(name = "Production.findByActualqty7", query = "SELECT p FROM Production p WHERE p.actualqty7 = :actualqty7"),
    @NamedQuery(name = "Production.findByActualqty8", query = "SELECT p FROM Production p WHERE p.actualqty8 = :actualqty8"),
    @NamedQuery(name = "Production.findByActualqty9", query = "SELECT p FROM Production p WHERE p.actualqty9 = :actualqty9"),
    @NamedQuery(name = "Production.findByActualqty10", query = "SELECT p FROM Production p WHERE p.actualqty10 = :actualqty10"),
    @NamedQuery(name = "Production.findByActualqty11", query = "SELECT p FROM Production p WHERE p.actualqty11 = :actualqty11"),
    @NamedQuery(name = "Production.findByActualqty12", query = "SELECT p FROM Production p WHERE p.actualqty12 = :actualqty12"),
    @NamedQuery(name = "Production.findByActualqty13", query = "SELECT p FROM Production p WHERE p.actualqty13 = :actualqty13"),
    @NamedQuery(name = "Production.findByActualqty14", query = "SELECT p FROM Production p WHERE p.actualqty14 = :actualqty14"),
    @NamedQuery(name = "Production.findByActualqty15", query = "SELECT p FROM Production p WHERE p.actualqty15 = :actualqty15"),
    @NamedQuery(name = "Production.findByActualqty16", query = "SELECT p FROM Production p WHERE p.actualqty16 = :actualqty16"),
    @NamedQuery(name = "Production.findByActualqty17", query = "SELECT p FROM Production p WHERE p.actualqty17 = :actualqty17"),
    @NamedQuery(name = "Production.findByActualqty18", query = "SELECT p FROM Production p WHERE p.actualqty18 = :actualqty18"),
    @NamedQuery(name = "Production.findByActualqty19", query = "SELECT p FROM Production p WHERE p.actualqty19 = :actualqty19"),
    @NamedQuery(name = "Production.findByActualqty20", query = "SELECT p FROM Production p WHERE p.actualqty20 = :actualqty20"),
    @NamedQuery(name = "Production.findByProductioninstruction1", query = "SELECT p FROM Production p WHERE p.productioninstruction1 = :productioninstruction1"),
    @NamedQuery(name = "Production.findByProductioninstruction2", query = "SELECT p FROM Production p WHERE p.productioninstruction2 = :productioninstruction2"),
    @NamedQuery(name = "Production.findByProductioninstruction3", query = "SELECT p FROM Production p WHERE p.productioninstruction3 = :productioninstruction3"),
    @NamedQuery(name = "Production.findByProductioninstruction4", query = "SELECT p FROM Production p WHERE p.productioninstruction4 = :productioninstruction4"),
    @NamedQuery(name = "Production.findByProductioninstruction5", query = "SELECT p FROM Production p WHERE p.productioninstruction5 = :productioninstruction5"),
    @NamedQuery(name = "Production.findByProductioninstruction6", query = "SELECT p FROM Production p WHERE p.productioninstruction6 = :productioninstruction6"),
    @NamedQuery(name = "Production.findByProductioninstruction7", query = "SELECT p FROM Production p WHERE p.productioninstruction7 = :productioninstruction7"),
    @NamedQuery(name = "Production.findByProductioninstruction8", query = "SELECT p FROM Production p WHERE p.productioninstruction8 = :productioninstruction8"),
    @NamedQuery(name = "Production.findByProductioninstruction9", query = "SELECT p FROM Production p WHERE p.productioninstruction9 = :productioninstruction9"),
    @NamedQuery(name = "Production.findByProductioninstruction10", query = "SELECT p FROM Production p WHERE p.productioninstruction10 = :productioninstruction10"),
    @NamedQuery(name = "Production.findByProductioninstruction11", query = "SELECT p FROM Production p WHERE p.productioninstruction11 = :productioninstruction11"),
    @NamedQuery(name = "Production.findByProductioninstruction12", query = "SELECT p FROM Production p WHERE p.productioninstruction12 = :productioninstruction12"),
    @NamedQuery(name = "Production.findByProductioninstruction13", query = "SELECT p FROM Production p WHERE p.productioninstruction13 = :productioninstruction13"),
    @NamedQuery(name = "Production.findByProductioninstruction14", query = "SELECT p FROM Production p WHERE p.productioninstruction14 = :productioninstruction14"),
    @NamedQuery(name = "Production.findByProductioninstruction15", query = "SELECT p FROM Production p WHERE p.productioninstruction15 = :productioninstruction15"),
    @NamedQuery(name = "Production.findByProductioninstruction16", query = "SELECT p FROM Production p WHERE p.productioninstruction16 = :productioninstruction16"),
    @NamedQuery(name = "Production.findByProductioninstruction17", query = "SELECT p FROM Production p WHERE p.productioninstruction17 = :productioninstruction17"),
    @NamedQuery(name = "Production.findByProductioninstruction18", query = "SELECT p FROM Production p WHERE p.productioninstruction18 = :productioninstruction18"),
    @NamedQuery(name = "Production.findByProductioninstruction19", query = "SELECT p FROM Production p WHERE p.productioninstruction19 = :productioninstruction19"),
    @NamedQuery(name = "Production.findByProductioninstruction20", query = "SELECT p FROM Production p WHERE p.productioninstruction20 = :productioninstruction20"),
    @NamedQuery(name = "Production.findByProductqtyperpail1", query = "SELECT p FROM Production p WHERE p.productqtyperpail1 = :productqtyperpail1"),
    @NamedQuery(name = "Production.findByProductqtyperpail2", query = "SELECT p FROM Production p WHERE p.productqtyperpail2 = :productqtyperpail2"),
    @NamedQuery(name = "Production.findByProductqtyperpail3", query = "SELECT p FROM Production p WHERE p.productqtyperpail3 = :productqtyperpail3"),
    @NamedQuery(name = "Production.findByProductqtyperpail4", query = "SELECT p FROM Production p WHERE p.productqtyperpail4 = :productqtyperpail4"),
    @NamedQuery(name = "Production.findByProductqtyperpail5", query = "SELECT p FROM Production p WHERE p.productqtyperpail5 = :productqtyperpail5"),
    @NamedQuery(name = "Production.findByProductqtyperpail6", query = "SELECT p FROM Production p WHERE p.productqtyperpail6 = :productqtyperpail6"),
    @NamedQuery(name = "Production.findByProductqtyperpail7", query = "SELECT p FROM Production p WHERE p.productqtyperpail7 = :productqtyperpail7"),
    @NamedQuery(name = "Production.findByProductqtyperpail8", query = "SELECT p FROM Production p WHERE p.productqtyperpail8 = :productqtyperpail8"),
    @NamedQuery(name = "Production.findByProductqtyperpail9", query = "SELECT p FROM Production p WHERE p.productqtyperpail9 = :productqtyperpail9"),
    @NamedQuery(name = "Production.findByProductqtyperpail10", query = "SELECT p FROM Production p WHERE p.productqtyperpail10 = :productqtyperpail10"),
    @NamedQuery(name = "Production.findByProductqtyperpail11", query = "SELECT p FROM Production p WHERE p.productqtyperpail11 = :productqtyperpail11"),
    @NamedQuery(name = "Production.findByProductqtyperpail12", query = "SELECT p FROM Production p WHERE p.productqtyperpail12 = :productqtyperpail12"),
    @NamedQuery(name = "Production.findByProductqtyperpail13", query = "SELECT p FROM Production p WHERE p.productqtyperpail13 = :productqtyperpail13"),
    @NamedQuery(name = "Production.findByProductqtyperpail14", query = "SELECT p FROM Production p WHERE p.productqtyperpail14 = :productqtyperpail14"),
    @NamedQuery(name = "Production.findByProductqtyperpail15", query = "SELECT p FROM Production p WHERE p.productqtyperpail15 = :productqtyperpail15"),
    @NamedQuery(name = "Production.findByProductqtyperpail16", query = "SELECT p FROM Production p WHERE p.productqtyperpail16 = :productqtyperpail16"),
    @NamedQuery(name = "Production.findByProductqtyperpail17", query = "SELECT p FROM Production p WHERE p.productqtyperpail17 = :productqtyperpail17"),
    @NamedQuery(name = "Production.findByProductqtyperpail18", query = "SELECT p FROM Production p WHERE p.productqtyperpail18 = :productqtyperpail18"),
    @NamedQuery(name = "Production.findByProductqtyperpail19", query = "SELECT p FROM Production p WHERE p.productqtyperpail19 = :productqtyperpail19"),
    @NamedQuery(name = "Production.findByProductqtyperpail20", query = "SELECT p FROM Production p WHERE p.productqtyperpail20 = :productqtyperpail20"),
    @NamedQuery(name = "Production.findByProductionqty1", query = "SELECT p FROM Production p WHERE p.productionqty1 = :productionqty1"),
    @NamedQuery(name = "Production.findByProductionqty2", query = "SELECT p FROM Production p WHERE p.productionqty2 = :productionqty2"),
    @NamedQuery(name = "Production.findByProductionqty3", query = "SELECT p FROM Production p WHERE p.productionqty3 = :productionqty3"),
    @NamedQuery(name = "Production.findByProductionqty4", query = "SELECT p FROM Production p WHERE p.productionqty4 = :productionqty4"),
    @NamedQuery(name = "Production.findByProductionqty5", query = "SELECT p FROM Production p WHERE p.productionqty5 = :productionqty5"),
    @NamedQuery(name = "Production.findByProductionqty6", query = "SELECT p FROM Production p WHERE p.productionqty6 = :productionqty6"),
    @NamedQuery(name = "Production.findByProductionqty7", query = "SELECT p FROM Production p WHERE p.productionqty7 = :productionqty7"),
    @NamedQuery(name = "Production.findByProductionqty8", query = "SELECT p FROM Production p WHERE p.productionqty8 = :productionqty8"),
    @NamedQuery(name = "Production.findByProductionqty9", query = "SELECT p FROM Production p WHERE p.productionqty9 = :productionqty9"),
    @NamedQuery(name = "Production.findByProductionqty10", query = "SELECT p FROM Production p WHERE p.productionqty10 = :productionqty10"),
    @NamedQuery(name = "Production.findByProductionqty11", query = "SELECT p FROM Production p WHERE p.productionqty11 = :productionqty11"),
    @NamedQuery(name = "Production.findByProductionqty12", query = "SELECT p FROM Production p WHERE p.productionqty12 = :productionqty12"),
    @NamedQuery(name = "Production.findByProductionqty13", query = "SELECT p FROM Production p WHERE p.productionqty13 = :productionqty13"),
    @NamedQuery(name = "Production.findByProductionqty14", query = "SELECT p FROM Production p WHERE p.productionqty14 = :productionqty14"),
    @NamedQuery(name = "Production.findByProductionqty15", query = "SELECT p FROM Production p WHERE p.productionqty15 = :productionqty15"),
    @NamedQuery(name = "Production.findByProductionqty16", query = "SELECT p FROM Production p WHERE p.productionqty16 = :productionqty16"),
    @NamedQuery(name = "Production.findByProductionqty17", query = "SELECT p FROM Production p WHERE p.productionqty17 = :productionqty17"),
    @NamedQuery(name = "Production.findByProductionqty18", query = "SELECT p FROM Production p WHERE p.productionqty18 = :productionqty18"),
    @NamedQuery(name = "Production.findByProductionqty19", query = "SELECT p FROM Production p WHERE p.productionqty19 = :productionqty19"),
    @NamedQuery(name = "Production.findByProductionqty20", query = "SELECT p FROM Production p WHERE p.productionqty20 = :productionqty20"),
    @NamedQuery(name = "Production.findByStrtime", query = "SELECT p FROM Production p WHERE p.strtime = :strtime"),
    @NamedQuery(name = "Production.findByEndtime", query = "SELECT p FROM Production p WHERE p.endtime = :endtime"),
    @NamedQuery(name = "Production.findByStrdate", query = "SELECT p FROM Production p WHERE p.strdate = :strdate"),
    @NamedQuery(name = "Production.findByEnddate", query = "SELECT p FROM Production p WHERE p.enddate = :enddate"),
    @NamedQuery(name = "Production.findByClient", query = "SELECT p FROM Production p WHERE p.client = :client"),
    @NamedQuery(name = "Production.findByAddcode1", query = "SELECT p FROM Production p WHERE p.addcode1 = :addcode1"),
    @NamedQuery(name = "Production.findByAddcode2", query = "SELECT p FROM Production p WHERE p.addcode2 = :addcode2"),
    @NamedQuery(name = "Production.findByAddcode3", query = "SELECT p FROM Production p WHERE p.addcode3 = :addcode3"),
    @NamedQuery(name = "Production.findByAddinstr1", query = "SELECT p FROM Production p WHERE p.addinstr1 = :addinstr1"),
    @NamedQuery(name = "Production.findByAddinstr2", query = "SELECT p FROM Production p WHERE p.addinstr2 = :addinstr2"),
    @NamedQuery(name = "Production.findByAddinstr3", query = "SELECT p FROM Production p WHERE p.addinstr3 = :addinstr3"),
    @NamedQuery(name = "Production.findByAddqty1", query = "SELECT p FROM Production p WHERE p.addqty1 = :addqty1"),
    @NamedQuery(name = "Production.findByAddqty2", query = "SELECT p FROM Production p WHERE p.addqty2 = :addqty2"),
    @NamedQuery(name = "Production.findByAddqty3", query = "SELECT p FROM Production p WHERE p.addqty3 = :addqty3"),
    @NamedQuery(name = "Production.findByAddprodqty1", query = "SELECT p FROM Production p WHERE p.addprodqty1 = :addprodqty1"),
    @NamedQuery(name = "Production.findByAddprodqty2", query = "SELECT p FROM Production p WHERE p.addprodqty2 = :addprodqty2"),
    @NamedQuery(name = "Production.findByAddprodqty3", query = "SELECT p FROM Production p WHERE p.addprodqty3 = :addprodqty3"),
    @NamedQuery(name = "Production.findByStatus", query = "SELECT p FROM Production p WHERE p.status = :status"),
    @NamedQuery(name = "Production.findByCreatedby", query = "SELECT p FROM Production p WHERE p.createdby = :createdby"),
    @NamedQuery(name = "Production.findByEditedby", query = "SELECT p FROM Production p WHERE p.editedby = :editedby"),
    @NamedQuery(name = "Production.findByTimecreated", query = "SELECT p FROM Production p WHERE p.timecreated = :timecreated"),
    @NamedQuery(name = "Production.findByTimeedited", query = "SELECT p FROM Production p WHERE p.timeedited = :timeedited"),
    @NamedQuery(name = "Production.findByPackagetype", query = "SELECT p FROM Production p WHERE p.packagetype = :packagetype"),
    @NamedQuery(name = "Production.findByContainertype", query = "SELECT p FROM Production p WHERE p.containertype = :containertype"),
    @NamedQuery(name = "Production.findByProductSG", query = "SELECT p FROM Production p WHERE p.productSG = :productSG")})
public class Production implements Serializable {
    @Size(max = 45)
    @Column(name = "addcode4")
    private String addcode4;
    @Size(max = 45)
    @Column(name = "addcode5")
    private String addcode5;
    @Size(max = 45)
    @Column(name = "addcode6")
    private String addcode6;
    @Size(max = 45)
    @Column(name = "addcode7")
    private String addcode7;
    @Size(max = 45)
    @Column(name = "addcode8")
    private String addcode8;
    @Size(max = 45)
    @Column(name = "addinstr4")
    private String addinstr4;
    @Size(max = 45)
    @Column(name = "addinstr5")
    private String addinstr5;
    @Size(max = 45)
    @Column(name = "addinstr6")
    private String addinstr6;
    @Size(max = 45)
    @Column(name = "addinstr7")
    private String addinstr7;
    @Size(max = 45)
    @Column(name = "addinstr8")
    private String addinstr8;
    @Column(name = "addqty4")
    private Double addqty4;
    @Column(name = "addqty5")
    private Double addqty5;
    @Column(name = "addqty6")
    private Double addqty6;
    @Column(name = "addqty7")
    private Double addqty7;
    @Column(name = "addqty8")
    private Double addqty8;
    @Column(name = "addprodqty4")
    private Double addprodqty4;
    @Column(name = "addprodqty5")
    private Double addprodqty5;
    @Column(name = "addprodqty6")
    private Double addprodqty6;
    @Column(name = "addprodqty7")
    private Double addprodqty7;
    @Column(name = "addprodqty8")
    private Double addprodqty8;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productionbatch")
    private Integer productionbatch;
    @Size(max = 45)
    @Column(name = "productclass")
    private String productclass;
    @Size(max = 45)
    @Column(name = "productname")
    private String productname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "requiredqty")
    private Double requiredqty;
    @Size(max = 45)
    @Column(name = "productcode1")
    private String productcode1;
    @Size(max = 45)
    @Column(name = "productcode2")
    private String productcode2;
    @Size(max = 45)
    @Column(name = "productcode3")
    private String productcode3;
    @Size(max = 45)
    @Column(name = "productcode4")
    private String productcode4;
    @Size(max = 45)
    @Column(name = "productcode5")
    private String productcode5;
    @Size(max = 45)
    @Column(name = "productcode6")
    private String productcode6;
    @Size(max = 45)
    @Column(name = "productcode7")
    private String productcode7;
    @Size(max = 45)
    @Column(name = "productcode8")
    private String productcode8;
    @Size(max = 45)
    @Column(name = "productcode9")
    private String productcode9;
    @Size(max = 45)
    @Column(name = "productcode10")
    private String productcode10;
    @Size(max = 45)
    @Column(name = "productcode11")
    private String productcode11;
    @Size(max = 45)
    @Column(name = "productcode12")
    private String productcode12;
    @Size(max = 45)
    @Column(name = "productcode13")
    private String productcode13;
    @Size(max = 45)
    @Column(name = "productcode14")
    private String productcode14;
    @Size(max = 45)
    @Column(name = "productcode15")
    private String productcode15;
    @Size(max = 45)
    @Column(name = "productcode16")
    private String productcode16;
    @Size(max = 45)
    @Column(name = "productcode17")
    private String productcode17;
    @Size(max = 45)
    @Column(name = "productcode18")
    private String productcode18;
    @Size(max = 45)
    @Column(name = "productcode19")
    private String productcode19;
    @Size(max = 45)
    @Column(name = "productcode20")
    private String productcode20;
    @Column(name = "actualqty1")
    private Double actualqty1;
    @Column(name = "actualqty2")
    private Double actualqty2;
    @Column(name = "actualqty3")
    private Double actualqty3;
    @Column(name = "actualqty4")
    private Double actualqty4;
    @Column(name = "actualqty5")
    private Double actualqty5;
    @Column(name = "actualqty6")
    private Double actualqty6;
    @Column(name = "actualqty7")
    private Double actualqty7;
    @Column(name = "actualqty8")
    private Double actualqty8;
    @Column(name = "actualqty9")
    private Double actualqty9;
    @Column(name = "actualqty10")
    private Double actualqty10;
    @Column(name = "actualqty11")
    private Double actualqty11;
    @Column(name = "actualqty12")
    private Double actualqty12;
    @Column(name = "actualqty13")
    private Double actualqty13;
    @Column(name = "actualqty14")
    private Double actualqty14;
    @Column(name = "actualqty15")
    private Double actualqty15;
    @Column(name = "actualqty16")
    private Double actualqty16;
    @Column(name = "actualqty17")
    private Double actualqty17;
    @Column(name = "actualqty18")
    private Double actualqty18;
    @Column(name = "actualqty19")
    private Double actualqty19;
    @Column(name = "actualqty20")
    private Double actualqty20;
    @Size(max = 45)
    @Column(name = "productioninstruction1")
    private String productioninstruction1;
    @Size(max = 45)
    @Column(name = "productioninstruction2")
    private String productioninstruction2;
    @Size(max = 45)
    @Column(name = "productioninstruction3")
    private String productioninstruction3;
    @Size(max = 45)
    @Column(name = "productioninstruction4")
    private String productioninstruction4;
    @Size(max = 45)
    @Column(name = "productioninstruction5")
    private String productioninstruction5;
    @Size(max = 45)
    @Column(name = "productioninstruction6")
    private String productioninstruction6;
    @Size(max = 45)
    @Column(name = "productioninstruction7")
    private String productioninstruction7;
    @Size(max = 45)
    @Column(name = "productioninstruction8")
    private String productioninstruction8;
    @Size(max = 45)
    @Column(name = "productioninstruction9")
    private String productioninstruction9;
    @Size(max = 45)
    @Column(name = "productioninstruction10")
    private String productioninstruction10;
    @Size(max = 45)
    @Column(name = "productioninstruction11")
    private String productioninstruction11;
    @Size(max = 45)
    @Column(name = "productioninstruction12")
    private String productioninstruction12;
    @Size(max = 45)
    @Column(name = "productioninstruction13")
    private String productioninstruction13;
    @Size(max = 45)
    @Column(name = "productioninstruction14")
    private String productioninstruction14;
    @Size(max = 45)
    @Column(name = "productioninstruction15")
    private String productioninstruction15;
    @Size(max = 45)
    @Column(name = "productioninstruction16")
    private String productioninstruction16;
    @Size(max = 45)
    @Column(name = "productioninstruction17")
    private String productioninstruction17;
    @Size(max = 45)
    @Column(name = "productioninstruction18")
    private String productioninstruction18;
    @Size(max = 45)
    @Column(name = "productioninstruction19")
    private String productioninstruction19;
    @Size(max = 45)
    @Column(name = "productioninstruction20")
    private String productioninstruction20;
    @Column(name = "productqtyperpail1")
    private Double productqtyperpail1;
    @Column(name = "productqtyperpail2")
    private Double productqtyperpail2;
    @Column(name = "productqtyperpail3")
    private Double productqtyperpail3;
    @Column(name = "productqtyperpail4")
    private Double productqtyperpail4;
    @Column(name = "productqtyperpail5")
    private Double productqtyperpail5;
    @Column(name = "productqtyperpail6")
    private Double productqtyperpail6;
    @Column(name = "productqtyperpail7")
    private Double productqtyperpail7;
    @Column(name = "productqtyperpail8")
    private Double productqtyperpail8;
    @Column(name = "productqtyperpail9")
    private Double productqtyperpail9;
    @Column(name = "productqtyperpail10")
    private Double productqtyperpail10;
    @Column(name = "productqtyperpail11")
    private Double productqtyperpail11;
    @Column(name = "productqtyperpail12")
    private Double productqtyperpail12;
    @Column(name = "productqtyperpail13")
    private Double productqtyperpail13;
    @Column(name = "productqtyperpail14")
    private Double productqtyperpail14;
    @Column(name = "productqtyperpail15")
    private Double productqtyperpail15;
    @Column(name = "productqtyperpail16")
    private Double productqtyperpail16;
    @Column(name = "productqtyperpail17")
    private Double productqtyperpail17;
    @Column(name = "productqtyperpail18")
    private Double productqtyperpail18;
    @Column(name = "productqtyperpail19")
    private Double productqtyperpail19;
    @Column(name = "productqtyperpail20")
    private Double productqtyperpail20;
    @Column(name = "productionqty1")
    private Double productionqty1;
    @Column(name = "productionqty2")
    private Double productionqty2;
    @Column(name = "productionqty3")
    private Double productionqty3;
    @Column(name = "productionqty4")
    private Double productionqty4;
    @Column(name = "productionqty5")
    private Double productionqty5;
    @Column(name = "productionqty6")
    private Double productionqty6;
    @Column(name = "productionqty7")
    private Double productionqty7;
    @Column(name = "productionqty8")
    private Double productionqty8;
    @Column(name = "productionqty9")
    private Double productionqty9;
    @Column(name = "productionqty10")
    private Double productionqty10;
    @Column(name = "productionqty11")
    private Double productionqty11;
    @Column(name = "productionqty12")
    private Double productionqty12;
    @Column(name = "productionqty13")
    private Double productionqty13;
    @Column(name = "productionqty14")
    private Double productionqty14;
    @Column(name = "productionqty15")
    private Double productionqty15;
    @Column(name = "productionqty16")
    private Double productionqty16;
    @Column(name = "productionqty17")
    private Double productionqty17;
    @Column(name = "productionqty18")
    private Double productionqty18;
    @Column(name = "productionqty19")
    private Double productionqty19;
    @Column(name = "productionqty20")
    private Double productionqty20;
    @Size(max = 45)
    @Column(name = "strtime")
    private String strtime;
    @Size(max = 45)
    @Column(name = "endtime")
    private String endtime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "strdate")
    @Temporal(TemporalType.DATE)
    private Date strdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Size(max = 100)
    @Column(name = "client")
    private String client;
    @Size(max = 45)
    @Column(name = "addcode1")
    private String addcode1;
    @Size(max = 45)
    @Column(name = "addcode2")
    private String addcode2;
    @Size(max = 45)
    @Column(name = "addcode3")
    private String addcode3;
    @Size(max = 45)
    @Column(name = "addinstr1")
    private String addinstr1;
    @Size(max = 45)
    @Column(name = "addinstr2")
    private String addinstr2;
    @Size(max = 45)
    @Column(name = "addinstr3")
    private String addinstr3;
    @Column(name = "addqty1")
    private Double addqty1;
    @Column(name = "addqty2")
    private Double addqty2;
    @Column(name = "addqty3")
    private Double addqty3;
    @Column(name = "addprodqty1")
    private Double addprodqty1;
    @Column(name = "addprodqty2")
    private Double addprodqty2;
    @Column(name = "addprodqty3")
    private Double addprodqty3;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
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
    @Size(max = 45)
    @Column(name = "packagetype")
    private String packagetype;
    @Size(max = 45)
    @Column(name = "containertype")
    private String containertype;
    @Size(max = 10)
    @Column(name = "productSG")
    private String productSG;

    public Production() {
    }

    public Production(Integer productionbatch) {
        this.productionbatch = productionbatch;
    }

    public Production(Integer productionbatch, Date strdate, Date enddate) {
        this.productionbatch = productionbatch;
        this.strdate = strdate;
        this.enddate = enddate;
    }

    public Integer getProductionbatch() {
        return productionbatch;
    }

    public void setProductionbatch(Integer productionbatch) {
        this.productionbatch = productionbatch;
    }

    public String getProductclass() {
        return productclass;
    }

    public void setProductclass(String productclass) {
        this.productclass = productclass;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getRequiredqty() {
        return requiredqty;
    }

    public void setRequiredqty(Double requiredqty) {
        this.requiredqty = requiredqty;
    }

    public String getProductcode1() {
        return productcode1;
    }

    public void setProductcode1(String productcode1) {
        this.productcode1 = productcode1;
    }

    public String getProductcode2() {
        return productcode2;
    }

    public void setProductcode2(String productcode2) {
        this.productcode2 = productcode2;
    }

    public String getProductcode3() {
        return productcode3;
    }

    public void setProductcode3(String productcode3) {
        this.productcode3 = productcode3;
    }

    public String getProductcode4() {
        return productcode4;
    }

    public void setProductcode4(String productcode4) {
        this.productcode4 = productcode4;
    }

    public String getProductcode5() {
        return productcode5;
    }

    public void setProductcode5(String productcode5) {
        this.productcode5 = productcode5;
    }

    public String getProductcode6() {
        return productcode6;
    }

    public void setProductcode6(String productcode6) {
        this.productcode6 = productcode6;
    }

    public String getProductcode7() {
        return productcode7;
    }

    public void setProductcode7(String productcode7) {
        this.productcode7 = productcode7;
    }

    public String getProductcode8() {
        return productcode8;
    }

    public void setProductcode8(String productcode8) {
        this.productcode8 = productcode8;
    }

    public String getProductcode9() {
        return productcode9;
    }

    public void setProductcode9(String productcode9) {
        this.productcode9 = productcode9;
    }

    public String getProductcode10() {
        return productcode10;
    }

    public void setProductcode10(String productcode10) {
        this.productcode10 = productcode10;
    }

    public String getProductcode11() {
        return productcode11;
    }

    public void setProductcode11(String productcode11) {
        this.productcode11 = productcode11;
    }

    public String getProductcode12() {
        return productcode12;
    }

    public void setProductcode12(String productcode12) {
        this.productcode12 = productcode12;
    }

    public String getProductcode13() {
        return productcode13;
    }

    public void setProductcode13(String productcode13) {
        this.productcode13 = productcode13;
    }

    public String getProductcode14() {
        return productcode14;
    }

    public void setProductcode14(String productcode14) {
        this.productcode14 = productcode14;
    }

    public String getProductcode15() {
        return productcode15;
    }

    public void setProductcode15(String productcode15) {
        this.productcode15 = productcode15;
    }

    public String getProductcode16() {
        return productcode16;
    }

    public void setProductcode16(String productcode16) {
        this.productcode16 = productcode16;
    }

    public String getProductcode17() {
        return productcode17;
    }

    public void setProductcode17(String productcode17) {
        this.productcode17 = productcode17;
    }

    public String getProductcode18() {
        return productcode18;
    }

    public void setProductcode18(String productcode18) {
        this.productcode18 = productcode18;
    }

    public String getProductcode19() {
        return productcode19;
    }

    public void setProductcode19(String productcode19) {
        this.productcode19 = productcode19;
    }

    public String getProductcode20() {
        return productcode20;
    }

    public void setProductcode20(String productcode20) {
        this.productcode20 = productcode20;
    }

    public Double getActualqty1() {
        return actualqty1;
    }

    public void setActualqty1(Double actualqty1) {
        this.actualqty1 = actualqty1;
    }

    public Double getActualqty2() {
        return actualqty2;
    }

    public void setActualqty2(Double actualqty2) {
        this.actualqty2 = actualqty2;
    }

    public Double getActualqty3() {
        return actualqty3;
    }

    public void setActualqty3(Double actualqty3) {
        this.actualqty3 = actualqty3;
    }

    public Double getActualqty4() {
        return actualqty4;
    }

    public void setActualqty4(Double actualqty4) {
        this.actualqty4 = actualqty4;
    }

    public Double getActualqty5() {
        return actualqty5;
    }

    public void setActualqty5(Double actualqty5) {
        this.actualqty5 = actualqty5;
    }

    public Double getActualqty6() {
        return actualqty6;
    }

    public void setActualqty6(Double actualqty6) {
        this.actualqty6 = actualqty6;
    }

    public Double getActualqty7() {
        return actualqty7;
    }

    public void setActualqty7(Double actualqty7) {
        this.actualqty7 = actualqty7;
    }

    public Double getActualqty8() {
        return actualqty8;
    }

    public void setActualqty8(Double actualqty8) {
        this.actualqty8 = actualqty8;
    }

    public Double getActualqty9() {
        return actualqty9;
    }

    public void setActualqty9(Double actualqty9) {
        this.actualqty9 = actualqty9;
    }

    public Double getActualqty10() {
        return actualqty10;
    }

    public void setActualqty10(Double actualqty10) {
        this.actualqty10 = actualqty10;
    }

    public Double getActualqty11() {
        return actualqty11;
    }

    public void setActualqty11(Double actualqty11) {
        this.actualqty11 = actualqty11;
    }

    public Double getActualqty12() {
        return actualqty12;
    }

    public void setActualqty12(Double actualqty12) {
        this.actualqty12 = actualqty12;
    }

    public Double getActualqty13() {
        return actualqty13;
    }

    public void setActualqty13(Double actualqty13) {
        this.actualqty13 = actualqty13;
    }

    public Double getActualqty14() {
        return actualqty14;
    }

    public void setActualqty14(Double actualqty14) {
        this.actualqty14 = actualqty14;
    }

    public Double getActualqty15() {
        return actualqty15;
    }

    public void setActualqty15(Double actualqty15) {
        this.actualqty15 = actualqty15;
    }

    public Double getActualqty16() {
        return actualqty16;
    }

    public void setActualqty16(Double actualqty16) {
        this.actualqty16 = actualqty16;
    }

    public Double getActualqty17() {
        return actualqty17;
    }

    public void setActualqty17(Double actualqty17) {
        this.actualqty17 = actualqty17;
    }

    public Double getActualqty18() {
        return actualqty18;
    }

    public void setActualqty18(Double actualqty18) {
        this.actualqty18 = actualqty18;
    }

    public Double getActualqty19() {
        return actualqty19;
    }

    public void setActualqty19(Double actualqty19) {
        this.actualqty19 = actualqty19;
    }

    public Double getActualqty20() {
        return actualqty20;
    }

    public void setActualqty20(Double actualqty20) {
        this.actualqty20 = actualqty20;
    }

    public String getProductioninstruction1() {
        return productioninstruction1;
    }

    public void setProductioninstruction1(String productioninstruction1) {
        this.productioninstruction1 = productioninstruction1;
    }

    public String getProductioninstruction2() {
        return productioninstruction2;
    }

    public void setProductioninstruction2(String productioninstruction2) {
        this.productioninstruction2 = productioninstruction2;
    }

    public String getProductioninstruction3() {
        return productioninstruction3;
    }

    public void setProductioninstruction3(String productioninstruction3) {
        this.productioninstruction3 = productioninstruction3;
    }

    public String getProductioninstruction4() {
        return productioninstruction4;
    }

    public void setProductioninstruction4(String productioninstruction4) {
        this.productioninstruction4 = productioninstruction4;
    }

    public String getProductioninstruction5() {
        return productioninstruction5;
    }

    public void setProductioninstruction5(String productioninstruction5) {
        this.productioninstruction5 = productioninstruction5;
    }

    public String getProductioninstruction6() {
        return productioninstruction6;
    }

    public void setProductioninstruction6(String productioninstruction6) {
        this.productioninstruction6 = productioninstruction6;
    }

    public String getProductioninstruction7() {
        return productioninstruction7;
    }

    public void setProductioninstruction7(String productioninstruction7) {
        this.productioninstruction7 = productioninstruction7;
    }

    public String getProductioninstruction8() {
        return productioninstruction8;
    }

    public void setProductioninstruction8(String productioninstruction8) {
        this.productioninstruction8 = productioninstruction8;
    }

    public String getProductioninstruction9() {
        return productioninstruction9;
    }

    public void setProductioninstruction9(String productioninstruction9) {
        this.productioninstruction9 = productioninstruction9;
    }

    public String getProductioninstruction10() {
        return productioninstruction10;
    }

    public void setProductioninstruction10(String productioninstruction10) {
        this.productioninstruction10 = productioninstruction10;
    }

    public String getProductioninstruction11() {
        return productioninstruction11;
    }

    public void setProductioninstruction11(String productioninstruction11) {
        this.productioninstruction11 = productioninstruction11;
    }

    public String getProductioninstruction12() {
        return productioninstruction12;
    }

    public void setProductioninstruction12(String productioninstruction12) {
        this.productioninstruction12 = productioninstruction12;
    }

    public String getProductioninstruction13() {
        return productioninstruction13;
    }

    public void setProductioninstruction13(String productioninstruction13) {
        this.productioninstruction13 = productioninstruction13;
    }

    public String getProductioninstruction14() {
        return productioninstruction14;
    }

    public void setProductioninstruction14(String productioninstruction14) {
        this.productioninstruction14 = productioninstruction14;
    }

    public String getProductioninstruction15() {
        return productioninstruction15;
    }

    public void setProductioninstruction15(String productioninstruction15) {
        this.productioninstruction15 = productioninstruction15;
    }

    public String getProductioninstruction16() {
        return productioninstruction16;
    }

    public void setProductioninstruction16(String productioninstruction16) {
        this.productioninstruction16 = productioninstruction16;
    }

    public String getProductioninstruction17() {
        return productioninstruction17;
    }

    public void setProductioninstruction17(String productioninstruction17) {
        this.productioninstruction17 = productioninstruction17;
    }

    public String getProductioninstruction18() {
        return productioninstruction18;
    }

    public void setProductioninstruction18(String productioninstruction18) {
        this.productioninstruction18 = productioninstruction18;
    }

    public String getProductioninstruction19() {
        return productioninstruction19;
    }

    public void setProductioninstruction19(String productioninstruction19) {
        this.productioninstruction19 = productioninstruction19;
    }

    public String getProductioninstruction20() {
        return productioninstruction20;
    }

    public void setProductioninstruction20(String productioninstruction20) {
        this.productioninstruction20 = productioninstruction20;
    }

    public Double getProductqtyperpail1() {
        return productqtyperpail1;
    }

    public void setProductqtyperpail1(Double productqtyperpail1) {
        this.productqtyperpail1 = productqtyperpail1;
    }

    public Double getProductqtyperpail2() {
        return productqtyperpail2;
    }

    public void setProductqtyperpail2(Double productqtyperpail2) {
        this.productqtyperpail2 = productqtyperpail2;
    }

    public Double getProductqtyperpail3() {
        return productqtyperpail3;
    }

    public void setProductqtyperpail3(Double productqtyperpail3) {
        this.productqtyperpail3 = productqtyperpail3;
    }

    public Double getProductqtyperpail4() {
        return productqtyperpail4;
    }

    public void setProductqtyperpail4(Double productqtyperpail4) {
        this.productqtyperpail4 = productqtyperpail4;
    }

    public Double getProductqtyperpail5() {
        return productqtyperpail5;
    }

    public void setProductqtyperpail5(Double productqtyperpail5) {
        this.productqtyperpail5 = productqtyperpail5;
    }

    public Double getProductqtyperpail6() {
        return productqtyperpail6;
    }

    public void setProductqtyperpail6(Double productqtyperpail6) {
        this.productqtyperpail6 = productqtyperpail6;
    }

    public Double getProductqtyperpail7() {
        return productqtyperpail7;
    }

    public void setProductqtyperpail7(Double productqtyperpail7) {
        this.productqtyperpail7 = productqtyperpail7;
    }

    public Double getProductqtyperpail8() {
        return productqtyperpail8;
    }

    public void setProductqtyperpail8(Double productqtyperpail8) {
        this.productqtyperpail8 = productqtyperpail8;
    }

    public Double getProductqtyperpail9() {
        return productqtyperpail9;
    }

    public void setProductqtyperpail9(Double productqtyperpail9) {
        this.productqtyperpail9 = productqtyperpail9;
    }

    public Double getProductqtyperpail10() {
        return productqtyperpail10;
    }

    public void setProductqtyperpail10(Double productqtyperpail10) {
        this.productqtyperpail10 = productqtyperpail10;
    }

    public Double getProductqtyperpail11() {
        return productqtyperpail11;
    }

    public void setProductqtyperpail11(Double productqtyperpail11) {
        this.productqtyperpail11 = productqtyperpail11;
    }

    public Double getProductqtyperpail12() {
        return productqtyperpail12;
    }

    public void setProductqtyperpail12(Double productqtyperpail12) {
        this.productqtyperpail12 = productqtyperpail12;
    }

    public Double getProductqtyperpail13() {
        return productqtyperpail13;
    }

    public void setProductqtyperpail13(Double productqtyperpail13) {
        this.productqtyperpail13 = productqtyperpail13;
    }

    public Double getProductqtyperpail14() {
        return productqtyperpail14;
    }

    public void setProductqtyperpail14(Double productqtyperpail14) {
        this.productqtyperpail14 = productqtyperpail14;
    }

    public Double getProductqtyperpail15() {
        return productqtyperpail15;
    }

    public void setProductqtyperpail15(Double productqtyperpail15) {
        this.productqtyperpail15 = productqtyperpail15;
    }

    public Double getProductqtyperpail16() {
        return productqtyperpail16;
    }

    public void setProductqtyperpail16(Double productqtyperpail16) {
        this.productqtyperpail16 = productqtyperpail16;
    }

    public Double getProductqtyperpail17() {
        return productqtyperpail17;
    }

    public void setProductqtyperpail17(Double productqtyperpail17) {
        this.productqtyperpail17 = productqtyperpail17;
    }

    public Double getProductqtyperpail18() {
        return productqtyperpail18;
    }

    public void setProductqtyperpail18(Double productqtyperpail18) {
        this.productqtyperpail18 = productqtyperpail18;
    }

    public Double getProductqtyperpail19() {
        return productqtyperpail19;
    }

    public void setProductqtyperpail19(Double productqtyperpail19) {
        this.productqtyperpail19 = productqtyperpail19;
    }

    public Double getProductqtyperpail20() {
        return productqtyperpail20;
    }

    public void setProductqtyperpail20(Double productqtyperpail20) {
        this.productqtyperpail20 = productqtyperpail20;
    }

    public Double getProductionqty1() {
        return productionqty1;
    }

    public void setProductionqty1(Double productionqty1) {
        this.productionqty1 = productionqty1;
    }

    public Double getProductionqty2() {
        return productionqty2;
    }

    public void setProductionqty2(Double productionqty2) {
        this.productionqty2 = productionqty2;
    }

    public Double getProductionqty3() {
        return productionqty3;
    }

    public void setProductionqty3(Double productionqty3) {
        this.productionqty3 = productionqty3;
    }

    public Double getProductionqty4() {
        return productionqty4;
    }

    public void setProductionqty4(Double productionqty4) {
        this.productionqty4 = productionqty4;
    }

    public Double getProductionqty5() {
        return productionqty5;
    }

    public void setProductionqty5(Double productionqty5) {
        this.productionqty5 = productionqty5;
    }

    public Double getProductionqty6() {
        return productionqty6;
    }

    public void setProductionqty6(Double productionqty6) {
        this.productionqty6 = productionqty6;
    }

    public Double getProductionqty7() {
        return productionqty7;
    }

    public void setProductionqty7(Double productionqty7) {
        this.productionqty7 = productionqty7;
    }

    public Double getProductionqty8() {
        return productionqty8;
    }

    public void setProductionqty8(Double productionqty8) {
        this.productionqty8 = productionqty8;
    }

    public Double getProductionqty9() {
        return productionqty9;
    }

    public void setProductionqty9(Double productionqty9) {
        this.productionqty9 = productionqty9;
    }

    public Double getProductionqty10() {
        return productionqty10;
    }

    public void setProductionqty10(Double productionqty10) {
        this.productionqty10 = productionqty10;
    }

    public Double getProductionqty11() {
        return productionqty11;
    }

    public void setProductionqty11(Double productionqty11) {
        this.productionqty11 = productionqty11;
    }

    public Double getProductionqty12() {
        return productionqty12;
    }

    public void setProductionqty12(Double productionqty12) {
        this.productionqty12 = productionqty12;
    }

    public Double getProductionqty13() {
        return productionqty13;
    }

    public void setProductionqty13(Double productionqty13) {
        this.productionqty13 = productionqty13;
    }

    public Double getProductionqty14() {
        return productionqty14;
    }

    public void setProductionqty14(Double productionqty14) {
        this.productionqty14 = productionqty14;
    }

    public Double getProductionqty15() {
        return productionqty15;
    }

    public void setProductionqty15(Double productionqty15) {
        this.productionqty15 = productionqty15;
    }

    public Double getProductionqty16() {
        return productionqty16;
    }

    public void setProductionqty16(Double productionqty16) {
        this.productionqty16 = productionqty16;
    }

    public Double getProductionqty17() {
        return productionqty17;
    }

    public void setProductionqty17(Double productionqty17) {
        this.productionqty17 = productionqty17;
    }

    public Double getProductionqty18() {
        return productionqty18;
    }

    public void setProductionqty18(Double productionqty18) {
        this.productionqty18 = productionqty18;
    }

    public Double getProductionqty19() {
        return productionqty19;
    }

    public void setProductionqty19(Double productionqty19) {
        this.productionqty19 = productionqty19;
    }

    public Double getProductionqty20() {
        return productionqty20;
    }

    public void setProductionqty20(Double productionqty20) {
        this.productionqty20 = productionqty20;
    }

    public String getStrtime() {
        return strtime;
    }

    public void setStrtime(String strtime) {
        this.strtime = strtime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Date getStrdate() {
        return strdate;
    }

    public void setStrdate(Date strdate) {
        this.strdate = strdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAddcode1() {
        return addcode1;
    }

    public void setAddcode1(String addcode1) {
        this.addcode1 = addcode1;
    }

    public String getAddcode2() {
        return addcode2;
    }

    public void setAddcode2(String addcode2) {
        this.addcode2 = addcode2;
    }

    public String getAddcode3() {
        return addcode3;
    }

    public void setAddcode3(String addcode3) {
        this.addcode3 = addcode3;
    }

    public String getAddinstr1() {
        return addinstr1;
    }

    public void setAddinstr1(String addinstr1) {
        this.addinstr1 = addinstr1;
    }

    public String getAddinstr2() {
        return addinstr2;
    }

    public void setAddinstr2(String addinstr2) {
        this.addinstr2 = addinstr2;
    }

    public String getAddinstr3() {
        return addinstr3;
    }

    public void setAddinstr3(String addinstr3) {
        this.addinstr3 = addinstr3;
    }

    public Double getAddqty1() {
        return addqty1;
    }

    public void setAddqty1(Double addqty1) {
        this.addqty1 = addqty1;
    }

    public Double getAddqty2() {
        return addqty2;
    }

    public void setAddqty2(Double addqty2) {
        this.addqty2 = addqty2;
    }

    public Double getAddqty3() {
        return addqty3;
    }

    public void setAddqty3(Double addqty3) {
        this.addqty3 = addqty3;
    }

    public Double getAddprodqty1() {
        return addprodqty1;
    }

    public void setAddprodqty1(Double addprodqty1) {
        this.addprodqty1 = addprodqty1;
    }

    public Double getAddprodqty2() {
        return addprodqty2;
    }

    public void setAddprodqty2(Double addprodqty2) {
        this.addprodqty2 = addprodqty2;
    }

    public Double getAddprodqty3() {
        return addprodqty3;
    }

    public void setAddprodqty3(Double addprodqty3) {
        this.addprodqty3 = addprodqty3;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getProductSG() {
        return productSG;
    }

    public void setProductSG(String productSG) {
        this.productSG = productSG;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productionbatch != null ? productionbatch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Production)) {
            return false;
        }
        Production other = (Production) object;
        if ((this.productionbatch == null && other.productionbatch != null) || (this.productionbatch != null && !this.productionbatch.equals(other.productionbatch))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.application.premierpaints.production.data.Production[ productionbatch=" + productionbatch + " ]";
    }

    public String getAddcode4() {
        return addcode4;
    }

    public void setAddcode4(String addcode4) {
        this.addcode4 = addcode4;
    }

    public String getAddcode5() {
        return addcode5;
    }

    public void setAddcode5(String addcode5) {
        this.addcode5 = addcode5;
    }

    public String getAddcode6() {
        return addcode6;
    }

    public void setAddcode6(String addcode6) {
        this.addcode6 = addcode6;
    }

    public String getAddcode7() {
        return addcode7;
    }

    public void setAddcode7(String addcode7) {
        this.addcode7 = addcode7;
    }

    public String getAddcode8() {
        return addcode8;
    }

    public void setAddcode8(String addcode8) {
        this.addcode8 = addcode8;
    }

    public String getAddinstr4() {
        return addinstr4;
    }

    public void setAddinstr4(String addinstr4) {
        this.addinstr4 = addinstr4;
    }

    public String getAddinstr5() {
        return addinstr5;
    }

    public void setAddinstr5(String addinstr5) {
        this.addinstr5 = addinstr5;
    }

    public String getAddinstr6() {
        return addinstr6;
    }

    public void setAddinstr6(String addinstr6) {
        this.addinstr6 = addinstr6;
    }

    public String getAddinstr7() {
        return addinstr7;
    }

    public void setAddinstr7(String addinstr7) {
        this.addinstr7 = addinstr7;
    }

    public String getAddinstr8() {
        return addinstr8;
    }

    public void setAddinstr8(String addinstr8) {
        this.addinstr8 = addinstr8;
    }

    public Double getAddqty4() {
        return addqty4;
    }

    public void setAddqty4(Double addqty4) {
        this.addqty4 = addqty4;
    }

    public Double getAddqty5() {
        return addqty5;
    }

    public void setAddqty5(Double addqty5) {
        this.addqty5 = addqty5;
    }

    public Double getAddqty6() {
        return addqty6;
    }

    public void setAddqty6(Double addqty6) {
        this.addqty6 = addqty6;
    }

    public Double getAddqty7() {
        return addqty7;
    }

    public void setAddqty7(Double addqty7) {
        this.addqty7 = addqty7;
    }

    public Double getAddqty8() {
        return addqty8;
    }

    public void setAddqty8(Double addqty8) {
        this.addqty8 = addqty8;
    }

    public Double getAddprodqty4() {
        return addprodqty4;
    }

    public void setAddprodqty4(Double addprodqty4) {
        this.addprodqty4 = addprodqty4;
    }

    public Double getAddprodqty5() {
        return addprodqty5;
    }

    public void setAddprodqty5(Double addprodqty5) {
        this.addprodqty5 = addprodqty5;
    }

    public Double getAddprodqty6() {
        return addprodqty6;
    }

    public void setAddprodqty6(Double addprodqty6) {
        this.addprodqty6 = addprodqty6;
    }

    public Double getAddprodqty7() {
        return addprodqty7;
    }

    public void setAddprodqty7(Double addprodqty7) {
        this.addprodqty7 = addprodqty7;
    }

    public Double getAddprodqty8() {
        return addprodqty8;
    }

    public void setAddprodqty8(Double addprodqty8) {
        this.addprodqty8 = addprodqty8;
    }
    
}
