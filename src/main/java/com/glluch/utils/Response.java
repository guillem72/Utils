/*
 * The MIT License
 *
 * Copyright 2016 Guillem LLuch Moll guillem72@gmail.com.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.glluch.utils;

/**
 *
 * @author Guillem LLuch Moll
 */
public class Response {
    protected Object info; //The response body
    protected boolean success; //Indicating if the petition has been well done or not 
    protected String castTo; //To what kind of object has to cast the response
    protected int code; //
    

    public Response(boolean success, Object info) {
        this.info = info;
        this.success = success;
    }

    public Response() {
    }
    
    

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCastTo() {
        return castTo;
    }

    public void setCastTo(String castTo) {
        this.castTo = castTo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Response{" + "info=" + info + ", success=" + success + ", castTo=" + castTo + ", code=" + code + '}';
    }
    
    public String infoToString(){
            return info.toString();
    }
    
    public void showInfo(){
        Out.p(infoToString());
    }
    
    }
