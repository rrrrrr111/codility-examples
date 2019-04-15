package ru.roman.task.gfg.dp;

/**
 *
 */
class GfgPalindromePartitioning {
    int test(String str) {
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
                if (L == 2)
                    P[i][j] = (str.charAt(i) ==
                            str.charAt(j));
                else
                    P[i][j] = (str.charAt(i) ==
                            str.charAt(j)) && P[i + 1][j - 1];
            }
        }

        for (i = 0; i < length; i++) {
            if (P[0][i] == true)
                C[i] = 0;
            else {
                C[i] = Integer.MAX_VALUE;
                for (j = 0; j < i; j++) {
                    if (P[j + 1][i] == true && 1 +
                            C[j] < C[i])
                        C[i] = 1 + C[j];
                }
            }
        }

        // Return the min cut value for complete
        // string. i.e., str[0..n-1]
        return C[length - 1];
    }
}
