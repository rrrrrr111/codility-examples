package ru.roman.jcl.util.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * JCL API Examples
 */
class StreamExamples {

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

        long i1 = List.of(1, 2, 3, 3, 3, 2, 1).stream()               // remove duplicates and count
                .mapToInt(i -> i)
                .distinct()
                .count();

        Map<String, Integer> sorted = Map.of("word", 1, "foo", 2)    // sort Map in reverse order
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))  // just comparator
                .collect(Collectors.toMap(
                        Map.Entry::getKey,                                       // key function
                        Map.Entry::getValue,                                     // value function
                        (val1, val2) -> val2,                                    // merge value function for key collisions
                        LinkedHashMap::new)                                      // map factory
                );

        Map<Integer, String> brandMap = List.of("11", "22").stream()             // List as Map
                .collect(Collectors.toMap(String::hashCode, Function.identity()));
        // Unlike a groupingBy operation, Map will throw as exception in case of key collisions,
        // so, need to use overloading method with union function if keys duplicated

        // суммирующий коллектор
        Collector<Person, ?, Integer> summingSalaries = Collectors.summingInt(Person::getSalary);

        Collector<Person, ?, Map<Sex, List<Person>>> c1 =             // multimap с листом
                Collectors.groupingBy(Person::getGender);             // classifier функция ключа

        Collector<Person, ?, Map<Sex, Set<Integer>>> c2 =             // multimap с желаемой коллекцией
                Collectors.groupingBy(Person::getGender,              // classifier функция ключа
                        Collectors.mapping(Person::getSalary,         // вторым парамтером идет собирающий значение мапы коллектор
                                Collectors.toCollection(LinkedHashSet::new)
                        )
                );

        Collector<Person, ?, Map<Sex, Set<Integer>>> c3 =               // все groupingBy объединяют значения с одинаковым
                Collectors.groupingBy(Person::getGender,                // classifier последующим коллектором
                        LinkedHashMap::new,                             // c тремя параметрами, вторым идет фабрика самой мапы
                        Collectors.mapping(Person::getSalary,           // мапиг коллектор трансфорирует и передает следующему
                                Collectors.toCollection(LinkedHashSet::new)    // коллектору
                        )
                );


        // комбинирование коллекторов для multimap
        Map<Sex, List<String>> namesByGender = List.of(new Person())
                .stream()
                .collect(Collectors.groupingBy(           // через коллектор группирующий в Map, или в Multimap
                        Person::getGender,                // classifier - функция ключа
                        Collectors.mapping(               // значение мапы собирай коллектором мапящим (преобразование и складывание в ...)
                                Person::getName,          // classifier - функция на что мапить сущность
                                Collectors.toList())      // коллектор собирающий результаты всё переданное ему в лист
                ));

        Collector<Person, TreeSet<Person>, TreeSet<Person>> intoSet =     // свой Collector собрающий к TreeSet
                Collector.of(
                        TreeSet::new,                // supplier() - Supplier - создание контейнера
                        TreeSet::add,                // accumulator() - BiConsumer - включение элемента в контейнер
                        (left, right) -> {           // combiner() - BinaryOperator - сборка двух результирующих контейнеров в один
                            left.addAll(right);
                            return left;
                        }
                );                          // finisher() - Function - опционально финализирующая трансформация
        // есть соотв оверлод
        // аналог но только с  Supplier
        Collector<Person, ?, NavigableSet<Person>> c = Collectors.toCollection(TreeSet::new);

        Map<Character, Long> m1 = "aaabb".chars()              // make a sign map for a string like Map['a'->3, 'b'->2]
                .collect(HashMap::new,                                // prepare container
                        (mapa, ch) ->                                 // put value to container
                                mapa.merge(
                                        (char) ch,                            // put key
                                        1L,                             // put value
                                        (oldVal, newVal) -> oldVal + newVal   // merge values in case of key collision
                                ),
                        (left, right) ->
                                right.forEach((key, value) ->              // merge right map two left map
                                        left.merge(key, value, (oldVal, newVal) -> oldVal + newVal))
                );

        Map<Character, Long> m5 = Map.of();                                // merge two maps
        Map<Character, Long> m4 = m1.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (value1, value2) -> value1 + value2,
                        () -> new HashMap<>(m5))                            // initial container function
                );

        Map<Character, Long> m2 = Stream.concat(
                m1.entrySet().stream(), m4.entrySet().stream()              // merge two maps
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (value1, value2) -> value1 + value2));

        Map<Character, Long> m3 = Stream.of(m1, m2)                         // merge two maps
                .flatMap(mapa -> mapa.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (value1, value2) -> value1 + value2));
    }

    private enum Sex {
        MALE, FEMALE
    }

    private static class Person {
        Sex getGender() {
            return null;
        }

        String getName() {
            return null;
        }

        int getSalary() {
            return 0;
        }
    }
}
