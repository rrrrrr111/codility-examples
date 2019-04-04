package ru.roman.task.projecteuler.dp;

/**
 * Let p(n) represent the number of different ways in which n coins can be separated into piles. For example, five coins can be separated into piles in exactly seven different ways, so p(5)=7.
 * <pre>
 * OOOOO
 * OOOO O
 * OOO OO
 * OOO O O
 * OO OO O
 * OO O O O
 * O O O O O</pre>
 * Find the least value of n for which p(n) is divisible by one million.
 */
public class Euler078CoinPartitions {

    public static void main(String[] a) {

        for (int limit = 1; ; limit *= 2) {
            int result = search(limit);
            if (result != -1) {
                System.out.println(result);
                return;
            }
        }
    }

    private static final int MODULUS = 1_000_000;

    /**
     * partitions[i] is {the number of ways i can be written
     * as an unordered sum of positive integers} mod 10^6.
     * Note that the partition function P(n, k) can be computed with
     * dynamic programming using only 1 dimension for memoization.
     */
    private static int search(int limit) {
        int[] partitions = new int[limit];
        partitions[0] = 1;
        for (int i = 1; i < limit; i++) {
            for (int j = i; j < limit; j++)
                partitions[j] = (partitions[j] + partitions[j - i]) % MODULUS;
        }
        for (int i = 0; i < limit; i++) {
            if (partitions[i] == 0)
                return i;
        }
        return -1;
    }
}
