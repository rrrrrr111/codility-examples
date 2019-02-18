/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.object;

/**
 * @author churganov_r
 */
public class ObjectExample {

    public static void main(String args[]) {

        try {
            Thread.yield();

            // методы объекта object
            new Object().equals(args);
            new Object().getClass();
            new Object().hashCode();
            new Object().notify();
            new Object().notifyAll();
            new Object().toString();
            new Object().wait();
            //new Object().clone();   // clone has protected access in java.lang.object
            new Object().wait(1);
            new Object().wait(1, 1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
