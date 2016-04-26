package com.glluch.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * For the cols name, title is used and for the rows names, id.
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class Table {

    private HashMap<String, Integer> headers = new HashMap<>();
    private HashMap<String, Integer> rowId=new HashMap<> ();
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

    public void addRow(String id,HashMap<String, Double> hm){
   addRow(id);
   addVals(hm);
    }
    
    public void addRow(String id) {
        matrix.put(++lastRow, Init.row(numCols));
        rowId.put(id,lastRow);
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
            int pos = headers.get(title);
            HashMap<Integer, Double> row = matrix.get(lastRow);
            well=(Objects.equals(row.put(pos, val), val));
            matrix.put(lastRow, row);
        }
        
        return well;
    }
    
    public boolean addCol(String title){
        if (headers.containsKey(title)) return false;
        HashMap <String, Double> values=new HashMap <> ();
       return addCol(title,values);
        
    }
    
    public boolean addCol(String title, HashMap <String, Double> values){
         if (headers.containsKey(title)) return false;
         boolean res=true;
       headers.put(title, headers.size());
       Set ids=matrix.keySet();
       for (Object id0:ids){
           String id=(String) id0;
           if (values.containsKey(id)){
               res=addVal(id,title,values.get(id));
           }
           else {
               res=addVal(id,title,0.0);
           }
       }
        return res;
    }
    
    public boolean addVal(String id,String title, Double val) {
        boolean well = false;
        if (headers.containsKey(title) && rowId.containsKey(id)) {
            well = true;
            int pos = headers.get(title);
            int row_pos=rowId.get(id);                   
            HashMap<Integer, Double> row = matrix.get(row_pos);
            row.put(pos, val);
            matrix.put(row_pos, row);
        }
        
        return well;
    }

    public HashMap<Integer, Double> getRow(String id){
        if (rowId.containsKey(id)){
        int row_pos=rowId.get(id);
        return matrix.get(row_pos);
        }
        else return null;
    }

    public HashMap<String, Integer> getHeaders() {
        return headers;
    }

    public HashMap<String, Integer> getRowId() {
        return rowId;
    }

    public HashMap<Integer, HashMap<Integer, Double>> getMatrix() {
        return matrix;
    }
    
  
  
}
