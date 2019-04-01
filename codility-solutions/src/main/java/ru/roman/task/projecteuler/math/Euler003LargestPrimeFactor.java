package ru.roman.task.projecteuler.math;

import java.util.Set;
import java.util.TreeSet;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Euler003LargestPrimeFactor {

    public static void main(String[] args) {


        Long[] primeFactors = preparePrimeFactors(600851475143L);
        System.out.println(primeFactors[primeFactors.length - 1]);
    }

    private static Long[] preparePrimeFactors(long num) {

        Set<Long> primes = new TreeSet<>();
        while (true) {
            long p = smallestPrimeFactor(num);
            primes.add(p);

            if (p < num) {
                num /= p;
            } else
                return primes.toArray(new Long[0]);
        }
    }

    private static long smallestPrimeFactor(long num) {  // smallest factor always prime factor
        if (num <= 1)
            throw new IllegalArgumentException();

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return i;
        }
        return num;  // num itself is prime
    }
}
