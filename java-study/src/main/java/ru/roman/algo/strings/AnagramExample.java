package ru.roman.algo.strings;

import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class AnagramExample {

    public static void main(String[] args) {

        Preconditions.checkState(isAnagrams("a", "a"));
        Preconditions.checkState(!isAnagrams("b", "a"));
        Preconditions.checkState(!isAnagrams("aa", "a"));
        Preconditions.checkState(isAnagrams("ba", "ab"));
        Preconditions.checkState(!isAnagrams("ж", "м"));
        Preconditions.checkState(isAnagrams("м", "м"));
        Preconditions.checkState(!isAnagrams(null, null));
        Preconditions.checkState(!isAnagrams("", null));
        Preconditions.checkState(!isAnagrams("d", null));
        Preconditions.checkState(!isAnagrams("", ""));
        Preconditions.checkState(!isAnagrams(" ", " "));

        Preconditions.checkState(isAnagrams("baba", "abba"));
        Preconditions.checkState(isAnagrams("тор", "рот"));
        Preconditions.checkState(!isAnagrams("aaabb", "aabbb"));
        Preconditions.checkState(!isAnagrams("aabbb", "aaabb"));
        Preconditions.checkState(!isAnagrams("тор", "роj"));
    }

    /**
     * Computation complexity O(a + b)
     * Space complexity O(chars range)
     */
    private static boolean isAnagrams(String a, String b) {
        if (a == null || b == null
                || a.isBlank() || b.isBlank()
                || a.length() != b.length())
            return false;

        return asMap(b).equals(asMap(a));
        //return Arrays.equals(signature(b), signature(a));
    }

    private static Map<Character, Long> asMap(String a) {
//        Map<Character, Integer> counters = new HashMap<>();
//        char[] chars = a.toCharArray();
//        for (char aChar : chars) {
//            counters.put(aChar, counters.getOrDefault(aChar, 0) + 1);
//        }
//        return counters;

        return a.chars()
                .collect(HashMap::new,
                        (map, c) -> map.merge((char) c, 1L, (old, newVal) -> old + newVal),
                        (left, right) ->
                                right.forEach((key, value) ->
                                        left.merge(key, value, (old, newVal) -> old + newVal))
                );
    }

    private static int[] signature(String str) {
        if (str == null) throw new IllegalArgumentException("Given str is null");

        int[] sign = new int[26];
        for (char c : str.toCharArray()) {
            int num = c - 'a';
            if (num < 0 || 25 < num) throw new IllegalArgumentException("Char " + c + " is out of range");
            sign[num]++;
        }
        return sign;
    }
}
