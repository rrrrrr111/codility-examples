package ru.roman.algo.math;

import static ru.roman.algo.PrintUtil.printArray;
import static ru.roman.algo.PrintUtil.printRange;
import static ru.roman.algo.math.SieveOfEratosthenesExample.prepareFactorsSieve;
import static ru.roman.algo.math.SieveOfEratosthenesExample.preparePrimeNumbers;

/**
 *
 */
public class NumberSequenceExample {

    public static void main(String[] args) {


        System.out.printf("Numbers        : %s%n", printRange(0, 1000, 3));
        System.out.printf("SieveOfEratos : %s%n", printArray(prepareFactorsSieve(1000), 3));
        System.out.println();
        System.out.printf("Primes  : %s%n", printArray(preparePrimeNumbers(100_000), 3));
    }
}
