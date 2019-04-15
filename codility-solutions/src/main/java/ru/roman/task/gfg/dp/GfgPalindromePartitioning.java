package ru.roman.task.gfg.dp;

/**
 *
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

        int[] C = new int[length];  // C[i] = Minimum number of cuts needed for palindrome partitioning of substring  str[0..i]
        boolean[][] P = new boolean[length][length];   // P[i][j] = true if substring str[i..j] is palindrome, else false

        int i, j, k, L;
        for (i = 0; i < length; i++) {
            P[i][i] = true;
        }

        /* L is substring length. Build the solution in bottom up manner by considering all substrings of length starting from 2 to n. */
        for (L = 2; L <= length; L++) {
            // For substring of length L, set different
            // possible starting indexes
            for (i = 0; i < length - L + 1; i++) {
                j = i + L - 1; // Set ending index

                // If L is 2, then we just need to
                // compare two characters. Else need to
                // check two corner characters and value
                // of P[i+1][j-1]
                boolean charsEquals = str.charAt(i) == str.charAt(j);
                if (L == 2)
                    P[i][j] = charsEquals;
                else
                    P[i][j] = charsEquals && P[i + 1][j - 1];
            }
        }

        for (i = 0; i < length; i++) {
            if (P[0][i])
                C[i] = 0;
            else {
                C[i] = Integer.MAX_VALUE;
                for (j = 0; j < i; j++) {
                    if (P[j + 1][i] && 1 +
                            C[j] < C[i])
                        C[i] = 1 + C[j];
                }
            }
        }
        // Return the min cut value for complete string. i.e., str[0..n-1]
        return C[length - 1];
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
