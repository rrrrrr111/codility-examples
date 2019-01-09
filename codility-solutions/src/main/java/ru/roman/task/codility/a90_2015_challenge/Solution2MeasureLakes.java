package ru.roman.task.codility.a90_2015_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are helping a geologist friend investigate an area with mountain lakes. A recent heavy rainfall has flooded these lakes and their water levels have reached the highest possible point. Your friend is interested to know the maximum depth in the deepest part of these lakes.
 * <p>
 * We simplify the problem in 2-D dimensions. The whole landscape can be divided into small blocks and described by an array A of length N. Each element of A is the altitude of the rock floor of a block (i.e. the height of this block when there is no water at all). After the rainfall, all the low-lying areas (i.e. blocks that have higher blocks on both sides) are holding as much water as possible. You would like to know the maximum depth of water after this entire area is flooded. You can assume that the altitude outside this area is zero and the outside area can accommodate infinite amount of water.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 2
 * A[3] = 1
 * A[4] = 2
 * A[5] = 1
 * A[6] = 5
 * A[7] = 3
 * A[8] = 3
 * A[9] = 4
 * A[10] = 2
 * The following picture illustrates the landscape after it has flooded:
 * <p>
 * <p>
 * <p>
 * The gray area is the rock floor described by the array A above and the blue area with dashed lines represents the water filling the low-lying areas with maximum possible volume. Thus, blocks 3 and 5 have a water depth of 2 while blocks 2, 4, 7 and 8 have a water depth of 1. Therefore, the maximum water depth of this area is 2.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the maximum depth of water.
 * <p>
 * Given array A shown above, the function should return 2, as explained above.
 * <p>
 * For the following array:
 * <p>
 * A[0] = 5
 * A[1] = 8
 * the function should return 0, because this landscape cannot hold any water.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..100,000,000].
 */
class Solution2MeasureLakes {
    public int solution(int[] A) {
        System.out.println("On input: " + Arrays.toString(A));

        if (A.length < 3) {
            return 0;
        }

        final List<Integer> tops = findAllTops(A);
        System.out.println("Top indexes found: " + tops);
        if (tops.size() < 2) {
            return 0;
        }

        int peakIndex = findPeak(tops, A);
        System.out.println("Peak value found at index: " + peakIndex);

        int topsRemoved;
        while ((topsRemoved = removeMinorTops(tops, A, 1, peakIndex)) != 0) {
            peakIndex -= topsRemoved;
        }
        System.out.println("Minor tops before peak removed: " + tops);

        while (removeMinorTops(tops, A, peakIndex + 1, tops.size() - 1) != 0) {
        }
        System.out.println("Minor tops after peak removed: " + tops);

        return findDeepestLake(tops, A);
    }

    private int findDeepestLake(List<Integer> tops, int[] A) {
        int depth;
        int maxDepth = 0;

        for (int i = 0; i < tops.size() - 1; i++) {
            Integer top = tops.get(i);
            Integer nextTop = tops.get(i + 1);

            depth = findMaxDepth(top, nextTop, A);
            maxDepth = Math.max(depth, maxDepth);
        }
        return maxDepth;
    }

    private int findMaxDepth(Integer from, Integer to, int[] A) {

        int maxLevel = Math.min(A[from], A[to]);
        int depth;
        int maxDepth = 0;

        for (int i = from + 1; i < to; i++) {

            depth = maxLevel - A[i];
            maxDepth = Math.max(depth, maxDepth);
        }
        return maxDepth;
    }

    private int removeMinorTops(List<Integer> tops, int[] A, int start, int end) {
        int topsRemoved = 0;
        for (int i = end - 1; i >= start; i--) {
            Integer top = tops.get(i);
            Integer prevTop = tops.get(i - 1);
            Integer nextTop = tops.get(i + 1);
            if (A[top] < A[prevTop] && A[top] < A[nextTop]) {
                tops.remove(i);
                topsRemoved++;
            }
        }
        return topsRemoved;
    }

    private List<Integer> findAllTops(int[] A) {
        final List<Integer> tops = new ArrayList<>(A.length / 2);
        int prevValue = -1;
        boolean asc;
        boolean prevAsc = false;

        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            asc = value >= prevValue;

            if (prevAsc && !asc) {
                tops.add(i - 1);
            }
            prevValue = value;
            prevAsc = asc;
        }
        tops.add(A.length - 1);
        return tops;
    }

    private int findPeak(List<Integer> tops, int[] A) {
        int index = -1;
        int maxTop = 0;

        for (int i = 0; i < tops.size(); i++) {
            Integer top = A[tops.get(i)];
            if (top > maxTop) {
                index = i;
                maxTop = top;
            }
        }

        if (index == -1) {
            throw new IllegalStateException();
        }
        return index;
    }
}
