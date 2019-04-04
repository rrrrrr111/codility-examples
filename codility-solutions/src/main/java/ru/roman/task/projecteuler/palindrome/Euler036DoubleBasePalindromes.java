package ru.roman.task.projecteuler.palindrome;

/**
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 * <p>
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * <p>
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */
public class Euler036DoubleBasePalindromes {

    public static void main(String[] a) {

        long sum = 0;
        for (int i = 1; i < 1000000; i++) {
            if (isPalindrome(Integer.toString(i, 10))
                    && isPalindrome(Integer.toString(i, 2)))
                sum += i;
        }

        System.out.println(sum);
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
