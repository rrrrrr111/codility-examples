package ru.roman.task.codility.lessons.a006_sorting;

/**
 * Дана последовательность целых чисел. Необходимо найти минимально возможное произведение пары элементов последовательности.
 * Например, для последовательности чисел 9 4 2 5 3 ответ будет 6.
 *
 * <pre>
 * -100            -100 * -99 = 9900     ,
 * -99             -100 * -1  = -100
 * -2
 * -1               -1 * -2   = 2       - if we have only positives or only negatives we multiply abs(smallest) of them
 * 0                0  * ...  = 0       - if we have only positives or only negatives and zero we return zero
 * 1                1  * 2    = 2
 * 2                1  * -100 = -100
 * 99               99 * 100  = 9900
 * 100             -100 * 100 = -10000  - if we have at least one negative and positive we multiply smallest negative with largest positive
 * </pre>
 */
class MinProductOfTwo {

    long test(int[] arr) {
        if (arr == null || arr.length < 2)
            throw new IllegalArgumentException();
        if (arr.length == 2)
            return arr[0] * (long) arr[1];


        //   -100                 -2                                 -1
        int minNegative = 0, preMaxNegative = Integer.MIN_VALUE, maxNegative = Integer.MIN_VALUE;
        boolean zeroPresent = false;
        //    1                                    2                                 100
        int minPositive = Integer.MAX_VALUE, postMinPositive = Integer.MAX_VALUE, maxPositive = 0;

        for (int a : arr) {
            if (a == 0) {
                zeroPresent = true;

            } else if (a > 0) {
                if (a < minPositive) {
                    postMinPositive = minPositive;
                    minPositive = a;
                } else if (a < postMinPositive) {
                    postMinPositive = a;
                }

                if (maxPositive < a) {
                    maxPositive = a;
                }

            } else {
                if (maxNegative < a) {
                    preMaxNegative = maxNegative;
                    maxNegative = a;
                } else if (preMaxNegative < a) {
                    preMaxNegative = a;
                }

                if (a < minNegative) {
                    minNegative = a;
                }
            }
        }

        if (minNegative != 0 && maxPositive != 0) { // if we have at least one negative and positive we multiply smallest negative with largest positive
            return minNegative * (long) maxPositive;
        }
        if (zeroPresent) return 0;                // if we have only positives or only negatives and zero we return zero
        if (minNegative == 0) return minPositive * (long) postMinPositive;   // if we have only positives or only negatives,
        if (maxPositive == 0) return preMaxNegative * (long) maxNegative;    //     we multiply abs(smallest) of them

        throw new IllegalStateException();
    }
}
