package ru.roman.algo.strings;

/**
 *
 */
public class PalindromeExample {

    public static void main(String[] args) {

        print(80677608);
        print(113323311);
        print(806776080);
    }

    private static void print(int num) {
        boolean res = isPalindrome(num);
        System.out.printf("Num %s is palindrome: %s", num, res);
        System.out.println();
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
