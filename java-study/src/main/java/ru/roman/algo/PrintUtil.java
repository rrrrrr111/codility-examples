package ru.roman.algo;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.apache.commons.lang3.StringUtils.leftPad;

final class PrintUtil {
    private PrintUtil() {
    }

    static String printArray(Object[] arr, int leftPad) {
        return Arrays.toString(
                Arrays.stream(arr).map(v -> leftPad("" + v, leftPad)).toArray()
        );
    }

    static String printArray(int[] arr, int leftPad) {
        return Arrays.toString(
                Arrays.stream(arr).mapToObj(v -> leftPad("" + v, leftPad)).toArray()
        );
    }

    static String printRange(int from, int to, int leftPad) {
        return Arrays.toString(
                IntStream.range(from, to).mapToObj(v -> leftPad("" + v, leftPad)).toArray()
        );
    }
}
