package ru.roman.algo.search;

import java.util.Arrays;

import static com.google.common.base.Preconditions.checkState;
import static ru.roman.algo.PrintUtil.printArray;
import static ru.roman.algo.PrintUtil.printRange;

/**
 *
 */
class BinarySearchExample {

    public static void main(String[] args) {

        int[] arr = {-178, -98, -98, -1, 0, 1, 2, 3, 4, 4, 14, 14, 15, 67, 68, 98, 99};
        Arrays.sort(arr);

        System.out.printf("Index    : %s%n", printRange(0, arr.length, 4));
        System.out.printf("Array    : %s%n", printArray(arr, 4));
        checkState(binarySearch(arr, -98) == 1);
        checkState(binarySearch(arr, 0) == 4);
        checkState(binarySearch(arr, 4) == 8);
        checkState(binarySearch(arr, 14) == 10);
        checkState(binarySearch(arr, 68) == 14);
        checkState(binarySearch(arr, 98) == 15);
        checkState(binarySearch(arr, 99) == 16);
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
