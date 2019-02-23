package ru.roman.certification.classes.overloading;


public abstract class OverloadingExample {

    public static void main(String[] args) {
        OverloadingExample o = null;

        //o.foo((short)1);
        //o.foo(Short.valueOf((short) 1));
        o.foo(new Nest2());
    }

    abstract void foo(byte p);
    //abstract void foo(short p);
    //abstract void foo(char p);
    //abstract void foo(int p);
    //abstract void foo(long p);
    //abstract void foo(float p);
    //abstract void foo(double p);

    abstract void foo(Byte p);
    abstract void foo(Short p);
    abstract void foo(Character p);
    abstract void foo(Integer p);
    abstract void foo(Long p);
    abstract void foo(Float p);
    abstract void foo(Double p);

    abstract void foo(Nest0 p);
    abstract void foo(Nest1 p);
    //abstract void foo(Nest2 p);
    abstract void foo(Nest3 p);
    abstract void foo(Nest4 p);

    private static class Nest0 {}
    private static class Nest1 extends Nest0 {}
    private static class Nest2 extends Nest1 {}
    private static class Nest3 extends Nest2 {}
    private static class Nest4 extends Nest3 {}
}
