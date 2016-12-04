/*
 * The MIT License
 *
 * Copyright 2016 Guillem LLuch Moll <guillem72@gmail.com>.
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

import java.util.Comparator;
import java.util.StringTokenizer;

/**
 *
 * @author Guillem LLuch Moll
 */
public class StringsThings implements Comparator<String> {

    /**
     * Compares its two arguments for order based on the number or words. The
     * number of words are the result of split by spaces. Returns a negative
     * integer, zero, or a positive integer as the first argument is less than,
     * equal to, or greater than the second.
     *
     * @param s1 the first String to be compared.
     * @param s2 the second String to be compared.
     * @return a negative integer, zero, or a positive integer as the first has
     * less words than, equal to, or greater than the second.
     */
    @Override
    public int compare(String s1, String s2) {

        StringTokenizer st = new StringTokenizer(s1);
        int i1 = st.countTokens();
        st = new StringTokenizer(s2);
        int i2 = st.countTokens();
        int res = i1 - i2;
        //Out.p(s1+", "+s2+" => "+res);
        return res;

    }

}
