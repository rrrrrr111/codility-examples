package ru.roman.certification.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * 1. В java можно создать массив не указывая его размер, если он многомерный
 *
 * 2. Ссылаясь на первый уровнь массива нам возвращается элемент первого
 * уровня тоесть внутренний массив
 *
 * 3.  Collection.toArray и Arrays.asList - методы мосты между массивами и
 * коллекциями, Arrays.asList можно использовать для создания листа в стиле
 * объявления массива
 *
 * 4. При объявлении массива можно поствить запятую после последнего элемента
 * и это не  будет ошибкой
 *
 * 5. При распечатывании листа элементы печатаются в квадратных скобках,
 * через запятую.
 *
 * 6. У массивов метод toString() не реализован
 *
 * @author churganov_r 22.03.2011
 */
class Array {

    public static void main(String... args) {

        int[][] it = new int[3][]; // legal
        it[0] = new int[4];
        it[1] = new int[6];
        it[2] = new int[0];
        int[] kt = it[2];

        //int[][] it1 = new int[3, 1];  // not legal
        int[][] it2 = new int[3][1];  // legal

        List<Object> l = Arrays.asList(new Object[]{new Object(), new Object()
                , // лишняя запятая допустима
        });
        System.out.println(l);
        System.out.println(new Object[]{new Object(), new Object()});
        //System.out.println({new Object(),new Object()});        // не компилится
        //System.out.println({1,2,3});// не компилится
        int[] i = {1, 2, 3};                            // компилится
        Object[] i2 = {new Object(), new Object(), new Object()};         // компилится

        //foo({new Object(), new Object(), new Object()});                // не компилится
    }


    static void foo(Object[] obj) {
        System.out.println(obj);
    }
}
