package ru.roman.algo.search;

import java.util.Arrays;

import static ru.roman.algo.PrintUtil.printArray;
import static ru.roman.algo.PrintUtil.printRange;

/**
 *
 */
class BinarySearchExample {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 5, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 11, 13, 14, 14, 14, 15, 16, 17, 20, 21};
        Arrays.sort(arr);

        System.out.printf("Index    : %s%n", printRange(0, arr.length, 2));
        System.out.printf("Array    : %s%n", printArray(arr, 2));
        System.out.printf("%s -> %s%n", 0, binarySearch(arr, 0));
        System.out.printf("%s -> %s%n", 7, binarySearch(arr, 7));
        System.out.printf("%s -> %s%n", 8, binarySearch(arr, 8));
        System.out.printf("%s -> %s%n", 16, binarySearch(arr, 16));
        System.out.printf("%s -> %s%n", 22, binarySearch(arr, 22));
    }

    private static int binarySearch(int[] arr, int value) {
        int beg = 0, end = arr.length - 1;

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
