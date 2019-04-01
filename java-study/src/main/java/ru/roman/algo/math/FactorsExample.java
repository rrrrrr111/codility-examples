package ru.roman.algo.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static ru.roman.algo.PrintUtil.printArray;

/**
 *
 */
class FactorsExample {

    public static void main(String[] args) {

        printFor(132);
        printFor(600851475143L);
    }

    private static void printFor(long num) {
        Long[] divs = prepareAllFactors(num);
        Long[] primeDivs = preparePrimeFactors(num);

        System.out.printf("Num: %s, Sqrt: %s%n", num, Math.sqrt(num));
        System.out.printf("All factors    : %s%n", printArray(divs, 3));
        System.out.printf("Prime factors  : %s%n", printArray(primeDivs, 3));
        System.out.println();
    }

    private static Long[] prepareAllFactors(long num) {
        List<Long> divs = new ArrayList<>(Arrays.asList(1L, num));
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                divs.add(i);
                divs.add(num / i);
            }
        }
        Collections.sort(divs);
        return divs.toArray(new Long[0]);
    }

    private static Long[] preparePrimeFactors(long num) {

        Set<Long> primes = new TreeSet<>();
        while (true) {
            long p = smallestPrimeFactor(num);
            primes.add(p);

            if (p < num) {
                num /= p;
            }
            else
                return primes.toArray(new Long[0]);
        }
    }

    private static long smallestPrimeFactor(long num) {  // smallest factor always prime factor
        if (num <= 1)
            throw new IllegalArgumentException();

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return i;
        }
        return num;  // num itself is prime
    }
}
