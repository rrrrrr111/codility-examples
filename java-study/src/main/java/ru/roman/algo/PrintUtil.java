package ru.roman.algo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.apache.commons.lang3.StringUtils.leftPad;

public final class PrintUtil {
    private PrintUtil() {
    }

    public static String printArray(Object[] arr, int leftPad) {
        return Arrays.toString(
                Arrays.stream(arr).map(v -> leftPad("" + v, leftPad)).toArray()
        );
    }

    public static String printArray(int[] arr, int leftPad) {
        return Arrays.toString(
                Arrays.stream(arr).mapToObj(v -> leftPad("" + v, leftPad)).toArray()
        );
    }

    public static String printList(List<?> list, int leftPad) {
        return printArray(list.toArray(), leftPad);
    }

    public static String printRange(int from, int to, int leftPad) {
        return Arrays.toString(
                IntStream.range(from, to).mapToObj(v -> leftPad("" + v, leftPad)).toArray()
        );
    }
}
