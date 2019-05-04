package ru.roman.task.codility.other_tests.arrays;

import java.util.Arrays;

/**
 * <div id="brinza-task-description">
 * <p>Integer V <i>lies strictly</i> between integers U and W if U &lt; V &lt; W or if U &gt; V &gt; W.</p>
 * <p>A non-empty array A consisting of N integers is given. A pair of indices (P, Q), where 0 ≤ P &lt; Q &lt; N, is said to <i>have adjacent values</i> if no value in the array lies strictly between values A[P] and A[Q].</p>
 * <p>For example, in array A such that:</p>
 * <pre style="white-space:pre-wrap">
 * A[0] = 0
 * A[1] = 3
 * A[2] = 3
 * A[3] = 7
 * A[4] = 5
 * A[5] = 3
 * A[6] = 11
 * A[7] = 1</pre>
 * <p>the following pairs of indices have adjacent values:</p>
 * <pre style="white-space:pre-wrap">
 * (0, 7),   (1, 2),   (1, 4),
 * (1, 5),   (1, 7),   (2, 4),
 * (2, 5),   (2, 7),   (3, 4),
 * (3, 6),   (4, 5),   (5, 7).</pre>
 * <p>For example, indices 4 and 5 have adjacent values because there is no value in array A that lies strictly between A[4] = 5 and A[5] = 3; the only such value could be the number 4, and it is not present in the array.</p>
 * <p>Given two indices P and Q, their <i>distance</i> is defined as abs(A[P] − A[Q]), where abs(X) = X for X ≥ 0, and abs(X) = −X for X &lt; 0. For example, the distance between indices 4 and 5 is 2 because (A[4] − A[5]) = (5 − 3) = 2.</p>
 * <p>Write a function:</p>
 * <blockquote><p style="font-family: monospace; font-size: 9pt; display: block; white-space: pre-wrap"><tt>class Solution { public int solution(int[] A); }</tt></p></blockquote>
 * <p>that, given a non-empty array A consisting of N integers, returns the minimum distance between indices of this array that have adjacent values. The function should return −1 if the minimum distance is greater than 100,000,000. The function should return −2 if no adjacent indices exist.</p>
 * <p>For example, given array A such that:</p>
 * <pre style="white-space:pre-wrap">
 * A[0] =  0
 * A[1] =  3
 * A[2] =  3
 * A[3] =  7
 * A[4] =  5
 * A[5] =  3
 * A[6] = 11
 * A[7] =  1</pre>
 * <p>the function should return 0 because:</p>
 * <blockquote><ul style="margin: 10px;padding: 0px;"><li>indices 1 and 2 are adjacent, because the array does not contain any value that lies strictly between A[1] = 3 and A[2] = 3;</li>
 * <li>the distance between these indices is (A[1] − A[2]) = (3 − 3) = 0;</li>
 * <li>no other pair of adjacent indices that has smaller distance exists.</li>
 * </ul>
 * </blockquote><p>Write an <b><b>efficient</b></b> algorithm for the following assumptions:</p>
 * <blockquote><ul style="margin: 10px;padding: 0px;"><li>N is an integer within the range [<span class="number">1</span>..<span class="number">40,000</span>];</li>
 * <li>each element of array A is an integer within the range [<span class="number">−2,147,483,648</span>..<span class="number">2,147,483,647</span>].</li>
 * </ul>
 * </blockquote></div>
 */
class AdjacentValues {
    public int solution(int[] A) {

        System.out.printf("On input: %s%n", Arrays.toString(A));
        if (A.length < 2)
            return -2;

        Arrays.sort(A);

        long minDist = Long.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {

            long dist = Math.abs((long) A[i] - A[i + 1]);
            minDist = Math.min(minDist, dist);
        }

        return minDist > 100_000_000 ? -1 : (int) minDist;
    }
}
