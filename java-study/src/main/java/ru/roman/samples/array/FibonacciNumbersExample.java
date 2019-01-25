package ru.roman.samples.array;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.apache.commons.lang3.StringUtils.leftPad;

/**
 *
 */
public class FibonacciNumbersExample {

    public static void main(String[] args) {

        int maxValue = 46;
        int[] factors = prepareFibonacciNumbers(maxValue);

        System.out.printf("Nums     : %s%n",
                Arrays.toString(
                        IntStream.range(0, maxValue + 1).mapToObj(v -> leftPad("" + v, 10)).toArray()
                )
        );
        System.out.printf("Fibonacci: %s%n",
                Arrays.toString(
                        IntStream.of(factors).mapToObj(v -> leftPad("" + v, 10)).toArray()
                )
        );
    }

    private static int[] prepareFibonacciNumbers(int maxValue) {
        int max = maxValue + 1;
        int[] result = new int[max];
        result[1] = 1;

        for (int i = 2; i < max; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }

}