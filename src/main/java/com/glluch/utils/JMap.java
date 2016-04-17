/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glluch.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class JMap {
    public static HashMap <String, Double> intersectAndSum(HashMap <String,Double> hm1,HashMap  <String, Double> hm2){
        HashMap <String, Double> hm=new HashMap<>();
        Set keys=hm1.keySet();
        for (Object key0:keys){
            String key=(String) key0;
            if (hm2.containsKey(key)){
                Double value=hm1.get(key)+hm2.get(key);
                hm2.remove(key);
                hm.put(key, value);
            }
            else
            {
                hm.put(key,hm1.get(key));
            }
        }//for
        
        hm.putAll(hm2);
      
        
        
        return hm;
    }
    
    public static ArrayList<String> keys2array(HashMap <String, Integer> map){
        ArrayList<String> strings=new ArrayList<>();
        Set keys=map.keySet();
        for(Object key0:keys){
            String key=(String) key0;
            strings.add(key);
            
        }
        //res.addAll(keys);
        return strings;
    }
    
    public static HashMap<String,Double> si2sd(HashMap<String,Integer> map ){
    HashMap<String,Double> res=new HashMap<>();
     ArrayList<String> strings=new ArrayList<>();
        Set keys=map.keySet();
        for(Object key0:keys){
            String key=(String) key0;
           res.put(key, NumberUtils.createDouble(map.get(key).toString()));
            
        }
        //res.addAll(keys);
        
    return res;
    }
}
