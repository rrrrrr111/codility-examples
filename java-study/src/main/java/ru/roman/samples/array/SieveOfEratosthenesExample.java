package ru.roman.samples.array;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.apache.commons.lang3.StringUtils.leftPad;

/**
 *
 */
public class SieveOfEratosthenesExample {

    public static void main(String[] args) {

        int maxValue = 1_000;
        int[] factors = preparePrimeFactors(maxValue);

        System.out.printf("Nums    : %s%n",
                Arrays.toString(
                        IntStream.range(0, maxValue + 1).mapToObj(v -> leftPad("" + v, 3)).toArray()
                )
        );
        System.out.printf("Factors : %s%n",
                Arrays.toString(
                        IntStream.of(factors).mapToObj(v -> leftPad("" + v, 3)).toArray()
                )
        );
    }

    private static int[] preparePrimeFactors(int maxValue) {
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

}
