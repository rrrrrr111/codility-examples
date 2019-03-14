package ru.roman.certification.classes.lambda;

/**
 *
 */
@FunctionalInterface
interface MyFunc {

    void foo();

    String toString();   // overrides method in Object
    int hashCode();
}
