package ru.roman.algo.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

import static com.google.common.base.Preconditions.checkState;

public class ArrayOperations {

    public static void main(String[] args) {

        checkState(Arrays.equals(remove(new int[]{1, 2, 4, 3}, 0), new int[]{2, 4, 3}));
        checkState(Arrays.equals(remove(new int[]{1, 2, 4, 3}, 3), new int[]{1, 2, 4}));
        checkState(Arrays.equals(remove(new int[]{1, 2, 4, 3}, 2), new int[]{1, 2, 3}));
        checkState(Arrays.equals(remove(new int[]{1, 2, 4, 3}, 3), new int[]{1, 2, 4}));

        checkState(Arrays.equals(removeRange(new int[]{1, 2, 4, 3}, 0, 1), new int[]{4, 3}));
        checkState(Arrays.equals(removeRange(new int[]{1, 2, 4, 3}, 2, 3), new int[]{1, 2}));
        checkState(Arrays.equals(removeRange(new int[]{1, 2, 4, 3}, 0, 3), new int[0]));
        checkState(Arrays.equals(removeRange(new int[]{1, 2, 4, 3}, 0, 2), new int[]{3}));

        checkState(Arrays.equals(strip(1, new int[]{1, 2, 2, 2, 3}, 1), new int[]{2, 2, 2}));
        checkState(Arrays.equals(strip(3, new int[]{1, 2, 2, 4, 3}, 1), new int[]{4}));
        checkState(Arrays.equals(strip(0, new int[]{1, 2, 2, 2, 3}, 1), new int[]{1, 2, 2, 2}));
        checkState(Arrays.equals(strip(0, new int[]{1, 2, 2, 2, 3}, 0), new int[]{1, 2, 2, 2, 3}));
        checkState(Arrays.equals(strip(3, new int[]{1, 2, 2, 2, 3}, 2), new int[0]));

        checkState(Arrays.equals(insert(new int[]{1, 2, 3}, 3, 69), new int[]{1, 2, 3, 69}));
        checkState(Arrays.equals(insert(new int[]{1, 2, 3}, 0, 29), new int[]{29, 1, 2, 3}));
        checkState(Arrays.equals(insert(new int[]{1, 2, 3}, 2, 69), new int[]{1, 2, 69, 3}));
        checkState(Arrays.equals(insert(new int[]{1, 2, 3}, 2, 69, 76), new int[]{1, 2, 69, 76, 3}));
        checkState(Arrays.equals(insert(new int[]{1, 2, 3}, 0, 69, 76), new int[]{69, 76, 1, 2, 3}));
        checkState(Arrays.equals(insert(new int[]{1, 2, 3}, 3, 6, 5, 7), new int[]{1, 2, 3, 6, 5, 7}));
        checkState(Arrays.equals(insert(new int[0], 0, 1, 2, 3), new int[]{1, 2, 3}));

        checkState(indexOf(new int[]{1, 2, 3, 1}, 1, 0) == 0);
        checkState(indexOf(new int[]{1, 2, 3}, 1, 1) == -1);
        checkState(indexOf(new int[]{1, 2, 3}, 4, 0) == -1);
        checkState(indexOf(new int[]{1, 2, 3}, 3, 0) == 2);
        checkState(indexOf(new int[]{1, 2, 3}, 3) == 2);

        checkState(lastIndexOf(new int[]{1, 2, 3, 3, 2, 1}, 1, 5) == 5);
        checkState(lastIndexOf(new int[]{3, 2, 1}, 1, 1) == -1);
        checkState(lastIndexOf(new int[]{1, 2, 3, 3, 2, 1}, 4, 5) == -1);
        checkState(lastIndexOf(new int[]{1, 2, 3, 3, 2, 1}, 3, 2) == 2);
        checkState(lastIndexOf(new int[]{1, 2, 3, 3, 2, 1}, 3, 3) == 3);
        checkState(lastIndexOf(new int[]{1, 2, 3, 3, 2, 1}, 3, 4) == 3);
        checkState(lastIndexOf(new int[]{1, 2, 3, 3, 2, 1}, 3) == 3);

        checkState(lengthOfSubSequence(new int[]{1, 2, 3}, 0, 2) == 1);
        checkState(lengthOfSubSequence(new int[]{1, 2, 3}, 1, 2) == 1);
        checkState(lengthOfSubSequence(new int[]{1, 2, 3}, 2, 2) == 1);
        checkState(lengthOfSubSequence(new int[]{2, 2, 3}, 0, 2) == 2);
        checkState(lengthOfSubSequence(new int[]{0, 3, 3}, 1, 2) == 2);
        checkState(lengthOfSubSequence(new int[]{3, 3, 3}, 0, 2) == 3);
        checkState(lengthOfSubSequence(new int[]{3, 3, 3}, 1, 2) == 2);
        checkState(lengthOfSubSequence(new int[]{3, 3, 3}, 1, 1) == 1);

        checkState(Arrays.equals(reverse(new int[]{1, 2, 3}), new int[]{3, 2, 1}));
        checkState(Arrays.equals(reverse(new int[1]), new int[1]));
        checkState(Arrays.equals(reverse(new int[]{1}, 0, 1), new int[]{1}));
        checkState(Arrays.equals(reverse(new int[]{1, 2}, 0, 1), new int[]{1, 2}));
        checkState(Arrays.equals(reverse(new int[]{1, 2, 3, 4, 5}, 1, 4), new int[]{1, 4, 3, 2, 5}));
        checkState(Arrays.equals(reverse(new int[]{1, 2, 3, 4, 5}, 1, 5), new int[]{1, 5, 4, 3, 2}));
        checkState(Arrays.equals(reverse(new int[]{1, 2, 3, 4, 5}, 0, 3), new int[]{3, 2, 1, 4, 5}));

        checkState(Arrays.equals(swap(new int[]{1, 2, 3}, 1, 2), new int[]{1, 3, 2}));
        checkState(Arrays.equals(swap(new int[]{1, 2, 3}, 0, 2), new int[]{3, 2, 1}));
        checkState(Arrays.equals(swap(new int[]{1, 2, 3}, 0, 1), new int[]{2, 1, 3}));
    }

