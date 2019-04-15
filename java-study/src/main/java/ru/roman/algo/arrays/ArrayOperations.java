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

        Preconditions.checkState(Arrays.equals(removeElements(new int[]{1, 2, 4, 3}, 0, 0), new int[]{2, 4, 3}));
        Preconditions.checkState(Arrays.equals(removeElements(new int[]{1, 2, 4, 3}, 3, 3), new int[]{1, 2, 4}));
        Preconditions.checkState(Arrays.equals(removeElements(new int[]{1, 2, 4, 3}, 2, 2), new int[]{1, 2, 3}));
        Preconditions.checkState(Arrays.equals(removeElements(new int[]{1, 2, 4, 3}, 3, 3), new int[]{1, 2, 4}));

        Preconditions.checkState(Arrays.equals(addElement(new int[]{1, 2, 3}, 69, 3), new int[]{1, 2, 3, 69}));
        Preconditions.checkState(Arrays.equals(addElement(new int[]{1, 2, 3}, 29, 0), new int[]{29, 1, 2, 3}));
        Preconditions.checkState(Arrays.equals(addElement(new int[]{1, 2, 3}, 69, 2), new int[]{1, 2, 69, 3}));

        Preconditions.checkState(Arrays.equals(strip(1, new int[]{1, 2, 2, 2, 3}, 1), new int[]{2, 2, 2}));
        Preconditions.checkState(Arrays.equals(strip(3, new int[]{1, 2, 2, 4, 3}, 1), new int[]{4}));
        Preconditions.checkState(Arrays.equals(strip(0, new int[]{1, 2, 2, 2, 3}, 1), new int[]{1, 2, 2, 2}));
        Preconditions.checkState(Arrays.equals(strip(0, new int[]{1, 2, 2, 2, 3}, 0), new int[]{1, 2, 2, 2, 3}));
        Preconditions.checkState(Arrays.equals(strip(3, new int[]{1, 2, 2, 2, 3}, 2), new int[0]));
    }


    private static int[] removeElement(int[] arr, int index) {
        if (arr == null) throw new IllegalArgumentException("Given array is null");
        if (index < 0 || index >= arr.length) throw new IllegalArgumentException();

        final int length = Array.getLength(arr) - 1;
        final int[] res = (int[]) newArrayFor(arr, length);

        System.arraycopy(arr, 0, res, 0, index);
        System.arraycopy(arr, index + 1, res, index, length - index);
        return res;
    }

    private static int[] removeElements(int[] arr, int from, int to) {
        if (arr == null) throw new IllegalArgumentException("Given array is null");
        if (from < 0) throw new IllegalArgumentException("from < 0");
        if (from >= arr.length) throw new IllegalArgumentException("from >= arr.length");
        if (to < 0) throw new IllegalArgumentException("to < 0");
        if (to >= arr.length) throw new IllegalArgumentException("to >= arr.length");
        if (from > to) throw new IllegalArgumentException("from > to");


        int removeCount = to - from + 1;
        final int length = Array.getLength(arr) - removeCount;
        final int[] res = (int[]) newArrayFor(arr, length);

        System.arraycopy(arr, 0, res, 0, from);
        System.arraycopy(arr, from, res, arr.length - to, arr.length - to);
        return res;
    }

    private static int[] addElement(int[] arr, int value, int index) {
        if (arr == null) throw new IllegalArgumentException("Given array is null");
        if (index < 0 || index >= arr.length + 1) throw new IllegalArgumentException();

        final int length = Array.getLength(arr) + 1;
        final int[] res = (int[]) newArrayFor(arr, length);
        System.arraycopy(arr, 0, res, 0, index);
        res[index] = value;
        System.arraycopy(arr, index, res, index + 1, length - index - 1);
        return res;
    }

    private static int[] strip(int headCount, int[] arr, int tailCount) {
        if (arr == null) throw new IllegalArgumentException("Given array is null");
        if (headCount < 0 || tailCount < 0
                || headCount > arr.length || tailCount > arr.length
                || arr.length - headCount < tailCount) throw new IllegalArgumentException();

        final int length = Array.getLength(arr) - headCount - tailCount;
        final int[] res = (int[]) newArrayFor(arr, length);
        System.arraycopy(arr, headCount, res, 0, res.length);
        return res;
    }

    private static Object newArrayFor(final Object array, int length) {
        return Array.newInstance(array.getClass().getComponentType(), length);
    }
}
