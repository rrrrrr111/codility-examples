package ru.roman.task.projectEuler.palindrome;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Euler004LargestPalindromeProduct {

    public static void main(String[] args) {

        int res = -1;
        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                int m = i * j;
                if (isPalindrome(m) && m > res)
                    res = m;
            }
        }
        System.out.println(res);
    }


    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static boolean isPalindrome(String s) {
        return s.equals(reverse(s));
    }

    private static boolean isPalindrome(int x) {
        return isPalindrome(Integer.toString(x));
    }
}
