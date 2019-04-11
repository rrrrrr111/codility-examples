package ru.roman.task.codility.lessons.a100_other_сhallenges;

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
class Solution1MissingInteger {
    public int solution(int[] A) {

        Arrays.sort(A);
        //System.out.println("On input: " + Arrays.toString(A));

        int prev = A[0];
        if (prev > 1) {
            return 1;
        }

        Integer val = null;
        for (int i = 1; i < A.length; i++) {
            int a = A[i];

            if (a > 1) {
                int diff = a - prev;
                if (diff > 1) {
                    val = prev + 1;
                    if (val < 1) {
                        val = 1;
                    }
                    break;
                }
            }
            prev = a;
        }
        if (val != null) {
            return val;
        }
        val = A[A.length - 1] + 1;

        if (val < 1) {
            val = 1;
        }
        return val;
    }
}
