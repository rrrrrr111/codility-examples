package ru.roman.algo.arrays;

import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

class OverlappingRangesExample {

    public static void main(String[] args) {

        printOverlappingCount(new int[][]{{1, 2}, {2, 3}, {3, 4}}, 1);
        printOverlappingCount(new int[][]{{1, 2}, {1, 2}, {2, 3}}, 2);
        printOverlappingCount(new int[][]{{1, 2}, {1, 3}, {2, 3}}, 2);
        printOverlappingCount(new int[][]{{1, 2}, {1, 4}, {2, 3}}, 2);
        printOverlappingCount(new int[][]{{1, 2}, {1, 4}, {2, 3}, {3, 6}, {4, 6}, {5, 6}}, 3);
    }

    private static void printOverlappingCount(int[][] arr, int expected) {
        int actual = findMaxOverlappingRangesCount(arr);
        String arrStr = Arrays.deepToString(arr);
        Preconditions.checkState(actual == expected, "Expected %s but got %s, in array: %s", expected, actual, arrStr);
        System.out.printf("%s -> %s%n", arrStr, actual);
    }

    private static int findMaxOverlappingRangesCount(int[][] ranges) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int[] range : ranges) {
            map.put(range[0], map.getOrDefault(range[0], 0) + 1);
            map.put(range[1], map.getOrDefault(range[1], 0) - 1);
        }
        int max = 0, current = 0;
        for (Integer count : map.values()) {
            current += count;
            max = Math.max(max, current);
        }
        return max;
    }
}
