package ru.roman.task.codility.a04_counting;

import java.util.Arrays;

/**
 *
 */
class Solution3MissingInteger {
    public int solution(int[] A) {
        System.out.println("On input: " + Arrays.toString(A));

        int[] counters = transformToCounters(A);

        for (int i = 1; i < counters.length; i++) {
            int counter = counters[i];
            if (counter == 0) {
                return i;
            }
        }
        return 0;
    }


    private int[] transformToCounters(int[] A) {
        int[] counters = new int[1_000_001];
        for (int a : A) {
            if (a < 1) {
                continue;
            }
            counters[a]++;
        }
        return counters;
    }
}
