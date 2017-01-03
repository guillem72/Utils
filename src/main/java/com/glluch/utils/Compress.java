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
import com.glluch.utils.Out;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Guillem LLuch Moll
 */
public class Compress {    
    
    /**From http://stackoverflow.com/questions/23318383/compress-directory-into-a-zipfile-with-commons-io
     * @param sourceDir
     * @param outputFile
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
    */
    public static void compressZipfile(String sourceDir, String outputFile) throws IOException, FileNotFoundException {
    ZipOutputStream zipFile = new ZipOutputStream(new FileOutputStream(outputFile));
    compressDirectoryToZipfile(sourceDir, sourceDir, zipFile);
    IOUtils.closeQuietly(zipFile);
}

private static void compressDirectoryToZipfile(String rootDir, String sourceDir, ZipOutputStream out) throws IOException, FileNotFoundException {
    for (File file : new File(sourceDir).listFiles()) {
        if (file.isDirectory()) {
            compressDirectoryToZipfile(rootDir, sourceDir + file.getName() + File.separator, out);
        } else {
            ZipEntry entry = new ZipEntry(sourceDir.replace(rootDir, "") + file.getName());
            out.putNextEntry(entry);

            FileInputStream in = new FileInputStream(sourceDir + file.getName());
            IOUtils.copy(in, out);
            IOUtils.closeQuietly(in);
        }
    }
}
    
    
    
    
    
    
    
    
    
    protected transient boolean verbose = true;

    public boolean isVerbose() {
        return verbose;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    protected transient boolean debug=true;

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }




 /**
     * Sent a message to the console depens on the parametre verbose. If it is
     * true (on), the text is shown.
     *
     * @param text The text to be shown
     */

  protected void show(String text) {
        if (this.verbose) {
            Out.p(text);
        }
    }
    

  /**
     * Sent a message to the console depens on the parametre debug. If it is
     * true (on), the text is shown.
     *
     * @param text The text to be shown
     */
    protected void debug(String text){
        if (this.debug){
        Out.p(text);
        }
    }

}
