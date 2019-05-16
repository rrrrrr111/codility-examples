package ru.roman.task.pramp;

import java.util.Arrays;

/**
 * Move Zeros To End
 * Given a static-sized array of integers arr, move all zeroes in the array to the end of the array. You should preserve the relative order of items in the array.
 * <p>
 * We should implement a solution that is more efficient than a naive brute force.
 * <p>
 * Examples:
 * <p>
 * input:  arr = [1, 10, 0, 2, 8, 3, 0, 0, 6, 4, 0, 5, 7, 0]
 * output: [1, 10, 2, 8, 3, 6, 4, 5, 7, 0, 0, 0, 0, 0]
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * [input] array.integer arr
 * 0 ≤ arr.length ≤ 20
 * [output] array.integer
 */
class MoveZerosToEnd {
    public int[] solution(int[] arr) {
        System.out.printf("On input: %s%n", Arrays.toString(arr));

        outer: for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] == 0) {
                int j = i + 1;
                while (arr[j] == 0) {
                    j++;
                    if (j == arr.length)
                        break outer;
                }
                swap(arr, i, j);
            }
        }
        return arr;
    }

    private static int[] swap(int[] arr, int from, int to) {
        if (arr == null) throw new IllegalArgumentException("Given array is null");
        if (from < 0) throw new IllegalArgumentException("from < 0");
        if (to < 0) throw new IllegalArgumentException("to < 0");
        if (from > arr.length) throw new IllegalArgumentException("from > arr.length");
        if (to > arr.length) throw new IllegalArgumentException("to > arr.length");

        int tmp = arr[to];
        arr[to] = arr[from];
        arr[from] = tmp;
        return arr;
    }
}
