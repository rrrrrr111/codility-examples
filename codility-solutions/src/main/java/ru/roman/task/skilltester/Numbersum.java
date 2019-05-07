package ru.roman.task.skilltester;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Реализуйте метод <code>numbersum</code>, который принимает массив целых чисел <code>numbers</code> и целое число <code>k</code> и возвращает все уникальные пары чисел, сумма которых равна <code>k</code>.</p>
 */
class Numbersum {
    static class Skilltester {
        static int[][] numbersum(int[] numbers, int k) {
            System.out.printf("On input: %s\n", Arrays.toString(numbers));

            Set<Set<Integer>> set = new HashSet<>();
            for (int i = 0; i < numbers.length; i++)
                for (int j = i + 1; j < numbers.length; j++)
                    if (numbers[i] + numbers[j] == k)
                        set.add(new HashSet<>(Arrays.asList(numbers[i], numbers[j])));


            int[][] result = new int[set.size()][0];
            int i = 0;
            for (Set<Integer> integers : set) {
                result[i] = integers.stream().mapToInt(Number::intValue).toArray();
                i++;
            }
            return result;
        }

        public static void main(String args[]) {
            int[] numbers = {1, 3, 2, 4, 20, 11, 2, 1, 3};
            int[][] result = Skilltester.numbersum(numbers, 5);

            System.out.println(Arrays.deepToString(result));
        }
    }
}
