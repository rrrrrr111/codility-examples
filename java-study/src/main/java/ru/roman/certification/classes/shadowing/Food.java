package ru.roman.certification.classes.shadowing;

class Food {

    static void toFoo(int i) {}
    static void toFoo(long i ) {}
    static void toFoo(double i ) {}
    static void toFoo(Object i ) {}
    static void toFoo(Object... i ) {}
}
