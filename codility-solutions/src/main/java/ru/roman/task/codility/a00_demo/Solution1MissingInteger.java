package ru.roman.task.codility.a00_demo;

import java.util.Arrays;

/**
 *
 */
class Solution1MissingInteger {
    public int solution(int[] A) {

        Arrays.sort(A);
        //System.out.println("On input: " + Arrays.toString(A));

        int prev = A[0];
        if (prev > 1) {
            return 1;
        }

        Integer val = null;
        for (int i = 1; i < A.length; i++) {
            int a = A[i];

            if (a > 1) {
                int diff = a - prev;
                if (diff > 1) {
                    val = prev + 1;
                    if (val < 1) {
                        val = 1;
                    }
                    break;
                }
            }
            prev = a;
        }
        if (val != null) {
            return val;
        }
        val = A[A.length - 1] + 1;

        if (val < 1) {
            val = 1;
        }
        return val;
    }
}
