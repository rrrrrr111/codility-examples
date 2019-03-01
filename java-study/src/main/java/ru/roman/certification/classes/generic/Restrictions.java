package ru.roman.certification.classes.generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Restrictions<T> {

    // private static T os; // illegal
    private T os; // legal

    public static void main(String[] args) {

        // List<int> p = new ArrayList<>(); // illegal

        List<Integer> list = null;
        //if (list instanceof List<Integer>) {           // illegal - compile-time error
        //}

        //List<String>[] s = {new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>()}; // illegal
        //List<String>[] rrr = new List<String>[0];           // illegal, создать массив с женериком вручную невозможно, исключение - vararg
        //List<String>[] rrrr = {new ArrayList<String>()};    // illegal
        //List<String>[] rrrrrr = {new ArrayList()};          // illegal
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
        //ArrayList<String> l4 = (ArrayList<String>)l3;  // illegal

        var r = new ArrayList<Integer>().getClass() == new ArrayList<Double>().getClass();  // true
        System.out.println(r);

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
