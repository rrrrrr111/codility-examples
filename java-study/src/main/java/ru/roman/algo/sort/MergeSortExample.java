package ru.roman.algo.sort;

import static ru.roman.algo.PrintUtil.printArray;

/**
 *
 */
class MergeSortExample {

    public static void main(String[] args) {

        int[] arr = {8, 7, 16, 2, 11, 18, 14, 19, 6, 5, 17, 15, 9, 13, 12, 3, 1, 4, 16, 10};
        System.out.printf("Array    : %s%n", printArray(arr, 2));
        int[] sorted = mergeSort(arr);
        System.out.printf("Sorted   : %s%n", printArray(sorted, 2));
    }

    private static int[] mergeSort(int[] arr) {

        int size = arr.length;
        if (size < 2) {
            return arr;
        }

        int mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];

        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, mid, right, 0, right.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {

        int[] res = new int[left.length + right.length];
        int li = 0, ri = 0, idx = 0;

        while (li < left.length && ri < right.length) {
            if (left[li] <= right[ri]) {
                res[idx++] = left[li++];
            } else {
                res[idx++] = right[ri++];
            }
        }
        while (li < left.length) {
            res[idx++] = left[li++];
        }
        while (ri < right.length) {
            res[idx++] = right[ri++];
        }
        return res;
    }
}
