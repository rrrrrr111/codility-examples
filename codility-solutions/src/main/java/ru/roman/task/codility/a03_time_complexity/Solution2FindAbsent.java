package ru.roman.task.codility.a03_time_complexity;

/**
 *
 */
class Solution2FindAbsent {
    int solution(int[] A) {

        int sum = 0;
        int biggestSum = 0;

        for (int i = 0; i < A.length; i++) {
            int a = A[i];

            sum += a;
            biggestSum += 2 + i;
        }

        return biggestSum - sum + 1;
    }
}
