package ru.roman.task.pramp;

import java.util.Arrays;

import static java.lang.Math.abs;

/**
 * Absolute Value Sort
 * Given an array of integers arr, write a function absSort(arr), that sorts the array according to
 * the absolute values of the numbers in arr. If two numbers have the same absolute value, sort them
 * according to sign, where the negative numbers come before the positive numbers.
 * <p>
 * Examples:
 * <p>
 * input:  arr = [2, -7, -2, -2, 0]
 * output: [0, -2, -2, 2, -7]
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * [input] array.integer arr
 * 0 ≤ arr.length ≤ 10
 * [output] array.integer
 */
public class AbsoluteValueSort {

    int[] absSort(int[] arr) {

        if (arr.length < 2)
            return arr;
        int length = arr.length;

        Arrays.sort(arr);

        if ((arr[0] >= 0 && arr[length - 1] >= 0)                    // only positive or negative range
                || (arr[0] <= 0 && arr[length - 1] <= 0)) {
            return arr;
        }

        int[] res = new int[length];

        int f = 0, b = length - 1;
        boolean fFinish = false, bFinish = false;

        for (int i = length - 1; f <= b;) {
            System.out.printf("%s(%s) %s(%s)%n", f, fFinish, b, bFinish);

            if (fFinish) {
                res[i--] = arr[b];
                b--;
            } else if (bFinish) {
                res[i--] = arr[f];
                f++;
            } else if (arr[b] < abs(arr[f])) {
                res[i--] = arr[f];
                f++;
            } else if (abs(arr[f]) < arr[b]) {
                res[i--] = arr[b];
                b--;
            } else {
                res[i--] = arr[b];
                if (b != f)  {
                    res[i--] = arr[f];
                }
                f++;
                b--;
            }
            if (arr[f] > 0) fFinish = true;
            if (arr[b] < 0) bFinish = true;
            if (fFinish && bFinish) break;
        }
        return res;
    }
}