    private static int[] swap(int[] arr, int from, int to) {
        if (arr == null) throw new IllegalArgumentException("Given array is null");
        if (from < 0) throw new IllegalArgumentException("from < 0");
        if (to < 0) throw new IllegalArgumentException("to < 0");
        if (from > arr.length) throw new IllegalArgumentException("from > arr.length");
        if (to > arr.length) throw new IllegalArgumentException("to > arr.length");

        int tmp = arr[to];
        arr[to] = arr[from];
        arr[from] = tmp;
        return arr;
    }

    private static int[] remove(int[] arr, int index) {
        return removeRange(arr, index, index);
    }

    private static int[] removeRange(int[] arr, int fromIdx, int toIdx) {
        if (arr == null) throw new IllegalArgumentException("Given array is null");
        if (fromIdx < 0) throw new IllegalArgumentException("fromIdx < 0");
        if (fromIdx >= arr.length) throw new IllegalArgumentException("fromIdx >= arr.length");
        if (toIdx < 0) throw new IllegalArgumentException("toIdx < 0");
        if (toIdx >= arr.length) throw new IllegalArgumentException("toIdx >= arr.length");
        if (fromIdx > toIdx) throw new IllegalArgumentException("fromIdx > toIdx");

        final int length = Array.getLength(arr);
        final int[] res = (int[]) newArrayFor(arr, length - (toIdx - fromIdx + 1));

        System.arraycopy(arr, 0, res, 0, fromIdx);
        if (toIdx < length - 1) {
            System.arraycopy(arr, toIdx + 1, res, fromIdx, length - toIdx - 1);
        }
        return res;
    }

    private static int[] strip(int headCount, int[] arr, int tailCount) {
        if (arr == null) throw new IllegalArgumentException("Given array is null");
        if (headCount < 0) throw new IllegalArgumentException("headCount < 0");
        if (tailCount < 0) throw new IllegalArgumentException("tailCount < 0");
        if (headCount > arr.length) throw new IllegalArgumentException("headCount > arr.length");
        if (tailCount > arr.length) throw new IllegalArgumentException("tailCount > arr.length");
        if (arr.length - headCount < tailCount) throw new IllegalArgumentException("arr.length - headCount < tailCount");

        return Arrays.copyOfRange(arr, headCount, arr.length - tailCount);
    }

