/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.samples.diff;

import java.awt.event.ComponentEvent;
import java.io.File;

/**
 * @author дтоь 12.01.2008
 */
public class Rtti implements InterfaceFoo {

    public void foo() {
        if (java.awt.event.ComponentEvent.class == ComponentEvent.class) { // ро

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
            }
        }
    }

    void bar() {

        System.out.println("ссылки внутри класса");
        System.out.println(Rtti.this);
        System.out.println(Rtti.class);
        System.out.println(Rtti.super.toString());

        System.out.println(this);
        System.out.println(super.toString());

    }

    public static void main(String[] args) throws Exception {

        System.out.println("получение класса при помощи литерала объекта");
        System.out.println(Integer.class);
        System.out.println(Integer.TYPE);
        System.out.println(int.class);

        System.out.println("получение класса при помощи метода forName() класса Class");
        System.out.println(int.class.forName("org.apache.derby.jdbc.ClientDriver"));
        System.out.println(Integer.class.forName("org.apache.derby.jdbc.ClientDriver").getClass());

        System.out.println(Class.forName("org.apache.derby.jdbc.ClientDriver"));
        System.out.println(Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance());

        System.out.println("получение класса при помощи литерала объекта");
        System.out.println(org.apache.commons.lang3.ArrayUtils.class);
        System.out.println(org.apache.commons.lang3.ArrayUtils.class.getClass());
        System.out.println(org.apache.commons.lang3.ArrayUtils.class.newInstance());

        System.out.println("получение класса из объекта методом getClass()");
        System.out.println(org.apache.commons.lang3.ArrayUtils.class.newInstance().getClass());

        new Rtti().bar();
    }
}
