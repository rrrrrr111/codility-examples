package ru.roman.task.codility.lessons.a100_other_сhallenges;

import java.util.Arrays;

/**
 * Kate was given a birthday gift of three theater tickets. Now she is browsing the theater
 * program for the next N days. On the program, performances are named by integers. Every day,
 * one performance is staged. Kate wants to choose three days (not necessarily consecutive) to go to the theater.
 * <p>
 * In how many ways can she use her tickets? Two ways are different if the sequences of watched
 * performances are different. Kate likes the theater, so she may watch one performance more
 * than once. For example, if N = 4 and theater program looks as following: [1, 2, 1, 1], Kate
 * has four possibilities to choose the dates: [1, 2, 1, 1], [1, 2, 1, 1], [1, 2, 1, 1],
 * and [1, 2, 1, 1], but they create only three different sequences: (1, 2, 1), (1, 1, 1)
 * and (2, 1, 1). The correct answer for this example is 3. Notice that the order of
 * performances matters, so the first and the last sequences are considered different.
 * <p>
 * Write a function:
 * <p>
 * int solution(int A[], int N);
 * <p>
 * that, given an array A consisting of N integers, denoting names of performances for the next N
 * days, returns the number of possible ways to spend the tickets. Since the answer can be very
 * large, provide it modulo 10^9 + 7 (1,000,000,007).
 * <p>
 * For example, given A = [1, 2, 1, 1], the function should return 3 as explained above.
 * <p>
 * Given A = [1, 2, 3, 4], the function should return 4. There are four ways to spend tickets:
 * (1, 2, 3), (1, 2, 4), (1, 3, 4) and (2, 3, 4).
 * <p>
 * Given A = [2, 2, 2, 2], the function should return 1. There is only one way to spend tickets:
 * (2, 2, 2).
 * <p>
 * Given A = [2, 2, 1, 2, 2], the function should return 4. There are four ways to spend tickets:
 * (1, 2, 2), (2, 1, 2), (2, 2, 1) and (2, 2, 2).
 * <p>
 * Given A = [1, 2], the function should return 0. Kate cannot use all three tickets in only two days.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [1..N].
 */
class Solution2TheaterTickets {
    public int solution(int A[], int N) {
        System.out.println("On input: " + Arrays.toString(A));

        int visits = 3;
        if (A.length < visits) {
            return 0;
        }

        int[] counters = transformToCounters(A, N);
        System.out.println("Counters array: " + Arrays.toString(counters));

        return 0;
    }

    private int[] transformToCounters(int[] A, int range) {
        int[] counters = new int[range + 1];
        for (int a : A) {
            counters[a]++;
        }
        return counters;
    }
}
