/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.puzzle;

import java.math.BigDecimal;

/**
 * 1. Операции над float и Double возвращают не точные значения
 * Результат операции над floating point типами зависят от платформы, если на поле не стоит strictfp
 *
 * @author churganov_r 21.03.2011
 */
class Puzzle2FloatingPoint {

    public static void main(String args[]) {
        System.out.println(2.00 - 1.10); // 0.8999999999999999
        System.out.println(2.00d / 1.5d); //  1.3333333333333333
        System.out.println(-2.00d / -0); //  -Infinity
        System.out.println(0d / 0); //  NaN
        System.out.println(0d / -100); //  -0.0
        System.out.println((2.00 - 1.10)); //  0.8999999999999999
        System.out.println(2.00f - 1.10f); //  0.9
        System.out.println(
                new BigDecimal("2.00").subtract(new BigDecimal("1.10")) // 0.90
        );
    }
}
