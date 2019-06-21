package ru.roman.task.projectEuler.math.factors;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * <p>
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * <p>
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class Euler021AmicableNumbers {

    public static void main(String[] a) {

        int sum = 0;
        for (int i = 1; i < 10000; i++) {
            if (isAmicable(i))
                sum += i;
        }
        Preconditions.checkArgument(sum == 31626);
        System.out.println(sum);
    }

    private static boolean isAmicable(long n) {
        long m = divisorSum(n);
        return m != n && divisorSum(m) == n;
    }

    private static long divisorSum(long n) {
        return Stream.of(prepareAllFactors(n))
                .mapToLong(i -> i)
                .sum();
    }

    private static Long[] prepareAllFactors(long num) {
        List<Long> divs = new ArrayList<>(Collections.singletonList(1L));
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                divs.add(i);
                divs.add(num / i);
            }
        }
        Collections.sort(divs);
        return divs.toArray(new Long[0]);
    }
}
