/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.jcl.io;

import java.io.File;

/**
 * @author העמ
 */
class MyFile {

    public static void main(String[] args) {

        try {

            File f = new File("C:\\4_NetBeans\\TestsProjects\\some");

            System.out.println(f.getAbsoluteFile());
            System.out.println(f.getAbsolutePath());
            System.out.println(f.getCanonicalFile());
            System.out.println(f.getCanonicalPath());
            System.out.println(f.getParent());
            System.out.println(f.getParentFile());
            System.out.println(f.isAbsolute());
            System.out.println(f.isDirectory());
            System.out.println(f.isFile());
            System.out.println(f.isHidden());
            System.out.println(f.toURI());
            System.out.println(f.toURL());


        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
