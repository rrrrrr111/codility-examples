package ru.roman.certification.classes.statics;

public class LazyStaticExample {

    public static void main(String[] args) {

        //System.out.println(foo().valueOf(2));
        int v = 0;
        System.out.println(((Integer)(++v)).valueOf(2));
        System.out.println(v);
    }

    static Integer foo() {
        System.out.println("foo");
        return Integer.valueOf(1);
    }
}
