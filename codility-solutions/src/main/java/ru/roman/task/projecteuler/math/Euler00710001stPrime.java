package ru.roman.task.projecteuler.math;

import java.util.stream.IntStream;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * <p>
 * What is the 10 001st prime number?
 */
public class Euler00710001stPrime {

    public static void main(String[] a) {

        int[] primes = preparePrimeNumbers(200_000);

        int res = primes[primes.length - 1];
        System.out.println(res);
    }

    private static int[] preparePrimeNumbers(int maxValue) {
        int max = maxValue + 1;
        int[] primes = new int[max];

        for (int i = 2; i * i <= max; i++) {
            int k = i * i;
            while (k < max) {
                primes[k] = -1;
                k += i;
            }
        }
        return IntStream.range(0, primes.length)
                .filter(i -> i > 1)
                .filter(i -> primes[i] == 0)
                .limit(10_001)
                .toArray();
    }
}
