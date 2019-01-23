/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.primitives;

/**
 * @author churganov_r
 */
public class Increment extends Thread {

    int y, i;

    @Override
    public void run() {

        // если плюсы стоят до переменной , то от переменной значение бетрется после прибавления к ней единицы
        // если плюсы стоят после переменной , то от переменной значение бетрется до прибавления к ней единицы
        y = ++i;

    }

    public static void main(String args[]) {

        Increment t = new Increment();
        t.run();
        System.out.println(t.y);

        // если переменная инициирована в классе как член, ей автоматически присваивается null или 0
        // при инициалицации переменной внутри метода , если ей не назначено значение,
        // произойдет RuntimeException: Uncompilable source code

        //int y, i;
        //y = ++i;
        //System.out.println(y);
    }
}
