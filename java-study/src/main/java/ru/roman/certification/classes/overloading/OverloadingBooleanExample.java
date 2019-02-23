package ru.roman.certification.classes.overloading;


public abstract class OverloadingBooleanExample {

    public static void main(String[] args) {
        OverloadingBooleanExample o = null;

        //o.foo(true);
        o.foo(Boolean.valueOf(false));

    }

    abstract void foo(boolean p);
    abstract void foo(boolean... p);
    abstract void foo(Boolean p);
    abstract void foo(Object p);
    abstract void foo(Boolean... p);
    abstract void foo(Object... p);
}