package ru.roman.task.pramp;

import java.util.Arrays;

/**
 * Given a 2D array (matrix) inputMatrix of integers, create a function spiralCopy that copies inputMatrix’s values into a 1D array in a spiral order, clockwise. Your function then should return that array. Analyze the time and space complexities of your solution.
 * <p>
 * Example:
 * <pre>
 * input:  inputMatrix  = [ [1,    2,   3,  4,    5],
 *                          [6,    7,   8,  9,   10],
 *                          [11,  12,  13,  14,  15],
 *                          [16,  17,  18,  19,  20] ]</pre>
 * <p>
 * output: [1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12]
 * See the illustration below to understand better what a clockwise spiral order looks like.
 * <p>
 * alt Clockwise spiral order
 * <p>
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * <p>
 * [input] array.array.integer inputMatrix
 * <p>
 * 1 ≤ inputMatrix[0].length ≤ 100
 * 1 ≤ inputMatrix.length ≤ 100
 * [output] array.integer
 */
class MatrixSpiralCopy {
    public int[] solution(int[][] arr) {
        System.out.printf("On input: %s\n", Arrays.deepToString(arr));

        int w = arr[0].length, h = arr.length;
        int[] res = new int[w * h];
        w++;                                // just to inscribe in common pattern
        int x = -1, y = 0, r = 0;
        Boolean forward = true, down = null;

        while (0 < w && 0 < h) {
            if (down == Boolean.TRUE) {
                for (int l = y + 1; l < y + h; l++)
                    res[r++] = arr[l][x];

                down = null;
                forward = false;
                y = y + h - 1;
                h--;

            } else if (down == Boolean.FALSE) {
                for (int l = y - 1; l > y - h; l--)
                    res[r++] = arr[l][x];

                down = null;
                forward = true;
                y = y - h + 1;
                h--;
            } else if (forward == Boolean.TRUE) {
                for (int l = x + 1; l < x + w; l++)
                    res[r++] = arr[y][l];

                forward = null;
                down = true;
                x = x + w - 1;
                w--;
            } else if (forward == Boolean.FALSE) {
                for (int l = x - 1; l > x - w; l--)
                    res[r++] = arr[y][l];

                forward = null;
                down = false;
                x = x - w + 1;
                w--;
            }
        }
        return res;
    }
}
