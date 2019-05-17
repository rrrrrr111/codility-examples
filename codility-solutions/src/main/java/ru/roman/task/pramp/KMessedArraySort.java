package ru.roman.task.pramp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Given an array of integers arr where each element is at most k places away from
 * its sorted position, code an efficient function sortKMessedArray that sorts arr.
 * For instance, for an input array of size 10 and k = 2, an element belonging to
 * index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in
 * the input array.
 * <p>
 * Analyze the time and space complexities of your solution.
 * <p>
 * Example:
 * <p>
 * input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2
 * <p>
 * output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * <p>
 * [input] array.integer arr
 * <p>
 * 1 ≤ arr.length ≤ 100
 * [input] integer k
 * <p>
 * 1 ≤ k ≤ 20
 * [output] array.integer
 */
class KMessedArraySort {

    /**
     * Insertion sort with element no far when k positions from need
     */
    int[] test(int[] arr, int k) {
        System.out.printf("On input: %s\n", Arrays.toString(arr));

        return swappingAlg(arr, k);
        //return linkedListAlg(arr, k);
    }

    private int[] swappingAlg(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j - i <= k && j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }

    private static int[] swap(int[] arr, int from, int to) {

        int tmp = arr[to];
        arr[to] = arr[from];
        arr[from] = tmp;
        return arr;
    }

    private int[] linkedListAlg(int[] arr, int k) {
        System.out.printf("On input: %s %s%n", Arrays.toString(arr), k);

        if (arr == null || arr.length < 2)
            return arr;

        LinkedList<Integer> result = new LinkedList<>();
        for (int i : arr) {
            result.add(i);
        }

        ListIterator<Integer> iter = result.listIterator();
        while (iter.hasNext()) {

            int candidate = iter.next();
            System.out.println("\nEvaluating: " + candidate);

            int j = 0;
            int candidatePos = -1;
            while (++j <= k && iter.hasNext()) {
                int val = iter.next();
                if (val < candidate) {
                    candidate = val;
                    candidatePos = j;
                }
            }
            if (candidatePos > -1) {
                System.out.println("Found candidate to swap: " + candidate + " on distance: " + candidatePos);
            }

            while (--j > 0) {                // backtracking here
                iter.previous();

                if (candidatePos == j) {
                    iter.remove();              // removes an element just returned by previous()
                    iter.previous();            // so we need one more step back
                    System.out.println("After removing: " + candidate + " " + result);
                }
            }
            if (candidatePos > -1) {
                iter.add(candidate);
                System.out.println("After add: " + candidate + " " + result);
            }
        }

        int[] ret = new int[result.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = result.get(i);
        return ret;
    }
}
