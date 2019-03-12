/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.certification.parameters;

/**
 * 1. В java происходит передача параметров по значению, это значит,
 * что  после выполнения метода ссылки и примитивы остаются доступны и смотрят по
 * старому.
 *
 * @author churganov_r 22.03.2011
 */
class A029_ParamsInput {


    void foo(String str, int i) {
        System.out.println(str + " " + i);
        str = "p";  // здесь мы меням ссылку , а значит она остется доступна после метода...
        // если бы мы могли здесь поменть сам объект . то он изменился бы и навыходе из
        // метода был би измененным .. .
        i = 2;
        System.out.println(str + " " + i);
    }


    public static void main(String[] args) {

        String str = "t";
        int i = 1;

        new A029_ParamsInput().foo(str, i);

        System.out.println(str + " " + i);
    }
}
