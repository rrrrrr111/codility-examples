package ru.roman.certification.jcl.util.concurrent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 */
class CopyOnWriteArrayListExample {


    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        System.out.printf("Initial list %s%n", list);

        for (Integer i : list) {
            list.add(3, 33);

            System.out.printf("After mutation %s%n", list);
        }

        System.out.printf("Final %s%n", list);
    }
}
