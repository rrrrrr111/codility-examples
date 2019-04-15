package ru.roman.algo.arrays;

import com.google.common.base.Preconditions;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayOperations {

    public static void main(String[] args) {

        Preconditions.checkState(Arrays.equals(removeElement(new int[]{1, 2, 4, 3}, 0), new int[]{2, 4, 3}));
        Preconditions.checkState(Arrays.equals(removeElement(new int[]{1, 2, 4, 3}, 3), new int[]{1, 2, 4}));
        Preconditions.checkState(Arrays.equals(removeElement(new int[]{1, 2, 4, 3}, 2), new int[]{1, 2, 3}));
        Preconditions.checkState(Arrays.equals(removeElement(new int[]{1, 2, 4, 3}, 3), new int[]{1, 2, 4}));
        Preconditions.checkState(Arrays.equals(addElement(new int[]{1, 2, 3}, 69, 3), new int[]{1, 2, 3, 69}));
        Preconditions.checkState(Arrays.equals(addElement(new int[]{1, 2, 3}, 69, 0), new int[]{69, 1, 2, 3}));
        Preconditions.checkState(Arrays.equals(addElement(new int[]{1, 2, 3}, 69, 2), new int[]{1, 2, 69, 3}));
    }


    private static int[] removeElement(int[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) throw new IllegalArgumentException();
        final int length = Array.getLength(arr) - 1;
        final int[] res = (int[]) newArrayFor(arr, length);

        System.arraycopy(arr, 0, res, 0, index);
        System.arraycopy(arr, index + 1, res, index, length - index);
        return res;
    }

    private static int[] addElement(int[] arr, int value, int index) {
        if (arr == null || index < 0 || index >= arr.length + 1) throw new IllegalArgumentException();

        final int length = Array.getLength(arr) + 1;
        final int[] res = (int[]) newArrayFor(arr, length);
        System.arraycopy(arr, 0, res, 0, index);
        res[index] = value;
        System.arraycopy(arr, index, res, index + 1, length - index - 1);
        return res;
    }

    private static Object newArrayFor(final Object array, int length) {
        return Array.newInstance(array.getClass().getComponentType(), length);
    }
}
