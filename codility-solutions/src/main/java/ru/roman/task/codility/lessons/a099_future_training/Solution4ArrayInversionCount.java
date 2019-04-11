package ru.roman.task.codility.lessons.a099_future_training;

import java.util.Arrays;
import java.util.Comparator;

/**
 * An array A consisting of N integers is given. An inversion is a pair of indexes (P, Q) such that P < Q and A[Q] < A[P].
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that computes the number of inversions in A, or returns −1 if it exceeds 1,000,000,000.
 * <p>
 * For example, in the following array:
 * <pre>
 * A[0] = -1
 * A[1] =  6
 * A[2] =  3
 * A[3] =  4
 * A[4] =  7
 * A[5] =  4</pre>
 * there are four inversions:
 * <pre>
 * (1,2)  (1,3)  (1,5)  (4,5)</pre>
 * so the function should return 4.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */
class Solution4ArrayInversionCount {
    public int solution(int[] A) {
        System.out.printf("On input: %s%n", Arrays.toString(A));

        if (A.length < 2) {
            return 0;
        }

        return mergeSortAlg(A);
        //return slowAlg(A);
    }

    private int mergeSortAlg(int[] A) {

        long[] invariantCounter = new long[]{0};
        mergeSort(A, invariantCounter);

        return invariantCounter[0] > 1_000_000_000 ? -1 : (int) invariantCounter[0];
    }

    private static int[] mergeSort(int[] arr, long[] counter) {

        int size = arr.length;
        if (size < 2) {
            return arr;
        }

        int mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];

        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, mid, right, 0, right.length);

        left = mergeSort(left, counter);
        right = mergeSort(right, counter);

        return merge(left, right, counter);
    }

    private static int[] merge(int[] left, int[] right, long[] counter) {

        int[] res = new int[left.length + right.length];
        int li = 0, ri = 0, idx = 0;

        while (li < left.length && ri < right.length) {
            if (left[li] <= right[ri]) {
                res[idx++] = left[li++];
            } else {
                counter[0] += left.length - li;
                res[idx++] = right[ri++];
            }
        }
        while (li < left.length) {
            res[idx++] = left[li++];
        }
        while (ri < right.length) {
            counter[0] += left.length - li;
            res[idx++] = right[ri++];
        }
        return res;
    }

    private int slowAlg(int[] A) {
        int[][] sorted = new int[A.length][2];
        for (int i = 0; i < A.length; i++) {
            sorted[i][0] = i;
            sorted[i][1] = A[i];
        }
        Arrays.sort(sorted, Comparator.comparingInt(e -> e[1]));

        int count = 0;
        for (int i = 0; i < sorted.length; i++) {
            int b = i - 1;
            while (b >= 0) {
                if (sorted[b][0] > sorted[i][0]) {
                    count++;
                }
                b--;
            }
            if (count > 1_000_000_000) {
                return -1;
            }
        }
        return count;
    }
}
