package ru.roman.certification.classes.superref;

/**
 *
 */
class SuperExample extends Bob {

    void faru() {
        //foo(super);              // illegal
        foo(this);
    }
    static void foo(SuperExample e) {}
}
class Bob {}

