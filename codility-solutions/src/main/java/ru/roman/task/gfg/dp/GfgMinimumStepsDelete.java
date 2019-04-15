package ru.roman.task.gfg.dp;

import java.util.Arrays;

/**
 * Given a string str. You are allowed to delete only some contiguous characters if all the characters are same in a single operation. The task is to find the minimum number of operations required to completely delete the string.
 */
class GfgMinimumStepsDelete {
    int test(String str) {
        System.out.printf("On input: %s%n", str);

        int[][] dp = new int[10][10];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        return recursiveAlg1(0, str.length() - 1, dp, str);
    }

    private int recursiveAlg1(int from, int to, int[][] dp, String str) {

        if (from > to) return 0;
        if (from == to) return 1;
        if (dp[from][to] != -1) return dp[from][to];

        // When a single character is deleted
        int res = 1 + recursiveAlg1(from + 1, to, dp, str);

        // When a group of consecutive characters are deleted if any of them matches
        for (int i = from + 1; i <= to; ++i) {

            // When both the characters are same then delete the letters in between them
            if (str.charAt(from) == str.charAt(i)) {
                res = Math.min(res,
                        recursiveAlg1(from + 1, i - 1, dp, str) + recursiveAlg1(i, to, dp, str)
                );
            }
        }
        return dp[from][to] = res;
    }
}
