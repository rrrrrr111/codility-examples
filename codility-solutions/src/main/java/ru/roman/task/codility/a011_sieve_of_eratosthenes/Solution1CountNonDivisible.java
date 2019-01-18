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
        for (int i = 0; i < A.length; i++) {
            counters[A[i]]++;
        }

        int totalDividers = A.length;

        System.out.printf("Total dividers : %s, ones: %s\n", totalDividers, counters[1]);
        System.out.printf("Factors : %s...\n", Arrays.toString(IntStream.of(factors).limit(33).mapToObj(value -> " " + value).toArray()));
        System.out.printf("Nums    : %s...\n", Arrays.toString(IntStream.range(0, 33).mapToObj(value -> value > 9 ? "" + value : " " + value).toArray()));
        System.out.printf("Counters: %s...\n", Arrays.toString(IntStream.of(counters).limit(33).mapToObj(value -> " " + value).toArray()));

        int[] result = new int[A.length];


        for (int i = 0; i < A.length; i++) {
            result[i] = totalDividers - counters[1];
            int a = A[i];

            if (a == 1) {
                System.out.printf("Count for one is %s\n", result[i]);

            } else {

                System.out.printf("\nCalculation started for %s, counter:%s\n", a, result[i]);
                Set<Integer> divs = new HashSet<>();
                divs.add(1);

                LinkedList<Integer> q = new LinkedList<>();
                q.add(a);
                while (!q.isEmpty()) {
                    int d = q.poll();

                    if (!divs.contains(d)) {
                        result[i] -= counters[d];
                        divs.add(d);
                        System.out.printf("Removing divider %s(%s), counter: %s\n", d, counters[d], result[i]);
                    }
                    int f = factors[d];

                    if (f > 0){
                        if (!divs.contains(f)) {
                            q.push(f);
                        }
                        int sd = a / f;
                        if (sd > 0 && !divs.contains(sd)){
                            q.push(sd);
                        }
                    }
                }
            }
        }

        return result;
    }
}
