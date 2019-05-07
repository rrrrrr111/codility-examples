package ru.roman.task.pramp;

import java.util.Arrays;

/**
 * Array Quadruplet
 * Given an unsorted array of integers arr and a number s, write a function findArrayQuadruplet that finds four numbers (quadruplet) in arr that sum up to s. Your function should return an array of these numbers in an ascending order. If such a quadruplet doesn’t exist, return an empty array.
 * <p>
 * Note that there may be more than one quadruplet in arr whose sum is s. You’re asked to return the first one you encounter (considering the results are sorted).
 * <p>
 * Explain and code the most efficient solution possible, and analyze its time and space complexities.
 * <p>
 * Example:
 * <p>
 * input:  arr = [2, 7, 4, 0, 9, 5, 1, 3], s = 20
 * <p>
 * output: [0, 4, 7, 9] # The ordered quadruplet of (7, 4, 0, 9)
 * # whose sum is 20. Notice that there
 * # are two other quadruplets whose sum is 20:
 * # (7, 9, 1, 3) and (2, 4, 9, 5), but again you’re
 * # asked to return the just one quadruplet (in an
 * # ascending order)
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * <p>
 * [input] array.integer arr
 * <p>
 * 1 ≤ arr.length ≤ 100
 * [input] integer s
 * <p>
 * [output] array.integer
 */
class ArrayQuadrupletSolution {

    static int[] findArrayQuadruplet(int[] arr, int s) {
        System.out.printf("On input: %s %s\n", Arrays.toString(arr), s);

        Arrays.sort(arr);

        // O(n^3)
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {

                int sum = arr[i] + arr[j];
                int diff = s - sum;

                int k = j + 1, l = arr.length - 1;
                while (k < l) {
                    if (arr[k] + arr[l] == diff) {
                        return new int[]{arr[i], arr[j], arr[k], arr[l]};
                    } else if (arr[k] + arr[l] > diff) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return new int[0];
    }
}
