package ru.roman.task.gfg.string;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * дано массив строк, задаётся ввиде   String[] data={"abc", "bac", "abc", "d", "et", "d", "et", "zzz"};
 * найти строки состоящие из одинакового набора букв, например строки "aa" и "aaa" - разные
 * "abb" и "bba"  и "bab" - одинаковые, исходный массив менять нельзя,
 * результат распечать в виде индексов элементов на консоль, строки без дубликатов - не выводить
 * <p>
 * пример результата для массива из задачи (форматирование может быть любое):
 * abc 0,1,2
 * d 3,5
 * et 4,6
 */
class PrintAnagramsOnly {
    public void solution(String[] data) {
        System.out.printf("On input: %s%n", Arrays.toString(data));

        List<Map<Character, Long>> allSigns = Arrays.stream(data)
                .map(a -> asSign(a))
                .collect(Collectors.toList());

        Set<Map<Character, Long>> duplicates = allSigns.stream()
                .collect(Collectors.toMap(
                        c -> c, c -> 1L, Long::sum, LinkedHashMap::new
                ))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (Map<Character, Long> sign : duplicates) {

            int idx = allSigns.indexOf(sign);
            System.out.printf("%s", data[idx]);

            for (int i = 0; i < allSigns.size(); i++) {
                if (allSigns.get(i).equals(sign)) {
                    System.out.printf(" %s", i);
                }
            }
            System.out.println();
        }
    }

    private static Map<Character, Long> asSign(String a) {
        return a.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, c -> 1L, Long::sum));
    }
}
