package ru.roman.task.codility.other_tests;

import java.util.Arrays;

/**
 * <div class="task-description-content task-description__TaskContentWrapper-sc-380ibo-1 iVZZWO">
 * <p>
 * <meta http-equiv="content-type" content="text/html; charset=utf-8">
 *
 *
 * <div id="brinza-task-description">
 * <p>Arrays A and B consisting of N non-negative integers are given. Together, they represent N real numbers, denoted as C[0], ..., C[N−1]. Elements of A represent the integer parts and the corresponding elements of B (divided by 1,000,000) represent the fractional parts of the elements of C. More formally, A[I] and B[I] represent C[I] = A[I] + B[I] / 1,000,000.</p>
 * <p>For example, consider the following arrays A and B:</p>
 * <pre>
 * A[0] = 0 B[0] = 500,000
 * A[1] = 1 B[1] = 500,000
 * A[2] = 2 B[2] = 0
 * A[3] = 2 B[3] = 0
 * A[4] = 3 B[4] = 0
 * A[5] = 5 B[5] = 20,000
 * </pre>
 * <p>They represent the following real numbers:</p>
 * <tt style="white-space:pre-wrap">
 * C[0] = 0.5
 * C[1] = 1.5
 * C[2] = 2.0
 * C[3] = 2.0
 * C[4] = 3.0
 * C[5] = 5.02</tt>
 * <p>A pair of indices (P, Q) is <i>multiplicative</i> if 0 ≤ P &lt; Q &lt; N and C[P] * C[Q] ≥ C[P] + C[Q].</p>
 * <p>The above arrays yield the following multiplicative pairs:</p>
 * <blockquote><ul style="margin: 10px;padding: 0px;"><li>(1, 4), because 1.5 * 3.0 = 4.5 ≥ 4.5 = 1.5 + 3.0,</li>
 * <li>(1, 5), because 1.5 * 5.02 = 7.53 ≥ 6.52 = 1.5 + 5.02,</li>
 * <li>(2, 3), because 2.0 * 2.0 = 4.0 ≥ 4.0 = 2.0 + 2.0,</li>
 * <li>(2, 4) and (3, 4), because 2.0 * 3.0 = 6.0 ≥ 5.0 = 2.0 + 3.0.</li>
 * <li>(2, 5) and (3, 5), because 2.0 * 5.02 = 10.04 ≥ 7.02 = 2.0 + 5.02.</li>
 * <li>(4, 5), because 3.0 * 5.02 = 15.06 ≥ 8.02 = 3.0 + 5.02.</li>
 * </ul>
 * </blockquote><p>Write a function:</p>
 * <blockquote><p style="font-family: monospace; font-size: 9pt; display: block; white-space: pre-wrap"><tt>class Solution { public int solution(int[] A, int[] B); }</tt></p></blockquote>
 * <p>that, given arrays A and B, each containing N non-negative integers, returns the number of multiplicative pairs of indices.</p>
 * <p>If the number of multiplicative pairs is greater than 1,000,000,000, the function should return 1,000,000,000.</p>
 * <p>For example, given:</p>
 * <tt style="white-space:pre-wrap">  A[0] = 0	B[0] = 500,000
 * A[1] = 1	B[1] = 500,000
 * A[2] = 2	B[2] = 0
 * A[3] = 2	B[3] = 0
 * A[4] = 3	B[4] = 0
 * A[5] = 5	B[5] = 20,000</tt>
 * <p>the function should return 8, as explained above.</p>
 * <p>Write an <b><b>efficient</b></b> algorithm for the following assumptions:</p>
 * <blockquote><ul style="margin: 10px;padding: 0px;"><li>N is an integer within the range [<span class="number">0</span>..<span class="number">100,000</span>];</li>
 * <li>each element of array A is an integer within the range [<span class="number">0</span>..<span class="number">1,000</span>];</li>
 * <li>each element of array B is an integer within the range [<span class="number">0</span>..<span class="number">999,999</span>];</li>
 * <li>real numbers created from arrays are sorted             in non-decreasing order.</li>
 * </ul>
 * </blockquote></div>
 * <div style="margin-top:5px">
 * </div>
 * </div>
 */
class CountMultiplicativePairs {

    public int solution(int[] A, int[] B) {
        System.out.printf("On input: %s %s%n", Arrays.toString(A), Arrays.toString(B));

        final int length = A.length;
        if (length < 2)
            return 0;

        CustomPredicate searchPredicate = (int[] a, int[] b, int i, int mid) -> {

            long p = (a[i] * 1_000_000L + b[i]) * (a[mid] * 1_000_000L + b[mid]);
            long product;
            if (a[i] != 0 || a[mid] != 0) {
                product = p / 1_000_000L;
            } else {
                product = p;
            }
            long sum = a[i] * 1_000_000L + a[mid] * 1_000_000L + b[i] + b[mid];

            //  System.out.printf("Usual search indexes %s, %s  ->  prod: %s, sum: %s  :  res %s%n", i, mid, product, sum, res);
            return product >= sum;
        };

        long count = 0;
        for (int i = 0; i < length; i++) {

            if (A[i] == 0 && B[i] == 0) {

                int idx = binarySearchOfLastZero(A, B, i + 1, length - 1);
                if (idx > 0)
                    count += idx - i;

            } else {

                int idx = binarySearchLessOrEq(A, B, i, i + 1, length - 1, searchPredicate);
                if (idx > 0)
                    count += length - idx;
            }
            if (count > 1_000_000_000) return 1_000_000_000;
        }

        return (int) count;
    }


    private static int binarySearchLessOrEq(int[] a, int[] b, int i,
                                            int fromIdx, int toIdx, CustomPredicate predicate) {

        int beg = fromIdx, end = toIdx;
        int res = -1;
        for (int mid; beg <= end; ) {
            mid = (beg + end) / 2;
            if (predicate.test(a, b, i, mid)) {
                res = mid;
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return res;
    }

    private static int binarySearchOfLastZero(int[] a, int[] b,
                                              int fromIdx, int toIdx) {
        int beg = fromIdx, end = toIdx;
        int res = -1;
        for (int mid; beg <= end; ) {

            mid = (beg + end) / 2;
            if (a[mid] == 0 && b[mid] == 0) {
                res = mid;
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
            //  System.out.printf("Zero search from %s to %s  ->  mid: %s, res: %s%n", fromIdx, toIdx, mid, res);
        }
        return res;
    }

    @FunctionalInterface
    private interface CustomPredicate {
        boolean test(int[] a, int[] b, int i, int idx);
    }
}
