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

interface X { <T>   T execute(T a); }
interface Y { <S,T> S execute(S a); }
interface Z { <S>   S execute(S a); }
//interface Exec extends X, Y {}          // illegal: different signatures, same erasure
@FunctionalInterface
interface Exec extends X, Z {}
@FunctionalInterface
interface Exec1 extends X, Z {}


interface I    { Object m(Class c); }
interface J<S> { S m(Class<?> c); }
interface K<T> { T m(Class<?> c); }
@FunctionalInterface
interface Functional<S, T> extends I, J<S>, K<T> {}
@FunctionalInterface
interface Funcy extends Functional<Integer, String>{} // illegal methods with unrelated types



interface G1 {    <E extends Exception> Object m() throws E;         }
interface G2 {    <F extends Exception> String m() throws Exception; }
@FunctionalInterface
interface G extends G1, G2 {}
