package ru.roman.task.codility.a010_prime_and_composite;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A peak is an array element which is larger than its neighbors. More precisely, it is an index P such that 0 < P < N − 1,  A[P − 1] < A[P] and A[P] > A[P + 1].
 * <p>
 * For example, the following array A:
 * <pre>
 * A[0] = 1
 * A[1] = 2
 * A[2] = 3
 * A[3] = 4
 * A[4] = 3
 * A[5] = 4
 * A[6] = 1
 * A[7] = 2
 * A[8] = 3
 * A[9] = 4
 * A[10] = 6
 * A[11] = 2
 * </pre>
 * has exactly three peaks: 3, 5, 10.
 * <p>
 * We want to divide this array into blocks containing the same number of elements. More precisely, we want to choose a number K that will yield the following blocks:
 * <pre>
 * A[0], A[1], ..., A[K − 1],
 * A[K], A[K + 1], ..., A[2K − 1],
 * ...
 * A[N − K], A[N − K + 1], ..., A[N − 1].
 * </pre>
 * What's more, every block should contain at least one peak. Notice that extreme elements of the blocks (for example A[K − 1] or A[K]) can also be peaks, but only if they have both neighbors (including one in an adjacent blocks).
 * <p>
 * The goal is to find the maximum number of blocks into which the array A can be divided.
 * <p>
 * Array A can be divided into blocks as follows:
 * <p>
 * one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains three peaks.
 * <p>
 * two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has a peak.
 * <p>
 * three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has a peak.
 * <p>
 * Notice in particular that the first block (1, 2, 3, 4) has a peak at A[3], because A[2] < A[3] > A[4], even though A[4] is in the adjacent block.
 * However, array A cannot be divided into four blocks, (1, 2, 3), (4, 3, 4), (1, 2, 3) and (4, 6, 2), because the (1, 2, 3) blocks do not contain a peak. Notice in particular that the (4, 3, 4) block contains two peaks: A[3] and A[5].
 * <p>
 * The maximum number of blocks that array A can be divided into is three.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the maximum number of blocks into which A can be divided.
 * <p>
 * If A cannot be divided into some number of blocks, the function should return 0.
 * <p>
 * For example, given:
 * <pre>
 * A[0] = 1
 * A[1] = 2
 * A[2] = 3
 * A[3] = 4
 * A[4] = 3
 * A[5] = 4
 * A[6] = 1
 * A[7] = 2
 * A[8] = 3
 * A[9] = 4
 * A[10] = 6
 * A[11] = 2</pre>
 * the function should return 3, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [0..1,000,000,000].
 */
class Solution3Peaks {
    public int solution(int[] A) {
        System.out.printf("On input: %s\n", Arrays.toString(A));

        if (A.length < 3) {
            return 0;
        }

        int[] peaks = new int[A.length];
        int count = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
                count++;
            }
            peaks[i] = count;
        }
        peaks[peaks.length - 1] = peaks[peaks.length - 2];

        System.out.printf("Peaks   : %s\n", Arrays.toString(peaks));

        double sqrt = Math.sqrt((double) A.length);

        int div = (int) sqrt;
        if (sqrt - div > 0) {
            while (A.length % div != 0) {
                div--;
            }
        }

        TreeSet<Integer> dividers = new TreeSet<>();
        while (div > 1) {
            if (A.length % div == 0) {
                dividers.add(div);
                dividers.add(A.length / div);
            }
            div--;
        }
        dividers.add(A.length);

        System.out.printf("Square root: %s, dividers: %s\n", sqrt, dividers);

        Iterator<Integer> iterator = dividers.iterator();
        outer:
        while (iterator.hasNext()) {
            Integer d = iterator.next();

            for (int i = d; i <= A.length; i += d) {
                int startIndex = i - d - 1;
                int stopIndex = i - 1;
                int peaksCount = peaks[stopIndex] - (startIndex > 0 ? peaks[startIndex] : 0);

                System.out.printf("Check: [%s;%s], peaks: %s, divider: %s \n", startIndex, stopIndex, peaksCount, d);
                if (peaksCount < 1) {
                    continue outer;
                }
            }
            return A.length / d;
        }
        return 0;
    }
}
