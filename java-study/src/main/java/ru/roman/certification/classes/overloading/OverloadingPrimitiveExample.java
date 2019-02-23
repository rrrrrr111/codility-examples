package ru.roman.certification.classes.overloading;


public abstract class OverloadingPrimitiveExample {

    public static void main(String[] args) {
        OverloadingPrimitiveExample o = null;

        //o.foo((short)1);
        o.foo(Short.valueOf((short) 1));
        //o.foo(null);
    }

    abstract void foo(byte p);
    abstract void foo(short p);
    abstract void foo(char p);
    abstract void foo(int p);
    abstract void foo(long p);
    abstract void foo(float p);
    abstract void foo(double p);

    abstract void foo(Byte p);
    abstract void foo(Short p);
    abstract void foo(Character p);
    abstract void foo(Integer p);
    abstract void foo(Long p);
    abstract void foo(Float p);
    abstract void foo(Double p);
}
