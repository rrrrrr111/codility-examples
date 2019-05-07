package ru.roman.task.blank;

import java.io.Console;
import java.util.Arrays;

/**
 *
 */
class Solution {
    public int solution(int[] A) {
        System.out.printf("On input: %s%n", Arrays.toString(A));

        int i =1;
        while (true) {
            Console console = System.console();
            String str = console.readLine();

            System.out.printf("%d %s%n", i++, str);
        }


        return 0;
    }
}
