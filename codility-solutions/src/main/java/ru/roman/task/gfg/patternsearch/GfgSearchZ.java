package ru.roman.task.gfg.patternsearch;

import java.util.Arrays;

/**
 *
 */
class GfgSearchZ {
    public static void main(String[] args) {

        //String text = "GEEKS FOR GEEKS", pattern = "GEEK";
        String text = "ABABDABACDABABCABAB", pattern = "ABABCABAB";
        //String text = "THIS IS A TEST TEXT", pattern = "TEST";

        searchZ(text, pattern);
    }

    // prints all occurrences of pattern in text using Z algo
    private static void searchZ(String text, String pattern) {

        String concat = pattern + "$" + text;
        int length = concat.length();

        int[] Z = prepareZ(concat);
        System.out.println("Z array prepared: " + Arrays.toString(Z));

        // now looping through Z array for matching condition
        for (int i = 0; i < length; ++i) {

            // if Z[i] (matched region) is equal to pattern
            // length we got the pattern

            if (Z[i] == pattern.length()) {
                System.out.println("Pattern found at index " + (i - pattern.length() - 1));
            }
        }
    }

    // Fills Z array for given string str[]
    private static int[] prepareZ(String str) {

        int[] Z = new int[str.length()];

        // [L,R] make a window which matches with
        // prefix of s
        int L = 0, R = 0;

        for (int i = 1; i < Z.length; ++i) {

            // if i>R nothing matches so we will calculate.
            // Z[i] using naive way.
            if (i > R) {

                L = R = i;

                // R-L = 0 in starting, so it will start
                // checking from 0'th index. For example,
                // for "ababab" and i = 1, the value of R
                // remains 0 and Z[i] becomes 0. For string
                // "aaaaaa" and i = 1, Z[i] and R become 5

                while (R < Z.length && str.charAt(R - L) == str.charAt(R))
                    R++;

                Z[i] = R - L;
                R--;

            } else {

                // k = i-L so k corresponds to number which
                // matches in [L,R] interval.
                int k = i - L;

                // if Z[k] is less than remaining interval
                // then Z[i] will be equal to Z[k].
                // For example, str = "ababab", i = 3, R = 5
                // and L = 2
                if (Z[k] < R - i + 1)
                    Z[i] = Z[k];

                    // For example str = "aaaaaa" and i = 2, R is 5,
                    // L is 0
                else {


                    // else start from R and check manually
                    L = i;
                    while (R < Z.length && str.charAt(R - L) == str.charAt(R))
                        R++;

                    Z[i] = R - L;
                    R--;
                }
            }
        }
        return Z;
    }
}
