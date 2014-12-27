/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.application.premierpaints.rawmaterials.presentation;

import com.application.premierpaints.rawmaterials.data.Rwcode;
import com.application.premierpaints.users.data.Users;
import java.lang.reflect.Field;
import java.util.Comparator;
import org.primefaces.model.SortOrder;

/**
 *
 * @author ollaollu
 */
public class RwcodeSorter implements Comparator<Rwcode> {
 
    private String sortField;
     
    private SortOrder sortOrder;
     
    public RwcodeSorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(Rwcode o1, Rwcode o2) {
        try {
            
            Field field1 = o1.getClass().getDeclaredField(this.sortField);
            Field field2 = o2.getClass().getDeclaredField(this.sortField);
            field1.setAccessible(true);
            field2.setAccessible(true);
            Object value1 = field1.get(o1);
            Object value2 = field2.get(o2);
 
            int value = ((Comparable)value1).compareTo(value2);
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;

        }
        catch(Exception e) {
            throw new RuntimeException();
        }        
    }
}
