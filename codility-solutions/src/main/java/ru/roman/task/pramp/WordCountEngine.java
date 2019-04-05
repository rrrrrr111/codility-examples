package ru.roman.task.pramp;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
public class WordCountEngine {

    static String[][] wordCountEngine(String document) {

        Map<String, Integer> map = new LinkedHashMap<>();
        document = document.replaceAll("[^a-zA-Z\\s]", "");
        String[] words = document.split("\\s");

        // is it needed in some optimisation ??
        // what do you mean?
        // can you tell me about your time and space complexity
        // it's hard to conduct an interview like this
        // ok, thank you very much, bue

        for (String word : words) {
            if (word.length() > 0) {
                word = word.toLowerCase();
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        Map<String, Integer> sorted = map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e2,
                        LinkedHashMap::new)
                );

        String[][] res = new String[map.size()][2];
        int i = 0;
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            res[i][0] = entry.getKey();
            res[i][1] = entry.getValue() + "";
            i++;
        }
        return res;
    }
}
