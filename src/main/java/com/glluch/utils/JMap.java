/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glluch.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class JMap {

    public static HashMap<String, Double> intersectAndSum(HashMap<String, Double> hm1, HashMap<String, Double> hm2) {
        HashMap<String, Double> hm = new HashMap<>();
        Set keys = hm1.keySet();
        for (Object key0 : keys) {
            String key = (String) key0;
            if (hm2.containsKey(key)) {
                Double value = hm1.get(key) + hm2.get(key);
                hm2.remove(key);
                hm.put(key, value);
            } else {
                hm.put(key, hm1.get(key));
            }
        }//for

        hm.putAll(hm2);

        return hm;
    }

    public static ArrayList<String> valuesD2string(Collection<Double> ds) {
        ArrayList<String> res = new ArrayList<>();
        for (Double d : ds) {
            res.add(d.toString());
        }
        return res;
    }

    public static ArrayList<String> keys2array(HashMap<String, Integer> map) {
        ArrayList<String> strings = new ArrayList<>();
        Set keys = map.keySet();
        for (Object key0 : keys) {
            String key = (String) key0;
            strings.add(key);

        }
        //res.addAll(keys);
        return strings;
    }

    public static HashMap<String, Double> si2sd(HashMap<String, Integer> map) {
        HashMap<String, Double> res = new HashMap<>();
        ArrayList<String> strings = new ArrayList<>();
        Set keys = map.keySet();
        for (Object key0 : keys) {
            String key = (String) key0;
            res.put(key, NumberUtils.createDouble(map.get(key).toString()));

        }
        //res.addAll(keys);

        return res;
    }

    public static HashMap<String, String> is2ss(HashMap<Integer, String> mis) {
        HashMap<String, String> mss = new HashMap<String, String>();
        Set<Integer> keys = mis.keySet();
        for (Object key0 : keys) {
            int key = (Integer) key0;
            mss.put(String.valueOf(key), mis.get(key));
        }

        return mss;
    }

    protected static String fieldsSeparator = "@";

    public static HashMap<String, String> readFile(String filename) throws IOException {
        HashMap<String, String> map = new HashMap<>();

        List<String> lines = FileUtils.readLines(new File(filename));
        for (String line : lines) {
            String[] parts = StringUtils.split(line, fieldsSeparator);
            if (parts.length == 2) {
                map.put(parts[0], parts[1]);
            }
        }
        return map;
    }
}
