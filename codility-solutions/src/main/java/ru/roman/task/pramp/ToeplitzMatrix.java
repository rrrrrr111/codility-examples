package ru.roman.task.pramp;

import java.util.Arrays;

/**
 * Toeplitz Matrix
 * A Toeplitz matrix is a matrix where every left-to-right-descending diagonal has the same element. Given a non-empty matrix arr, write a function that returns true if and only if it is a Toeplitz matrix. The matrix can be any dimensions, not necessarily square.
 * <p>
 * For example,
 * <p>
 * [[1,2,3,4],
 * [5,1,2,3],
 * [6,5,1,2]]
 * is a Toeplitz matrix, so we should return true, while
 * <p>
 * [[1,2,3,4],
 * [5,1,9,3],
 * [6,5,1,2]]
 * isn’t a Toeplitz matrix, so we should return false.
 * <p>
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * [input] array.array.integer arr
 * 0 ≤ arr.length ≤ 20
 * 0 ≤ arr[i].length ≤ 20
 * 0 ≤ arr[i][j] ≤ 20
 * [output] boolean
 */
class ToeplitzMatrix {
    public boolean solution(int[][] arr) {
        System.out.printf("On input: %s%n", Arrays.deepToString(arr));

        for (int i = 0; i < arr[0].length - 1; i++) {
            int val = arr[0][i];

            int k = i + 1;
            for (int j = 1; j < arr.length && k < arr[0].length; j++) {
                if (arr[j][k] != val ) {
                    return false;
                }
                k++;
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int val = arr[i][0];

            int k = i + 1;
            for (int j = 1; j < arr[0].length && k < arr.length; j++) {
                if (arr[k][j] != val ) {
                    return false;
                }
                k++;
            }
        }
        return true;
    }
}
