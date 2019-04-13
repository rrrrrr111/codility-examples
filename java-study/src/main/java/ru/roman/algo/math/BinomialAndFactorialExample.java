package ru.roman.algo.math;

import com.google.common.base.Preconditions;

import java.math.BigInteger;
import java.util.stream.IntStream;

import static ru.roman.algo.PrintUtil.printArray;
import static ru.roman.algo.PrintUtil.printRange;

/**
 *
 */
class BinomialAndFactorialExample {

    public static void main(String[] args) {

        Preconditions.checkArgument(binomial(4, 2).equals(BigInteger.valueOf(6)));
        Preconditions.checkArgument(binomial(40, 20).equals(BigInteger.valueOf(137846528820L)));

        System.out.printf("Nums                         : %s%n", printRange(0, 14, 10));
        System.out.printf("Factorials                   : %s%n", printArray(prepareFactorials(14), 10));
        System.out.printf("Binomial Сoefficient C(n, 2) : %s%n", printArray(prepareBinomials(14, 2), 10));
        System.out.printf("Binomial Сoefficient C(n, 4) : %s%n", printArray(prepareBinomials(14, 4), 10));
        System.out.printf("Binomial Сoefficient C(n, 8) : %s%n", printArray(prepareBinomials(14, 8), 10));
    }

    static BigInteger[] prepareFactorials(int num) {
        return IntStream.range(0, num)
                .mapToObj(BinomialAndFactorialExample::factorial)
                .toArray(BigInteger[]::new);
    }

    static BigInteger[] prepareBinomials(int num, int k) {
        return IntStream.range(0, num)
                .mapToObj((int n) -> n < k ? BigInteger.ZERO : binomial(n, k))
                .toArray(BigInteger[]::new);
    }

    /**
     * Returns n!
     */
    private static BigInteger factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Factorial of negative number");

        BigInteger p = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            p = p.multiply(BigInteger.valueOf(i));
        return p;
    }

    /**
     * Returns n choose k (Binomial Сoefficient)
     */
    private static BigInteger binomial(int n, int k) {
        if (k < 0 || k > n)
            throw new IllegalArgumentException();

        BigInteger p = BigInteger.ONE;
        for (int i = 0; i < k; i++)
            p = p.multiply(BigInteger.valueOf(n - i));
        return p.divide(factorial(k));
    }
}
