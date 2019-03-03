package ru.roman.certification.classes.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class NonReifiableTypes {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        addToList(list1, "Seven", "Eight", "Nine");
        addToList(list2, "Ten", "Eleven", "Twelve");
        List<List<String>> lists = new ArrayList<>();

        addToList(lists, list1, list2);
        faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));
    }


    @SafeVarargs
    static <T> void addToList(List<T> list, T... elements) {
        list.addAll(Arrays.asList(elements));
    }

    @SafeVarargs // предотвращает варниг (Possible heap pollution from parameterized vararg type T), появилось в 1.7
    //@SuppressWarnings({"unchecked", "varargs"})    // аналогичная аннотация
    static void faultyMethod(List<String>... l) {    // vararg создает массив типа женерик
        List<String>[] r = l;                        // Valid

        l[0].get(0).intern();                        // аргумент Generic типа сохраняется в массиве, методы String доступны

        Object[] arr = l;                            // Valid
        arr[0] = new ArrayList<Date>();              // Valid, in theory An ArrayStoreException should be thrown, but the runtime can't detect it
        arr[0] = Arrays.asList(42);                  // Valid, same
        String s = l[0].get(0);                      // ClassCastException thrown here

        List<Integer>[] arrl = null;
        foo(arrl);
    }

    static void foo(List<Integer>... arr) {

        //arr[0].add(new Object());                 // illegal
    }
}
