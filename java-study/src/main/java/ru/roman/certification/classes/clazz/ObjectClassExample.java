package ru.roman.certification.classes.clazz;

import java.lang.reflect.Array;
import java.lang.Long;

/**
 *
 */
public class ObjectClassExample {

    public static void main(String[] args) throws Exception {

        System.out.println(String.class);
        System.out.println(Class.forName("java.lang.Long"));
        System.out.println(Integer.valueOf(1).getClass());
        System.out.println();

        //System.out.println(Class.forName("Long"));                      // ClassNotFoundException
        System.out.println(Integer.TYPE);
        System.out.println(int.class);
        System.out.println(void.class);
        System.out.println(Class.class == Class.class.getClass());
        System.out.println(Class.class == Class.class.getClass().getClass());
        //System.out.println(Integer.class == Integer.class.getClass());       // illegal
        System.out.println();

        var v1 = new Integer[]{1} instanceof Number[];                        // true - Контроль типов c учетом наследования
        var v2 = new Integer[]{1}.getClass() == new Integer[]{}.getClass();   // false - будет проверено четко совпадают ли классы
        var v3 = Number[].class.isInstance(Array.newInstance(Integer.class, 0));    // true - аналог instanceof
        var v = Number[].class.isAssignableFrom(Integer[].class);               // true - обратно instanceof


        System.out.println(v);
    }
}
