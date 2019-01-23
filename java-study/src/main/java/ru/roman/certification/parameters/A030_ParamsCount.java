/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.parameters;

/**
 * 1. Последний параметр можно задать как массив (тоесть получается переменное
 * число парамтров)
 * 2. После такого хитрого параметра не может быть больше параметров,
 * перед ним могут быть
 *
 * @author churganov_r 21.03.2011
 */
public class A030_ParamsCount {

    A030_ParamsCount(int i, String... str) {
        for (String s : str) {
            System.out.println(s);
        }
    }


    void foo(int... i) {   // скомпилировать такие перегруженные мотоды
        // можно, но их не вызвать т к оба берут
        // на вход одинаковые параметры..

    }

    void foo(Integer... i) {

    }

    public static void main(String[] args) {
        new A030_ParamsCount(1, "рас");
        new A030_ParamsCount(2, "рас", "два");
        //new A030_ParamsCount(1, "рас").foo(1);
    }
}


