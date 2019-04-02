package ru.roman.algo.arrays;

import java.util.Arrays;

/**
 *
 */
public class PermutationExample {


    public static void main(String[] args) {
        int[] arr = {'b', 'o', 'o', 'm'};
        iterateAllPermutations(arr);
    }

    private static void iterateAllPermutations(int[] arr) {
        Arrays.sort(arr);

        do {
            StringBuffer b = new StringBuffer(arr.length);
            for (int c : arr) b.append((char) c);
            System.out.println(b.toString());
        } while (nextPermutation(arr));
    }

    /**
     * Attempts to advance the given sequence to the next permutation in lexicographical order.
     * Returns true if the sequence was successfully permuted, or returns false if the sequence
     * was already at the last possible permutation (a non-ascending sequence).
     * Explanation: https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
     * For example:
     * - nextPermutation({0,0,1}) changes the argument array to {0,1,0} and returns true.
     * - nextPermutation({1,0,0}) leaves the argument array unchanged and returns false.
     */
    private static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        for (; i > 0 && arr[i - 1] >= arr[i]; i--) ;

        if (i <= 0)
            return false;

        {
            int j = arr.length - 1;
            for (; arr[j] <= arr[i - 1]; j--) ;
            int temp = arr[i - 1];
            arr[i - 1] = arr[j];
            arr[j] = temp;
        }
        for (int j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return true;
    }
}
