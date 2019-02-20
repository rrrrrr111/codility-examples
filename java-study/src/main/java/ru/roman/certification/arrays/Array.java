package ru.roman.certification.arrays;

import java.util.Arrays;
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

        //int[][] it1 = new int[3, 1];    // not legal
        //it[0, 0] = 0;                   // not legal
        int[][] it2 = new int[1][];
        int[] it3[] = new int[1][];
        int[][] it4 = new int[1][];       // кривое форматирование
        int[] it5[] = new int[1][];       // кривое форматирование

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
        i4[0] = 1;
    }
}
