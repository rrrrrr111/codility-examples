package ru.roman.task.projecteuler.math.lcmgcm;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Euler005SmallestMultiple {

    public static void main(String[] a) {

        long res = 1;
        for (int i = 1; i <= 20; i++)
            res = lcm(i, res);

        System.out.println(res);
    }

    private static long lcm(long a, long b) {
        return a * b / gcd3(a, b);
    }

    private static long gcd3(long a, long b) {
        if (a < 0 || b < 0)
            throw new IllegalArgumentException("Negative a:" + a + " or b:" + b);

        long res = 1;

        for (; ; ) {
            if (a == b) {
                return res * a;
            } else if ((a % 2 == 0) && (b % 2 == 0)) {
                a /= 2;
                b /= 2;
                res *= 2;
            } else if (a % 2 == 0) {
                a /= 2;
            } else if (b % 2 == 0) {
                b /= 2;

            } else if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
    }
}
