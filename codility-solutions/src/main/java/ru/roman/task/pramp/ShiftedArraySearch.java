package ru.roman.task.pramp;

import java.util.Arrays;

/**
 * Shifted Array Search
 * <p>
 * A sorted array of distinct integers shiftArr is shifted to the left by an unknown
 * offset and you don’t have a pre-shifted copy of it. For instance, the sequence
 * 1, 2, 3, 4, 5 becomes 3, 4, 5, 1, 2, after shifting it twice to the left.
 * <p>
 * Given shiftArr and an integer num, implement a function shiftedArrSearch that finds
 * and returns the index of num in shiftArr. If num isn’t in shiftArr, return -1.
 * Assume that the offset can be any value between 0 and arr.length - 1.
 * <p>
 * Explain your solution and analyze its time and space complexities.
 * <p>
 * Example:
 * <p>
 * input:  shiftArr = [9, 12, 17, 2, 4, 5], num = 2 # shiftArr is the
 * # outcome of shifting
 * # [2, 4, 5, 9, 12, 17]
 * # three times to the left
 * <p>
 * output: 3 # since it’s the index of 2 in arr
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * [input] array.integer arr
 * [input] integer num
 * [output] integer
 */
class ShiftedArraySearch {

    int shiftedArrSearch(int[] shiftArr, int num) {
        System.out.printf("On input: %s\n", Arrays.toString(shiftArr));

        int point = findPivotPoint(shiftArr);
        if (point > -1) {
            if (shiftArr[0] <= num) {
                return binarySearch(shiftArr, 0, point, num);
            } else {
                return binarySearch(shiftArr, point + 1, shiftArr.length - 1, num);
            }
        }
        return binarySearch(shiftArr, 0, shiftArr.length - 1, num);
    }

    private static int findPivotPoint(int[] arr) {
        int beg = 0, end = arr.length - 1;

        for (int mid; beg <= end; ) {
            mid = (beg + end) / 2;

            if (mid < arr.length - 2 && arr[mid] > arr[mid + 1])
                return mid;
            if (mid > 0 && arr[mid - 1] > arr[mid])
                return mid - 1;

            if (arr[mid] < arr[0]) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int from, int to, int value) {
        int beg = from, end = to;

        int res = -1;
        for (int mid; beg <= end; ) {
            mid = (beg + end) / 2;
            if (arr[mid] == value) {
                res = mid;
                end = mid - 1;
            } else if (arr[mid] < value) {
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
}
