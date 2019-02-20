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
 * <p>
 * 2. при делении маленького числа на большое , все маленькое
 * число остается в остатке
 *
 * @author churganov_r 19.03.2011
 */
public class BinaryArithmetic {

    public static void main(String[] args) {

        byte b1 = -1, b2 = 15, b3, b4 = 2, b5 = 2, b6 = 2, b7 = 2;
        int i1 = -1, i2 = 15, i3, i4 = 2, i5 = 2, i6 = 2, i7 = 2;
        float f1 = -1, f2 = 15, f3, f4 = 2, f5 = 2, f6 = 2, f7 = 2;

        float r1 = 7 + 3f;              // 10.0 - если хотябы один операнд float второй тоже приводится к float
        float r11 = f1 + f2;            //
        float r12 = 3.4e38f * 2;        // не ругатся даже при overflow
        byte r2 =  7 + 31;              // на литералах компилятор не ругается, если видит что результат не вылазит
        //byte r3 = b1 - b2;            // illegal, required int found byte
        //byte r4 =  777 + 7;           // illegal, required int found byte

        System.out.println(7 * 3);
        System.out.println(7 / 3);      // 2 при делении int остаток отбрасывается, т к результат int
        System.out.println(7d / 3);     // 2.3333333333333335 при делении double остаток не отбрасывается

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
