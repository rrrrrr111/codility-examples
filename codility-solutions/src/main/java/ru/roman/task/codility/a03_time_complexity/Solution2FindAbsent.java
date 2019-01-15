package ru.roman.task.codility.a03_time_complexity;

/**
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 *
 * Your goal is to find that missing element.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A, returns the value of the missing element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
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
