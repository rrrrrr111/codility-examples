package ru.roman.algo.math;

import static ru.roman.algo.PrintUtil.printArray;
import static ru.roman.algo.PrintUtil.printRange;

/**
 * The Fibonacci numbers are the numbers in the following integer sequence.
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
 * <p>
 * In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation
 * <p>
 * Fn = Fn-1 + Fn-2
 * <p>
 * with seed values F0 = 0 and F1 = 1.
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

    private static int getFibNum(int n) {
        if (n <= 1)
            return n;
        return getFibNum(n - 1) + getFibNum(n - 2);
    }
}
