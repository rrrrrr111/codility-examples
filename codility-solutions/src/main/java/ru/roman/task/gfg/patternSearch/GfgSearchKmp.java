package ru.roman.task.gfg.patternSearch;

import java.util.Arrays;

/**
 * KMP Algorithm for Pattern Searching
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.
 */
class GfgSearchKmp {
    public static void main(String[] args) {

        String text = "GEEKS FOR GEEKS", pattern = "GEEK";
        //String text = "ABABDABACDABABCABAB", pattern = "ABABCABAB";
        //String text = "THIS IS A TEST TEXT", pattern = "TEST";

        searchKmp(pattern, text);
    }


    private static void searchKmp(String pat, String txt) {
        int textLength = txt.length();

        // create lps[] that will hold the longest prefix suffix values for pattern
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[] array)
        int[] lps = prepareLps(pat);
        System.out.println("LSP array prepared: " + Arrays.toString(lps));

        int i = 0; // index for txt[]
        while (i < textLength) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == lps.length) {
                System.out.println("Found pattern " + "at index " + (i - j));
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < textLength && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    private static int[] prepareLps(String pat) {

        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        int[] lps = new int[pat.length()];
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < lps.length) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
    }
}
