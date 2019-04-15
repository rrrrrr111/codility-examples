package ru.roman.task.codility.other_tests.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple java code to remove multiple occurrences of characters which occurs more than or equal to the given limit.
 */
class RemoveRecurringCharacters {
    public String solution(String input, int limit) {
        System.out.printf("On input: %s %s%n", input, limit);


        //make a character array with the characters in the input
        char[] karakterler = input.toCharArray();
        Map<Character, Integer> karaktersay = new HashMap<>();
        for (char c : karakterler) {
            if (c != ' ') {//do not count spaces
                if (karaktersay.containsKey(c)) {
                    karaktersay.put(c, karaktersay.get(c) + 1);
                } else {
                    karaktersay.put(c, 1);
                }
            }
        }

        String s = input;
        //remove the characters occured more than or equal to limit
        for (Map.Entry<Character, Integer> e : karaktersay.entrySet()) {
            if (e.getValue() >= limit) {
                //System.out.println("harf: " + e.getKey() + "  sayisi " + e.getValue());
                s = s.replaceAll(e.getKey().toString(), "");
                //System.out.println(s);
            }
        }
        return s;
    }
}
