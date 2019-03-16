package ru.roman.algo;

/**
 *
 */
class CountersExample {

    public static void main(String[] args) {

        int maxValue = 60;
        int[] arr = {1, 2, 3, 0, 0, 0, 4, 5, 6, 7, 8, 56, 7, 6, 2, 2, 2, 23, 4};
        int[] counters = prepareCounters(arr, maxValue);

        System.out.printf("Nums     : %s%n", PrintUtil.printArray(arr, 3));
        System.out.printf("Counters : %s%n", PrintUtil.printArray(counters, 3));
    }

    private static int[] prepareCounters(int[] A, int maxValue) {
        int[] counters = new int[maxValue + 1];
        for (int a : A) {
            if (a > maxValue) {
                throw new IllegalArgumentException("Value:" + a + " exceed max value:" + maxValue);
            }
            if (a < 0) {
                throw new IllegalArgumentException("Value:" + a + " less then zero");
            }
            counters[a]++;
        }
        return counters;
    }
}
