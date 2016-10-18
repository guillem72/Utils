package com.glluch.utils;

import java.util.ArrayList;
import java.util.Collection;
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
    
    
    public static String p(List<String[]> terms){
    String res="";
        int i=0;
        for (String[] t:terms){
            i++;
            if (i==1) res+=System.lineSeparator();
            for(int j=0; j<t.length;j++){
                res+=" "+t[j];
            }
            res+=System.lineSeparator();
        }
         System.out.println(res);
        return res;
    }
    
    public static String msas(Map<String, ArrayList<String>> map){
        String res="";
         Set keys=map.keySet();
          int i=0;
        for (Object t0:keys){
            String t=(String) t0;
            i++;
            if (i!=1) res+=System.lineSeparator();
            res+=t+sep+stringlist(map.get(t))+System.lineSeparator();
        }
        System.out.println(res);
        return res;
    }
    
    public static String stringlist(Collection <String> terms){
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
        if (o!=null)
        System.out.println(o.toString());
        else System.out.println("null");
    }
    
    public static void p(){
        System.out.println();
    }
    
    public static void typeOf(Object o){
        p(Obj.typeOf(o));
    }
    
    
}
