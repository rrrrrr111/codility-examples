package ru.roman.algo.math;

import static ru.roman.algo.PrintUtil.printArray;
import static ru.roman.algo.PrintUtil.printRange;
import static ru.roman.algo.math.BinomialAndFactorialExample.prepareBinomials;
import static ru.roman.algo.math.BinomialAndFactorialExample.prepareFactorials;
import static ru.roman.algo.math.FibonacciNumbersExample.prepareFibs;
import static ru.roman.algo.math.PowAndSqrtExample.prepareExponent;
import static ru.roman.algo.math.SieveOfEratosthenesExample.prepareFactorsSieve;
import static ru.roman.algo.math.SieveOfEratosthenesExample.preparePrimeNumbers;

/**
 *
 */
public class NumberSequenceExample {

    public static void main(String[] args) {

        System.out.printf("Numbers                      : %s%n", printRange(0, 1000, 4));
        System.out.printf("Sieve of Eratosthenes        : %s%n", printArray(prepareFactorsSieve(1000), 4));
        System.out.printf("Prime numbers                : %s%n", printArray(preparePrimeNumbers(1000), 4));
        System.out.println();

        System.out.printf("Numbers                      : %s%n", printRange(0, 14, 10));
        System.out.printf("Fibonacci numbers            : %s%n", printArray(prepareFibs(46), 10));
        System.out.printf("Binomial Сoefficient C(n, 2) : %s%n", printArray(prepareBinomials(14, 2), 10));
        System.out.printf("Binomial Сoefficient C(n, 4) : %s%n", printArray(prepareBinomials(14, 4), 10));
        System.out.printf("Binomial Сoefficient C(n, 8) : %s%n", printArray(prepareBinomials(14, 8), 10));
        System.out.printf("Exponents 2^n                : %s%n", printArray(prepareExponent(14, 2), 10));
        System.out.printf("Exponents 2^n                : %s%n", printArray(prepareExponent(14, 3), 10));
        System.out.printf("Exponents 3^n                : %s%n", printArray(prepareExponent(14, 4), 10));
        System.out.printf("Factorials                   : %s%n", printArray(prepareFactorials(14), 10));
        System.out.println();
    }
}
