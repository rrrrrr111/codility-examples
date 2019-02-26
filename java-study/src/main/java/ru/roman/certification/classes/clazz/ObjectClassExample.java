package ru.roman.certification.classes.clazz;

/**
 *
 */
public class ObjectClassExample {

    public static void main(String[] args) throws ClassNotFoundException {

        System.out.println(String.class);
        System.out.println(int.class);
        System.out.println(Class.forName("java.lang.Long"));
        System.out.println(Integer.valueOf(1).getClass());

    }
}
