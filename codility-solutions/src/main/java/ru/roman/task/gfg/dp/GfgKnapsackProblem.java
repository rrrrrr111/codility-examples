package ru.roman.task.gfg.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
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
        //return alg0Recursive(Iv, Iw, W, Iv.length) + "";
        //return alg1Dp(Iv, Iw, W);


        return alg3UsingBranchAndBound(W, Iv, Iw);
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

    /**
     * O(n*W)
     */
    private String alg1Dp(int[] Iv, int[] Iw, int W) {
        int i, w;
        int[][] dp = new int[Iw.length + 1][W + 1];

        for (i = 0; i <= Iv.length; i++) {
            for (w = 0; w <= W; w++) {

                if (i == 0 || w == 0)
                    dp[i][w] = 0;

                else if (Iw[i - 1] <= w)
                    dp[i][w] = Math.max(Iv[i - 1] + dp[i - 1][w - Iw[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        int res = dp[Iv.length][W];
        final List<Integer> items = new ArrayList<>();
        final String result = res + "";

        w = W;
        for (i = Iw.length; i > 0 && res > 0; i--) {

            // either the result comes from the top dp[i-1][w] or from Iv[i-1] + dp[i-1][w-Iw[i-1]]
            // as in Knapsack table. If it comes from the latter one/ it means the item is included.
            if (res == dp[i - 1][w])
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

    private String alg3UsingBranchAndBound(int W, int[] Iv, int[] Iw) {

        Item[] arr = new Item[Iv.length];
        int n = arr.length;

        for (int i = 0; i < Iv.length; i++) {
            arr[i] = new Item();
            arr[i].value = Iv[i];
            arr[i].weight = Iw[i];
        }

        Arrays.sort(arr, (a, b) -> {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r1, r2);
        });

        // make a queue for traversing the node
        Deque<Node> queue = new LinkedList<>();
        Node u = new Node(), v = new Node();

        // dummy node at starting
        u.level = -1;
        u.profit = u.weight = 0;
        queue.push(u);

        // One by one extract an item from decision tree
        // compute profit of all children of extracted item
        // and keep saving maxProfit
        float maxProfit = 0;
        while (!queue.isEmpty()) {
            u = queue.getFirst();
            queue.pop();

            // If it is starting node, assign level 0
            if (u.level == -1)
                v.level = 0;

            // If there is nothing on next level
            if (u.level == n - 1)
                continue;

            // Else if not last node, then increment level,
            // and compute profit of children nodes.
            v.level = u.level + 1;

            // Taking current level's item add current
            // level's weight and value to node u's
            // weight and value
            v.weight = u.weight + arr[v.level].weight;
            v.profit = u.profit + arr[v.level].value;

            // If cumulated weight is less than W and
            // profit is greater than previous profit,
            // update maxprofit
            if (v.weight <= W && v.profit > maxProfit)
                maxProfit = v.profit;

            // Get the upper bound on profit to decide
            // whether to add v to queue or not.
            v.bound = bound(v, n, W, arr);

            // If bound value is greater than profit,
            // then only push into queue for further
            // consideration
            if (v.bound > maxProfit)
                queue.push(v);

            // Do the same thing, but Without taking
            // the item in knapsack
            v.weight = u.weight;
            v.profit = u.profit;
            v.bound = bound(v, n, W, arr);
            if (v.bound > maxProfit)
                queue.push(v);
        }

        return String.valueOf(maxProfit);
    }

    // Returns bound of profit in subtree rooted with u.
// This function mainly uses Greedy solution to find
// an upper bound on maximum profit.

    private float bound(Node u, int n, int W, Item arr[]) {
        // if weight overcomes the knapsack capacity, return
        // 0 as expected bound
        if (u.weight >= W)
            return 0;

        // initialize bound on profit by current profit
        float profit_bound = u.profit;

        // start including items from index 1 more to current
        // item index
        int j = u.level + 1;
        float totweight = u.weight;

        // checking index condition and knapsack capacity
        // condition
        while ((j < n) && (totweight + arr[j].weight <= W)) {
            totweight += arr[j].weight;
            profit_bound += arr[j].value;
            j++;
        }

        // If k is not n, include last item partially for
        // upper bound on profit
        if (j < n)
            profit_bound += (W - totweight) * arr[j].value /
                    arr[j].weight;

        return profit_bound;
    }

    private static class Item {
        float weight;
        int value;

    }
    private static class Node {
        // level --> Level of node in decision tree (or index
        //			 in arr[]
        // profit --> Profit of nodes on path from root to this
        //		 node (including this node)
        // bound ---> Upper bound of maximum profit in subtree
        //		 of this node/
        int level;
        float profit, bound;

        float weight;
    }

}