package ru.roman.task.codility.other_tests.strings;

/**
 * If Strings are equals return "EQUAL"
 * If Strings are equal after one replacement, return REPLACE %s %s, for example "tent", "test" -> "REPLACE n s"
 * If Strings are equal after one insert, return INSERT %s, for example "tent", "ten" -> "INSERT t"
 * If Strings are equal after one swap, return SWAP %s %s, for example "tent", "tnet" -> "SWAP e n"
 * Else return "IMPOSSIBLE"
 *
 */
class Solution1AdjustStrings {

    public String solution(String S, String T) {

        if (S.equals(T)) {
            return "EQUAL";
        }
        int diff = Math.abs(S.length() - T.length());
        if (diff > 1) {
            return "IMPOSSIBLE";
        }

        char[] all = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        if (diff == 0) {

            for (int i = 0; i < S.length(); i++) {
                for (char c : all) {

                    char[] arr = S.toCharArray();
                    char prev = arr[i];
                    arr[i] = c;
                    if (String.valueOf(arr).equals(T)) {
                        return String.format("REPLACE %s %s", prev, c);
                    }
                }
            }

            for (int i = 0; i < T.length(); i++) {
                for (char c : all) {

                    char[] arr = T.toCharArray();
                    int prev = arr[i];
                    arr[i] = c;
                    if (String.valueOf(arr).equals(S)) {
                        return String.format("REPLACE %s %s", prev, c);
                    }
                }
            }

            for (int i = 0; i < S.length() - 1; i++) {

                StringBuilder b = new StringBuilder(S);
                char curr = b.charAt(i);
                char next = b.charAt(i + 1);
                b.setCharAt(i, next);
                b.setCharAt(i + 1, curr);

                if (b.toString().equals(T)) {
                    return String.format("SWAP %s %s", curr, next);
                }
            }

            for (int i = 0; i < T.length() - 1; i++) {

                StringBuilder b = new StringBuilder(T);
                char curr = b.charAt(i);
                char next = b.charAt(i + 1);
                b.setCharAt(i, next);
                b.setCharAt(i + 1, curr);

                if (b.toString().equals(S)) {
                    return String.format("SWAP %s %s", curr, next);
                }
            }
        }

        if (S.length() < T.length()) {
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
