/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.operator;

/**
 * 1. присваивание происходит спарва на лево
 * 2. Результатом выражения присваивания является присваиваемое значение
 *
 * @author churganov_r 21.03.2011
 */
public class Assign {

    public static void main(String[] args) {


        int b = 0;
        int a1 = 0, a2, a3;  //  можно инициализировать не все и декларировать в одну строку
        //int c1, long c2;   // illegal
        int c1; long c2;
        int x1, x2, x3;
        x1 = x2 = x3 = 0;  // 0 - результат всего выражения равен последнему присваиванию

        System.out.println(x1 = x2 = x3 = 0);
        System.out.println((x3 = 0) == 0);

    }
}
