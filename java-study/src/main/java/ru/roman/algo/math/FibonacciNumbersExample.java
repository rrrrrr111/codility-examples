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
 * <p>
 * https://www.ics.uci.edu/~eppstein/161/960109.html#dynprog
 */
class FibonacciNumbersExample {

    public static void main(String[] args) {

        int valueNum = 46;
        int[] fibonacci = prepareFibs(valueNum);

        System.out.printf("Nums     : %s%n", printRange(0, valueNum + 1, 10));
        System.out.printf("Fibonacci: %s%n", printArray(fibonacci, 10));
    }

    /**
     * O(n), space O(n)
     */
    static int[] prepareFibs(int num) {
        int[] result = new int[num + 1];  // 1 extra to handle case, num = 0
        result[1] = 1;

        for (int i = 2; i < result.length; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }

    /**
     * O(n^2), space O(1)
     */
    private static int fib1(int num) {
        if (num <= 1)
            return num;
        return fib1(num - 1) + fib1(num - 2);
    }

    /**
     * O(n), space O(1)
     */
    private static int fib2(int n) {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    /**
     * O(n), space O(1), Matrix Method
     */
    private static int fib3(int n) {
        int[][] F = new int[][]{{1, 1}, {1, 0}};
        if (n == 0)
            return 0;
        power(F, n - 1);

        return F[0][0];
    }

    private static void power(int[][] F, int n) {

        int[][] M = new int[][]{{1, 1}, {1, 0}};
        for (int i = 2; i <= n; i++)        // n - 1 times multiply the matrix to {{1,0},{0,1}}
            multiply(F, M);
    }

    private static void multiply(int[][] F, int[][] M) {
        F[0][0] = F[0][0] * M[0][0] + F[0][1] * M[1][0];
        F[0][1] = F[0][0] * M[0][1] + F[0][1] * M[1][1];
        F[1][0] = F[1][0] * M[0][0] + F[1][1] * M[1][0];
        F[1][1] = F[1][0] * M[0][1] + F[1][1] * M[1][1];
    }

    /**
     * Based on matrix equation
     * O(log n)
     */
    private static int fib4(int num) {

        int[] nums = new int[1_000];
        if (num == 0)
            return 0;

        if (num == 1 || num == 2)
            return (nums[num] = 1);
        if (nums[num] != 0)
            return nums[num];
        int k = (num & 1) == 1 ? (num + 1) / 2 : num / 2;

        nums[num] = (num & 1) == 1
                ? fib4(k) * fib4(k) + fib4(k - 1) * fib4(k - 1)
                : (2 * fib4(k - 1) + fib4(k)) * fib4(k);
        return nums[num];
    }

    /**
     * O(1), space O(1), by formula
     */
    private static int fib5(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(phi, n) / Math.sqrt(5));
    }
}
