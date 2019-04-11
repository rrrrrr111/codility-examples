package ru.roman.task.codility.lessons.a099_future_training;

/**
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S, returns the index (counting from 0) of a character such that the part of the string to the left of that character is a reversal of the part of the string to its right. The function should return −1 if no such index exists.
 * <p>
 * Note: reversing an empty string (i.e. a string whose length is zero) gives an empty string.
 * <p>
 * For example, given a string:
 * <p>
 * "racecar"
 * <p>
 * the function should return 3, because the substring to the left of the character "e" at index 3 is "rac", and the one to the right is "car".
 * <p>
 * Given a string:
 * <p>
 * "x"
 * <p>
 * the function should return 0, because both substrings are empty.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * the length of S is within the range [0..2,000,000].
 */
class Solution3StrSymmetryPoint {
    public int solution(String S) {
        System.out.printf("On input: %s%n", S);

        if (S.length() == 0)
            return -1;
        if (S.length() == 1)
            return 0;
        if (S.length() % 2 == 0)
            return -1;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(S.length() - i - 1))
                return -1;
        }
        return S.length() / 2;
    }
}
