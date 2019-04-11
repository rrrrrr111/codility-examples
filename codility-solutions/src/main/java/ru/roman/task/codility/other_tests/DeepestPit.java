package ru.roman.task.codility.other_tests;

import java.util.Arrays;

/**
 * <div id="brinza-task-description">
 * <p>A non-empty array A consisting of N integers is given. A <i>pit</i> in this array is any triplet of integers (P, Q, R) such that:</p>
 * <blockquote><ul style="margin: 10px;padding: 0px;"><li>0 ≤ P &lt; Q &lt; R &lt; N;</li>
 * <li>sequence [A[P], A[P+1], ..., A[Q]] is strictly decreasing, <br>
 * i.e. A[P] &gt; A[P+1] &gt; ... &gt; A[Q];</li>
 * <li>sequence A[Q], A[Q+1], ..., A[R] is strictly increasing, <br>
 * i.e. A[Q] &lt; A[Q+1] &lt; ... &lt; A[R].</li>
 * </ul>
 * </blockquote><p>The <i>depth</i> of a pit (P, Q, R) is the number <b>min</b>{A[P] − A[Q], A[R] − A[Q]}.</p>
 * <p>For example, consider array A consisting of 10 elements such that:</p>
 * <tt style="white-space:pre-wrap">  A[0] =  0
 * A[1] =  1
 * A[2] =  3
 * A[3] = -2
 * A[4] =  0
 * A[5] =  1
 * A[6] =  0
 * A[7] = -3
 * A[8] =  2
 * A[9] =  3</tt>
 * <p>Triplet (2, 3, 4) is one of pits in this array, because sequence [A[2], A[3]] is strictly decreasing (3 &gt; −2) and sequence [A[3], A[4]] is strictly increasing (−2 &lt; 0). Its depth is <b>min</b>{A[2] − A[3], A[4] − A[3]} = 2. Triplet (2, 3, 5) is another pit with depth 3. Triplet (5, 7, 8) is yet another pit with depth 4. There is no pit in this array deeper (i.e. having depth greater) than 4.</p>
 * <p>Write a function:</p>
 * <blockquote><p style="font-family: monospace; font-size: 9pt; display: block; white-space: pre-wrap"><tt>class Solution { public int solution(int[] A); }</tt></p></blockquote>
 * <p>that, given a non-empty array A consisting of N integers, returns the depth of the deepest pit in array A. The function should return −1 if there are no pits in array A.</p>
 * <p>For example, consider array A consisting of 10 elements such that:</p>
 * <tt style="white-space:pre-wrap">  A[0] =  0
 * A[1] =  1
 * A[2] =  3
 * A[3] = -2
 * A[4] =  0
 * A[5] =  1
 * A[6] =  0
 * A[7] = -3
 * A[8] =  2
 * A[9] =  3</tt>
 * <p>the function should return 4, as explained above.</p>
 * <p>Write an <b><b>efficient</b></b> algorithm for the following assumptions:</p>
 * <blockquote><ul style="margin: 10px;padding: 0px;"><li>N is an integer within the range [<span class="number">1</span>..<span class="number">1,000,000</span>];</li>
 * <li>each element of array A is an integer within the range [<span class="number">−100,000,000</span>..<span class="number">100,000,000</span>].</li>
 * </ul>
 * </blockquote></div>
 */
class DeepestPit {
    public int solution(int[] A) {
        System.out.printf("On input: %s%n", Arrays.toString(A));

        int N = A.length;

        int depth = -1;
        int P, Q, R;
        int i = 0, j, k;
        while (i < N - 2) {
            P = A[i];

            j = i + 1;
            int p = P;
            while (j < N - 1 && A[j] < p) {
                p = A[j++];
            }
            if (j == N - 1) {
                break;
            }
            if (j > i + 1) {
                Q = A[j - 1];
            } else {
                i++;
                continue;
            }
            k = j;
            int q = Q;
            while (k < N && A[k] > q) {
                q = A[k++];
            }

            if (k > j) {
                R = A[k - 1];
                depth = Math.max(depth, Math.min(P - Q, R - Q));
                i = k - 1;
            } else {
                i = j - 1;
            }
        }

        return Math.max(depth, -1);
    }
}
