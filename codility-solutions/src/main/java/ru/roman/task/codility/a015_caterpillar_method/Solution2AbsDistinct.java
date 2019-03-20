package ru.roman.task.codility.a015_caterpillar_method;

import java.util.stream.IntStream;

import static java.lang.Math.abs;

/**
 * A non-empty array A consisting of N numbers is given. The array is sorted in non-decreasing order. The absolute distinct count of this array is the number of distinct absolute values among the elements of the array.
 * <p>
 * For example, consider array A such that:
 * <pre>
 * A[0] = -5
 * A[1] = -3
 * A[2] = -1
 * A[3] =  0
 * A[4] =  3
 * A[5] =  6
 * </pre>
 * The absolute distinct count of this array is 5, because there are 5 distinct absolute values among the elements of this array, namely 0, 1, 3, 5 and 6.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N numbers, returns absolute distinct count of array A.
 * <p>
 * For example, given array A such that:
 * <pre>
 * A[0] = -5
 * A[1] = -3
 * A[2] = -1
 * A[3] =  0
 * A[4] =  3
 * A[5] =  6
 * </pre>
 * the function should return 5, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647];
 * array A is sorted in non-decreasing order.
 */
class Solution2AbsDistinct {
    public int solution(int[] A) {
//        System.out.printf("On input: %s%n", Arrays.toString(A));

        //return streamAlg(A);
        return caterpillarAlg(A);
    }

    private int streamAlg(int[] A) {
        return (int) IntStream.of(A)
                .map(Math::abs)
                .distinct()
                .count();
    }

    private int caterpillarAlg(int[] A) {
        if (A.length == 1) {
            return 1;
        } else if (A.length == 2) {
            return abs(A[0]) == abs(A[1]) ? 1 : 2;
        }

        int counter = 0;
        if ((A[0] >= 0 && A[A.length - 1] >= 0)                    // only positive or negative range
                || (A[0] <= 0 && A[A.length - 1] <= 0)) {

            int prev = A[0] - 1;
            for (int a : A) {
                if (prev != a) {
                    counter++;
                }
                prev = a;
            }
            return counter;
        }

        int forwardIdx = 0, backwardIdx = A.length - 1;
        int forwardVal = abs(A[forwardIdx]), backwardVal = A[backwardIdx];
        counter = 2;
        int count, prevCount = 2;
        boolean forwardFinish = false, backwardFinish = false;

        for (;;) {                                              // has positive and negative range
            System.out.printf(">> %s(%s)  %s(%s) >> %s%n", -forwardVal, forwardIdx, backwardVal, backwardIdx, counter);

            count = 0;
            if ((backwardVal < forwardVal || forwardVal == Integer.MIN_VALUE || backwardFinish) && !forwardFinish) {
                if (A[forwardIdx + 1] <= 0 && forwardVal != 0) {
                    forwardVal = abs(A[++forwardIdx]);
                    if (abs(A[forwardIdx - 1]) != forwardVal) count++;
                } else forwardFinish = true;
            } else if ((forwardVal < backwardVal || forwardFinish) && !backwardFinish) {
                if (A[backwardIdx - 1] >= 0 && backwardVal != 0) {
                    backwardVal = A[--backwardIdx];
                    if (A[backwardIdx + 1] != backwardVal) count++;
                } else backwardFinish = true;
            } else {
                if (prevCount > 0) {
                    counter--;
                }

                if (A[forwardIdx + 1] <= 0 && forwardVal != 0) {
                    forwardVal = abs(A[++forwardIdx]);
                    if (abs(A[forwardIdx - 1]) != forwardVal) count++;
                } else forwardFinish = true;
                if (A[backwardIdx - 1] >= 0 && backwardVal != 0) {
                    backwardVal = A[--backwardIdx];
                    if (A[backwardIdx + 1] != backwardVal) count++;
                } else backwardFinish = true;
            }
            prevCount = count;
            counter += count;
            if (forwardFinish && backwardFinish) {
                break;
            }
        }
        return counter;
    }
}