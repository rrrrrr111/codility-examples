package ru.roman.task.codility.lessons.a009_maximum_slice;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 * <p>
 * The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
 * <p>
 * For example, array A such that:
 * <pre>
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2</pre>
 * contains the following example double slices:
 * <pre>
 * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
 * double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
 * double slice (3, 4, 5), sum is 0.</pre>
 * The goal is to find the maximal sum of any double slice.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.
 * <p>
 * For example, given:
 * <pre>
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2</pre>
 * the function should return 17, because no double slice of array A has a sum of greater than 17.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */
class Solution3MaxDoubleSliceSum {
    public int solution(int[] A) {
        System.out.printf("On input: %s\n", Arrays.toString(A));

        int[] pref = new int[A.length];
        int[] suff = new int[A.length];

        for (int i = 1; i < A.length - 1; i++) {

            pref[i] = Math.max(0, A[i] + pref[i - 1]);
            suff[A.length - i - 1] = Math.max(0, A[A.length - i - 1] + suff[A.length - i]);
        }

        System.out.printf("Pref    : %s\n", Arrays.toString(pref));
        System.out.printf("Suff    : %s\n", Arrays.toString(suff));

        int max = 0;
        for (int i = 1; i < A.length - 1; i++) {

            max = Math.max(max, pref[i - 1] + suff[i + 1]);
        }
        return max;
    }
}
