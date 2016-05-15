/*
 * The MIT License
 *
 * Copyright 2016 Guillem LLuch Moll guillem72@gmail.com.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.glluch.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class CsvWriter {

    private String fileName = "resources/ml/matrix.csv";
    private ArrayList<String> headers;
    //private HashMap<String,Integer> positions;
    private int numFields;
    private File target;

    public void writeTableWithNames(Table table) throws IOException{
        Set heads=table.getHeaders().keySet();
        ArrayList<String> h=new ArrayList<>();
        h.add("RowName");
        h.addAll(heads);
        writeHeader(h);
        Set rowsNames=table.getRowIds().keySet();
        for (Object row0:rowsNames){
            String rowName=(String) row0;
            HashMap<Integer, Double> row = table.getRow(rowName);
            h=new ArrayList<>();
            h.add(rowName);
            h.addAll(JMap.valuesD2string(row.values()));
            writeRowFromStrings(h);
        }
         
        
    }
    
    public void writeRowFromStrings(Collection<String> vals) throws IOException{
        String row = StringUtils.join(vals, ",") + System.lineSeparator();
        FileUtils.write(target, row, true);
    
    }
    
    
    public void writeHeader(ArrayList<String> h) throws IOException {
        target = new File(fileName);
      
        headers = h;
          numFields = headers.size();
        String row = StringUtils.join(h, ",") + System.lineSeparator();
        //Out.p(row);
        FileUtils.write(target, row, false);
    }

    public void writeRow(Collection<Double> nums) throws IOException {
        String row = StringUtils.join(nums, ",") + System.lineSeparator();
        FileUtils.write(target, row, true);

    }

    //a row header -> value
    public void writeRow(HashMap<String, Double> nums) throws IOException {
        Double[] values = Init.zeros(numFields);
        Set keys = nums.keySet();
        for (Object key0 : keys) {
            String key = (String) key0;
            if (headers.contains(key)) {
                int pos=headers.indexOf(key);
                values[pos]=nums.get(key);
            }
            else {
                Out.p("Unexpected Header: "+key);
            }
        }
        String row = StringUtils.join(nums, ",") + System.lineSeparator();
        FileUtils.write(target, row, true);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    
}
