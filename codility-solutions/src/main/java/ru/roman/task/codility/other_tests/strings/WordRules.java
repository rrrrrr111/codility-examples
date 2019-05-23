package ru.roman.task.codility.other_tests.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given a rules like ["I>N", "S>P", "A>I", "P>A"],
 * where every first char is a char standing in the word exactly before second char,
 * need to build the original word, so for given example the result word is SPAIN.
 * All characters in rules are unique.
 */
class WordRules {

    public String findWord(String[] rules) {
        System.out.printf("On input: %s%n", Arrays.toString(rules));

        Map<Character, Character> map = Arrays.stream(rules)
                .map(String::toCharArray)
                .collect(Collectors.toMap(chars -> chars[0], chars -> chars[2]));

        Set<Character> placed = new HashSet<>(rules.length + 1);
        List<Character> list = new ArrayList<>(rules.length + 1);

        Map.Entry<Character, Character> first = map.entrySet().iterator().next();
        list.add(first.getKey());
        list.add(first.getValue());
        placed.add(first.getKey());
        placed.add(first.getValue());

        System.out.printf("Map:%s list:%s placed:%s%n", map, list, placed);

        while (placed.size() != map.size() + 1)
            for (Map.Entry<Character, Character> entry : map.entrySet()) {

                if (placed.contains(entry.getKey()) && placed.contains(entry.getValue()))
                    continue;

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals(entry.getValue())) {

                        list.add(i, entry.getKey());
                        placed.add(entry.getKey());
                        break;
                    } else if (list.get(i).equals(entry.getKey())) {
                        list.add(i + 1, entry.getValue());
                        placed.add(entry.getValue());
                        break;
                    }
                }
            }

        return list.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
