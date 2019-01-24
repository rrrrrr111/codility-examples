package ru.roman.samples.array;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 */
public class SieveOfEratosthenesExample {

    public static void main(String[] args) {

        int maxValue = 1_000;
        int[] factors = prepareFactors(maxValue);

        System.out.printf("Nums    : %s%n",
                Arrays.toString(
                        IntStream.range(0, maxValue + 1).mapToObj(SieveOfEratosthenesExample::adjust).toArray()
                )
        );
        System.out.printf("Factors : %s%n",
                Arrays.toString(
                        IntStream.of(factors).mapToObj(SieveOfEratosthenesExample::adjust).toArray()
                )
        );
    }

    private static int[] prepareFactors(int maxValue) {
        int max = maxValue + 1;
        int[] factors = new int[max];

        for (int i = 2; i * i < max; ) {
            int k = i * i;
            while (k < max) {
                factors[k] = i;
                k += i;
            }
            i++;
        }
        return factors;
    }

    private static String adjust(int value) {
        return value > 9
                ? (
                value > 99
                        ? "" + value
                        : " " + value)
                : "  " + value;
    }
}
