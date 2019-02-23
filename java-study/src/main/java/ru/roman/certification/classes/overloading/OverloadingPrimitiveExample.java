package ru.roman.certification.classes.overloading;


import java.util.Arrays;

public abstract class OverloadingPrimitiveExample {

    public static void main(String[] args) {
        OverloadingPrimitiveExample o = null;

        //o.foo((byte) 1);
        o.foo(Byte.valueOf((byte) 1));
    }

    //abstract void foo(byte p);
//    abstract void foo(short p);
//    abstract void foo(char p);
//    abstract void foo(int p);
//    abstract void foo(long p);
//    abstract void foo(float p);
//    abstract void foo(double p);

    //abstract void foo(byte... p);
//    abstract void foo(short... p);
//    abstract void foo(char... p);
//    abstract void foo(int... p);
//    abstract void foo(long... p);
//    abstract void foo(float... p);
//    abstract void foo(double... p);

    //abstract void foo(Byte p);
    abstract void foo(Short p);
    abstract void foo(Character p);
    abstract void foo(Integer p);
    abstract void foo(Long p);
    abstract void foo(Float p);
    abstract void foo(Double p);

    //abstract void foo(Number p);
    //abstract void foo(Object p);

    //abstract void foo(Byte... p);
    abstract void foo(Short... p);
    abstract void foo(Character... p);
    abstract void foo(Integer... p);
    abstract void foo(Long... p);
    abstract void foo(Float... p);
    abstract void foo(Double... p);

    //abstract void foo(Number... p);
    abstract void foo(Object... p);

    static void foor(byte... bb) {
        System.out.println(Arrays.toString(bb));
        System.out.println(bb.getClass().getSimpleName());
    }
}