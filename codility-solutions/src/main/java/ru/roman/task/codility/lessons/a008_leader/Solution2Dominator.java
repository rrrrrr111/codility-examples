package ru.roman.task.codility.lessons.a008_leader;

import java.util.Arrays;

/**
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
 * <p>
 * For example, consider array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 * <p>
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.
 * <p>
 * For example, given array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */
class Solution2Dominator {
    public int solution(int[] A) {
        System.out.printf("On input: %s\n", Arrays.toString(A));

        Integer dominator = null, count = 0, index = -1;
        for (int i = 0; i < A.length; i++) {
            if (dominator == null) {
                dominator = A[i];
                count++;
                index = i;
            } else if (dominator == A[i]) {
                count++;
                index = i;
            } else {
                count--;
            }
            if (count == 0) {
                dominator = null;
            }
        }
        if (dominator == null) {
            return -1;
        }

        count = 0;
        for (int a : A) {
            if (a == dominator) {
                count++;
            }
        }
        return count > A.length / 2 ? index : -1;
    }
}
