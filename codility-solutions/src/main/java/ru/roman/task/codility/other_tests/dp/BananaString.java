package ru.roman.task.codility.other_tests.dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Write a program in Java to Calculate the smallest number of letters that must be removed in order for the letters of the remaining word to be sorted in lexicographical order (abcde…wxyz)
 * <p>
 * For example given “banana” the function should return 3 because we can remove three letters (the first 3rd and 6th) to get the word “aan” which is sorted. Please note that it is not possible to be remove fewer than three letters
 * <p>
 * Max str length is 100_000, str consists only of a-z chars
 */
class BananaString {

    public int solution(String str) {
        System.out.printf("On input: %s%n", str);
        char[] chars = str.toCharArray();

        return str.length() - findLongestSequence(chars);
        //return recursiveAlg(chars, new HashMap<>());
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

    private int recursiveAlg(char[] chars, HashMap<String, Integer> cache) {
        final String str = new String(chars);
        if (cache.containsKey(str)) return cache.get(str);

        if (isLexicographicalOrder(chars)) return 0;

        int minDelete = Integer.MAX_VALUE;
        for (int i = 0; i < chars.length; i++) {

            //System.out.println("Splitting onto " + str.substring(from, i + 1) + " and " + str.substring(i + 1, to));
            minDelete = Math.min(
                    minDelete,
                    1 + recursiveAlg(removeElement(chars, i), cache)
            );
        }
        cache.put(str, minDelete);
        return minDelete;
    }


    private static boolean isLexicographicalOrder(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] > chars[i + 1])
                return false;
        }
        return true;
    }

    private static char[] removeElement(char[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) throw new IllegalArgumentException();
        char[] res = new char[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) continue;
            res[k++] = arr[i];
        }
        return res;
    }
}
