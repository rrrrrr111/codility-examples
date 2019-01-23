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

        int x1, x2, x3;

        System.out.println(x1 = x2 = x3 = 0);
        System.out.println((x3 = 0) == 0);

    }
}
