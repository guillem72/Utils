/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glluch.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class Main {
    // /root/sincron/programacio/java/netbeans/moocsSolr/resources/courses/en/Aerodynamics | edX.html.json 10

    public static void main(String[] args) throws IOException   {
    //name();
    testcsvwrite();
    //testTable();
    
     }

    private static void name() {
            String fileName="/root/sincron/programacio/java/netbeans/moocsSolr/resources/courses/en/Aerodynamics | edX.html.json";
    String txt=Filename.nameWithoutExtension(fileName);
    Out.p(txt);
    }

    private static void testcsvwrite() throws IOException {
           CsvWriter cw=new CsvWriter();
        ArrayList<String> h=new ArrayList <>();
        h.add("A1");
        h.add("A2");
        cw.writeHeader(h);
        ArrayList<Double> n=new ArrayList<>();
        n.add(.4);
        n.add(1.0);
        cw.writeRow(n);
        n=new ArrayList<>();
         n.add(.46);
        n.add(0.0);
        cw.writeRow(n);
    }

    private static void testTable() throws IOException {
        CsvWriter cw=new CsvWriter();
        Table table=new Table();
       ArrayList<String> h=new ArrayList <>();
        h.add("A1");
        h.add("A2");
        table.setHeaders(h);
        HashMap<String, Double> row=new HashMap<>();
        row.put("A1",0.6);
        row.put("A2",0.98);
        table.addRow("r1", row);
        row=new HashMap<>();
         row.put("A1",-0.7);
        row.put("A2",0.08);
        table.addRow("r2", row);
        
        HashMap<String, Double> col=new HashMap<>();
        col.put("r1", -0.01);
        col.put("r2",1.1);
        table.addCol("A3",col);
        cw.writeTableWithNames(table);
    }
    
}
