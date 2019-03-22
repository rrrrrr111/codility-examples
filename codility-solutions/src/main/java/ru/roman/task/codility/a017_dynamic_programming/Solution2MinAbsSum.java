package ru.roman.task.codility.a017_dynamic_programming;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * For a given array A of N integers and a sequence S of N integers from the set {−1, 1}, we define val(A, S) as follows:
 * <p>
 * val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|
 * <p>
 * (Assume that the sum of zero elements equals zero.)
 * <p>
 * For a given array A, we are looking for such a sequence S that minimizes val(A,S).
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, computes the minimum value of val(A,S) from all possible values of val(A,S) for all possible sequences S of N integers from the set {−1, 1}.
 * <p>
 * For example, given array:
 * <pre>
 * A[0] =  1
 * A[1] =  5
 * A[2] =  2
 * A[3] = -2</pre>
 * your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..20,000];
 * each element of array A is an integer within the range [−100..100].
 */
class Solution2MinAbsSum {
    /**
     * https://codility.com/media/train/solution-min-abs-sum.pdf
     */
    public int solution(int[] A) {
        System.out.printf("On input: %s%n", Arrays.toString(A));

        if (A.length == 0) {
            return 0;
        }

        //return slowAlg(A);           // O(A^2 * 100)
        return fastAlg(A);             // O(A * (100^2))
    }

    private int fastAlg(int[] A) {

        int[] counters = new int[101];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            A[i] = Math.abs(A[i]);
            counters[A[i]]++;
            sum += A[i];
        }

        int[] dp = new int[sum];

        Arrays.fill(dp, -1);
        dp[0] = 0;
        System.out.printf(">>          %s%n", Arrays.toString(dp));
        for (int a = 1; a < counters.length; a++)
            if (counters[a] > 0)
                for (int se = 0; se < dp.length; se++) {
                    if (dp[se] >= 0)
                        dp[se] = counters[a];
                    else if (se >= a && dp[se - a] > 0)
                        dp[se] = dp[se - a] - 1;
                    System.out.printf(">> a:%s, se:%s %s%n", a, se, Arrays.toString(dp));
                }

        int res = sum;
        for (int i = 0; i < sum / 2 + 1; i++)
            if (dp[i] >= 0)
                res = Math.min(res, sum - 2 * i);
        return res;
    }

    private int slowAlg(int[] A) {
        int sum = Stream.iterate(0, i -> i + 1)
                .mapToInt(i -> i)
                .limit(A.length)
                .map(i -> A[i] = Math.abs(A[i]))
                .sum();

        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;
        for (int a : A)
            for (int i = dp.length - 1; i >= 0; i--)
                if (dp[i] && i + a <= sum) {
                    dp[i + a] = true;
                }

        int res = sum;
        for (int i = 0; i < sum / 2 + 1; i++)
            if (dp[i])
                res = Math.min(res, sum - 2 * i);
        return res;
    }
}
