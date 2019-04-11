package ru.roman.task.codility.other_tests;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import static java.math.BigDecimal.valueOf;

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
 * A[0] = 0	B[0] = 500,000
 * A[1] = 1	B[1] = 500,000
 * A[2] = 2	B[2] = 0
 * A[3] = 2 B[3] = 0
 * A[4] = 3	B[4] = 0
 * A[5] = 5	B[5] = 20,000
 * </pre>
 * <p>They represent the following real numbers:</p>
 * <tt style="white-space:pre-wrap">  C[0] = 0.5
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
        System.out.printf("On input: %s%n", Arrays.toString(A));

        if (A.length < 2 || B.length < 2)
            return 0;

        BigDecimal[] C = new BigDecimal[A.length];

        for (int i = 0; i < A.length; i++) {
            C[i] = valueOf(A[i]).add((valueOf(B[i])
                    .divide(valueOf(1_000_000L), 1_000_000, RoundingMode.HALF_UP)));
            System.out.println(C[i]);
        }

        long count = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (C[i].compareTo(valueOf(2.0)) >= 0
                    && C[i + 1].compareTo(valueOf(2.0)) >= 0) {

                count += ((A.length - 1 - i) * (A.length - i)) / 2;

                i = A.length;
            } else {
                for (int j = i + 1; j < A.length; j++) {

                    if ((C[i].multiply(C[j])).compareTo(C[i].add(C[j])) >= 0) {
                        count++;
                        //System.out.println(C[i]+"---"+C[j]);
                    }
                }
            }
        }

        if (count > 1_000_000_000)
            return 1_000_000_000;

        return (int) count;
    }
}
