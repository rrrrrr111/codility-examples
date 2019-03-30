package ru.roman.task.gfg.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find a subarray which adds to a given number. If there are more than one subarrays with the sum as the given number, print any of them.
 * <p>
 * Examples:
 * <p>
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * Ouptut: 2,4
 * <p>
 * Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
 * Ouptut: 0,3
 * <p>
 * Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
 * Ouptut: -1
 */
class GfgSubArraySum {
    String test(int[] arr, int sum) {

        int currSum = 0;
        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            int diff = currSum - sum;

            if (diff == 0) {
                return 0 + "," + i;
            }
            if (map.containsKey(diff)) {
                return (map.get(diff) + 1) + "," + i;
            }

            map.put(currSum, i);
        }

        return "-1";
    }
}
