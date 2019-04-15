package ru.roman.task.gfg.dp;

/**
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome. For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”. Determine the fewest cuts needed for palindrome partitioning of a given string. For example, minimum 3 cuts are needed for “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”. If a string is palindrome, then minimum 0 cuts are needed. If a string of length n containing all different characters, then minimum n-1 cuts are needed.
 */
class GfgPalindromePartitioning {
    int test(String str) {
        //return recursionAlg(str, 0, str.length());
        return dpAlg(str);
    }

    private int recursionAlg(String str, int from, int to) {

        String subStr = str.substring(from, to);
        //System.out.println("Checking: " + subStr);
        if (subStr.length() < 2
                || isPalindrome(subStr)) return 0;

        int minCuts = Integer.MAX_VALUE;
        for (int i = from; i < to - 1; i++) {

            //System.out.println("Splitting onto " + str.substring(from, i + 1) + " and " + str.substring(i + 1, to));
            minCuts = Math.min(
                    minCuts,
                    recursionAlg(str, from, i + 1)
                            + 1
                            + recursionAlg(str, i + 1, to)
            );
        }
        return minCuts;
    }

    private int dpAlg(String str) {
        System.out.printf("On input: %s%n", str);

        int length = str.length();
        boolean[][] dp = new boolean[length][length];   // dp[start][end] = true if substring str[start..end] is palindrome, else false

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int start, end, len;
        /* len is substring length. Build the solution in bottom up manner by considering all substrings of length starting from 2 to n. */
        for (len = 2; len <= length; len++) {
            // For substring of length len, set different possible starting indexes
            for (start = 0; start < length - len + 1; start++) {
                end = start + len - 1; // Set ending index

                // If len is 2, then we just need to compare two characters. Else need to
                // check two corner characters and value of dp[start+1][end-1]
                boolean charsEq = str.charAt(start) == str.charAt(end);
                dp[start][end] = len == 2 ? charsEq : charsEq && dp[start + 1][end - 1];
            }
        }

        int[] minCuts = new int[length];  // minCuts[start] = Minimum number of cuts needed for palindrome partitioning of substring  str[0..start]
        for (int i = 0; i < length; i++) {
            if (dp[0][i])
                minCuts[i] = 0;
            else {
                minCuts[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i] && 1 + minCuts[j] < minCuts[i])
                        minCuts[i] = 1 + minCuts[j];
                }
            }
        }
        return minCuts[length - 1];
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
