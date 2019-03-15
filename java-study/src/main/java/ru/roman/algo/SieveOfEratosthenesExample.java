package ru.roman.algo;

import static ru.roman.algo.PrintUtil.printArray;
import static ru.roman.algo.PrintUtil.printRange;

/**
 *
 */
class SieveOfEratosthenesExample {

    public static void main(String[] args) {

        int maxValue = 1_000;
        int[] factors = preparePrimeFactors(maxValue);

        System.out.printf("Nums    : %s%n", printRange(0, maxValue + 1, 3));
        System.out.printf("Factors : %s%n", printArray(factors, 3));
    }

    private static int[] preparePrimeFactors(int maxValue) {
        int max = maxValue + 1;
        int[] factors = new int[max];

        for (int i = 2; i * i < max; ) {
            int k = i * i;
            while (k < max) {
                factors[k] = i;
                k += i;
            }
            i++;
        }
        return factors;
    }
}
