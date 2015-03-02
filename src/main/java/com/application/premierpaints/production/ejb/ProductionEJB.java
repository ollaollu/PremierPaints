/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.production.ejb;

import com.application.premierpaints.production.data.Production;
import com.application.premierpaints.util.JsfUtil;
import com.application.premierpaints.production.presentation.ProductionWarehouseRemoval;
import com.application.premierpaints.util.BaseSessionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author ollaollu
 * @date
 * @version 1
 * 
 * EJB for working with our production values
 */
@Stateless
public class ProductionEJB {
    @PersistenceContext(unitName = "premierPaintsPU")
    private EntityManager entityManager;
    private BaseSessionListener bsl;
    boolean persist = true;
    boolean update = true;
    //our bean for our warehouse quantity update is called
    private final ProductionWarehouseRemoval pwr = new ProductionWarehouseRemoval();

    
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    
    public int count() {
        return ((Long) entityManager.createQuery("select count(p) from Production as p").getSingleResult()).intValue();
    }

    
    public List<Production> findRange(int[] range) {
        return null;
    }

    
    public List<Production> findAll() {
        TypedQuery query = entityManager.createNamedQuery("Production.findAll", Production.class);
        return query.getResultList();        
    }
    
    public List<Production> findAll(int startingAt, int maxPerPage, String filterValue) {
        String sql = "SELECT p FROM Production p WHERE p.productname LIKE ?1 or p.client LIKE ?2 or p.status LIKE ?3";    
        Query query = entityManager.createQuery(sql);
        query.setParameter(1, filterValue + "%");
        query.setParameter(2, filterValue + "%");
        query.setParameter(3, filterValue + "%");
        query.setFirstResult(startingAt);
        query.setMaxResults(maxPerPage);
        
        return query.getResultList();
    }    

    
    public Production find(Object id) {
        return entityManager.find(Production.class, id);
    }

    
    public void remove(Production entity) {
        entityManager.remove(entityManager.merge(entity));
    }

    
    public void edit(Production entity) throws SQLException {
            bsl = new BaseSessionListener();
            String name = entity.getProductname();
            int batch = entity.getProductionbatch();
            List<Double> editList = pwr.getOldValueforEdit(batch);
                double oldDB1 = editList.get(0); // perform production used
                double oldDB2 = editList.get(1);
                double oldDB3 = editList.get(2);
                double oldDB4 = editList.get(3);
                double oldDB5 = editList.get(4);
                double oldDB6 = editList.get(5);
                double oldDB7 = editList.get(6);
                double oldDB8 = editList.get(7);
                double oldDB9 = editList.get(8);
                double oldDB10 = editList.get(9);
                double oldDB11 = editList.get(10);
                double oldDB12 = editList.get(11);
                double oldDB13 = editList.get(12);
                double oldDB14 = editList.get(13);
                double oldDB15 = editList.get(14);
                double oldDB16 = editList.get(15);
                double oldDB17 = editList.get(16);
                double oldDB18 = editList.get(17);
                double oldDB21 = editList.get(18);
                double oldDB22 = editList.get(19);
                double oldDB23 = editList.get(20);
                double oldDB24 = editList.get(21);
                double oldDB25 = editList.get(22);
                double oldDB26 = editList.get(23);
                double oldDB27 = editList.get(24);
                double oldDB28 = editList.get(25);
            
            //set date of edit
            Date dateEdited = new Date();
            String editedBy = bsl.remoteUser();
            entity.setEditedby(editedBy);
            entity.setTimeedited(dateEdited);
            
        String inputCode1 = entity.getProductcode1();
        Double newQty1 = entity.getProductionqty1();
            double dbQty1 = pwr.getStockQty(inputCode1);
            int sBatch1 = pwr.getStockId(inputCode1);
            double newDbQty1 = 0;
        String inputCode2 = entity.getProductcode2();
        Double newQty2 = entity.getProductionqty2();
            double dbQty2 = pwr.getStockQty(inputCode2);
            int sBatch2 = pwr.getStockId(inputCode2);
            double newDbQty2 = 0;
        String inputCode3 = entity.getProductcode3();
        Double newQty3 = entity.getProductionqty3();
            double dbQty3 = pwr.getStockQty(inputCode3);
            int sBatch3 = pwr.getStockId(inputCode3);
            double newDbQty3 = 0;
        String inputCode4 = entity.getProductcode4();
        Double newQty4 = entity.getProductionqty4();
            double dbQty4 = pwr.getStockQty(inputCode4);
            int sBatch4 = pwr.getStockId(inputCode4);
            double newDbQty4 = 0;
        String inputCode5 = entity.getProductcode5();
        Double newQty5 = entity.getProductionqty5();
            double dbQty5 = pwr.getStockQty(inputCode5);
            int sBatch5 = pwr.getStockId(inputCode5);
            double newDbQty5 = 0;
        String inputCode6 = entity.getProductcode6();
        Double newQty6 = entity.getProductionqty6();
            double dbQty6 = pwr.getStockQty(inputCode6);
            int sBatch6 = pwr.getStockId(inputCode6);
            double newDbQty6 = 0;
        String inputCode7 = entity.getProductcode7();
        Double newQty7 = entity.getProductionqty7();
            double dbQty7 = pwr.getStockQty(inputCode7);
            int sBatch7 = pwr.getStockId(inputCode7);
            double newDbQty7 = 0;
        String inputCode8 = entity.getProductcode8();
        Double newQty8 = entity.getProductionqty8();
            double dbQty8 = pwr.getStockQty(inputCode8);
            int sBatch8 = pwr.getStockId(inputCode8);
            double newDbQty8 = 0;
        String inputCode9 = entity.getProductcode9();
        Double newQty9 = entity.getProductionqty9();
            double dbQty9 = pwr.getStockQty(inputCode9);
            int sBatch9 = pwr.getStockId(inputCode9);
            double newDbQty9 = 0;
        String inputCode10 = entity.getProductcode10();
        Double newQty10 = entity.getProductionqty10();
            double dbQty10 = pwr.getStockQty(inputCode10);
            int sBatch10 = pwr.getStockId(inputCode10);
            double newDbQty10 = 0;
        String inputCode11 = entity.getProductcode11();
        Double newQty11 = entity.getProductionqty11();
            double dbQty11 = pwr.getStockQty(inputCode11);
            int sBatch11 = pwr.getStockId(inputCode11);
            double newDbQty11 = 0;
        String inputCode12 = entity.getProductcode12();
        Double newQty12 = entity.getProductionqty12();
            double dbQty12 = pwr.getStockQty(inputCode12);
            int sBatch12 = pwr.getStockId(inputCode12);
            double newDbQty12 = 0;
        String inputCode13 = entity.getProductcode13();
        Double newQty13 = entity.getProductionqty13();
            double dbQty13 = pwr.getStockQty(inputCode13);
            int sBatch13 = pwr.getStockId(inputCode13);
            double newDbQty13 = 0;
        String inputCode14 = entity.getProductcode14();
        Double newQty14 = entity.getProductionqty14();
            double dbQty14 = pwr.getStockQty(inputCode14);
            int sBatch14 = pwr.getStockId(inputCode14);
            double newDbQty14 = 0;
        String inputCode15 = entity.getProductcode15();
        Double newQty15 = entity.getProductionqty15();
            double dbQty15 = pwr.getStockQty(inputCode15);
            int sBatch15 = pwr.getStockId(inputCode15);
            double newDbQty15 = 0;
        String inputCode16 = entity.getProductcode16();
        Double newQty16 = entity.getProductionqty16();
            double dbQty16 = pwr.getStockQty(inputCode16);
            int sBatch16 = pwr.getStockId(inputCode16);
            double newDbQty16 = 0;
        String inputCode17 = entity.getProductcode17();
        Double newQty17 = entity.getProductionqty17();
            double dbQty17 = pwr.getStockQty(inputCode17);
            int sBatch17 = pwr.getStockId(inputCode17);
            double newDbQty17 = 0;
        String inputCode18 = entity.getProductcode18();
        Double newQty18 = entity.getProductionqty18();
            double dbQty18 = pwr.getStockQty(inputCode18);
            int sBatch18 = pwr.getStockId(inputCode18);
            double newDbQty18 = 0;            
        String inputCode21 = entity.getAddcode1();
        Double newQty21 = entity.getAddprodqty1();
            double dbQty21 = pwr.getStockQty(inputCode21);
            int sBatch21 = pwr.getStockId(inputCode21);
            double newDbQty21 = 0;
        String inputCode22 = entity.getAddcode2();
        Double newQty22 = entity.getAddprodqty2();
            double dbQty22 = pwr.getStockQty(inputCode22);
            int sBatch22 = pwr.getStockId(inputCode22);
            double newDbQty22 = 0;
        String inputCode23 = entity.getAddcode3();
        Double newQty23 = entity.getAddprodqty3();
            double dbQty23 = pwr.getStockQty(inputCode23);
            int sBatch23 = pwr.getStockId(inputCode23);
            double newDbQty23 = 0;
        String inputCode24 = entity.getAddcode4();
        Double newQty24 = entity.getAddprodqty4();
            double dbQty24 = pwr.getStockQty(inputCode24);
            int sBatch24 = pwr.getStockId(inputCode24);
            double newDbQty24 = 0;
        String inputCode25 = entity.getAddcode5();
        Double newQty25 = entity.getAddprodqty5();
            double dbQty25 = pwr.getStockQty(inputCode25);
            int sBatch25 = pwr.getStockId(inputCode25);
            double newDbQty25 = 0;
        String inputCode26 = entity.getAddcode6();
        Double newQty26 = entity.getAddprodqty6();
            double dbQty26 = pwr.getStockQty(inputCode26);
            int sBatch26 = pwr.getStockId(inputCode26);
            double newDbQty26 = 0;
        String inputCode27 = entity.getAddcode7();
        Double newQty27 = entity.getAddprodqty7();
            double dbQty27 = pwr.getStockQty(inputCode27);
            int sBatch27 = pwr.getStockId(inputCode27);
            double newDbQty27 = 0;
        String inputCode28 = entity.getAddcode8();
        Double newQty28 = entity.getAddprodqty8();
            double dbQty28 = pwr.getStockQty(inputCode28);
            int sBatch28 = pwr.getStockId(inputCode28);
            double newDbQty28 = 0;            
            
            //set quantity 1 in database
        if (newQty1!=null){ 
        		double diff1 = newQty1 - oldDB1;
                if(dbQty1 >= diff1){
                        newDbQty1 = dbQty1 - diff1;
                        entity.setProductionqty1(newQty1);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode1 + " to update " +name+ " production, You have just " +dbQty1+ " left in warehouse");
                        update = false;
                }
        }        
                
