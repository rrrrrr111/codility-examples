package ru.roman.task.codility.a03_time_complexity;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
 * <p>
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * <p>
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * <p>
 * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * We can split this tape in four places:
 * <p>
 * P = 1, difference = |3 − 10| = 7
 * P = 2, difference = |4 − 9| = 5
 * P = 3, difference = |6 − 7| = 1
 * P = 4, difference = |10 − 3| = 7
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * the function should return 1, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 */
class Solution3TypeEquilibrium {
    public int solution(int[] A) {

        System.out.println("On input: " + Arrays.toString(A));

        final int[] s = new int[A.length - 1], r = new int[A.length - 1];
        int sp = 0, rp = 0;

        for (int i = 0; i < A.length - 1; i++) {
            s[i] = sp + A[i];
            sp = s[i];

            r[i] = rp + A[A.length - i - 1];
            rp = r[i];
        }

        System.out.println("Straight sums : " + Arrays.toString(s));
        System.out.println("Revers sums : " + Arrays.toString(r));

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < s.length; i++) {
            int sv = s[i];
            int rv = r[s.length - i - 1];
            int diff = Math.abs(sv - rv);

            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}
