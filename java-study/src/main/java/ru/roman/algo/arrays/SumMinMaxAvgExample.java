package ru.roman.algo.arrays;

public class SumMinMaxAvgExample {

    public static void main(String[] args) {

        printSumMinMaxAvg(new int[]{1, 2, 4, 3, -45, 33, 4, 5, 6, 87});
    }

    private static void printSumMinMaxAvg(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Given array is null or empty");

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        long sum = 0;
        double avg = 0;

        for (int a : arr) {
            sum += a;
            min = Math.min(min, a);
            max = Math.max(max, a);

        }
        avg = sum / (double)arr.length;

        System.out.println("Min value is " + min);
        System.out.println("Max value is " + max);
        System.out.println("Sum is " + sum);
        System.out.println("Avg is " + avg);
    }
}
