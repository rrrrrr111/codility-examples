package ru.roman.task.codility.other_tests;

import java.util.Arrays;

/**
 * Write a program in Java to Calculate the smallest number of letters that must be removed in order for the letters of the remaining word to be sorted in lexicographical order (abcde…wxyz)
 * <p>
 * For example given “banana” the function should return 3 because we can remove three letters (the first 3rd and 6th) to get the word “aan” which is sorted. Please note that it is not possible to be remove fewer than three letters
 * <p>
 * Max str length is 100_000, str consists only of a-z chars
 */
class Solution3BananaString {

    public int solution(String str) {

        int l = findLongestSequence(str.toCharArray());
        return str.length() - l;
    }

    private static int findLongestSequence(char[] chars) {
        int[] dp = new int[chars.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < chars.length; i++) {
            for (int j = 0; j < i; j++) {
                int newSeqLength = dp[j] + 1;

                if (chars[j] <= chars[i] && dp[i] < newSeqLength) {
                    dp[i] = newSeqLength;

                    System.out.println(Arrays.toString(dp));
                }
            }
        }

        int res = 0;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}
