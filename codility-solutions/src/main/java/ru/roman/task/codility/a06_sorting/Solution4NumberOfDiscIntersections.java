package ru.roman.task.codility.a06_sorting;

import java.util.Arrays;

/**
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N
 * non-negative integers, specifying the radiuses of the discs, is given. The J-th disc
 * is drawn with its center at (J, 0) and radius A[J].
 * <p>
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th
 * discs have at least one common point (assuming that the discs contain their borders).
 * <p>
 * The figure below shows discs drawn for N = 6 and A as follows:
 * <p>
 * A[0] = 1
 * A[1] = 5
 * A[2] = 2
 * A[3] = 1
 * A[4] = 4
 * A[5] = 0
 * <p>
 * <p>
 * There are eleven (unordered) pairs of discs that intersect, namely:
 * <p>
 * discs 1 and 4 intersect, and both intersect with all the other discs;
 * disc 2 also intersects with discs 0 and 3.
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A describing N discs as explained above, returns the number of
 * (unordered) pairs of intersecting discs. The function should return −1 if the number
 * of intersecting pairs exceeds 10,000,000.
 * <p>
 * Given array A shown above, the function should return 11, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..2,147,483,647].
 */
class Solution4NumberOfDiscIntersections {
    public int solution(int[] A) {
        System.out.printf("On input: %s\n", Arrays.toString(A));

        int[] plus = new int[A.length + 1];
        int[] minus = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            long a = A[i];

            long stepBack = i - a;
            long stepForward = i + a + 1;
            int plusIndex = stepBack < 0 ? 0 : (int) stepBack;
            int minusIndex = stepForward > A.length ? A.length : (int) stepForward;

            plus[plusIndex]++;
            minus[minusIndex]--;
        }
        System.out.printf("Plus   : %s\n", Arrays.toString(plus));
        System.out.printf("Minus  : %s\n", Arrays.toString(minus));

        int[] d = new int[plus.length];
        long[] s = new long[plus.length];

        int disks = 0;
        long intersections = 0;
        for (int i = 0; i < plus.length - 1; i++) {
            disks += minus[i];

            if (plus[i] > 0) {
                intersections += disks == 0
                        ? countIntersectionsFor(plus[i])
                        : (
                        disks == 1
                                ? countIntersectionsFor(plus[i] + 1)
                                : plus[i] * disks);
            }
            disks += plus[i];

            if (intersections > Integer.MAX_VALUE) {
                return -1;
            }

            d[i] = disks;
            s[i] = intersections;
        }
        System.out.printf("Disks  : %s\n", Arrays.toString(d));
        System.out.printf("Count  : %s\n", Arrays.toString(s));

        return (int) intersections;
    }

    private long countIntersectionsFor(int i) {
        int count = 0;
        for (int j = 2; j <= i; j++) {
            count += j - 1;
        }
        return count;
    }
}