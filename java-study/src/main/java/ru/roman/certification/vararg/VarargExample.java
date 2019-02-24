package ru.roman.certification.vararg;

import java.util.Arrays;

/**
 *
 */
public class VarargExample {

    public static void main(String[] args) {

        foo(null);
        foo("1");
        foo(new String[0]);
        foo(new String[]{null});


        System.gc();
    }

    static void foo(Object... args) {
        System.out.println(args ==  null ? args : Arrays.toString(args));
    }

    static void foo(String... args) {
        System.out.println(args ==  null ? args : Arrays.toString(args));
    }
}
