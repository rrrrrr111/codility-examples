package ru.roman.task.projectEuler.math.pow;

import java.math.BigInteger;

/**
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * <p>
 * What is the sum of the digits of the number 21000?
 */
public class Euler016PowerDigitSum {

    public static void main(String[] a) {

        String temp = BigInteger.ONE.shiftLeft(1000).toString();
        int sum = 0;
        for (int i = 0; i < temp.length(); i++)
            sum += temp.charAt(i) - '0';

        System.out.println(sum);
    }
}
