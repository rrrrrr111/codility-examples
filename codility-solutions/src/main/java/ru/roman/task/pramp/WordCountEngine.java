package ru.roman.task.pramp;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Word Count Engine
 * Implement a document scanning function wordCountEngine, which receives a string document and returns a list
 * of all unique words in it and their number of occurrences, sorted by the number of occurrences in a
 * descending order. If two or more words have the same count, they should be sorted according to their order
 * in the original sentence. Assume that all letters are in english alphabet. You function should be
 * case-insensitive, so for instance, the words “Perfect” and “perfect” should be considered the same word.
 * <p>
 * The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.
 * <p>
 * Analyze the time and space complexities of your solution. Try to optimize for time while keeping a
 * polynomial space complexity.
 * <p>
 * Examples:
 * <p>
 * input:  document = "Practice makes perfect. you'll only
 * get Perfect by practice. just practice!"
 * <p>
 * output: [ ["practice", "3"], ["perfect", "2"], ["makes", "1"], ["youll", "1"], ["only", "1"],
 * ["get", "1"], ["by", "1"], ["just", "1"] ]
 * Important: please convert the occurrence integers in the output list to strings (e.g. "3" instead of 3).
 * We ask this because in compiled languages such as C#, Java, C++, C etc., it’s not straightforward to create
 * mixed-type arrays (as it is, for instance, in scripted languages like JavaScript, Python, Ruby etc.). The
 * expected output will simply be an array of string arrays.
 * <p>
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * [input] string document
 * [output] array.array.string
 */
class WordCountEngine {

    static String[][] wordCountEngine(String document) {
        System.out.printf("On input: %s\n", document);

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
