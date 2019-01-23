package ru.roman.task.codility.a007_stacks_and_queues;

import java.util.Deque;
import java.util.LinkedList;

/**
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 *
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 *
 * Write a function:
 *
 * class Solution { public int solution(String S); }
 *
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 *
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 */
class Solution1BracketsNesting {
    public int solution(String S) {
        System.out.printf("On input: %s\n", S);

        Deque<Character> stack = new LinkedList<>();
        for (char c : S.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {

                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                Character bracket = stack.pop();
                if ((bracket == '[' && c != ']')
                        || (bracket == '{' && c != '}')
                        || (bracket == '(' && c != ')')) {
                    return 0;
                }
            }
        }
        return !stack.isEmpty() ? 0 : 1;
    }
}
