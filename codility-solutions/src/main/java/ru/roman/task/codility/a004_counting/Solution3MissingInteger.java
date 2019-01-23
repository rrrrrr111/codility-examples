package ru.roman.task.codility.a004_counting;

import java.util.Arrays;

/**
 * This is a demo task.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
class Solution3MissingInteger {
    public int solution(int[] A) {
        System.out.println("On input: " + Arrays.toString(A));

        int[] counters = transformToCounters(A);

        for (int i = 1; i < counters.length; i++) {
            int counter = counters[i];
            if (counter == 0) {
                return i;
            }
        }
        return 0;
    }


    private int[] transformToCounters(int[] A) {
        int[] counters = new int[1_000_001];
        for (int a : A) {
            if (a < 1) {
                continue;
            }
            counters[a]++;
        }
        return counters;
    }
}
