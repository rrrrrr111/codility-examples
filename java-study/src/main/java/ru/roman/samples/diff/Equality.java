/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.samples.diff;

/**
 * @author дтоь 12.01.2008
 */
public class Equality {

    static Object u;
    static Integer t;

    public static void main(String[] args) {

        int y = 0;

        Integer i = null;
        Object o = null;
        String f = null;

        System.out.println(u);
        System.out.println(t);
        System.out.println(i);
        System.out.println(o);

        System.out.println("133" == "133" + " > " + (new String("133") == new String("133")));
        System.out.println(o = 133);

        System.out.println(y++ + ++y);
    }
}
