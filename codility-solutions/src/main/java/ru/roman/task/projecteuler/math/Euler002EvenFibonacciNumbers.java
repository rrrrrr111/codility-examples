package ru.roman.task.projecteuler.math;

/**
 *
 */
public class Euler002EvenFibonacciNumbers {

    public static void main(String[] args) {

        int max = 4_000_000;
        int[] fibs = prepareFibs(max);

        long res = 0;
        for (int fib : fibs) {
            if (fib > max)
                break;
            if (fib % 2 == 0) {
                System.out.println(fib);
                res += fib;
            }
        }

        System.out.println(res);
    }

    private static int[] prepareFibs(int max) {
        int[] result = new int[1000];  // 1 extra to handle case, num = 0
        result[1] = 1;

        for (int i = 2; i < result.length; i++) {
            result[i] = result[i - 1] + result[i - 2];
            if (result[i] > max)
                break;
        }
        return result;
    }
}
