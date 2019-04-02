package ru.roman.algo.math;

import com.google.common.base.Preconditions;

import java.math.BigInteger;

/**
 *
 */
class BinomialAndFactorialExample {

    public static void main(String[] args) {

        Preconditions.checkArgument(binomial(4, 2).equals(BigInteger.valueOf(6)));
        Preconditions.checkArgument(binomial(40, 20).equals(BigInteger.valueOf(137846528820L)));
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

        BigInteger product = BigInteger.ONE;
        for (int i = 0; i < k; i++)
            product = product.multiply(BigInteger.valueOf(n - i));
        return product.divide(factorial(k));
    }
}
