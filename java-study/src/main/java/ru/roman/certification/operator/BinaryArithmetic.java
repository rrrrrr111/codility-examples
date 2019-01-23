/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.operator;

/**
 * 1. · вычисление остатка от деления целых чисел "%" (возвращает остаток от
 * деления первого числа на второе, причем результат будет иметь тот же знак,
 * что и делимое)
 * - В Java эта операция может использоваться и для вещественных переменных
 * (типа float или double). При этом возвращаетс остаток с соответствующей
 * дробью
 *
 * 2. при делении маленького числа на большое , все маленькое
 * число остается в остатке
 *
 * @author churganov_r 19.03.2011
 */
public class BinaryArithmetic {

    public static void main(String[] args) {

        int a = -1, b = 15, c, d = 2, e = 2, f = 2, g = 2;

        System.out.println(7 + 3);
        System.out.println(7 - 3);
        System.out.println(7 * 3);
        System.out.println(7 / 3);  // при делении двух int остаток отбрасывается, и результат тоде int
        System.out.println(7d / 3f);  // при делении двух double остаток тоже делится

        System.out.println("==============================");
        System.out.println(3 % -7);
        System.out.println(-7 % -3);
        System.out.println(-7 % 3);
        System.out.println(7 % -3);
        System.out.println(7 % 3);
        System.out.println("==============================");
        System.out.println(7.5f % 3f);
        System.out.println(7.5d % 3d);

        System.out.println(7.5d / 3d);
        System.out.println(7.5f / 388f);

    }
}
