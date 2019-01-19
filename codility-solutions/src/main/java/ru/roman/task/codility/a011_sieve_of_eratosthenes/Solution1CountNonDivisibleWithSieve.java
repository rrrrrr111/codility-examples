package ru.roman.task.codility.a011_sieve_of_eratosthenes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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
class Solution1CountNonDivisibleWithSieve {
    private static boolean log = false;

    public int[] solution(int[] A) {
        //log("On input: %s", Arrays.toString(A));

        int[] factors = new int[100_001];
        int i = 2;
        int j;
        for (; ; ) {
            j = i * i;
            if (j >= 100_001) {
                break;
            }
            int k = j;
            while (k < 100_001) {
                factors[k] = i;
                k += i;
            }
            i++;
        }

        int[] counters = new int[100_001];
        for (int a : A) {
            counters[a]++;
        }

        //log("Total dividers : %s, ones: %s", totalDividers, counters[1]);
        //log("Factors : %s...", Arrays.toString(IntStream.of(factors).limit(133).mapToObj(value -> " " + value).toArray()));
        //log("Nums    : %s...", Arrays.toString(IntStream.range(0, 133).mapToObj(value -> value > 9 ? "" + value : " " + value).toArray()));
        //log("Counters: %s...", Arrays.toString(IntStream.of(counters).limit(133).mapToObj(value -> " " + value).toArray()));

        final int totalDividers = A.length;
        final int[] result = new int[A.length];
        final Set<Integer> divs = new HashSet<>();
        final LinkedList<Integer> queue = new LinkedList<>();

        for (int i1 = 0; i1 < A.length; i1++) {
            int a = A[i1];

            //log("\nCalculation started for %s, totalDividers:%s", a, totalDividers);

            divs.clear();

            int count = 0;
            divs.add(a);
            queue.push(a);
            count += counters[a];

            while (!queue.isEmpty()) {
                int d = queue.pop();
                int f = factors[d];

                int c1 = a / d;
                if (divs.add(c1)) {
                    queue.push(c1);
                    count += counters[c1];
                    //log("Removing a/x %s(%s), counter: %s", c1, counters[c1], count);
                }

                if (f > 0) {

                    if (divs.add(f)) {
                        queue.push(f);
                        count += counters[f];
                        //log("Removing factor %s(%s), counter: %s", f, counters[f], result[i]);
                    }

                    int c2 = d / f;
                    if (divs.add(c2)) {
                        queue.push(c2);
                        count += counters[c2];
                        //log("Removing x/f %s(%s), counter: %s", c2, counters[c2], count);
                    }
                    int c3 = a / f;
                    if (divs.add(c3)) {
                        queue.push(c3);
                        count += counters[c3];
                        //log("Removing a/f %s(%s), counter: %s", c3, counters[c3], count);
                    }
                }
                if (count == totalDividers) {
                    queue.clear();
                    break;
                }
            }
            result[i1] = totalDividers - count;
        }
        return result;
    }

    private static void log(String str, Object... params) {
        if (log)
            System.out.printf(str + "\n", params);
    }
}
