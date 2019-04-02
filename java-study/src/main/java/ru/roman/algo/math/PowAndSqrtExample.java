package ru.roman.algo.math;

import com.google.common.base.Preconditions;

import java.util.stream.IntStream;

import static ru.roman.algo.PrintUtil.printArray;
import static ru.roman.algo.PrintUtil.printRange;

/**
 *
 */
class PowAndSqrtExample {

    public static void main(String[] args) {

        Preconditions.checkArgument(sqrt(100_000_000) == Math.sqrt(100_000_000));
        Preconditions.checkArgument(sqrt(100_000_000L) == Math.sqrt(100_000_000));
        Preconditions.checkArgument(isSquare(16));
        Preconditions.checkArgument(pow(2, 4) == 16);

        System.out.printf("Nums               : %s%n", printRange(0, 20, 10));
        System.out.printf("Exponents 2^n      : %s%n", printArray(prepareExponent(20, 2), 10));
    }

    static int[] prepareExponent(int num, int b) {
        return IntStream.range(0, num)
                .map((int x) -> pow(b, x))
                .toArray();
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
}
