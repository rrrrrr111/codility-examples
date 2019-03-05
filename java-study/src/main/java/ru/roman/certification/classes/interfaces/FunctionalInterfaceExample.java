package ru.roman.certification.classes.interfaces;

/**
 *
 */
public class FunctionalInterfaceExample {
}

@FunctionalInterface
interface Foop<T, N> {
    void m(T arg);
    //void m(N arg);                     // illegal, метод после Type Erasure будет такойже
}

//@FunctionalInterface                   // illegal т к два метода
interface Foo<T, N extends Number> {     // интерфейс может объявлять методы потенциально сводящиеся к одному
    void m(T arg);
    void m(N arg);                       // методы после Type Erasure разные, этот Number, первый Object
}

//@FunctionalInterface                   // illegal всё еще два метода
interface Bar extends Foo<String, Integer> {}
@FunctionalInterface                     // логически один метод
interface Baz extends Foo<Integer, Integer> {}   // и в наследниках нужно будет имплементить один общий метод

class Foozz<T, N extends Number> {
    void m(T arg){}
    void m(N arg){}

    public static void main(String[] args) {
        //new Foozz<Integer, Integer>().m(1);  // illegal ambiguous method m(..)
    }
}