package ru.roman.task.gfg.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. Also given an integer W which represents knapsack capacity, find out the items such that sum of the weights of those items of given subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 * <p>
 * Prerequisite : 0/1 Knapsack
 * <p>
 * Examples :
 * <p>
 * Input : val[] = {60, 100, 120};
 * wt[] = {10, 20, 30};
 * W = 50;
 * Output : 220 //maximum value that can be obtained
 * 30 20 //weights 20 and 30 are included.
 * <p>
 * Input : val[] = {40, 100, 50, 60};
 * wt[] = {20, 10, 40, 30};
 * W = 60;
 * Output : 200
 * 30 20 10
 */
class GfgKnapsackProblem {

    String test(int Iv[], int Iw[], int W) {
        return alg0Recursive(Iv, Iw, W, Iv.length) + "";
        //return alg1Dp(Iv, Iw, W);
    }

    /**
     * Базовый рекурсивный подход O(2^n)
     */
    private static int alg0Recursive(int[] Iv, int[] Iw, int W, int itemIdx) {
        if (itemIdx == 0 || W == 0)
            return 0;

        if (Iw[itemIdx - 1] > W)
            return alg0Recursive(Iv, Iw, W, itemIdx - 1);

        else return Math.max(
                Iv[itemIdx - 1] + alg0Recursive(Iv, Iw, W - Iw[itemIdx - 1], itemIdx - 1),  // предмет в рюкзаке
                alg0Recursive(Iv, Iw, W, itemIdx - 1) // предмет не в рюкзаке
        );
    }

    private String alg1Dp(int[] Iv, int[] Iw, int W) {
        int i, w;
        int[][] K = new int[Iw.length + 1][W + 1];

        for (i = 0; i <= Iv.length; i++) {
            for (w = 0; w <= W; w++) {

                if (i == 0 || w == 0)
                    K[i][w] = 0;

                else if (Iw[i - 1] <= w)
                    K[i][w] = Math.max(Iv[i - 1] + K[i - 1][w - Iw[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        int res = K[Iv.length][W];
        final List<Integer> items = new ArrayList<>();
        final String result = res + "";

        w = W;
        for (i = Iw.length; i > 0 && res > 0; i--) {

            // either the result comes from the top K[i-1][w] or from Iv[i-1] + K[i-1][w-Iw[i-1]]
            // as in Knapsack table. If it comes from the latter one/ it means the item is included.
            if (res == K[i - 1][w])
                continue;
            else {
                // This item is included.
                items.add(Iw[i - 1]);

                // Since this weight is included its value is deducted
                res = res - Iv[i - 1];
                w = w - Iw[i - 1];
            }
        }

        Collections.sort(items);
        return result + " " + items;
    }
}