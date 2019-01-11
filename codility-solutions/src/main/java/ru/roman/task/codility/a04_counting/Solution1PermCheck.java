package ru.roman.task.codility.a04_counting;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * is a permutation, but array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * is not a permutation, because value 2 is missing.
 * <p>
 * The goal is to check whether array A is a permutation.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * the function should return 1.
 * <p>
 * Given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * the function should return 0.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 */
class Solution1PermCheck {
    public int solution(int[] A) {
        System.out.println("On input: " + Arrays.toString(A));

        int smallest = findSmallest(A);
        int[] counters = new int[A.length];
        for (int a : A) {
            int val = a - smallest;
            if (val > A.length - 1) {
                return 0;
            }
            counters[val]++;
            if (counters[val] > 1) {
                return 0;
            }
        }
        return 1;
    }

    private int findSmallest(int[] A) {
        int s = Integer.MAX_VALUE;
        for (int a : A) {
            s = Math.min(a, s);
        }
        return s;
    }
}
