package ru.roman.algo;

import static ru.roman.algo.PrintUtil.printArray;
import static ru.roman.algo.PrintUtil.printRange;

/**
 *
 */
class FibonacciNumbersExample {

    public static void main(String[] args) {

        int maxValue = 46;
        int[] fibonacci = prepareFibonacciNumbers(maxValue);

        System.out.printf("Nums     : %s%n", printRange(0, maxValue + 1, 10));
        System.out.printf("Fibonacci: %s%n", printArray(fibonacci, 10));
    }

    private static int[] prepareFibonacciNumbers(int maxValue) {
        int max = maxValue + 1;
        int[] result = new int[max];
        result[1] = 1;

        for (int i = 2; i < result.length; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }
}
