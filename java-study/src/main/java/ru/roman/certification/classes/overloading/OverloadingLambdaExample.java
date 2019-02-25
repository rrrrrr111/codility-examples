package ru.roman.certification.classes.overloading;


import java.util.concurrent.Callable;

public abstract class OverloadingLambdaExample {

    public static void main(String[] args) {
        OverloadingLambdaExample o = null;

        o.foo(() -> Integer.valueOf(0));
    }

    abstract void foo(Runnable r);
    abstract void foo(Runnable... r);
    abstract void foo(Callable<?> c);
    abstract void foo(Callable<?>... c);

    abstract void foo(Object... p);

    abstract void foo(Object p);
}