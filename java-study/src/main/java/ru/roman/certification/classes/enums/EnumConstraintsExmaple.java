package ru.roman.certification.classes.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class EnumConstraintsExmaple {

    public static void main(String[] args) {
        System.out.println(Color.GREEN);
    }
}

enum Color {
    RED, GREEN, BLUE;
    Color() {
        foo();
        //MAP.put(toString(), this);            // illegal
    }
    void foo() {
        MAP.put(toString(), this);    // ExceptionInInitializerError Caused by: NullPointerException
    }
    static final Map<String, Color> MAP = new HashMap<>();
}
