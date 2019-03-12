package ru.roman.certification.classes.hiding;

/**
 *
 */
class HidingExample {}

class Foo {
           int n = 1;
    static int s = 2;
}
class SubFoo extends Foo {
           double n = 3.;
    static double s = 4.;

    void printBoth() {

        System.out.println(super.n);             // 1
        System.out.println(super.s);             // 2
        System.out.println(((Foo)this).n);       // 1
        System.out.println(((Foo)this).s);       // 2
        System.out.println(Foo.s);               // 2

    }
    public static void main(String[] args) {
        SubFoo sample = new SubFoo();
        sample.printBoth();

        System.out.println(((Foo)sample).n);     // 1
        System.out.println(((Foo)sample).s);     // 2
        System.out.println(Foo.s);               // 2
    }
}
