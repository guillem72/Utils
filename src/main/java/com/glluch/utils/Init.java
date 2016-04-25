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
public class Init {
    public static Double[] zeros(int capacity){
        Double [] nums=new Double[capacity];
        int i=0;
        while (i<capacity){
            nums[i++]=0.0;
        }
        return nums;
        
    }
    
    public static int[] intZeros(int capacity){
        int [] nums=new int[capacity];
        int i=0;
        while (i<capacity){
            nums[i++]=0;
        }
        return nums;
    }
    
    public static HashMap<Integer, Double> row(int capacity){
        HashMap<Integer, Double> hm=new HashMap<>();
        int i=0;
        while (i<capacity){
            hm.put(i++,0.0);
        }
        return hm;
    }
}
