/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glluch.utils;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class Filename {
    
    public static String nameWithoutExtension(String fileName){
        String res="";
        String[] parts1=fileName.split("/");
        String doc=fileName;
        doc=parts1[parts1.length-1];
        
        String[] parts=StringUtils.split(doc, ".");
        int i=0;
        while (i<parts.length-1){
            if (i!=0) res+=".";
            res+=parts[i++];
        }
        return res;
    }
}
