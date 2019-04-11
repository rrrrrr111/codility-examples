package ru.roman.task.codility.lessons.a017_dynamic_programming;

import java.util.Arrays;

/**
 * For a given set of denominations, you are asked to find the minimum number of coins with
 * which a given amount of money can be paid. Assume that you can use as many coins of
 * a particular denomination as necessary.
 * <pre>
 * 1 def dynamic_coin_changing(C, k):
 * 2    n = len(C)
 * 4    dp = [[0] * (k + 1) for i in xrange(n + 1)]
 * 5    dp[0] = [0] + [MAX_INT] * k
 * 6    for i in xrange(1, n + 1):
 * 7        for j in xrange(C[i - 1]):
 * 8            dp[i][j] = dp[i - 1][j]
 * 9        for j in xrange(C[i - 1], k + 1):
 * 10           dp[i][j] = min(dp[i][j - C[i - 1]] + 1, dp[i - 1][j])
 * 11   return dp[n]</pre>
 */
public class DynamicCoinChangingLessonTask {

    public static void main(String[] args) {
        int[] C = {1, 3, 4};  // coins
        int k = 6;            // Sum

        twoDimArrayAlg(C, k);
        oneDimArrayAlg(C, k);
    }

    private static void twoDimArrayAlg(int[] coins, int sum) {
        int[][] dp = new int[coins.length + 1][sum + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0] = 0;

        for (int c = 1; c < dp.length; c++) {

            int coin = coins[c - 1];

            for (int idx = 0; idx < coin; idx++) {
                System.out.printf("Prepare for idx:%s, coin %s   ", idx, coin);

                dp[c][idx] = dp[c - 1][idx];

                System.out.println(Arrays.deepToString(dp));
            }
            for (int idx = coin; idx <= sum; idx++) {
                System.out.printf("Calculate for idx:%s, coin %s ", idx, coin);

                dp[c][idx] = Math.min(dp[c][idx - coin] + 1, dp[c - 1][idx]);

                System.out.println(Arrays.deepToString(dp));
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void oneDimArrayAlg(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {

            for (int idx = coin; idx < dp.length; idx++) {
                System.out.printf("Calculate for coin:%s index:%s ", coin, idx);

                dp[idx] = Math.min(dp[idx - coin] + 1, dp[idx]);

                System.out.println(Arrays.toString(dp));
            }
            System.out.println();
        }
        System.out.println();
    }
}