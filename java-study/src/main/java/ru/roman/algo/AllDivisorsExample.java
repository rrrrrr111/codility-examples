package ru.roman.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ru.roman.algo.PrintUtil.printArray;

/**
 *
 */
class AllDivisorsExample {

    public static void main(String[] args) {

        int num = 132;
        List<Integer> divs = new ArrayList<>(Arrays.asList(1, num));
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                divs.add(i);
                divs.add(num / i);
            }
        }
        Collections.sort(divs);

        System.out.printf("Num: %s, Sqrt: %s%n", num, Math.sqrt(num));
        System.out.printf("Divisors     : %s%n", printArray(divs.toArray(), 3));
    }
}
