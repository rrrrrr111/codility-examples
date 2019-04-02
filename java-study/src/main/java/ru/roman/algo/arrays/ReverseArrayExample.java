package ru.roman.algo.arrays;

import java.util.Arrays;

/**
 *
 */
public class ReverseArrayExample {

    public static void main(String[] args) {

        char[] arr = {'b', 'o', 'o', 'm'};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] data) {
        for (int left = 0, right = data.length - 1; left < right; left++, right--) {
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
        }
    }

    private static void reverse(char[] data) {
        for (int left = 0, right = data.length - 1; left < right; left++, right--) {
            char temp = data[left];
            data[left] = data[right];
            data[right] = temp;
        }
    }
}
