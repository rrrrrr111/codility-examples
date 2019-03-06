package ru.roman.certification.variable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LocalVariableTypeInference {
    public static void main(String[] args) {

        //var v = null;                          // illegal, can not infer type
        //var e;                                 // Illegal: no initializer
        //var b = 2, c = 3.0;                    // Illegal: multiple declarators
        var l1 = new ArrayList<String>();        // ArrayList<String>
        var l2 = new ArrayList<>();              // ArrayList<Object>
        var l3 = List.of();                      // List<Object>
        var c = "x".getClass();                  // Class<? extends String>
        var nums = List.of(1, 2.0, "3");         // List<Serializable&Comparable<? extends Serializable&Comparable<?>>>
        var flags = 0;                           // int - хотя можно ожидать что там short, byte, char
        var mask = 0x7fff;                       // int
        var base = 017;                          // int
        //var d[] = new int[4];                  // Illegal: extra bracket pairs
        //var[] d = new int[4];                  // Illegal: extra bracket pairs
        var d = new int[4];
        //var f = { 6 };                         // Illegal: array initializer
        var f = new int[]{ 6 };
        //var g = g = 7;                         // Illegal: self reference in initializer

        var ac = new Object() { void boo() {} }; // d has the type of the anonymous class
        ac.boo();
    }
}

class Foo {}
