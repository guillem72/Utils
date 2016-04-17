/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glluch.utils;

import java.util.HashMap;

/**
 *
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class Test {
     public static void main(String[] args){
        //TJMap();
     }

    private static void TJMap() {
        HashMap <String, Double> hm1=new HashMap<> ();
        HashMap <String, Double> hm2=new HashMap<> ();
        hm1.put("a",1.0);
        hm1.put("b",3.0);
        hm1.put("c",8.1);
        hm2.put("d", 4.1);
        hm2.put("b",0.6);
        System.out.println(JMap.intersectAndSum(hm1, hm2).toString());
       
    }
    
}
