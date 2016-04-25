/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glluch.utils;

/**
 *
 * @author Guillem LLuch Moll guillem72@gmail.com
 */
public class Obj {
 public static String typeOf(Object obj) {
     Class cls = obj.getClass();
     return cls.getName();
}   
 
 public static String showTypeOf(Object obj){
     Out.p(typeOf(obj));
     return typeOf(obj);
 }
}
