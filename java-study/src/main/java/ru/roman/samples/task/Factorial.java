/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.samples.task;

/**
 * // вычислени факториалов разными способами . ..
 *
 * @author churganov_r
 */
class Factorial {

    int factorial1(int arg) {
        int res = arg > 0 ? arg : 1;
        while (arg > 1) {
            res *= --arg;
        }
        return res;
    }

    int factorial2(int arg) {
        if (arg == 0) {
            return 1;
        } else {
            return arg * factorial2(arg - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Factorial().factorial1(0));
        System.out.println(new Factorial().factorial2(0));
    }
}
