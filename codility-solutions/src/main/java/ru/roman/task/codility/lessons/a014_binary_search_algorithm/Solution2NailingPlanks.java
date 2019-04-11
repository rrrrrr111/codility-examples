package ru.roman.task.codility.lessons.a014_binary_search_algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * You are given two non-empty arrays A and B consisting of N integers. These arrays represent N planks. More precisely, A[K] is the start and B[K] the end of the K−th plank.
 * <p>
 * Next, you are given a non-empty array C consisting of M integers. This array represents M nails. More precisely, C[I] is the position where you can hammer in the I−th nail.
 * <p>
 * We say that a plank (A[K], B[K]) is nailed if there exists a nail C[I] such that A[K] ≤ C[I] ≤ B[K].
 * <p>
 * The goal is to find the minimum number of nails that must be used until all the planks are nailed. In other words, you should find a value J such that all planks will be nailed after using only the first J nails. More precisely, for every plank (A[K], B[K]) such that 0 ≤ K < N, there should exist a nail C[I] such that I < J and A[K] ≤ C[I] ≤ B[K].
 * <p>
 * For example, given arrays A, B such that:
 * </p>
 * <pre>
 * A[0] = 1    B[0] = 4
 * A[1] = 4    B[1] = 5
 * A[2] = 5    B[2] = 9
 * A[3] = 8    B[3] = 10</pre>
 * <p>
 * four planks are represented: [1, 4], [4, 5], [5, 9] and [8, 10].
 * <p>
 * Given array C such that:
 * <pre>
 * C[0] = 4
 * C[1] = 6
 * C[2] = 7
 * C[3] = 10
 * C[4] = 2</pre>
 * <p>
 * if we use the following nails:
 * <p>
 * 0, then planks [1, 4] and [4, 5] will both be nailed.
 * 0, 1, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
 * 0, 1, 2, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
 * 0, 1, 2, 3, then all the planks will be nailed.
 * Thus, four is the minimum number of nails that, used sequentially, allow all the planks to be nailed.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A, int[] B, int[] C); }
 * <p>
 * that, given two non-empty arrays A and B consisting of N integers and a non-empty array C consisting of M integers, returns the minimum number of nails that, used sequentially, allow all the planks to be nailed.
 * <p>
 * If it is not possible to nail all the planks, the function should return −1.
 * <p>
 * For example, given arrays A, B, C such that:
 * <pre>
 * A[0] = 1    B[0] = 4
 * A[1] = 4    B[1] = 5
 * A[2] = 5    B[2] = 9
 * A[3] = 8    B[3] = 10
 *
 * C[0] = 4
 * C[1] = 6
 * C[2] = 7
 * C[3] = 10
 * C[4] = 2</pre>
 * the function should return 4, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N and M are integers within the range [1..30,000];
 * each element of arrays A, B, C is an integer within the range [1..2*M];
 * A[K] ≤ B[K].
 */
class Solution2NailingPlanks {
    private static boolean withTimePoints = true;
    private static long time;
    private static Map<String, Long> timePoints;

    public int solution(int[] A, int[] B, int[] C) {
        //System.out.printf("On input: %s%n, %s%n, %s%n", Arrays.toString(A), Arrays.toString(B), Arrays.toString(C));
        startTime();

        int[][] nails = prepareNails(C);
        timePoint("prepareNails");

        int[] result = {-2, -2};
        int max = nails[nails.length - 1][1],
                min = nails[0][1],
                plankStart,
                plankEnd;

        NavigableSet<Integer> prefs = new TreeSet<>();

        for (int i = 0; i < A.length; i++) {
            plankStart = A[i];
            plankEnd = B[i];

            if (!prefs.subSet(plankStart, true, plankEnd, true)
                    .isEmpty()) {                                                          // optimisation
                //System.out.println("Opts");
                continue;
            }

            int[] nail = findEarliestNail(plankStart, plankEnd, nails);
            //System.out.println("Nail found: " + Arrays.toString(nail));
            if (nail == null) {
                return -1;
            }
            prefs.add(nail[1]);
            result = result[0] > nail[0] ? result : nail;
        }

        timePoint("mainAlg");
        logTimePoints();
        return result[0] + 1;
    }

    private int[][] prepareNails(int[] C) {
        int nails[][] = new int[C.length][2];
        for (int i = 0; i < C.length; i++) {
            int c = C[i];
            nails[i][0] = i;
            nails[i][1] = c;
        }
        Arrays.sort(nails, Comparator.comparingInt(o -> o[1]));
        return nails;
    }

    private int[] findEarliestNail(int plankStart, int plankEnd, int[][] nails) {
        int beg = 0, end = nails.length - 1;
        int res[] = null, resIdx = -1;
        for (int nail[], midIdx; beg <= end; ) {     // need to find first nail on plank range
            midIdx = (beg + end) / 2;
            nail = nails[midIdx];

            if (plankEnd < nail[1]) {
                end = midIdx - 1;
            } else if (nail[1] < plankStart) {
                beg = midIdx + 1;
            } else {
                res = nail;
                resIdx = midIdx;
                end = midIdx - 1;
            }
        }
        if (res == null) {          // not found
            return null;
        }
        for (int i = resIdx + 1; i < nails.length; i++) {   // check if some nail eager
            int[] nail = nails[i];
            if (nail[1] > plankEnd) {
                return res;
            }
            res = nail[0] < res[0] ? nail : res;
        }
        return res;
    }

    static void startTime() {
        if (withTimePoints) {
            timePoints = new LinkedHashMap<>();
            time = System.currentTimeMillis();
        }
    }

    static void timePoint(String str) {
        if (withTimePoints) {
            long t = System.currentTimeMillis();
            timePoints.put(str, t - time);
            time = t;
        }
    }

    static void logTimePoints() {
        if (withTimePoints) {
            System.out.println("Time Points: " + timePoints);
        }
    }
}
