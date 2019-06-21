package ru.roman.task.projectEuler.dp;

import ru.roman.task.blank.Util;

import java.math.BigInteger;

/**
 * It is possible to write five as a sum in exactly six different ways:
 * <p>
 * 4 + 1
 * 3 + 2
 * 3 + 1 + 1
 * 2 + 2 + 1
 * 2 + 1 + 1 + 1
 * 1 + 1 + 1 + 1 + 1
 * <p>
 * How many different ways can one hundred be written as a sum of at least two positive integers?
 */
public class Euler076CountingSummations {

    public static void main(String[] a) {

        BigInteger res = partitions(100, 1).subtract(BigInteger.ONE);
        System.out.println(res);
    }

    private static BigInteger partitions(int n, int k) {
        // Dynamic programming
        BigInteger[][] table = new BigInteger[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = n; j >= 0; j--) {
                if (j == i)
                    table[i][j] = BigInteger.ONE;
                else if (j > i)
                    table[i][j] = BigInteger.ZERO;
                else if (j == 0)
                    table[i][j] = table[i][j + 1];
                else
                    table[i][j] = table[i][j + 1].add(table[i - j][j]);
            }
        }
        System.out.println(Util.matrixToString(table, 9));
        return table[n][k];
    }
}
