package ru.roman.task.codility.a008_leader;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * The leader of this array is the value that occurs in more than half of the elements of A.
 * <p>
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * we can find two equi leaders:
 * <p>
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 * 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
 * The goal is to count the number of equi leaders.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * the function should return 2, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 */
class Solution1EquiLeader {
    public int solution(int[] A) {
        System.out.printf("On input: %s\n", Arrays.toString(A));

        if (A.length < 2) {
            return 0;
        }

        int[] counters = new int[A.length];
        Integer leader = findLeader(A, counters);
        if (leader == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < counters.length - 1; i++) {

            int leftCount = counters[i];
            int rightCount = counters[counters.length - 1] - counters[i];

            if (leftCount > (i + 1) / 2
                    && rightCount > (counters.length - i - 1) / 2) {
                count++;
            }
        }
        return count;
    }

    private Integer findLeader(int[] A, int[] counters) {
        Integer leader = null, count = 0;
        for (int a : A) {
            if (leader == null) {
                leader = a;
                count++;
            } else if (leader == a) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                leader = null;
            }
        }
        if (leader == null) {
            return null;
        }
        count = 0;
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            if (a == leader) {
                count++;
            }
            counters[i] = count;
        }
        return count > A.length / 2 ? leader : null;
    }
}
