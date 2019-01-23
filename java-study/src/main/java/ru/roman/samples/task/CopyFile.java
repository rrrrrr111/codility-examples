/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.samples.task;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;

/**
 * Копирование большого файла
 *
 * @author churganov_r 19.03.2011
 */
public class CopyFile {

    void copy(String src, String dst) throws IOException, FileNotFoundException {
        long now = System.currentTimeMillis();

        FileChannel srcChannel = (new FileInputStream(src)).getChannel();
        FileChannel destChannel = (new FileOutputStream(dst)).getChannel();
        srcChannel.transferTo(0, srcChannel.size(), destChannel);

        System.out.println("Copied for " + (System.currentTimeMillis() - now) + " ms");
    }

    public static void main(String[] args) throws FileNotFoundException {
        try {
            if (args.length != 2) {
                System.out.println("usage:\njava CopyFile <SrcFile> <DestFile>");
            } else {
                new CopyFile().copy(args[0], args[1]);
            }

        } catch (Exception e) {
            e.printStackTrace(new PrintWriter("log"));
        }
    }
}
