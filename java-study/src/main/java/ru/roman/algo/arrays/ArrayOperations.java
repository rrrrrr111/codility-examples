package ru.roman.algo.arrays;

import com.google.common.base.Preconditions;

import java.util.Arrays;

public class ArrayOperations {

    public static void main(String[] args) {

        Preconditions.checkState(Arrays.equals(removeElement(new int[]{1, 2, 4, 3}, 2), new int[]{1, 2, 3}));
        Preconditions.checkState(Arrays.equals(removeElement(new int[]{1, 2, 4, 3}, 3), new int[]{1, 2, 4}));
        Preconditions.checkState(Arrays.equals(addElement(new int[]{1, 2, 3}, 69, 3), new int[]{1, 2, 3, 69}));
        Preconditions.checkState(Arrays.equals(addElement(new int[]{1, 2, 3}, 69, 0), new int[]{69, 1, 2, 3}));
        Preconditions.checkState(Arrays.equals(addElement(new int[]{1, 2, 3}, 69, 2), new int[]{1, 2, 69, 3}));

    }


    private static int[] removeElement(int[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) throw new IllegalArgumentException();
        int[] res = new int[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) continue;
            res[k++] = arr[i];
        }
        return res;
    }

    private static int[] addElement(int[] arr, int value, int index) {
        if (arr == null || index < 0 || index >= arr.length + 1) throw new IllegalArgumentException();

        int[] res = new int[arr.length + 1];
        for (int i = 0, k = 0; i < res.length; i++) {
            if (i == index) res[i] = value;
            else res[i] = arr[k++];
        }
        return res;
    }
}
