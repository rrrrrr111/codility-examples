package ru.roman.algo;

import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.StringUtils.leftPad;

/**
 * Euclidean algorithms
 */
class GcdAndLcmExample {

    public static void main(String[] args) {

        System.out.println(printFor(132, 176));
        System.out.println(printFor(122, 44));
        System.out.println(printFor(9, 3));
        System.out.println(printFor(12, 16));
    }

    private static String printFor(int a, int b) {
        return  "for " + leftPad(a + "", 3)
                + " and " + leftPad(b + "", 3)
                + " -> gcd: " + leftPad(gcd3(a, b) + "", 6)
                + ", lcm: " + leftPad(lcm(a, b) + "", 6);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd3(a, b);
    }

    private static int gcd1(int a, int b) {
        for (; ; ) {
            if (a == b) {
                return a;

            } else if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
    }

    private static int gcd2(int a, int b) {
        int c;

        for (; ; ) {
            if (a % b == 0) {
                return b;
            } else {
                c = a;
                a = b;
                b = c % b;
            }
        }
    }

    private static int gcd3(int a, int b) {
        int res = 1;

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
