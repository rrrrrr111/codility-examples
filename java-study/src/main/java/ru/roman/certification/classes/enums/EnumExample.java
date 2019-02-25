package ru.roman.certification.classes.enums;

enum EnumExample {

    CONST1(1),
    CONST2(2) {
        int v = 0;
        public void muOwnMethod(){}

        class Fff {}
    },
    ;

    public static final int CONST = 3;

    public int v;
    {}
    static {}
    EnumExample(int i) {
        v = i;
    }

    //abstract void аff();   // нужно всем имплементить

    class Fff {}
    static class Fff1 {}
}

enum EnumExample1 {
    EEEE,
}


class Test {

    public static void main(String[] args) {

        EnumExample.CONST2.v = 32;
        System.out.println(EnumExample.CONST2.v);

        var b = EnumExample.CONST == 3;

        //new EnumExample(1);
        EnumExample.CONST2.new Fff();

        System.out.println(EnumExample.CONST1.getClass());
        System.out.println(EnumExample.CONST2.getClass());
        //EnumExample.CONST2.m;
    }
}