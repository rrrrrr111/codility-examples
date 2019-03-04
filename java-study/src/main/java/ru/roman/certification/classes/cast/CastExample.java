package ru.roman.certification.classes.cast;

import java.util.Stack;
import java.util.Vector;

/**
 *
 */
public class CastExample {

    public static void main(String[] args) {

        Runnable r = null;
        //Long l1 = (Long) r;         // illegal т к Long final
        Number l2 = (Number) r;
        Stack l3 = (Stack) r;

        Vector al = null;
        //Number l3 = (Number) al;      // illegal Number не наследник Vector
        Runnable l5 = (Runnable) al;    // null тихо конвертнется Runnable
        Stack l4 = (Stack) al;

        Vector[] rl = new Vector[0];
        //Number[] r3 = (Number[]) rl;      // illegal, массивы ведут себя аналочно своим типам
        Runnable[] r5 = (Runnable[]) rl;    // ClassCastException
        Stack[] r4 = (Stack[]) rl;          // ClassCastException
    }
}
