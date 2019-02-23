package ru.roman.certification.classes.overloading;


import java.util.Arrays;

public abstract class OverloadingNullExample {

    public static void main(String[] args) {
        OverloadingNullExample o = null;

        o.foo(null);
    }

    abstract void foo(double p);

    //abstract void foo(byte... p);
    //abstract void foo(double... p);
    //abstract void foo(Byte... p);
    //abstract void foo(Double... p);
    //abstract void foo(Byte p);
    //abstract void foo(Double p);


    //abstract void foo(Number... p);
    //abstract void foo(Number p);

    abstract void foo(Object... p);

    abstract void foo(Object p);

}