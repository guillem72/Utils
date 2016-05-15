package com.glluch.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/**
 * A class for a matrix similar to a frame in R. All the values must be Double<br/>
 * For the cols name, title is used and for the rows names, id.
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class Table {

    private HashMap<String, Integer> headers = new HashMap<>();
    private HashMap<String, Integer> rowIds=new HashMap<> ();
    private HashMap<Integer, HashMap<Integer, Double>> matrix = new HashMap<>();
    private int lastRow = -1;
    private int numCols;

    /**
     * Establish the row as a header. It is necessary because the columms are refered by name.
     * @param hs the list of the headers. It is possible to ad more columns later.
     */
    public void setHeaders(ArrayList<String> hs) {
        int i = 0;
        numCols = hs.size();
        for (String h : hs) {
            headers.put(h, i++);
        }
    }

    /**
     * For ad a row to the matrix. It is necessary to provide the identify the row by a name.
     * @param id The name of the row.
     * @param hm the relation of column_name -&lt; value.
     * @return false if some column title is missing
     */
    public boolean addRow(String id,HashMap<String, Double> hm){
   addRow(id);
   return addVals(hm);
    }
    
    /**
     * Add an empty row to the matrix.
     * @param id The name of the row.
     */
    public void addRow(String id) {
        matrix.put(++lastRow, Init.row(numCols));
        rowIds.put(id,lastRow);
    }

    /**
     * Put values in the current row. It similar to addRow but addVals doesn't create a new row.
     * @param hm the values, the string is the name of the column and the double
     *  its value.
     * @return false if some column title is missing.
     */
    public boolean addVals(HashMap<String, Double> hm) {
        Set keys = hm.keySet();
        boolean res=true;
        HashMap<Integer, Double> row = matrix.get(lastRow);
        for (Object key0 : keys) {
            String title=(String) key0;
            if (headers.containsKey(title)) {
                int pos = headers.get(title);
                Double val=hm.get(title);
                row.put(pos, val);
            }
            else {
                res=false;
                //Out.p(title+" not found in matrix");
                addCol(title);
                int pos = headers.get(title);
                Double val=hm.get(title);
                row.put(pos, val);
            }
        }//for
        matrix.put(lastRow, row);
        return res;
    }

    /**
     * Add a double in the current row in the position set for the string title.
     * @param title the name of the column where the value has to be placed.
     * @param val the value to set.
     * @return true if the value has placed or if it have replaced a previos value. 
     * Note that if the value is the same as the previous one, it will return false.
     */
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
    
    /**
     * Add a new col in the table.
     * @param title The name of the new column.
     * @return true if the new column has been created, false otherwise.
     */
    public boolean addCol(String title){
        if (headers.containsKey(title)) return false;
        HashMap <String, Double> values=new HashMap <> ();
       return addCol(title,values);
        
    }
    
    /**
     * Add a new col in the table.
     * @param title The name of the new column.
     * @param values A hashmap where the key are the id (which identifies the row) where
     * the value has to be placed. If the HashMap contains keys not present in the table,
     * it ignores them. The id present in the table but not found in as keys in the hashmap,
     * will produce a 0.
     * @return true if the new column has been created, false otherwise.
     */
    public boolean addCol(String title, HashMap <String, Double> values){
         if (headers.containsKey(title)) return false;
         boolean res=true;
       headers.put(title, headers.size());
       Set ids=rowIds.keySet();
       for (Object id0:ids){
           //Out.p(id0);
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
    
    /**
     * Add or update a new value in a given position.
     * @param id the name of the row
     * @param title the name of the column
     * @param val the value to update or put.
     * @return true if the value has put in the correct place, false otherwise.
     */
    public boolean addVal(String id,String title, Double val) {
        boolean well = false;
        if (headers.containsKey(title) && rowIds.containsKey(id)) {
            well = true;
            int pos = headers.get(title);
            int row_pos=rowIds.get(id);                   
            HashMap<Integer, Double> row = matrix.get(row_pos);
            row.put(pos, val);
            matrix.put(row_pos, row);
        }
        
        return well;
    }

    public HashMap<Integer, Double> getRow(String id){
        if (rowIds.containsKey(id)){
        int row_pos=rowIds.get(id);
        return matrix.get(row_pos);
        }
        else return null;
    }

    public HashMap<String, Integer> getHeaders() {
        return headers;
    }
    
    public Set <String> getHeadersString(){
        return headers.keySet();
    }

    public HashMap<String, Integer> getRowIds() {
        return rowIds;
    }

    public HashMap<Integer, HashMap<Integer, Double>> getMatrix() {
        return matrix;
    }
    
   
  
  
}
