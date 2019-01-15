package ru.roman.task.codility.a05_prefix_sum;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * contains the following example slices:
 * <p>
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is minimal.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * the function should return 1, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */
class Solution3MinAvgTwoSlice {
    public int solution(int[] A) {
        System.out.println("On input: " + Arrays.toString(A));

        int minIndex = 0;
        double minSumm = (A[0] + A[1]) / 2d,
                summ;


        for (int i = 0; i < A.length - 1; i++) {
            int a0 = A[i];
            int a1 = A[i + 1];

            summ = (a0 + a1) / 2d;

            if (summ < minSumm) {
                minSumm = summ;
                minIndex = i;
            }

            if (i < A.length -2) {
                int a2 = A[i + 2];
                summ = (a0 + a1 + a2) / 3d;

                if (summ < minSumm) {
                    minSumm = summ;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
}
