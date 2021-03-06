package ru.roman.certification.arrays;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;

/**
 * 1. В java можно создать массив не указывая его размер, если он многомерный
 * <p>
 * 2. Ссылаясь на первый уровнь массива нам возвращается элемент первого
 * уровня тоесть внутренний массив
 * <p>
 * 3.  Collection.toArray и Arrays.asList - методы мосты между массивами и
 * коллекциями, Arrays.asList можно использовать для создания листа в стиле
 * объявления массива
 * <p>
 * 4. При объявлении массива можно поствить запятую после последнего элемента
 * и это не  будет ошибкой
 * <p>
 * 5. При распечатывании листа элементы печатаются в квадратных скобках,
 * через запятую.
 * <p>
 * 6. У массивов метод toString() не реализован
 *
 * @author churganov_r 22.03.2011
 */
class Array {

    public static void main(String... args) {

        int[] arr1 = {
                700, 800, 900, 1000        // shortcut syntax to create and initialize an array
                ,                          // лишняя запятая допустима
        };
        int s = arr1.length;               // 4

        int[][] it = new int[3][];         // второй уровень запоняется null
        it[2] = new int[0];
        int[] kt = it[2];

        //int[][] it1 = new int[3, 1];    // illegal
        //it[0, 0] = 0;                   // illegal
        int[][] it2 = new int[1][];
        int[] it3[] = new int[1][];

        int[][][][][][][][][][][] ary6 = new int[1][][][][][][][][][][];
        int ary7[][] = new int[][]{
                {1, 1, 1, 4},
                {2,},
                {1, 2, 3},
        };
        int ary8[][][][][] = new int[][][][][]{{{{{0}}}}};


        Arrays.copyOfRange(arr1, 0, 1);  // аналог arraycopy, создает и возвр массив, half open range
        Arrays.binarySearch(arr1, 0);        // бинарный поиск, массив должен быть отстрирован
        Arrays.equals(it2, it3);                  // массивы equals если содерж одинак элементы и имеют одинак длинну
        Arrays.deepEquals(it2, it3);              // аналог под multidimensional array
        Arrays.fill(arr1, 0);                 // перетирание всех элемнетов
        Arrays.sort(arr1);                        // Quicksort O(n log(n))
        Arrays.parallelSort(arr1);                // parallel sort-merge with FJPCP
        Arrays.asList(1, 2, 3);                   // bridge method for List
        Arrays.toString(arr1);                    // массивы исторически не имплементят свой метод toString()
        Arrays.deepToString(it3);                 // аналог под multidimensional array
        Arrays.compare(arr1, arr1);               // lexicographic comparison - типа сравнения строк
        Arrays.compareUnsigned(arr1, arr1);
        Arrays.hashCode(arr1);                    // считает hashCode для всего массива по элементам
        Arrays.deepHashCode(it2);                 // аналог под multidimensional array
        Arrays.stream(arr1);                      //
        Arrays.copyOf(arr1, 1);         // копирование с обрезанием/добавлением
        Arrays.mismatch(arr1, arr1);              // поиск индекса с которого начинаются различия
        Arrays.parallelPrefix(arr1, Math::max);   // функция бежит по элементам начиная со второго,
        // выполняется с текущим и предыдущ элементом, и заменет значение в массиве
        Arrays.parallelSetAll(arr1, IntUnaryOperator.identity());  // функция пробегает и заменяет,
        // IntUnaryOperator.identity() - заглушка позвращ свойже параметер
        Arrays.setAll(arr1, IntUnaryOperator.identity());  // в один поток, без FJPCP


        Arrays.asList(new Object[]{new Object()});  // излишнее создание массива на vararg методе

        var a = new Object[]{new Object(), new Object()};
        //System.out.println({new Object(),new Object()});        // illegal
        //System.out.println({1,2,3});                            // illegal
        int[] i = {1, 2, 3};
        Object[] i2 = {new Object(), new Object(), new Object()};
        //var i2 = {new Object(), new Object(), new Object()};      // illegal
        String[] i3 = {new String()};
        Object[] i4 = i3;
        //i4[0] = 1;                                 // ArrayStoreException


        //Integer[] t1 = new int[0];   // illegal
        //Object[] t1 = new int[0];   // illegal
        Object t1 = new int[0];
        Cloneable t11 = new int[0];   // также можно Serializable
        //Cloneable[] t12 = new int[0];   // illegal
        Number[] t2 = new Integer[0];
        Object[] t3 = new Integer[0];
        Serializable[] t33 = new Integer[0];  // можно и Serializable[]
        Cloneable t34 = new Integer[0];  // но Cloneable[] нельзя, врапперы не Cloneable
        Object t4 = new Integer[0];
        //int[] t = new byte[0];         // illegal

        List<Integer>[] t5 = null;
        //List<Number>[] t6 = t5;   // illegal
        List<? extends Number>[] t6 = t5;   // ok, массивы женерика ведут себя аналогично женерику

        //int v = foo(new long[0][0])[0][0];    // ArrayIndexOutOfBoundsException

        int[] arr = null;
        //arr[0] = 10l;                // illegal, аналогично перемеенным
//        arr[1] = 'a';               //  NullPointerException
        int k = 1;
        int b = -++k;
        b = +--k;
        //b = +++k;                    // illegal
        //b = ---k;
        b = -+-+-+k++;
        b = -+(-k--);

        System.out.println(k);

        char c = 1;
        c++;
        //+c;           // illegal

        boolean r1 = new int[]{1} == new int[]{1};                         // false
        boolean r2 = new int[]{1}.equals(new int[]{1});                    // false
        boolean r3 = new int[]{1}.hashCode() == new int[]{1}.hashCode();   // false

        byte r = 0xff - 0xc0;
        System.out.println("" + 0xff  +" " + 0xc0 +" "+ r);
    }

    static int foo (long va[][])[][] {
        return new int[0][0];
    }
}