            //set quantity 2 in database
        if (newQty2!=null){
                        double diff2 = newQty2 - oldDB2;
                if(dbQty2 >= diff2){
                        newDbQty2 = dbQty2 - diff2;
                        entity.setProductionqty1(newQty2);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode2 + " to update " +name+ " production, You have just " +dbQty2+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set quantity 3 in database
        if (newQty3!=null){ 
                        double diff3 = newQty3 - oldDB3;            
                if(dbQty3 >= diff3){
                        newDbQty3 = dbQty3 - diff3;
                        entity.setProductionqty3(newQty3);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode3 + " to update " +name+ " production, You have just " +dbQty3+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set quantity 4 in database
        if (newQty4!=null){ 
                        double diff4 = newQty4 - oldDB4;
                if(dbQty4 >= diff4){
                        newDbQty4 = dbQty4 - diff4;
                        entity.setProductionqty4(newQty4);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode4 + " to update " +name+ " production, You have just " +dbQty4+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set quantity 5 in database
        if (newQty5!=null){     
                        double diff5 = newQty5 - oldDB5;            
                if(dbQty5 >= diff5){
                        newDbQty5 = dbQty5 - diff5;
                        entity.setProductionqty5(newQty5);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode5 + " to update " +name+ " production, You have just " +dbQty5+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set quantity 6 in database
        if (newQty6!=null){
                        double diff6 = newQty6 - oldDB6;            
                if(dbQty6 >= diff6){
                        newDbQty6 = dbQty6 - diff6;
                        entity.setProductionqty6(newQty6);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode6 + " to update " +name+ " production, You have just " +dbQty6+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set quantity 7 in database
        if (newQty7!=null){  
                        double diff7 = newQty7 - oldDB7;            
                if(dbQty7 >= diff7){
                        newDbQty7 = dbQty7 - diff7;
                        entity.setProductionqty7(newQty7);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode7 + " to update " +name+ " production, You have just " +dbQty7+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set quantity 8 in database
        if (newQty8!=null){       
                        double diff8 = newQty8 - oldDB8;            
                if(dbQty8 >= diff8){
                        newDbQty8 = dbQty8 - diff8;
                        entity.setProductionqty8(newQty8);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode8 + " to update " +name+ " production, You have just " +dbQty8+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set quantity 9 in database
        if (newQty9!=null){  
                        double diff9 = newQty9 - oldDB9;            
                if(dbQty9 >= diff9){
                        newDbQty9 = dbQty9 - diff9;
                        entity.setProductionqty9(newQty9);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode9 + " to update " +name+ " production, You have just " +dbQty9+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set quantity 10 in database
        if (newQty10!=null){          
                        double diff10 = newQty10 - oldDB10;            
                if(dbQty10 >= diff10){
                        newDbQty10 = dbQty10 - diff10;
                        entity.setProductionqty10(newQty10);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode10 + " to update " +name+ " production, You have just " +dbQty10+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set quantity 11 in database
        if (newQty11!=null){                 
                        double diff11 = newQty11 - oldDB11;            
                if(dbQty11 >= diff11){
                        newDbQty11 = dbQty11 - diff11;
                        entity.setProductionqty11(newQty11);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode11 + " to update " +name+ " production, You have just " +dbQty11+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set quantity 12 in database
        if (newQty12!=null){                 
                        double diff12 = newQty12 - oldDB12;            
                if(dbQty12 >= diff12){
                        newDbQty12 = dbQty12 - diff12;
                        entity.setProductionqty12(newQty12);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode12 + " to update " +name+ " production, You have just " +dbQty12+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set quantity 13 in database
        if (newQty13!=null){     
                        double diff13 = newQty13 - oldDB13;            
                if(dbQty13 >= diff13){
                        newDbQty13 = dbQty13 - diff13;
                        entity.setProductionqty1(newQty13);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode13 + " to update " +name+ " production, You have just " +dbQty13+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set quantity 14 in database
        if (newQty14!=null){          
                        double diff14 = newQty14 - oldDB14;            
                if(dbQty14 >= diff14){
                        newDbQty14 = dbQty14 - diff14;
                        entity.setProductionqty14(newQty14);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode14 + " to update " +name+ " production, You have just " +dbQty14+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set quantity 15 in database
        if (newQty15!=null){                 
                        double diff15 = newQty15 - oldDB15;            
                if(dbQty15 >= diff15){
                        newDbQty15 = dbQty15 - diff15;
                        entity.setProductionqty15(newQty15);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode15 + " to update " +name+ " production, You have just " +dbQty15+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set quantity 16 in database
        if (newQty16!=null){                 
                        double diff16 = newQty16 - oldDB16;            
                if(dbQty16 >= diff16){
                        newDbQty16 = dbQty16 - diff16;
                        entity.setProductionqty16(newQty16);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode16 + " to update " +name+ " production, You have just " +dbQty16+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set quantity 17 in database
        if (newQty17!=null){                 
                        double diff17 = newQty17 - oldDB17;            
                if(dbQty17 >= diff17){
                        newDbQty17 = dbQty17 - diff17;
                        entity.setProductionqty17(newQty17);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode17 + " to update " +name+ " production, You have just " +dbQty17+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set quantity 18 in database
        if (newQty18!=null){    
                        double diff18 = newQty18 - oldDB18;            
                if(dbQty18 >= diff18){
                        newDbQty18 = dbQty18 - diff18;
                        entity.setProductionqty18(newQty18);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode18 + " to update " +name+ " production, You have just " +dbQty18+ " left in warehouse");
                        update = false;
                }
        }                
                                
      
            //set additional quantity 21 in database
        if (newQty21!=null){                 
                        double diff21 = newQty21 - oldDB21;            
                if(dbQty21 >= diff21){
                        newDbQty21 = dbQty21 - diff21;
                        entity.setAddprodqty1(newQty21);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode21 + " to update " +name+ " production, You have just " +dbQty21+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set additional quantity 22 in database
        if (newQty22!=null){                
                        double diff22 = newQty22 - oldDB22;            
                if(dbQty22 >= diff22){
                        newDbQty22 = dbQty22 - diff22;
                        entity.setAddprodqty2(newQty22);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode22 + " to update " +name+ " production, You have just " +dbQty22+ " left in warehouse");
                        update = false;
                }
        }                
                
            //set additional quantity 23 in database
        if (newQty23!=null){             
                        double diff23 = newQty23 - oldDB23;            
                if(dbQty23 >= diff23){
                        newDbQty23 = dbQty23 - diff23;
                        entity.setAddprodqty3(newQty23);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode23 + " to update " +name+ " production, You have just " +dbQty23+ " left in warehouse");
                        update = false;
                }  
        }
        
            //set additional quantity 24 in database
        if (newQty24!=null){             
                        double diff24 = newQty24 - oldDB24;            
                if(dbQty24 >= diff24){
                        newDbQty24 = dbQty24 - diff24;
                        entity.setAddprodqty4(newQty24);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode24 + " to update " +name+ " production, You have just " +dbQty24+ " left in warehouse");
                        update = false;
                }  
        }
        
            //set additional quantity 25 in database
        if (newQty25!=null){             
                        double diff25 = newQty25 - oldDB25;            
                if(dbQty25 >= diff25){
                        newDbQty25 = dbQty25 - diff25;
                        entity.setAddprodqty5(newQty25);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode25 + " to update " +name+ " production, You have just " +dbQty25+ " left in warehouse");
                        update = false;
                }  
        }
        
            //set additional quantity 26 in database
        if (newQty26!=null){             
                        double diff26 = newQty26 - oldDB26;            
                if(dbQty26 >= diff26){
                        newDbQty26 = dbQty26 - diff26;
                        entity.setAddprodqty6(newQty26);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode26 + " to update " +name+ " production, You have just " +dbQty26+ " left in warehouse");
                        update = false;
                }  
        }
        
            //set additional quantity 27 in database
        if (newQty27!=null){             
                        double diff27 = newQty27 - oldDB27;            
                if(dbQty27 >= diff27){
                        newDbQty27 = dbQty27 - diff27;
                        entity.setAddprodqty7(newQty27);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode27 + " to update " +name+ " production, You have just " +dbQty27+ " left in warehouse");
                        update = false;
                }  
        }
        
            //set additional quantity 28 in database
        if (newQty28!=null){             
                        double diff28 = newQty28 - oldDB28;            
                if(dbQty28 >= diff28){
                        newDbQty28 = dbQty28 - diff28;
                        entity.setAddprodqty8(newQty28);
                    }else{
                        JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode28 + " to update " +name+ " production, You have just " +dbQty28+ " left in warehouse");
                        update = false;
                }  
        }        
        //Grandtotal for production
        //using actualqty1 field in database as grandtotal field
        Double cost1 = null;
        Double cost2 = null;
        Double cost3 = null;
        Double cost4 = null;
        Double cost5 = null;
        Double cost6 = null;
        Double cost7 = null;
        Double cost8 = null;
        Double cost9 = null;
        Double cost10 = null;
        Double cost11 = null;
        Double cost12 = null;
        Double cost13 = null;
        Double cost14 = null;
        Double cost15 = null;
        Double cost16 = null;
        Double cost17 = null;
        Double cost18 = null;
        Double cost21 = null;
        Double cost22 = null;
        Double cost23 = null;
        Double cost24 = null;
        Double cost25 = null;
        Double cost26 = null;
        Double cost27 = null;
        Double cost28 = null;
            Double codeCost1 = pwr.getInputCodeCost(inputCode1);
            if(codeCost1!=null){
                if(newQty1 == null){
                    newQty1 = 0.0;
                }                
                cost1 = newQty1 * codeCost1;
            }   
            Double codeCost2 = pwr.getInputCodeCost(inputCode2);
            if(codeCost2!=null){
                if(newQty2 == null){
                    newQty2 = 0.0;
                }                
                cost2 = newQty2 * codeCost2;
            } 
            Double codeCost3 = pwr.getInputCodeCost(inputCode3);
            if(codeCost3!=null){
                if(newQty3 == null){
                    newQty3 = 0.0;
                }                
                cost3 = newQty3 * codeCost3;
            }
            Double codeCost4 = pwr.getInputCodeCost(inputCode4);
            if(codeCost4!=null){
                if(newQty4 == null){
                    newQty4 = 0.0;
                }                
                cost4 = newQty4 * codeCost4;
            }
            Double codeCost5 = pwr.getInputCodeCost(inputCode5);
            if(codeCost5!=null){
                if(newQty5 == null){
                    newQty5 = 0.0;
                }                
                cost5 = newQty5 * codeCost5;
            }
            Double codeCost6 = pwr.getInputCodeCost(inputCode6);
            if(codeCost6!=null){
                if(newQty6 == null){
                    newQty6 = 0.0;
                }                
                cost6 = newQty6 * codeCost6;
            }
            Double codeCost7 = pwr.getInputCodeCost(inputCode7);
            if(codeCost7!=null){
                if(newQty7 == null){
                    newQty7 = 0.0;
                }                
                cost7 = newQty7 * codeCost7;
            }
            Double codeCost8 = pwr.getInputCodeCost(inputCode8);
            if(codeCost8!=null){
                if(newQty8 == null){
                    newQty8 = 0.0;
                }                
                cost8 = newQty8 * codeCost8;
            }
            Double codeCost9 = pwr.getInputCodeCost(inputCode9);
            if(codeCost9!=null){
                if(newQty9 == null){
                    newQty9 = 0.0;
                }                
                cost9 = newQty9 * codeCost9;
            }
            Double codeCost10 = pwr.getInputCodeCost(inputCode10);
            if(codeCost10!=null){
                if(newQty10 == null){
                    newQty10 = 0.0;
                }                
                cost10 = newQty10 * codeCost10;
            }
            Double codeCost11 = pwr.getInputCodeCost(inputCode11);
            if(codeCost11!=null){
                if(newQty11 == null){
                    newQty11 = 0.0;
                }                
                cost11 = newQty11 * codeCost11;
            }
            Double codeCost12 = pwr.getInputCodeCost(inputCode12);
            if(codeCost12!=null){
                if(newQty12 == null){
                    newQty12 = 0.0;
                }                
                cost12 = newQty12 * codeCost12;
                //System.out.println("I am 12: codeCost, " + codeCost12 + " newQty " + newQty12 + " cost12 " + cost12 + " inputcode12 " + inputCode12);
            }
            Double codeCost13 = pwr.getInputCodeCost(inputCode13);
            if(codeCost13!=null){
                if(newQty13 == null){
                    newQty13 = 0.0;
                }
                cost13 = newQty13 * codeCost13;
            }
            Double codeCost14 = pwr.getInputCodeCost(inputCode14);
            if(codeCost14!=null){
                if(newQty14 == null){
                    newQty14 = 0.0;
                }                
                cost14 = newQty14 * codeCost14;
            }
            Double codeCost15 = pwr.getInputCodeCost(inputCode15);
            if(codeCost15!=null){
                if(newQty15 == null){
                    newQty15 = 0.0;
                }                
                cost15 = newQty15 * codeCost15;
            }
            Double codeCost16 = pwr.getInputCodeCost(inputCode16);
            if(codeCost16!=null){
                if(newQty16 == null){
                    newQty16 = 0.0;
                }                
                cost16 = newQty16 * codeCost16;
            }
            Double codeCost17 = pwr.getInputCodeCost(inputCode17);
            if(codeCost17!=null){
                if(newQty17 == null){
                    newQty17 = 0.0;
                }                
                cost17 = newQty17 * codeCost17;
            }
            Double codeCost18 = pwr.getInputCodeCost(inputCode18);
            if(codeCost18!=null){
                if(newQty18 == null){
                    newQty18 = 0.0;
                }                
                cost18 = newQty18 * codeCost18;
            }
            Double codeCost21 = pwr.getInputCodeCost(inputCode21);
            if(codeCost21!=null){
                if(newQty21 == null){
                    newQty21 = 0.0;
                }                
                cost21 = newQty21 * codeCost21;
            }
            Double codeCost22 = pwr.getInputCodeCost(inputCode22);
            if(codeCost22!=null){
                if(newQty22 == null){
                    newQty22 = 0.0;
                }                
                cost22 = newQty22 * codeCost22;
            }
            Double codeCost23 = pwr.getInputCodeCost(inputCode23);
            if(codeCost23!=null){
                if(newQty23 == null){
                    newQty23 = 0.0;
                }                
                cost23 = newQty23 * codeCost23;
            }
            Double codeCost24 = pwr.getInputCodeCost(inputCode24);
            if(codeCost24!=null){
                if(newQty24 == null){
                    newQty24 = 0.0;
                }                
                cost24 = newQty24 * codeCost24;
            }
            Double codeCost25 = pwr.getInputCodeCost(inputCode25);
            if(codeCost25!=null){
                if(newQty25 == null){
                    newQty25 = 0.0;
                }                
                cost25 = newQty25 * codeCost25;
            }
            Double codeCost26 = pwr.getInputCodeCost(inputCode26);
            if(codeCost26!=null){
                if(newQty26 == null){
                    newQty26 = 0.0;
                }                
                cost26 = newQty26 * codeCost26;
            }
            Double codeCost27 = pwr.getInputCodeCost(inputCode27);
            if(codeCost27!=null){
                if(newQty27 == null){
                    newQty27 = 0.0;
                }                
                cost27 = newQty27 * codeCost27;
            }
            Double codeCost28 = pwr.getInputCodeCost(inputCode28);
            if(codeCost28!=null){
                if(newQty28 == null){
                    newQty28 = 0.0;
                }                
                cost28 = newQty28 * codeCost28;
            }            
        /**
         * ActualQty1 = overallTotal of raw material cost and packaging cost
         * ActualQty2 = Price of packaging entered from production in dropdown
         * ActualQty3 = RMCC Standard entered in production in input field
         * ActualQty4 = Variance
         * ActualQty5 = RMCC Actual
         * ActualQty6 = grandTotal which is the cost total of all raw materials used
         * ActualQty7 = packageCost which is actual quantity multiplied by price of packaging
         */
        //1    
        Double grandTotal = cost1 + cost2 + cost3 + cost4 + cost5 + cost6 + cost7 + cost8 + cost9 + cost10 + cost11 + cost12 + cost13 + cost14 + cost15 + cost16 + cost17 + cost18 + cost21 + cost22 + cost23 + cost24 + cost25 + cost26 + cost27 + cost28;
        System.out.println("GrandTotal: " + grandTotal);        
        entity.setActualqty6(grandTotal);
          //double grandTotal = cost1 + cost2;
        //2
        Double actualQuantity = entity.getRequiredqty();
        System.out.println("actualQuantity: " + actualQuantity);
        //3
        Double packagePrice = entity.getActualqty2();
        System.out.println("packagePrice: " + packagePrice);
        //4
        Double packageCost = actualQuantity*packagePrice;
        System.out.println("packageCost: " + packageCost);
        entity.setActualqty7(packageCost);
        //5
        Double overallTotal = grandTotal + packageCost;
        System.out.println("overallTotal: " + overallTotal);
        //6
        entity.setActualqty1(overallTotal);
        //7
        //RMCC Actual
        Double rmccActual = overallTotal/actualQuantity;
        Double a = Math.round(rmccActual*100)/100.00d;        
        System.out.println("rmccActual: " + rmccActual);
        System.out.println("rmccActual rounded: " + a);
        //8
        //RMCC STD
        Double rmccStd = entity.getActualqty3();
        System.out.println("rmccstd: " + rmccStd);
        //9
        //VARIANCE
        Double variance = rmccStd - rmccActual;
        Double b = Math.round(variance*100)/100.00d;
        System.out.println("variance: " + variance);
        System.out.println("variance rounded: " + b);
        //10
        entity.setActualqty4(b);
        entity.setActualqty5(a);        
                
                if(update){
                    if(!inputCode1.isEmpty()){    
                        pwr.updateWarehouse(newDbQty1, sBatch1);
                    }
                    if(!inputCode2.isEmpty()){
                        pwr.updateWarehouse(newDbQty2, sBatch2);
                    }
                    if(!inputCode3.isEmpty()){
                        pwr.updateWarehouse(newDbQty3, sBatch3);
                    }
                    if(!inputCode4.isEmpty()){
                        pwr.updateWarehouse(newDbQty4, sBatch4);
                    }
                    if(!inputCode5.isEmpty()){
                        pwr.updateWarehouse(newDbQty5, sBatch5);
                    }
                    if(!inputCode6.isEmpty()){
                        pwr.updateWarehouse(newDbQty6, sBatch6);
                    }
                    if(!inputCode7.isEmpty()){
                        pwr.updateWarehouse(newDbQty7, sBatch7);
                    }
                    if(!inputCode8.isEmpty()){
                        pwr.updateWarehouse(newDbQty8, sBatch8);
                    }
                    if(!inputCode9.isEmpty()){
                        pwr.updateWarehouse(newDbQty9, sBatch9);
                    }
                    if(!inputCode10.isEmpty()){
                        pwr.updateWarehouse(newDbQty10, sBatch10);
                    }
                    if(!inputCode11.isEmpty()){
                        pwr.updateWarehouse(newDbQty11, sBatch11);
                    }
                    if(!inputCode12.isEmpty()){
                        pwr.updateWarehouse(newDbQty12, sBatch12);
                    }
                    if(!inputCode13.isEmpty()){
                        pwr.updateWarehouse(newDbQty13, sBatch13);
                    }
                    if(!inputCode14.isEmpty()){
                        pwr.updateWarehouse(newDbQty14, sBatch14);
                    }
                    if(!inputCode15.isEmpty()){
                        pwr.updateWarehouse(newDbQty15, sBatch15);
                    }
                    if(!inputCode16.isEmpty()){
                        pwr.updateWarehouse(newDbQty16, sBatch16);
                    }
                    if(!inputCode17.isEmpty()){
                        pwr.updateWarehouse(newDbQty17, sBatch17);
                    }
                    if(!inputCode18.isEmpty()){
                        pwr.updateWarehouse(newDbQty18, sBatch18);
                    }
                    if(inputCode21!=null){
                        pwr.updateWarehouse(newDbQty21, sBatch21);
                    }
                    if(inputCode22!=null){
                        pwr.updateWarehouse(newDbQty22, sBatch22);
                    }
                    if(inputCode23!=null){
                        pwr.updateWarehouse(newDbQty23, sBatch23);
                    }
                    if(inputCode24!=null){
                        pwr.updateWarehouse(newDbQty24, sBatch24);
                    } 
                    if(inputCode25!=null){
                        pwr.updateWarehouse(newDbQty25, sBatch25);
                    }
                    if(inputCode26!=null){
                        pwr.updateWarehouse(newDbQty26, sBatch26);
                    }
                    if(inputCode27!=null){
                        pwr.updateWarehouse(newDbQty27, sBatch27);
                    }
                    if(inputCode28!=null){
                        pwr.updateWarehouse(newDbQty28, sBatch28);
                    }                    
                    entityManager.merge(entity);
                    JsfUtil.addSuccessMessage("Production updated successfully");
                }
        
    }

    
    public Production create(Production entity) throws SQLException {
        bsl = new BaseSessionListener();
        String name = entity.getProductname();
        
        //variables for set actions
        String inputCode1 = entity.getProductcode1();
        Double newQty1 = entity.getProductionqty1();
            double dbQty1 = pwr.getStockQty(inputCode1);
            int sBatch1 = pwr.getStockId(inputCode1);
            double newDbQty1 = 0;
        String inputCode2 = entity.getProductcode2();
        Double newQty2 = entity.getProductionqty2();
            double dbQty2 = pwr.getStockQty(inputCode2);
            int sBatch2 = pwr.getStockId(inputCode2);
            double newDbQty2 = 0;
        String inputCode3 = entity.getProductcode3();
        Double newQty3 = entity.getProductionqty3();
            double dbQty3 = pwr.getStockQty(inputCode3);
            int sBatch3 = pwr.getStockId(inputCode3);
            double newDbQty3 = 0;
        String inputCode4 = entity.getProductcode4();
        Double newQty4 = entity.getProductionqty4();
            double dbQty4 = pwr.getStockQty(inputCode4);
            int sBatch4 = pwr.getStockId(inputCode4);
            double newDbQty4 = 0;
        String inputCode5 = entity.getProductcode5();
        Double newQty5 = entity.getProductionqty5();
            double dbQty5 = pwr.getStockQty(inputCode5);
            int sBatch5 = pwr.getStockId(inputCode5);
            double newDbQty5 = 0;
        String inputCode6 = entity.getProductcode6();
        Double newQty6 = entity.getProductionqty6();
            double dbQty6 = pwr.getStockQty(inputCode6);
            int sBatch6 = pwr.getStockId(inputCode6);
            double newDbQty6 = 0;
        String inputCode7 = entity.getProductcode7();
        Double newQty7 = entity.getProductionqty7();
            double dbQty7 = pwr.getStockQty(inputCode7);
            int sBatch7 = pwr.getStockId(inputCode7);
            double newDbQty7 = 0;
        String inputCode8 = entity.getProductcode8();
        Double newQty8 = entity.getProductionqty8();
            double dbQty8 = pwr.getStockQty(inputCode8);
            int sBatch8 = pwr.getStockId(inputCode8);
            double newDbQty8 = 0;
        String inputCode9 = entity.getProductcode9();
        Double newQty9 = entity.getProductionqty9();
            double dbQty9 = pwr.getStockQty(inputCode9);
            int sBatch9 = pwr.getStockId(inputCode9);
            double newDbQty9 = 0;
        String inputCode10 = entity.getProductcode10();
        Double newQty10 = entity.getProductionqty10();
            double dbQty10 = pwr.getStockQty(inputCode10);
            int sBatch10 = pwr.getStockId(inputCode10);
            double newDbQty10 = 0;
        String inputCode11 = entity.getProductcode11();
        Double newQty11 = entity.getProductionqty11();
            double dbQty11 = pwr.getStockQty(inputCode11);
            int sBatch11 = pwr.getStockId(inputCode11);
            double newDbQty11 = 0;
        String inputCode12 = entity.getProductcode12();
        Double newQty12 = entity.getProductionqty12();
            double dbQty12 = pwr.getStockQty(inputCode12);
            int sBatch12 = pwr.getStockId(inputCode12);
            double newDbQty12 = 0;
        String inputCode13 = entity.getProductcode13();
        Double newQty13 = entity.getProductionqty13();
            double dbQty13 = pwr.getStockQty(inputCode13);
            int sBatch13 = pwr.getStockId(inputCode13);
            double newDbQty13 = 0;
        String inputCode14 = entity.getProductcode14();
        Double newQty14 = entity.getProductionqty14();
            double dbQty14 = pwr.getStockQty(inputCode14);
            int sBatch14 = pwr.getStockId(inputCode14);
            double newDbQty14 = 0;
        String inputCode15 = entity.getProductcode15();
        Double newQty15 = entity.getProductionqty15();
            double dbQty15 = pwr.getStockQty(inputCode15);
            int sBatch15 = pwr.getStockId(inputCode15);
            double newDbQty15 = 0;
        String inputCode16 = entity.getProductcode16();
        Double newQty16 = entity.getProductionqty16();
            double dbQty16 = pwr.getStockQty(inputCode16);
            int sBatch16 = pwr.getStockId(inputCode16);
            double newDbQty16 = 0;
        String inputCode17 = entity.getProductcode17();
        Double newQty17 = entity.getProductionqty17();
            double dbQty17 = pwr.getStockQty(inputCode17);
            int sBatch17 = pwr.getStockId(inputCode17);
            double newDbQty17 = 0;
        String inputCode18 = entity.getProductcode18();
        Double newQty18 = entity.getProductionqty18();
            double dbQty18 = pwr.getStockQty(inputCode18);
            int sBatch18 = pwr.getStockId(inputCode18);
            double newDbQty18 = 0;           
        String inputCode21 = entity.getAddcode1();
        Double newQty21 = entity.getAddprodqty1();
            double dbQty21 = pwr.getStockQty(inputCode21);
            int sBatch21 = pwr.getStockId(inputCode21);
            double newDbQty21 = 0;
        String inputCode22 = entity.getAddcode2();
        Double newQty22 = entity.getAddprodqty2();
            double dbQty22 = pwr.getStockQty(inputCode22);
            int sBatch22 = pwr.getStockId(inputCode22);
            double newDbQty22 = 0;
        String inputCode23 = entity.getAddcode3();
        Double newQty23 = entity.getAddprodqty3();
            double dbQty23 = pwr.getStockQty(inputCode23);
            int sBatch23 = pwr.getStockId(inputCode23);
            double newDbQty23 = 0;
        String inputCode24 = entity.getAddcode4();
        Double newQty24 = entity.getAddprodqty4();
            double dbQty24 = pwr.getStockQty(inputCode24);
            int sBatch24 = pwr.getStockId(inputCode24);
            double newDbQty24 = 0;
        String inputCode25 = entity.getAddcode5();
        Double newQty25 = entity.getAddprodqty5();
            double dbQty25 = pwr.getStockQty(inputCode25);
            int sBatch25 = pwr.getStockId(inputCode25);
            double newDbQty25 = 0;
        String inputCode26 = entity.getAddcode6();
        Double newQty26 = entity.getAddprodqty6();
            double dbQty26 = pwr.getStockQty(inputCode26);
            int sBatch26 = pwr.getStockId(inputCode26);
            double newDbQty26 = 0;
        String inputCode27 = entity.getAddcode7();
        Double newQty27 = entity.getAddprodqty7();
            double dbQty27 = pwr.getStockQty(inputCode27);
            int sBatch27 = pwr.getStockId(inputCode27);
            double newDbQty27 = 0;           
        String inputCode28 = entity.getAddcode8();
        Double newQty28 = entity.getAddprodqty8();
            double dbQty28 = pwr.getStockQty(inputCode28);
            int sBatch28 = pwr.getStockId(inputCode28);
            double newDbQty28 = 0;            
        
        //set date of production
        Date dateCreated = new Date();
        String createdBy = bsl.remoteUser();        
        entity.setCreatedby(createdBy);
        entity.setTimecreated(dateCreated);
        
        
        //set quantity 1 in database
        if (newQty1!=null){
                if(dbQty1 >= newQty1){
                    newDbQty1 = dbQty1 - newQty1;
                    entity.setProductionqty1(newQty1);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode1 + " to make " +name+ " production, You have just " +dbQty1+ " left in warehouse");
                    persist = false;
                }           
        }

        //set quantity 2 in database
        if (newQty2!=null){
                if(dbQty2 >= newQty2){
                    newDbQty2 = dbQty2 - newQty2;
                    entity.setProductionqty2(newQty2);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode2 + " to make " +name+ " production, You have just " +dbQty2+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set quantity 3 in database
        if (newQty3!=null){
                if(dbQty3 >= newQty3){
                    newDbQty3 = dbQty3 - newQty3;
                    entity.setProductionqty3(newQty3);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode3 + " to make " +name+ " production, You have just " +dbQty3+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set quantity 4 in database
        if (newQty4!=null){
                if(dbQty4 >= newQty4){
                    newDbQty4 = dbQty4 - newQty4;
                    entity.setProductionqty4(newQty4);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode4 + " to make " +name+ " production, You have just " +dbQty4+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set quantity 5 in database
        if (newQty5!=null){
                if(dbQty5 >= newQty5){
                    newDbQty5 = dbQty5 - newQty5;
                    entity.setProductionqty5(newQty5);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode5 + " to make " +name+ " production, You have just " +dbQty5+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set quantity 6 in database
        if (newQty6!=null){
                if(dbQty6 >= newQty6){
                    newDbQty6 = dbQty6 - newQty6;
                    entity.setProductionqty6(newQty6);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode6 + " to make " +name+ " production, You have just " +dbQty6+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set quantity 7 in database
        if (newQty7!=null){
                if(dbQty7 >= newQty7){
                    newDbQty7 = dbQty7 - newQty7;
                    entity.setProductionqty7(newQty7);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode7 + " to make " +name+ " production, You have just " +dbQty7+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set quantity 8 in database
        if (newQty8!=null){
                if(dbQty8 >= newQty8){
                    newDbQty8 = dbQty8 - newQty8;
                    entity.setProductionqty8(newQty8);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode8 + " to make " +name+ " production, You have just " +dbQty8+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set quantity 9 in database
        if (newQty9!=null){
                if(dbQty9 >= newQty9){
                    newDbQty9 = dbQty9 - newQty9;
                    entity.setProductionqty9(newQty9);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode9 + " to make " +name+ " production, You have just " +dbQty9+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set quantity 10 in database
        if (newQty10!=null){
                if(dbQty10 >= newQty10){
                    newDbQty10 = dbQty10 - newQty10;
                    entity.setProductionqty10(newQty10);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode10 + " to make " +name+ " production, You have just " +dbQty10+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set quantity 11 in database
        if (newQty11!=null){
                if(dbQty11 >= newQty11){
                    newDbQty11 = dbQty11 - newQty11;
                    entity.setProductionqty11(newQty11);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode11 + " to make " +name+ " production, You have just " +dbQty11+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set quantity 12 in database
        if (newQty12!=null){
                if(dbQty12 >= newQty12){
                    newDbQty12 = dbQty12 - newQty12;
                    entity.setProductionqty12(newQty12);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode12 + " to make " +name+ " production, You have just " +dbQty12+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set quantity 13 in database
        if (newQty13!=null){
                if(dbQty13 >= newQty13){
                    newDbQty13 = dbQty13 - newQty13;
                    entity.setProductionqty13(newQty13);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode13 + " to make " +name+ " production, You have just " +dbQty13+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set quantity 14 in database
        if (newQty14!=null){
                if(dbQty14 >= newQty14){
                    newDbQty14 = dbQty14 - newQty14;
                    entity.setProductionqty14(newQty14);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode14 + " to make " +name+ " production, You have just " +dbQty14+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set quantity 15 in database
        if (newQty15!=null){
                if(dbQty15 >= newQty15){
                    newDbQty15 = dbQty15 - newQty15;
                    entity.setProductionqty15(newQty15);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode15 + " to make " +name+ " production, You have just " +dbQty15+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set quantity 16 in database
        if (newQty16!=null){
                if(dbQty16 >= newQty16){
                    newDbQty16 = dbQty16 - newQty16;
                    entity.setProductionqty16(newQty16);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode16 + " to make " +name+ " production, You have just " +dbQty16+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set quantity 17 in database
        if (newQty17!=null){
                if(dbQty17 >= newQty17){
                    newDbQty17 = dbQty17 - newQty17;
                    entity.setProductionqty17(newQty17);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode17 + " to make " +name+ " production, You have just " +dbQty17+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set quantity 18 in database
        if (newQty18!=null){
                if(dbQty18 >= newQty18){
                    newDbQty18 = dbQty18 - newQty18;
                    entity.setProductionqty18(newQty18);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode18 + " to make " +name+ " production, You have just " +dbQty18+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set additional quantity21 in database
        if (newQty21!=null){
                if(dbQty21 >= newQty21){
                    newDbQty21 = dbQty21 - newQty21;
                    entity.setAddprodqty1(newQty21);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode21 + " to make " +name+ " production, You have just " +dbQty21+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set additional quantity22 in database
        if (newQty22!=null){
                if(dbQty22 >= newQty22){
                    newDbQty22 = dbQty22 - newQty22;
                    entity.setAddprodqty2(newQty22);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode22 + " to make " +name+ " production, You have just " +dbQty22+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set additional quantity23 in database
        if (newQty23!=null){
                if(dbQty23 >= newQty23){
                    newDbQty23 = dbQty23 - newQty23;
                    entity.setAddprodqty3(newQty23);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode23 + " to make " +name+ " production, You have just " +dbQty23+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set additional quantity24 in database
        if (newQty24!=null){
                if(dbQty24 >= newQty24){
                    newDbQty24 = dbQty24 - newQty24;
                    entity.setAddprodqty4(newQty24);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode24 + " to make " +name+ " production, You have just " +dbQty24+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set additional quantity25 in database
        if (newQty25!=null){
                if(dbQty25 >= newQty25){
                    newDbQty25 = dbQty25 - newQty25;
                    entity.setAddprodqty5(newQty25);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode25 + " to make " +name+ " production, You have just " +dbQty25+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set additional quantity26 in database
        if (newQty26!=null){
                if(dbQty26 >= newQty26){
                    newDbQty26 = dbQty26 - newQty26;
                    entity.setAddprodqty6(newQty26);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode26 + " to make " +name+ " production, You have just " +dbQty26+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set additional quantity27 in database
        if (newQty27!=null){
                if(dbQty27 >= newQty27){
                    newDbQty27 = dbQty27 - newQty27;
                    entity.setAddprodqty7(newQty27);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode27 + " to make " +name+ " production, You have just " +dbQty27+ " left in warehouse");
                    persist = false;
                }           
        }
        
        //set additional quantity28 in database
        if (newQty28!=null){
                if(dbQty28 >= newQty28){
                    newDbQty28 = dbQty28 - newQty28;
                    entity.setAddprodqty8(newQty28);
                }else{
                    JsfUtil.addErrorMessage("Not Enough quantity of " + inputCode28 + " to make " +name+ " production, You have just " +dbQty28+ " left in warehouse");
                    persist = false;
                }           
        }        
        
        //Grandtotal for production
        //using actualqty1 field in database as grandtotal field
        Double cost1 = null;
        Double cost2 = null;
        Double cost3 = null;
        Double cost4 = null;
        Double cost5 = null;
        Double cost6 = null;
        Double cost7 = null;
        Double cost8 = null;
        Double cost9 = null;
        Double cost10 = null;
        Double cost11 = null;
        Double cost12 = null;
        Double cost13 = null;
        Double cost14 = null;
        Double cost15 = null;
        Double cost16 = null;
        Double cost17 = null;
        Double cost18 = null;
        Double cost21 = null;
        Double cost22 = null;
        Double cost23 = null;
        Double cost24 = null;
        Double cost25 = null;
        Double cost26 = null;
        Double cost27 = null;
        Double cost28 = null;
            Double codeCost1 = pwr.getInputCodeCost(inputCode1);
            if(codeCost1!=null){
                if(newQty1 == null){
                    newQty1 = 0.0;
                }                
                cost1 = newQty1 * codeCost1;
            }   
            Double codeCost2 = pwr.getInputCodeCost(inputCode2);
            if(codeCost2!=null){
                if(newQty2 == null){
                    newQty2 = 0.0;
                }                
                cost2 = newQty2 * codeCost2;
            } 
            Double codeCost3 = pwr.getInputCodeCost(inputCode3);
            if(codeCost3!=null){
                if(newQty3 == null){
                    newQty3 = 0.0;
                }                
                cost3 = newQty3 * codeCost3;
            }
            Double codeCost4 = pwr.getInputCodeCost(inputCode4);
            if(codeCost4!=null){
                if(newQty4 == null){
                    newQty4 = 0.0;
                }                
                cost4 = newQty4 * codeCost4;
            }
            Double codeCost5 = pwr.getInputCodeCost(inputCode5);
            if(codeCost5!=null){
                if(newQty5 == null){
                    newQty5 = 0.0;
                }                
                cost5 = newQty5 * codeCost5;
            }
            Double codeCost6 = pwr.getInputCodeCost(inputCode6);
            if(codeCost6!=null){
                if(newQty6 == null){
                    newQty6 = 0.0;
                }                
                cost6 = newQty6 * codeCost6;
            }
            Double codeCost7 = pwr.getInputCodeCost(inputCode7);
            if(codeCost7!=null){
                if(newQty7 == null){
                    newQty7 = 0.0;
                }                
                cost7 = newQty7 * codeCost7;
            }
            Double codeCost8 = pwr.getInputCodeCost(inputCode8);
            if(codeCost8!=null){
                if(newQty8 == null){
                    newQty8 = 0.0;
                }                
                cost8 = newQty8 * codeCost8;
            }
            Double codeCost9 = pwr.getInputCodeCost(inputCode9);
            if(codeCost9!=null){
                if(newQty9 == null){
                    newQty9 = 0.0;
                }                
                cost9 = newQty9 * codeCost9;
            }
            Double codeCost10 = pwr.getInputCodeCost(inputCode10);
            if(codeCost10!=null){
                if(newQty10 == null){
                    newQty10 = 0.0;
                }                
                cost10 = newQty10 * codeCost10;
            }
            Double codeCost11 = pwr.getInputCodeCost(inputCode11);
            if(codeCost11!=null){
                if(newQty11 == null){
                    newQty11 = 0.0;
                }                
                cost11 = newQty11 * codeCost11;
            }
            Double codeCost12 = pwr.getInputCodeCost(inputCode12);
            if(codeCost12!=null){
                if(newQty12 == null){
                    newQty12 = 0.0;
                }                
                cost12 = newQty12 * codeCost12;
                //System.out.println("I am 12: codeCost, " + codeCost12 + " newQty " + newQty12 + " cost12 " + cost12 + " inputcode12 " + inputCode12);
            }
            Double codeCost13 = pwr.getInputCodeCost(inputCode13);
            if(codeCost13!=null){
                if(newQty13 == null){
                    newQty13 = 0.0;
                }
                cost13 = newQty13 * codeCost13;
            }
            Double codeCost14 = pwr.getInputCodeCost(inputCode14);
            if(codeCost14!=null){
                if(newQty14 == null){
                    newQty14 = 0.0;
                }                
                cost14 = newQty14 * codeCost14;
            }
            Double codeCost15 = pwr.getInputCodeCost(inputCode15);
            if(codeCost15!=null){
                if(newQty15 == null){
                    newQty15 = 0.0;
                }                
                cost15 = newQty15 * codeCost15;
            }
            Double codeCost16 = pwr.getInputCodeCost(inputCode16);
            if(codeCost16!=null){
                if(newQty16 == null){
                    newQty16 = 0.0;
                }                
                cost16 = newQty16 * codeCost16;
            }
            Double codeCost17 = pwr.getInputCodeCost(inputCode17);
            if(codeCost17!=null){
                if(newQty17 == null){
                    newQty17 = 0.0;
                }                
                cost17 = newQty17 * codeCost17;
            }
            Double codeCost18 = pwr.getInputCodeCost(inputCode18);
            if(codeCost18!=null){
                if(newQty18 == null){
                    newQty18 = 0.0;
                }                
                cost18 = newQty18 * codeCost18;
            }
            Double codeCost21 = pwr.getInputCodeCost(inputCode21);
            if(codeCost21!=null){
                if(newQty21 == null){
                    newQty21 = 0.0;
                }                
                cost21 = newQty21 * codeCost21;
            }
            Double codeCost22 = pwr.getInputCodeCost(inputCode22);
            if(codeCost22!=null){
                if(newQty22 == null){
                    newQty22 = 0.0;
                }                
                cost22 = newQty22 * codeCost22;
            }
            Double codeCost23 = pwr.getInputCodeCost(inputCode23);
            if(codeCost23!=null){
                if(newQty23 == null){
                    newQty23 = 0.0;
                }                
                cost23 = newQty23 * codeCost23;
            }
            Double codeCost24 = pwr.getInputCodeCost(inputCode24);
            if(codeCost24!=null){
                if(newQty24 == null){
                    newQty24 = 0.0;
                }                
                cost24 = newQty24 * codeCost24;
            }
            Double codeCost25 = pwr.getInputCodeCost(inputCode25);
            if(codeCost25!=null){
                if(newQty25 == null){
                    newQty25 = 0.0;
                }                
                cost25 = newQty25 * codeCost25;
            }
            Double codeCost26 = pwr.getInputCodeCost(inputCode26);
            if(codeCost26!=null){
                if(newQty26 == null){
                    newQty26 = 0.0;
                }                
                cost26 = newQty26 * codeCost26;
            }
            Double codeCost27 = pwr.getInputCodeCost(inputCode27);
            if(codeCost27!=null){
                if(newQty27 == null){
                    newQty27 = 0.0;
                }                
                cost27 = newQty27 * codeCost27;
            }
            Double codeCost28 = pwr.getInputCodeCost(inputCode28);
            if(codeCost28!=null){
                if(newQty28 == null){
                    newQty28 = 0.0;
                }                
                cost28 = newQty28 * codeCost28;
            }            
        /**
         * ActualQty1 = overallTotal of raw material cost and packaging cost
         * ActualQty2 = Price of packaging entered from production in dropdown
         * ActualQty3 = RMCC Standard entered in production in input field
         * ActualQty4 = Variance
         * ActualQty5 = RMCC Actual
         * ActualQty6 = grandTotal which is the cost total of all raw materials used
         * ActualQty7 = packageCost which is actual quantity multiplied by price of packaging
         */
        //1    
        Double grandTotal = cost1 + cost2 + cost3 + cost4 + cost5 + cost6 + cost7 + cost8 + cost9 + cost10 + cost11 + cost12 + cost13 + cost14 + cost15 + cost16 + cost17 + cost18 + cost21 + cost22 + cost23 + cost24 + cost25 + cost26 + cost27 + cost28;
        System.out.println("GrandTotal: " + grandTotal);        
        entity.setActualqty6(grandTotal);
          //double grandTotal = cost1 + cost2;
        //2
        Double actualQuantity = entity.getRequiredqty();
        System.out.println("actualQuantity: " + actualQuantity);
        //3
        Double packagePrice = entity.getActualqty2();
        System.out.println("packagePrice: " + packagePrice);
        //4
        Double packageCost = actualQuantity*packagePrice;
        System.out.println("packageCost: " + packageCost);
        entity.setActualqty7(packageCost);
        //5
        Double overallTotal = grandTotal + packageCost;
        System.out.println("overallTotal: " + overallTotal);
        //6
        entity.setActualqty1(overallTotal);
        //7
        //RMCC Actual
        Double rmccActual = overallTotal/actualQuantity;
        Double a = Math.round(rmccActual*100)/100.00d;        
        System.out.println("rmccActual: " + rmccActual);
        System.out.println("rmccActual rounded: " + a);
        //8
        //RMCC STD
        Double rmccStd = entity.getActualqty3();
        System.out.println("rmccstd: " + rmccStd);
        //9
        //VARIANCE
        Double variance = rmccStd - rmccActual;
        Double b = Math.round(variance*100)/100.00d;
        System.out.println("variance: " + variance);
        System.out.println("variance rounded: " + b);
        //10
        entity.setActualqty4(b);
        entity.setActualqty5(a);
                
                //data will only be persisted and warehouse updated if all values resolve to true
                if(persist){
                    if(!inputCode1.isEmpty()){
                        pwr.updateWarehouse(newDbQty1, sBatch1);
                        pwr.populateWarehouseIssue(inputCode1, name, newQty1, createdBy, dateCreated, dbQty1, newDbQty1);
                    }                    
                    if(!inputCode2.isEmpty()){
                        pwr.updateWarehouse(newDbQty2, sBatch2);
                        pwr.populateWarehouseIssue(inputCode2, name, newQty2, createdBy, dateCreated, dbQty2, newDbQty2);
                    }
                    if(!inputCode3.isEmpty()){
                        pwr.updateWarehouse(newDbQty3, sBatch3);
                        pwr.populateWarehouseIssue(inputCode3, name, newQty3, createdBy, dateCreated, dbQty3, newDbQty3);
                    }
                    if(!inputCode4.isEmpty()){
                        pwr.updateWarehouse(newDbQty4, sBatch4);
                        pwr.populateWarehouseIssue(inputCode4, name, newQty4, createdBy, dateCreated, dbQty4, newDbQty4);
                    }                   
                    if(!inputCode5.isEmpty()){
                        pwr.updateWarehouse(newDbQty5, sBatch5);
                        pwr.populateWarehouseIssue(inputCode5, name, newQty5, createdBy, dateCreated, dbQty5, newDbQty5);
                    }
                    if(!inputCode6.isEmpty()){
                        pwr.updateWarehouse(newDbQty6, sBatch6);
                        pwr.populateWarehouseIssue(inputCode6, name, newQty6, createdBy, dateCreated, dbQty6, newDbQty6);
                    }
                    if(!inputCode7.isEmpty()){
                        pwr.updateWarehouse(newDbQty7, sBatch7);
                        pwr.populateWarehouseIssue(inputCode7, name, newQty7, createdBy, dateCreated, dbQty7, newDbQty7);
                    }
                    if(!inputCode8.isEmpty()){
                        pwr.updateWarehouse(newDbQty8, sBatch8);
                        pwr.populateWarehouseIssue(inputCode8, name, newQty8, createdBy, dateCreated, dbQty8, newDbQty8);
                    }
                    if(!inputCode9.isEmpty()){
                        pwr.updateWarehouse(newDbQty9, sBatch9);
                        pwr.populateWarehouseIssue(inputCode9, name, newQty9, createdBy, dateCreated, dbQty9, newDbQty9);
                    }
                    if(!inputCode10.isEmpty()){
                        pwr.updateWarehouse(newDbQty10, sBatch10);
                        pwr.populateWarehouseIssue(inputCode10, name, newQty10, createdBy, dateCreated, dbQty10, newDbQty10);
                    }
                    if(!inputCode11.isEmpty()){
                        pwr.updateWarehouse(newDbQty11, sBatch11);
                        pwr.populateWarehouseIssue(inputCode11, name, newQty11, createdBy, dateCreated, dbQty11, newDbQty11);
                    }
                    if(!inputCode12.isEmpty()){
                        pwr.updateWarehouse(newDbQty12, sBatch12);
                        pwr.populateWarehouseIssue(inputCode12, name, newQty12, createdBy, dateCreated, dbQty12, newDbQty12);
                    }
                    if(!inputCode13.isEmpty()){
                        pwr.updateWarehouse(newDbQty13, sBatch13);
                        pwr.populateWarehouseIssue(inputCode13, name, newQty13, createdBy, dateCreated, dbQty13, newDbQty13);
                    }
                    if(!inputCode14.isEmpty()){
                        pwr.updateWarehouse(newDbQty14, sBatch14);
                        pwr.populateWarehouseIssue(inputCode14, name, newQty14, createdBy, dateCreated, dbQty14, newDbQty14);
                    }
                    if(!inputCode15.isEmpty()){
                        pwr.updateWarehouse(newDbQty15, sBatch15);
                        pwr.populateWarehouseIssue(inputCode15, name, newQty15, createdBy, dateCreated, dbQty15, newDbQty15);
                    }
                    if(!inputCode16.isEmpty()){
                        pwr.updateWarehouse(newDbQty16, sBatch16);
                        pwr.populateWarehouseIssue(inputCode16, name, newQty16, createdBy, dateCreated, dbQty16, newDbQty16);
                    }
                    if(!inputCode17.isEmpty()){
                        pwr.updateWarehouse(newDbQty17, sBatch17);
                        pwr.populateWarehouseIssue(inputCode17, name, newQty17, createdBy, dateCreated, dbQty17, newDbQty17);
                    }
                    if(!inputCode18.isEmpty()){
                        pwr.updateWarehouse(newDbQty18, sBatch18);
                        pwr.populateWarehouseIssue(inputCode18, name, newQty18, createdBy, dateCreated, dbQty18, newDbQty18);
                    }
                    if(inputCode21!=null){
                        pwr.updateWarehouse(newDbQty21, sBatch21);
                        pwr.populateWarehouseIssue(inputCode21, name, newQty21, createdBy, dateCreated, dbQty21, newDbQty21);
                    }
                    if(inputCode22!=null){
                        pwr.updateWarehouse(newDbQty22, sBatch22);
                        pwr.populateWarehouseIssue(inputCode22, name, newQty22, createdBy, dateCreated, dbQty22, newDbQty22);
                    }
                    if(inputCode23!=null){
                        pwr.updateWarehouse(newDbQty23, sBatch23);
                        pwr.populateWarehouseIssue(inputCode23, name, newQty23, createdBy, dateCreated, dbQty23, newDbQty23);
                    }
                    if(inputCode24!=null){
                        pwr.updateWarehouse(newDbQty24, sBatch24);
                        pwr.populateWarehouseIssue(inputCode24, name, newQty24, createdBy, dateCreated, dbQty24, newDbQty24);
                    }
                    if(inputCode25!=null){
                        pwr.updateWarehouse(newDbQty25, sBatch25);
                        pwr.populateWarehouseIssue(inputCode25, name, newQty25, createdBy, dateCreated, dbQty25, newDbQty25);
                    }
                    if(inputCode26!=null){
                        pwr.updateWarehouse(newDbQty26, sBatch26);
                        pwr.populateWarehouseIssue(inputCode26, name, newQty26, createdBy, dateCreated, dbQty26, newDbQty26);
                    }
                    if(inputCode27!=null){
                        pwr.updateWarehouse(newDbQty27, sBatch27);
                        pwr.populateWarehouseIssue(inputCode27, name, newQty27, createdBy, dateCreated, dbQty27, newDbQty27);
                    }
                    if(inputCode28!=null){
                        pwr.updateWarehouse(newDbQty28, sBatch28);
                        pwr.populateWarehouseIssue(inputCode28, name, newQty28, createdBy, dateCreated, dbQty28, newDbQty28);
                    }                    
                    entityManager.persist(entity);
                    JsfUtil.addSuccessMessage("Production created successfully");
                }

        Production newProduction = null;
        persist = true;
        return newProduction;
    }
    
    
}
