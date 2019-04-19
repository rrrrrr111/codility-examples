package ru.roman.task.gfg.dp;

/**
 * Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will cause the eggs to break on landing. We make a few assumptions:
 * <p>
 * …..An egg that survives a fall can be used again.
 * …..A broken egg must be discarded.
 * …..The effect of a fall is the same for all eggs.
 * …..If an egg breaks when dropped, then it would break if dropped from a higher floor.
 * …..If an egg survives a fall then it would survive a shorter fall.
 * …..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.
 * <p>
 * If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out in only one way. Drop the egg from the first-floor window; if it survives, drop it from the second floor window. Continue upward until it breaks. In the worst case, this method may require 36 droppings. Suppose 2 eggs are available. What is the least number of egg-droppings that is guaranteed to work in all cases?
 * The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be dropped so that total number of trials are minimized.
 */
class GfgEggDropPuzzle {

    int test(int n, int k) {

        //return recursiveAlg(n, k);
        return dpAlg(n, k);
    }

    private int recursiveAlg(int n, int k) {
        // If there are no floors, then no trials needed. OR if there is one floor, one trial needed.
        if (k == 1 || k == 0)
            return k;

        // We need k trials for one egg and k floors
        if (n == 1)
            return k;

        int min = Integer.MAX_VALUE;
        int x, res;

        // Consider all droppings from 1st floor to kth floor and return the minimum of these values plus 1.
        for (x = 1; x <= k; x++) {
            res = Math.max(recursiveAlg(n - 1, x - 1), recursiveAlg(n, k - x));
            if (res < min) min = res;
        }

        return min + 1;
    }

    private int dpAlg(int n, int k) {
        System.out.printf("On input: %s %s%n", n, k);

        /* A 2D table where entery dp[i][j] will represent minimum number of trials needed for i eggs and j floors. */
        int[][] dp = new int[n + 1][k + 1];
        int res;
        int i, j, x;


        for (i = 1; i <= n; i++) {          // We need one trial for one floor and 0 trials for 0 floors
            dp[i][1] = 1;
            dp[i][0] = 0;
        }


        for (j = 1; j <= k; j++)          // We always need j trials for one egg and j floors.
            dp[1][j] = j;

        // Fill rest of the entries in table using optimal substructure
        // property
        for (i = 2; i <= n; i++) {
            for (j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                for (x = 1; x <= j; x++) {
                    res = 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]);
                    if (res < dp[i][j])
                        dp[i][j] = res;
                }
            }
        }
        return dp[n][k];
    }
}
