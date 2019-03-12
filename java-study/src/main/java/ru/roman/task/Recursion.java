/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.task;

/**
 * перечисления без использования циклов, goto и хардкода
 *
 * @author churganov_r
 */
class Recursion {

    int i;

    Recursion() {
        foo();
    }

    public void foo() {
        if (i < 10) {
            System.out.println(++i);
            foo();
        }
    }

    public static void main(String[] args) {
        new Recursion();
    }
}
