package ru.roman.task.projectEuler.math.product;

/**
 * The sum of the squares of the first ten natural numbers is,
 * <p>
 * 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is,
 * <p>
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * <p>
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Euler006SumSquareDifference {

    public static void main(String[] a) {

        int sum = 0;
        int sum2 = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
            sum2 += i * i;
        }
        int res = sum * sum - sum2;

        System.out.println(res);
    }
}
