package ru.roman.task.codility.a011_sieve_of_eratosthenes;

import java.util.Arrays;

/**
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
 * <p>
 * A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
 * <p>
 * You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.
 * <p>
 * Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.
 * <p>
 * For example, consider an integer N = 26 and arrays P, Q such that:
 * <pre>
 * P[0] = 1    Q[0] = 26
 * P[1] = 4    Q[1] = 10
 * P[2] = 16   Q[2] = 20</pre>
 * The number of semiprimes within each of these ranges is as follows:
 * <pre>
 * (1, 26) is 10,
 * (4, 10) is 4,
 * (16, 20) is 0.</pre>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int N, int[] P, int[] Q); }
 * <p>
 * that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.
 * <p>
 * For example, given an integer N = 26 and arrays P, Q such that:
 * <pre>
 * P[0] = 1    Q[0] = 26
 * P[1] = 4    Q[1] = 10
 * P[2] = 16   Q[2] = 20</pre>
 * the function should return the values [10, 4, 0], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..50,000];
 * M is an integer within the range [1..30,000];
 * each element of arrays P, Q is an integer within the range [1..N];
 * P[i] ≤ Q[i].
 */
class Solution2CountSemiprimes {
    public int[] solution(int N, int[] P, int[] Q) {
        System.out.printf("On input: %s %s %s\n", N, Arrays.toString(P), Arrays.toString(Q));

        final int[] sieve = new int[N + 1];
        for (int i = 2; i * i <= N; i++) {
            int k = i * i;
            while (k <= N) {
                sieve[k] = i;
                k += i;
            }
        }

        //System.out.printf("Factors   : %s\n", Arrays.toString(sieve));

        int count = 0;
        final int[] semiPrimeCount = new int[N + 1];
        for (int i = 4; i <= N; i++) {
            int f = sieve[i];
            if (f > 0 && sieve[f] == 0 && sieve[i / f] == 0) {
                count++;
            }

            semiPrimeCount[i] = count;
        }

        //System.out.printf("Semiprimes: %s\n", Arrays.toString(semiPrimeCount));

        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            int p = P[i];
            int q = Q[i];

            result[i] = semiPrimeCount[q] - (p > 0 ? semiPrimeCount[p - 1] : 0);
        }
        return result;
    }
}
