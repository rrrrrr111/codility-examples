package ru.roman.jcl.util.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class StreamExamples {

    void foo1() {

        long num = Arrays.asList("abc", "", "bcd", "", "defg", "jk")
                .stream()                                              // Count String with length more than 3
                .filter(x -> x.length() > 3)
                .count();

        String G7 = Stream.of("USA", "Japan")                          // Convert String to Uppercase and join them using coma
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));

        List<Integer> distinct = List.of(9, 10, 3, 4, 7, 3, 4)       // Create List of square of all distinct numbers
                .stream()
                .map(i -> i * i)
                .distinct()
                .collect(Collectors.toList());

        IntSummaryStatistics stats = Stream.<Integer>builder().add(2).add(3).add(5).build()
                .mapToInt((x) -> x)                                    // Get count, min, max, sum, and average for numbers
                .summaryStatistics();

        Integer lcm = Stream.iterate(0, i -> ++i)                // Find lcm of 2 and 3
                .filter(i -> i % 2 == 0)
                .filter(i -> i % 3 == 0)
                .findFirst().get();                                    // findFirst()/findAny() returns Optional

        Stream.of("aa", "bbb")                                         // print all
                .forEach(System.out::println);

        Map<String, Integer> sorted = Map.of("word", 1, "foo", 2)    // sort Map in reverse order
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))  // just comparator
                .collect(Collectors.toMap(
                        Map.Entry::getKey,                                       // key function
                        Map.Entry::getValue,                                     // value function
                        (e1, e2) -> e2,                                          // merge value function for key collisions
                        LinkedHashMap::new)                                      // map factory
                );


    }
}
