package ru.roman.task.projecteuler.math.fibonacci;

import java.math.BigInteger;

/**
 * The Fibonacci sequence is defined by the recurrence relation:
 * <p>
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 * <p>
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 * <p>
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class Euler025_1000digitFibonacciNumber {


    /**
     * Because the target number is relatively small, we simply compute each Fibonacci number starting
     * from the beginning until we encounter one with exactly 1000 digits. The Fibonacci sequence grows
     * exponentially with a base of about 1.618, so the numbers in base 10 will lengthen by one digit
     * after every log10(1.618) ~= 4.78 steps on average. This means the answer is at index around 4780.
     */
    public static void main(String[] a) {

        BigInteger lowerThres = BigInteger.TEN.pow(1000 - 1);
        BigInteger upperThres = BigInteger.TEN.pow(1000);
        BigInteger prev = BigInteger.ONE;
        BigInteger cur = BigInteger.ZERO;

        for (int i = 0; ; i++) {

            // At this point, prev = fibonacci(i - 1) and cur = fibonacci(i)
            if (cur.compareTo(upperThres) >= 0)
                throw new RuntimeException("Not found");

            else if (cur.compareTo(lowerThres) >= 0) {
                System.out.println(i);
                return;
            }

            BigInteger temp = cur.add(prev);
            prev = cur;
            cur = temp;
        }
    }
}
