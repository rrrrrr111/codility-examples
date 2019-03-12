/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.jcl.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author Роман 21.01.2008 JDK 1.5
 */
class FileCopy {


    void copyFile(File srcF, File destF) throws IOException {
        FileChannel srcC = new FileInputStream(srcF).getChannel();
        FileChannel destC = new FileOutputStream(destF).getChannel();
        srcC.transferTo(0, srcC.size(), destC);
    }


    public static void main(String[] args) throws IOException {

        File f1 = new File("1f.txt");
        File f2 = new File("2f.txt");

        new FileCopy().copyFile(f1, f2);
    }
}
