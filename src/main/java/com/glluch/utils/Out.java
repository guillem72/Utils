package com.glluch.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class Out {
    public static String sep=" ---> ";
    
    public static String stringlist(List <String> terms){
        String res="";
        int i=0;
        for (String t:terms){
            i++;
            if (i==1) res+=System.lineSeparator();
            res+=t+System.lineSeparator();
        }
         System.out.println(res);
        return res;
    }
    
    public static String stringstringmap(Map <String,String> map){
        String res="";
        
        int i=0;
        Set keys=map.keySet();
        for (Object t0:keys){
            String t=(String) t0;
            i++;
            if (i!=1) res+=System.lineSeparator();
            res+=t+sep+map.get(t)+System.lineSeparator();
        }
        System.out.println(res);
        return res;
    }
    
    public static String smsd(Map <String, HashMap <String,Double>> map){
         String res="";
        
        int i=0;
        Set keys=map.keySet();
          for (Object t0:keys){
            String t=(String) t0;
            i++;
              if (i!=1) res+=System.lineSeparator();
           res+=System.lineSeparator()+t+System.lineSeparator();
           res+="------------------------------------"+System.lineSeparator();
               res+=   stringdoublemap(map.get(t));
          }
           System.out.println(res);
        return res;
    }
    
    public static String stringdoublemap(Map <String,Double> map){
        String res="";
        
        int i=0;
        Set keys=map.keySet();
        for (Object t0:keys){
            String t=(String) t0;
            i++;
            if (i!=1) res+=System.lineSeparator();
            res+=t+sep+map.get(t);
        }
        System.out.println(res);
        return res;
    }
    
    public static void p(Object o){
        System.out.println(o.toString());
    }
    
    public static void typeOf(Object o){
        p(Obj.typeOf(o));
    }
}
