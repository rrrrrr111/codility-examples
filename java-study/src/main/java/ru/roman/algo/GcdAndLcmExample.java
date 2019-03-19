package ru.roman.algo;

/**
 *
 */
public class GcdAndLcmExample {

    public static void main(String[] args) {

        System.out.println("gcd: " + gcd3(132, 176) + " lcm: " + lcm(132, 176));
        System.out.println("gcd: " + gcd3(122, 44) + " lcm: " + lcm(122, 44));
        System.out.println("gcd: " + gcd3(9, 3) + " lcm: " + lcm(9, 3));
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
