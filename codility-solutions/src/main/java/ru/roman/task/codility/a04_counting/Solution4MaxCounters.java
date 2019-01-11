package ru.roman.task.codility.a04_counting;

import java.util.Arrays;

/**
 * You are given N counters, initially set to 0, and you have two possible operations on them:
 * <p>
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * A non-empty array A of M integers is given. This array represents consecutive operations:
 * <p>
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * For example, given integer N = 5 and array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * the values of the counters after each consecutive operation will be:
 * <p>
 * (0, 0, 1, 0, 0)
 * (0, 0, 1, 1, 0)
 * (0, 0, 1, 2, 0)
 * (2, 2, 2, 2, 2)
 * (3, 2, 2, 2, 2)
 * (3, 2, 2, 3, 2)
 * (3, 2, 2, 4, 2)
 * The goal is to calculate the value of every counter after all operations.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int N, int[] A); }
 * <p>
 * that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.
 * <p>
 * Result array should be returned as an array of integers.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * the function should return [3, 2, 2, 4, 2], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N and M are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..N + 1].
 */
class Solution4MaxCounters {
    public int[] solution(int N, int[] A) {
        System.out.println("On input: " + Arrays.toString(A) + " N=" + N);

        int[] res = new int[N];
        int max = 0;
        int min = 0;

        for (int a : A) {
            if (a == N + 1) {
                min = max;
            } else {
                int i = a - 1;

                if (res[i] < min) {
                    res[i] = min;
                }
                res[i]++;
                max = Math.max(max, res[i]);
            }
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] < min) {
                res[i] = min;
            }
        }
        return res;
    }
}
