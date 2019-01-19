package ru.roman.task.codility.a011_sieve_of_eratosthenes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * You are given an array A consisting of N integers.
 * <p>
 * For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i]. We say that these elements are non-divisors.
 * <p>
 * For example, consider integer N = 5 and array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 3
 * A[4] = 6
 * For the following elements:
 * <p>
 * A[0] = 3, the non-divisors are: 2, 6,
 * A[1] = 1, the non-divisors are: 3, 2, 3, 6,
 * A[2] = 2, the non-divisors are: 3, 3, 6,
 * A[3] = 3, the non-divisors are: 2, 6,
 * A[4] = 6, there aren't any non-divisors.
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.
 * <p>
 * Result array should be returned as an array of integers.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 3
 * A[4] = 6
 * the function should return [2, 4, 3, 2, 0], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..50,000];
 * each element of array A is an integer within the range [1..2 * N].
 */
class Solution1CountNonDivisible {
    public int[] solution(int[] A) {
        System.out.printf("On input: %s\n", Arrays.toString(A));
        int max = 100_001;

        int[] factors = new int[max];
        for (int i = 2; i * i < max; i++) {
            long k = i * i;
            while (k < max) {
                factors[(int) k] = i;
                k += i;
            }
        }

        int[] counters = new int[max];
        for (int a : A) {
            counters[a]++;
        }

        int totalDividers = A.length;

        System.out.printf("Total dividers : %s, ones: %s\n", totalDividers, counters[1]);
        System.out.printf("Factors : %s...\n", Arrays.toString(IntStream.of(factors).limit(133).mapToObj(value -> " " + value).toArray()));
        System.out.printf("Nums    : %s...\n", Arrays.toString(IntStream.range(0, 133).mapToObj(value -> value > 9 ? "" + value : " " + value).toArray()));
        System.out.printf("Counters: %s...\n", Arrays.toString(IntStream.of(counters).limit(133).mapToObj(value -> " " + value).toArray()));

        final int[] result = new int[A.length];
        final Set<Integer> divs = new HashSet<>();
        final LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            result[i] = totalDividers;
            int a = A[i];

            System.out.printf("\nCalculation started for %s, counter:%s\n", a, result[i]);

            divs.clear();

            divs.add(a);
            queue.push(a);
            result[i] -= counters[a];

            while (!queue.isEmpty()) {
                int d = queue.pop();
                int f = factors[d];

                int c1 = a / d;
                if (c1 != d && divs.add(c1)) {
                    queue.push(c1);
                    result[i] -= counters[c1];
                    System.out.printf("Removing a/x %s(%s), counter: %s\n", c1, counters[c1], result[i]);
                }

                if (f > 0) {
                    if (f != c1 && divs.add(f)) {
                        queue.push(f);
                        result[i] -= counters[f];
                        System.out.printf("Removing factor %s(%s), counter: %s\n", f, counters[f], result[i]);
                    }

                    int c2 = d / f;
                    if (c2 != c1 && c2 != f && divs.add(c2)) {
                        queue.push(c2);
                        result[i] -= counters[c2];
                        System.out.printf("Removing x/f %s(%s), counter: %s\n", c2, counters[c2], result[i]);
                    }
                    int c3 = a / f;
                    if (c3 != c2 && c3 != c1 && c3 != f && divs.add(c3)) {
                        queue.push(c3);
                        result[i] -= counters[c3];
                        System.out.printf("Removing a/f %s(%s), counter: %s\n", c3, counters[c3], result[i]);
                    }
                }
            }
        }
        return result;
    }
}
