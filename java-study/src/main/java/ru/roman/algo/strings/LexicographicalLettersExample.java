package ru.roman.algo.strings;

import com.google.common.base.Preconditions;

public class LexicographicalLettersExample {

    public static void main(String[] args) {

        Preconditions.checkState(isLexicographicalOrder("abcdefghijklmnopqrstuvwxyz"));
        Preconditions.checkState(!isLexicographicalOrder("ba"));
        Preconditions.checkState(!isLexicographicalOrder("bbbbbbbbbbbbbbbbaaaaaaaaaa"));
        Preconditions.checkState(isLexicographicalOrder("aaaaaaaaaabbbbbbbbbbbbbbbb"));
        Preconditions.checkState(isLexicographicalOrder("aaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    private static boolean isLexicographicalOrder(String s) {
        return isLexicographicalOrder(s.toCharArray());
    }

    private static boolean isLexicographicalOrder(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] > chars[i + 1])
                return false;
        }
        return true;
    }
}
