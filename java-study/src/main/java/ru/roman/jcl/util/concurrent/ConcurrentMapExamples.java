package ru.roman.jcl.util.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * JCL API Examples
 */
class ConcurrentMapExamples {

    void foo1() {

        ConcurrentMap<String, Long> map = new ConcurrentHashMap<>();                   // CAS operation
        Long old;
        do {
            old = map.get("New York");
        } while (!map.replace("New York", old, (old + 1)));


    }
}
