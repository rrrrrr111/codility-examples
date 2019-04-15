package ru.roman.task.codility.other_tests.strings;

import java.util.Arrays;

/**
 * If Strings are equals return "EQUAL"
 * If Strings are equal after one replacement, return REPLACE %s %s, for example "tent", "test" -> "REPLACE n s"
 * If Strings are equal after one insert, return INSERT %s, for example "tent", "ten" -> "INSERT t"
 * If Strings are equal after one swap, return SWAP %s %s, for example "tent", "tnet" -> "SWAP e n"
 * Else return "IMPOSSIBLE"
 */
class Solution1AdjustStrings {

    public String solution(String S, String T) {

        if (S.equals(T)) {
            return "EQUAL";
        }
        final int diff = Math.abs(S.length() - T.length());
        if (diff > 1) {
            return "IMPOSSIBLE";
        }

        final char[] sChars = S.toCharArray(), tChars = T.toCharArray();
        final char[] all = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        if (diff == 0) {

            for (int i = 0; i < sChars.length; i++) {
                for (char c : all) {

                    char[] arr = Arrays.copyOf(sChars, sChars.length);
                    char prev = arr[i];
                    arr[i] = c;

                    if (Arrays.equals(arr, tChars)) return String.format("REPLACE %s %s", prev, c);
                }
            }

            for (int i = 0; i < sChars.length - 1; i++) {

                char[] arr = Arrays.copyOf(sChars, sChars.length);
                char curr = arr[i];
                char next = arr[i + 1];
                arr[i] = next;
                arr[i + 1] = curr;

                if (Arrays.equals(arr, tChars)) return String.format("SWAP %s %s", curr, next);
            }
        }

        if (sChars.length < tChars.length) {
            for (char c : all) {
                for (int i = 0; i < S.length() + 1; i++) {
                    StringBuilder b = new StringBuilder(S);

                    if (b.insert(i, c).toString().equals(T)) {
                        return "INSERT " + c;
                    }
                }
            }
        } else {
            for (char c : all) {
                for (int i = 0; i < T.length() + 1; i++) {

                    StringBuilder b = new StringBuilder(T);
                    if (b.insert(i, c).toString().equals(S)) {
                        return "INSERT " + c;
                    }
                }
            }
        }
        return "IMPOSSIBLE";
    }
}
