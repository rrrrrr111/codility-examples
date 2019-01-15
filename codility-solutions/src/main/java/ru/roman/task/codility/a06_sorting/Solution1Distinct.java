package ru.roman.task.codility.a06_sorting;

import java.util.Arrays;

/**
 *
 */
class Solution1Distinct {
    public int solution(int[] A) {
        System.out.printf("On input: %s\n", Arrays.toString(A));

        if (A.length == 0) {
            return 0;
        }

        Arrays.sort(A);

        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                count++;
            }
        }
        return count;
    }
}
