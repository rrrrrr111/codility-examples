package ru.roman.algo.math;

import com.google.common.base.Preconditions;

import java.math.BigInteger;

/**
 *
 */
class MathOperations {

    public static void main(String[] args) {

        Preconditions.checkArgument(sqrt(100_000_000) == Math.sqrt(100_000_000));
        Preconditions.checkArgument(sqrt(100_000_000L) == Math.sqrt(100_000_000));
        Preconditions.checkArgument(isSquare(16));
        Preconditions.checkArgument(pow(2, 4) == 16);
        Preconditions.checkArgument(binomial(4, 2).equals(BigInteger.valueOf(6)));
        Preconditions.checkArgument(binomial(40, 20).equals(BigInteger.valueOf(137846528820L)));
    }

    /**
     * Returns floor(sqrt(x)), for x >= 0.
     */
    private static int sqrt(int x) {
        if (x < 0)
            throw new IllegalArgumentException("Square root of negative number");

        int y = 0;
        for (int i = 1 << 15; i != 0; i >>>= 1) {
            y |= i;
            if (y > 46340 || y * y > x)
                y ^= i;
        }
        return y;
    }

    /**
     * Returns floor(sqrt(x)), for x >= 0.
     */
    private static long sqrt(long x) {
        if (x < 0)
            throw new IllegalArgumentException("Square root of negative number");

        long y = 0;
        for (long i = 1L << 31; i != 0; i >>>= 1) {
            y |= i;
            if (y > 3037000499L || y * y > x)
                y ^= i;
        }
        return y;
    }

    private static boolean isSquare(int x) {
        if (x < 0)
            return false;
        double y = Math.sqrt(x);
        return y * y == x;
    }

    /**
     * Returns x to the power of y, throwing an exception if the result overflows an int.
     */
    private static int pow(int x, int y) {
        if (x < 0)
            throw new IllegalArgumentException("Negative base not supported");
        if (y < 0)
            throw new IllegalArgumentException("Negative exponent");
        int z = 1;
        for (int i = 0; i < y; i++) {
            if (Integer.MAX_VALUE / z < x)
                throw new ArithmeticException("Overflow");
            z *= x;
        }
        return z;
    }


    /**
     * Returns x^y mod m.
     */
    public static int powMod(int x, int y, int m) {
        if (x < 0)
            throw new IllegalArgumentException("Negative base not supported");
        if (y < 0)
            throw new IllegalArgumentException("Modular reciprocal not supported");
        if (m <= 0)
            throw new IllegalArgumentException("Modulus must be positive");
        if (m == 1)
            return 0;

        // Exponentiation by squaring
        int z = 1;
        for (; y != 0; y >>>= 1) {
            if ((y & 1) != 0)
                z = (int) ((long) z * x % m);
            x = (int) ((long) x * x % m);
        }
        return z;
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
