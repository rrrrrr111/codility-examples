package ru.roman.certification.classes.constructor;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
class DefaultConstructorExample {
    static final Map<String, DefaultConstructorExample> MAP = new HashMap<>();

    final DefaultConstructorExample i = null;

    public DefaultConstructorExample(DefaultConstructorExample i) {
        //this.i = i;
    }

    private DefaultConstructorExample() {
        // this(this);                            // illegal
        //this(new DefaultConstructorExample());  // stackowerflow
    }

    private DefaultConstructorExample(boolean b) {
        this();
        MAP.put(toString(), this);
    }

    public static void main(String[] args) {
        new DefaultConstructorExample(true);
    }
}


