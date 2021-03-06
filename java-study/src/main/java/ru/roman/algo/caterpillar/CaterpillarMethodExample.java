package ru.roman.algo.caterpillar;

import static ru.roman.algo.PrintUtil.printArray;

/**
 *
 */
class CaterpillarMethodExample {

    public static void main(String[] args) {

        int[] array = {1, 1, 1, 3, 5, 6, 4, 3, 2, 1, 1, 1, 1, 1};
        System.out.println(printArray(array, 2));
        System.out.println(caterpillarMethod(array, 15));
        System.out.println(caterpillarMethod(array, 31));
        System.out.println(caterpillarMethod(array, 32));
    }

    /**
     * Checks whether the array contains sequence of elements having the sum
     */
    private static boolean caterpillarMethod(int[] A, int sum) {

        for (int back, front, total = front = back = 0;
             back < A.length;
             back++) {

            for (;front < A.length && total + A[front] <= sum;
                 front++) {
                total += A[front];
            }
            if (total == sum) {
                return true;
            }
            total -= A[back];
        }
        return false;
    }
}
