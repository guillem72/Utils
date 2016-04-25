/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glluch.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class Table {

    private HashMap<String, Integer> headers = new HashMap<>();
    private HashMap<Integer, HashMap<Integer, Double>> matrix = new HashMap<>();
    private int lastRow = -1;
    private int numCols;

    public void setHeaders(ArrayList<String> hs) {
        int i = 0;
        numCols = hs.size();
        for (String h : hs) {
            headers.put(h, i++);
        }
    }

    public void addRow(HashMap<String, Double> hm){
   addRow();
   addVals(hm);
    }
    
    public void addRow() {
        matrix.put(++lastRow, Init.row(numCols));
    }

    public void addVals(HashMap<String, Double> hm) {
        Set keys = hm.keySet();
        
        HashMap<Integer, Double> row = matrix.get(lastRow);
        for (Object key0 : keys) {
            String title=(String) key0;
            if (headers.containsKey(title)) {
                int pos = headers.get(title);
                Double val=hm.get(title);
                row.put(pos, val);
            }
        }//for
        matrix.put(lastRow, row);
    }

    public boolean addVal(String title, Double val) {
        boolean well = false;
        if (headers.containsKey(title)) {
            well = true;
            int pos = headers.get(title);
            HashMap<Integer, Double> row = matrix.get(lastRow);
            Double previous = row.put(pos, val);
            matrix.put(lastRow, row);
        }
        
        return well;
    }
}
