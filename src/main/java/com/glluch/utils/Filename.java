/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glluch.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;


/**
 *
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class Filename {
    
    protected static char[] forbiden="\"?[]()`'\\\"+-®\"".toCharArray();
    
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
    
    /**
     * Transform a file name removing undesired chars.
     * @param fileName
     * @return the name of the file without the bad characters
     */
    public static String name2uglyName(String fileName){
    String res=fileName;
    for (char c:forbiden){
    res=StringUtils.remove(res, c);
    }
    return res;
    }
    
    /**
     * Given a file name with o without its path, return the name without extension.
     * @param fileName The file name. It could include its path.
     * @return the "title" of the file
     */
    public static String OnlyName(String fileName){
        String res="";
        String[] res0=fileName.trim().split("/");
        String res1=res0[res0.length-1];
        //Out.p("res1="+res1);
        String[] res2=res1.split("\\.");
        //Out.p("res2 length="+res2.length);
        int i=0;
        while (i<res2.length-1){
            res+=res2[i++];
        }
        return res;
    }
    
    /**
     * Given a collection of file names with path and extesions, return a collection 
     * with only the name, without extension nor the path.
     * @param filenames The collection of filename
     * @return A collection of filenames without either extension nor path 
     */
    public static Collection<String> onlyNames(Collection <File> filenames){
        ArrayList <String> onlyn=new ArrayList<>();
        Iterator<File> fns=filenames.iterator();
        while (fns.hasNext())
        {
            String filename=fns.next().getName();
            onlyn.add(FilenameUtils.getBaseName(filename));
        }
        return onlyn;
    
    }
}
