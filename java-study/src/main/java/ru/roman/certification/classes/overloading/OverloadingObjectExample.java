package ru.roman.certification.classes.overloading;


public abstract class OverloadingObjectExample {

    public static void main(String[] args) {
        OverloadingObjectExample o = null;

        Intf4 v = null;
        o.foo(v);
    }

    abstract void foo(Nest0 p);
    abstract void foo(Nest1 p);
    abstract void foo(Nest2 p);
    abstract void foo(Nest3 p);
    abstract void foo(Nest4 p);

    abstract void foo(Intf0 p);
    abstract void foo(Intf1 p);
    abstract void foo(Intf2 p);
    abstract void foo(Intf3 p);
    abstract void foo(Intf4 p);

    private static class Nest0 {}
    private static class Nest1 extends Nest0 {}
    private static class Nest2 extends Nest1 {}
    private static class Nest3 extends Nest2 implements Intf4 {}
    private static class Nest4 extends Nest3 {}

    private interface Intf0 {}
    private interface Intf1 extends Intf0 {}
    private interface Intf2 extends Intf1 {}
    private interface Intf3 extends Intf2 {}
    private interface Intf4 extends Intf3 {}
}
