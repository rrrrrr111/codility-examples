package ru.roman.algo.math;

import java.util.Set;

/**
 * если делить число без остатка пока результат не будет равен 1 только определенным набором простых делителей Set, если оно разделится то это значит, что у числа только указанный набор делителей Set и больше нет никаких других простых делителей, иначе бы основная теорема арифметики не удовлетворялась
 */
class CheckPrimeFactorsOfNumber {

    public static void main(String[] args) {

        System.out.print(prepare(3, Set.of(2, 3, 5)));
        System.out.print(prepare(5832, Set.of(2, 3, 5)));
        System.out.print(prepare(5834, Set.of(2, 3, 5)));
    }

    private static String prepare(int num, Set<Integer> set) {
        boolean res = isNumberHasOnlyPrimeDividersFromSet(num, set);
        return String.format("Nums %s prime factors from: %s : %b%n", num, set, res);
    }

    private static boolean isNumberHasOnlyPrimeDividersFromSet(int num, Set<Integer> set) {
        for (Integer prime : set) {
            num = divide(num, prime);
        }
        return num == 1;
    }

    private static int divide(int num, int prime) {
        while (num % prime == 0)
            num /= prime;
        return num;
    }
}
