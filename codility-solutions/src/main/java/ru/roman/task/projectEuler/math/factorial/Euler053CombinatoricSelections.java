package ru.roman.task.projectEuler.math.factorial;

import java.math.BigInteger;

/**
 * There are exactly ten ways of selecting three from five, 12345:
 * <p>
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 * <p>
 * In combinatorics, we use the notation, 5C3=10.
 * <p>
 * In general, nCr = n!/r!(n−r)!, where r≤n, n!=n×(n−1)×...×3×2×1, and 0!=1.
 * <p>
 * It is not until n=23, that a value exceeds one-million: 23C10=1144066.
 * <p>
 * How many, not necessarily distinct, values of nCr for 1≤n≤100, are greater than one-million?
 */
public class Euler053CombinatoricSelections {

    public static void main(String[] a) {

        BigInteger MILLION = BigInteger.TEN.pow(6);
        int count = 0;
        for (int n = 1; n <= 100; n++) {
            for (int r = 0; r <= n; r++) {
                if (binomial(n, r).compareTo(MILLION) > 0)
                    count++;
            }
        }

        System.out.println(count);
    }

    /**
     * Returns n!
     */
    private static BigInteger factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Factorial of negative number");

        BigInteger prod = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            prod = prod.multiply(BigInteger.valueOf(i));
        return prod;
    }


    /**
     * Returns n choose k (Binomial Сoefficient)
     */
    private static BigInteger binomial(int n, int k) {
        if (k < 0 || k > n)
            throw new IllegalArgumentException();

        BigInteger prod = BigInteger.ONE;
        for (int i = 0; i < k; i++)
            prod = prod.multiply(BigInteger.valueOf(n - i));
        return prod.divide(factorial(k));
    }
}
