package ru.roman.task.projecteuler.math;

import java.util.stream.IntStream;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * <p>
 * Find the sum of all the primes below two million.
 */
public class Euler010SummationOfPrimes {

    public static void main(String[] a) {

        int[] primes = preparePrimeNumbers();

        long res = 0;
        for (long prime : primes)
            res += prime;

        System.out.println(res);
    }

    private static int[] preparePrimeNumbers() {
        int max = 10_000_000;
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
                .filter(i -> i < 2_000_000)
                .toArray();
    }
}
