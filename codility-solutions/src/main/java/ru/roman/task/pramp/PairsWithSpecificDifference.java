package ru.roman.task.pramp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given an array arr of distinct integers and a nonnegative integer k, write a function findPairsWithGivenDifference that returns an array of all pairs [x,y] in arr, such that x - y = k. If no such pairs exist, return an empty array.
 * <p>
 * Note: the order of the pairs in the output array should maintain the order of the y element in the original array.
 * <p>
 * Examples:
 * <p>
 * input:  arr = [0, -1, -2, 2, 1], k = 1
 * output: [[1, 0], [0, -1], [-1, -2], [2, 1]]
 * <p>
 * input:  arr = [1, 7, 5, 3, 32, 17, 12], k = 17
 * output: []
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * <p>
 * [input] array.integer arr
 * <p>
 * 0 ≤ arr.length ≤ 100
 * [input]integer k
 * <p>
 * k ≥ 0
 * [output] array.array.integer
 */
public class PairsWithSpecificDifference {

    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        System.out.printf("On input: %s\n", Arrays.toString(arr));

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            map.put(arr[i], i);

        Map<Integer, Integer> mapYtoX = new LinkedHashMap<>();
        for (int y : arr) {
            int x = y + k;
            Integer xIdx = map.get(x);

            if (xIdx != null) {
                mapYtoX.put(y, arr[xIdx]);
            }
        }

        int[][] res = new int[mapYtoX.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : mapYtoX.entrySet()) {
            res[i][0] = entry.getValue();
            res[i][1] = entry.getKey();
            i++;
        }
        return res;
    }
}