    private static int[] insert(int[] arr, int index, int... values) {
        if (arr == null) throw new IllegalArgumentException("Given array is null");
        if (index < 0) throw new IllegalArgumentException("index < 0");
        if (index >= arr.length + 1) throw new IllegalArgumentException("index >= arr.length + 1");
        if (values == null) throw new IllegalArgumentException("values == null");
        if (values.length == 0) throw new IllegalArgumentException("values is empty");

        final int length = Array.getLength(arr);
        final int[] res = (int[]) newArrayFor(arr, length + values.length);
        if (0 < index) {
            System.arraycopy(arr, 0, res, 0, index);
        }
        System.arraycopy(values, 0, res, index, values.length);
        if (index < length) {
            System.arraycopy(arr, index, res, index + values.length, length - index);
        }
        return res;
    }

    private static int indexOf(int[] arr, int value) {
        return indexOf(arr, value, 0);
    }

    private static int indexOf(int[] arr, int value, int startIndex) {
        if (arr == null) throw new IllegalArgumentException("Given array is null");
        if (startIndex < 0) throw new IllegalArgumentException("startIndex < 0");
        if (startIndex >= arr.length) throw new IllegalArgumentException("startIndex >= arr.length");

        for (int i = startIndex; i < arr.length; i++) {
            if (value == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int lastIndexOf(int[] arr, int value) {
        return lastIndexOf(arr, value, arr.length - 1);
    }

    private static int lastIndexOf(int[] arr, int value, int startIndex) {
        if (arr == null) throw new IllegalArgumentException("Given array is null");
        if (startIndex < 0) throw new IllegalArgumentException("startIndex < 0");
        if (startIndex >= arr.length) throw new IllegalArgumentException("startIndex >= arr.length");

        for (int i = startIndex; i >= 0; i--) {
            if (value == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int lengthOfSubSequence(int[] arr, int startIndex, int stopIndex) {
        if (arr == null) throw new IllegalArgumentException("Given array is null");
        if (startIndex < 0) throw new IllegalArgumentException("startIndex < 0");
        if (startIndex >= arr.length) throw new IllegalArgumentException("startIndex >= arr.length");

        int value = arr[startIndex];
        int length = 1;
        for (int i = startIndex + 1; i <= stopIndex; i++) {
            if (value != arr[i])
                break;
            length++;
        }
        return length;
    }

    private static int[] reverse(int[] arr) {
        return reverse(arr, 0, arr.length);
    }

    private static int[] reverse(int[] arr, int startIndexInclusive, int endIndexExclusive) {
        if (arr == null) throw new IllegalArgumentException("Given array is null");
        if (startIndexInclusive < 0) throw new IllegalArgumentException("startIndexInclusive < 0");
        if (startIndexInclusive >= arr.length) throw new IllegalArgumentException("startIndexInclusive >= arr.length");
        if (endIndexExclusive < 1) throw new IllegalArgumentException("endIndexExclusive < 1");
        if (endIndexExclusive > arr.length) throw new IllegalArgumentException("endIndexExclusive > arr.length");

        final int length = Array.getLength(arr);
        final int[] res = (int[]) newArrayFor(arr, length);

        int i = startIndexInclusive, j = endIndexExclusive - 1;

        if (0 < startIndexInclusive) {
            System.arraycopy(arr, 0, res, 0, startIndexInclusive + 1);
        }
        while (j >= i) {
            res[i] = arr[j];
            res[j] = arr[i];
            j--;
            i++;
        }
        if (endIndexExclusive < length) {
            System.arraycopy(arr, endIndexExclusive, res, endIndexExclusive, length - endIndexExclusive);
        }
        return res;
    }

    private static Object newArrayFor(final Object array, int length) {
        return Array.newInstance(array.getClass().getComponentType(), length);
    }
}
