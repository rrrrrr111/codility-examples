package ru.roman.task.pramp;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Bracket Match
 * A string of brackets is considered correctly matched if every opening bracket in the string
 * can be paired up with a later closing bracket, and vice versa. For instance, “(())()” is
 * correctly matched, whereas “)(“ and “((” aren’t. For instance, “((” could become correctly
 * matched by adding two closing brackets at the end, so you’d return 2.
 * <p>
 * Given a string that consists of brackets, write a function bracketMatch that takes a bracket
 * string as an input and returns the minimum number of brackets you’d need to add to the
 * input in order to make it correctly matched.
 * <p>
 * Explain the correctness of your code, and analyze its time and space complexities.
 * <p>
 * Examples:
 * <p>
 * input:  text = “(()”
 * output: 1
 * <p>
 * input:  text = “(())”
 * output: 0
 * <p>
 * input:  text = “())(”
 * output: 2
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * <p>
 * [input] string text
 * <p>
 * 1 ≤ text.length ≤ 5000
 * [output] integer
 */
class BracketMatch {

    public int solution(String text) {
        System.out.printf("On input: %s\n", text);

        char[] chars = text.toCharArray();

        Deque<Character> stack = new LinkedList<>();
        int count = 0;

        for (char c : chars) {
            if (c == '(')
                stack.push(c);

            else if (stack.isEmpty())
                count++;

            else
                stack.pop();

        }
        count += stack.size();

        return count;
    }
}
