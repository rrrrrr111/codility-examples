package ru.roman.algo.math;

import java.util.stream.IntStream;

import static ru.roman.algo.PrintUtil.printArray;
import static ru.roman.algo.PrintUtil.printRange;

/**
 *
 */
class SieveOfEratosthenesExample {

    public static void main(String[] args) {

        int maxValue = 1_000;
        int[] factors = prepareFactorsSieve(maxValue);
        int[] primes = preparePrimeNumbers(100_000);

        System.out.printf("Nums    : %s%n", printRange(0, maxValue + 1, 3));
        System.out.printf("Factors : %s%n", printArray(factors, 3));
        System.out.println();
        System.out.printf("Primes  : %s%n", printArray(primes, 3));
    }

    static int[] prepareFactorsSieve(int maxValue) {
        int max = maxValue + 1;
        int[] factors = new int[max];

        for (int i = 2; i * i < max; i++) {
            int k = i * i;

            while (k < max) {
                factors[k] = i;
                k += i;
            }
        }
        return factors;
    }

    static int[] preparePrimeNumbers(int maxValue) {
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
                .toArray();
    }
}
