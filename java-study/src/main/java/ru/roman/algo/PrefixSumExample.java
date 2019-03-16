package ru.roman.algo;

import static ru.roman.algo.PrintUtil.printArray;

/**
 *
 */
public class PrefixSumExample {

    public static void main(String[] args) {

        int[] array = {1, 1, 1, 3, 5, 6, 4, 3, 2, 1, 1, 1, 1, 1};
        int[][] sums = prepareSums(array);

        System.out.println(printArray(array, 3));
        System.out.println(printArray(sums[0], 3));
        System.out.println(printArray(sums[1], 3));
    }

    private static int[][] prepareSums(int[] array) {
        int[][] pref = new int[2][array.length];

        for (int i = 0; i < array.length; i++) {

            pref[0][i] = i == 0 ? array[i] : pref[0][i - 1] + array[i];
            pref[1][array.length - i - 1] = i == 0
                    ? array[array.length - 1]
                    : pref[1][array.length - i] + array[array.length - i - 1];
        }
        return pref;
    }
}
