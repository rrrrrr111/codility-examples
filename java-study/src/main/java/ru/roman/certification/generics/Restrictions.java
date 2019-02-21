package ru.roman.certification.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Restrictions<T> {

    // private static T os; // not legal
    private T os; // legal

    public static void main(String[] args) {

        // List<int> p = new ArrayList<>(); // not legal

        List<Integer> list = null;
        //if (list instanceof List<Integer>) {           // not legal - compile-time error
        //}

        //List<String>[] s = {new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>()}; // not legal
        //List<String>[] rrr = new List<String>[0];           // not legal, создать массив с женериком вручную невозможно, исключение - vararg
        //List<String>[] rrrr = {new ArrayList<String>()};    // not legal
        //List<String>[] rrrrrr = {new ArrayList()};          // not legal
        List[] rrrrr = {new ArrayList<String>()};             // но можно с row типом
        List[] ss = {new ArrayList<Integer>(), new LinkedList<String>()};             // OK
        List[] sss = new List[]{new ArrayList<Integer>(), new LinkedList<String>()};  // OK
        List<String>[] rr = new List[0];                      // или так
        List<String>[] ssss = null;

        List<Integer> li = null;
        //List<Number>  ln = (List<Number>) li;                 // compile-time error

        List<String> l1 = null;
        ArrayList<String> l2 = (ArrayList<String>)l1;  // OK

        List<Integer> l3 = null;
        //ArrayList<String> l4 = (ArrayList<String>)l3;  // not legal


    }

    static <E> void append(List<E> list) {
        //E elem = new E();                                    // compile-time error
    }

    static <E> void append(List<E> list, Class<E> cls) throws Exception {
        E elem = cls.getDeclaredConstructor().newInstance();   // OK
    }

    void method() {
        Object[] strings = new String[2];
        strings[0] = "hi";   // OK
        strings[1] = 100;    // legal, but An ArrayStoreException is thrown at runtime
    }

    //class MathException<T> extends Exception { /* ... */ }    // compile-time error

    public static <T extends Exception, J> void execute(List<J> jobs) throws T {  // OK
        //  try {
        //  } catch (T e) {   // compile-time error, Cannot Create, Catch, or Throw Objects of Parameterized Types
        //  }
    }

    public void print(Set<String> strSet) { }
    //public void print(Set<Integer> intSet) { }   // compile-time error,  same signature after type erasure
    public <T> void print(T o) { }
    //public void print(Object o) { }              // compile-time error,  same signature after type erasure
}
