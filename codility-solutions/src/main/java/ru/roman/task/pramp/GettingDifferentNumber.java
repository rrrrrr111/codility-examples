package ru.roman.task.pramp;

import java.util.Arrays;

/**
 * Getting a Different Number
 * Given an array arr of unique nonnegative integers, implement a function getDifferentNumber that finds the smallest nonnegative integer that is NOT in the array.
 * <p>
 * Even if your programming language of choice doesn’t have that restriction (like Python), assume that the maximum value an integer can have is MAX_INT = 2^31-1. So, for instance, the operation MAX_INT + 1 would be undefined in our case.
 * <p>
 * Your algorithm should be efficient, both from a time and a space complexity perspectives.
 * <p>
 * Solve first for the case when you’re NOT allowed to modify the input arr. If successful and still have time, see if you can come up with an algorithm with an improved space complexity when modifying arr is allowed. Do so without trading off the time complexity.
 * <p>
 * Analyze the time and space complexities of your algorithm.
 * <p>
 * Example:
 * <p>
 * input:  arr = [0, 1, 2, 3]
 * <p>
 * output: 4
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * <p>
 * [input] array.integer arr
 * <p>
 * 1 ≤ arr.length ≤ MAX_INT
 * 0 ≤ arr[i] ≤ MAX_INT for every i, 0 ≤ i < MAX_INT
 * [output] integer
 */
class GettingDifferentNumber {

    int getDifferentNumber(int[] arr) {
        System.out.printf("On input: %s%n", Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i && arr[i] < arr.length) {
                swap(arr, arr[i], i);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i)
                return i;
        }

        return arr.length;
    }

    private static void swap(int[] arr, int from, int to) {
        int tmp = arr[to];
        arr[to] = arr[from];
        arr[from] = tmp;
    }
}
