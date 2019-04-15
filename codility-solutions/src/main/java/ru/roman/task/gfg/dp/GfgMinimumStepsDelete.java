package ru.roman.task.gfg.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given a string str. You are allowed to delete only some contiguous characters if all the characters are same in a single operation. The task is to find the minimum number of operations required to completely delete the string.
 */
class GfgMinimumStepsDelete {
    int test(String str) {
        System.out.printf("On input: %s%n", str);

        final int[][] dp = new int[100][100];
        final char[] chars = str.toCharArray();

        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        //return recursiveAlg1(0, chars.length - 1, dp, chars);
        return recursiveAlg2(0, chars.length - 1, dp, chars);
    }

    private int recursiveAlg1(int from, int to, int[][] dp, char[] chars) {
        if (from > to) return 0;
        if (from == to) return 1;
        if (dp[from][to] != -1) return dp[from][to];

        // When a single character is deleted
        int res = 1 + recursiveAlg1(from + 1, to, dp, chars);

        // When a group of consecutive characters are deleted if any of them matches
        for (int i = from + 1; i <= to; ++i) {

            // When both the characters are same then delete the letters in between them
            if (chars[from] == chars[i]) {
                res = Math.min(res,
                        recursiveAlg1(from + 1, i - 1, dp, chars) + recursiveAlg1(i, to, dp, chars)
                );
            }
        }
        return dp[from][to] = res;
    }

    private int recursiveAlg2(int from, int to, int[][] dp, char[] chars) {
        if (from > to) return 0;
        if (from == to) return 1;
        if (dp[from][to] != -1) return dp[from][to];
        if (lengthOfSubSequence(chars, from, to) == to - from + 1) return 1;

        int headStrip = lengthOfSubSequence(chars, from, to);
        int tailStrip = lengthOfSubSequence(reverse(chars, from, to + 1), from, to);

        if (chars[from] == chars[to]) {
            return 1 + recursiveAlg2(from + headStrip, to - tailStrip, dp, chars);
        }
        return Math.min(
                1 + recursiveAlg2(from + headStrip, to, dp, chars),
                1 + recursiveAlg2(from, to - tailStrip, dp, chars)
        );
    }

    private static int lengthOfSubSequence(char[] arr, int startIndex, int stopIndex) {
        int value = arr[startIndex];
        int length = 1;
        for (int i = startIndex + 1; i <= stopIndex; i++) {
            if (value != arr[i])
                break;
            length++;
        }
        return length;
    }

    private static char[] reverse(char[] arr, int startIndexInclusive, int endIndexExclusive) {
        final int length = Array.getLength(arr);
        final char[] res = (char[]) newArrayFor(arr, length);

        int i = startIndexInclusive, j = endIndexExclusive - 1;

        if (0 < startIndexInclusive) {
            System.arraycopy(arr, 0, res, 0, startIndexInclusive + 1);
        }
        while (j >= i) {
            res[i] = arr[j];
            res[j] = arr[i];
            j--;
            i++;
        }
        if (endIndexExclusive < length) {
            System.arraycopy(arr, endIndexExclusive, res, endIndexExclusive, length - endIndexExclusive);
        }
        return res;
    }

    private static Object newArrayFor(final Object array, int length) {
        return Array.newInstance(array.getClass().getComponentType(), length);
    }
}
