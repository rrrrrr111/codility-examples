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
public class CoinChangingProblem {

    public static void main(String[] args) {
        int coins[] = {3, 7}, sum = 17;
        //int coins[] = {1, 3, 4}, sum = 6;

        //int res = recursiveAlg(coins, sum);
        //int res = dpAlg1(coins, sum);
        int res = dpAlg2(coins, sum);
        System.out.println(res);
    }

    /**
     * Поиск min кол-ва монет для сдачи, а не кол-ва вариантов монет для набора сдачи
     */
    static int recursiveAlg(int[] coins, int sum) {
        if (sum == 0) return 0;

        int min = -1;
        for (int coin : coins) {
            if (sum >= coin) {
                int res = recursiveAlg(coins, sum - coin) + 1;   // we are looking for some min count which can be collected
                if (res != -1) {                                       // without current coin
                    min = min == -1 ? res : Math.min(min, res);       //  -1 if sum cannot be collected by given coins
                }
            }
        }
        return min;
    }

    private static int dpAlg1(int[] coins, int sum) {
        int[][] dp = new int[coins.length + 1][sum + 1];  // the matrix contains min count of coins needed to get the sum
        Arrays.fill(dp[0], -1);                       // if some sum can not be calculated by given coins we preserve -1
                                                          // every row for the coin also contains min count derived by prev coins
        dp[0][0] = 0;                      // basic value for convenience

        for (int cIdx = 1; cIdx < dp.length; cIdx++) {

            int coin = coins[cIdx - 1];                   // just iterating coins

            for (int sIdx = 0; sIdx < coin; sIdx++) {     // The sums which is less then current count we fill by values for prev coins
                                                          // so this sums can be collected only using previous coins

                int prevMinorCoinsMinCount = dp[cIdx - 1][sIdx];
                System.out.printf("Prepare min count for coin %s value [%s, %s] = %s from prev row%n", coin, cIdx, sIdx, prevMinorCoinsMinCount);

                dp[cIdx][sIdx] = prevMinorCoinsMinCount;          // this values will be used for further calculations
            }
            System.out.println(matrixToString(dp, 2));

            for (int sIdx = coin; sIdx <= sum; sIdx++) {
                System.out.printf("Calculate for sIdx:%s, coin %s%n", sIdx, coin);
                dp[cIdx][sIdx] = Math.min(
                        dp[cIdx][sIdx - coin] + 1,    // +1 - current coin plus
                                                      // value collected by minor coins prepared in previous loop or
                                                      // some value collected previously in this loop
                        dp[cIdx - 1][sIdx] == -1         // or min count collected by previous minor coins, indeed it could be more optimal
                                ? Integer.MAX_VALUE      // we avoid the case there it was not calculated due to lack of suitable coins
                                : dp[cIdx - 1][sIdx]
                );
            }
            System.out.println(matrixToString(dp, 2));
        }
        return dp[coins.length][sum];
    }

    private static int dpAlg2(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int coin : coins) {                                 // hire we use one dimension array, we preserve all calculations in one row
             for (int idx = coin; idx < dp.length; idx++) {        // and we fray through old value just after comparing it with
                                                                   // new calculated count, if new count more optimal then
                System.out.printf("Calculate for coin:%s index:%s%n", coin, idx);     // count collected by previous minor coins
                 int minCount = dp[idx - coin];           // min coins count for the sum = sum - current coin
                 dp[idx] = Math.min(
                        minCount + 1,
                        dp[idx] == -1
                                ? Integer.MAX_VALUE
                                : dp[idx]
                 );
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[sum];
    }

    private static String matrixToString(int[][] matrix, int leftPad) {
        StringBuilder b = new StringBuilder("  [");
        for (int[] arr : matrix) {
            if (b.length() == 3) b.append("[");
            else b.append("   [");

            for (int a : arr) {
                String str = String.valueOf(a);
                for (int i = 1; str.length() + i <= leftPad; i++)
                    b.append(" ");
                b.append(str)
                        .append(", ");
            }

            b.delete(b.length() - 2, b.length())
                    .append("]").append(System.lineSeparator());
        }
        b.delete(b.length() - System.lineSeparator().length(), b.length()).append("]");
        return b.toString();
    }
}