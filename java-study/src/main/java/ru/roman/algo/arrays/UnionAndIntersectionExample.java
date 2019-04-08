package ru.roman.algo.arrays;

import java.util.Arrays;

/**
 *
 */
public class UnionAndIntersectionExample {

    public static void main(String[] args) {

        int[] arr1 = {7, 1, 5, 2, 3, 6};
        int[] arr2 = {3, 8, 6, 20, 7};

        System.out.println("Union of two arrays is ");
        printUnion(arr1, arr2, arr1.length, arr2.length);

        System.out.println();

        System.out.println("Intersection of two arrays is ");
        printIntersection(arr1, arr2, arr1.length, arr2.length);
    }

    // Prints union of arr1[0..m-1] and arr2[0..n-1]
    private static void printUnion(int arr1[], int arr2[], int m, int n) {

        // Before finding union, make sure arr1[0..m-1] is smaller
        if (m > n) {
            int tempArr[] = arr1, temp = m;

            arr1 = arr2;
            arr2 = tempArr;
            m = n;
            n = temp;
        }

        // Now arr1[] is smaller
        // Sort the first array and print its elements (these two steps can be swapped as order in output is not important)

        Arrays.sort(arr1);
        for (int i = 0; i < m; i++)
            System.out.print(arr1[i] + " ");

        // Search every element of bigger array in smaller array and print the element if not found
        for (int i = 0; i < n; i++) {
            if (binarySearch(arr1, 0, m - 1, arr2[i]) == -1)
                System.out.print(arr2[i] + " ");
        }
    }

    // Prints intersection of arr1[0..m-1] and arr2[0..n-1]
    private static void printIntersection(int arr1[], int arr2[], int m, int n) {

        // Before finding intersection, make sure arr1[0..m-1] is smaller
        if (m > n) {
            int tempArr[] = arr1, temp = m;
            arr1 = arr2;
            arr2 = tempArr;
            m = n;
            n = temp;
        }

        // Now arr1[] is smaller
        // Sort smaller array arr1[0..m-1]
        Arrays.sort(arr1);

        // Search every element of bigger array in smaller array
        // and print the element if found
        for (int i = 0; i < n; i++) {
            if (binarySearch(arr1, 0, m - 1, arr2[i]) != -1)
                System.out.print(arr2[i] + " ");
        }
    }

    /**
     * Recursive binary search of unique element, in sorted array
     */
    private static int binarySearch(int arr[], int fromIdx, int toIdx, int value) {
        if (toIdx >= fromIdx) {
            int mid = fromIdx + (toIdx - fromIdx) / 2;

            if (arr[mid] == value)
                return mid;

            if (arr[mid] > value)
                return binarySearch(arr, fromIdx, mid - 1, value);

            return binarySearch(arr, mid + 1, toIdx, value);
        }
        return -1;
    }
}
