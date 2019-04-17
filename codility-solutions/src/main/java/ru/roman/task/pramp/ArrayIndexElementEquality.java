package ru.roman.task.pramp;

/**
 * Array Index & Element Equality
 * Given a sorted array arr of distinct integers, write a function indexEqualsValueSearch that returns the lowest index i for which arr[i] == i. Return -1 if there is no such index. Analyze the time and space complexities of your solution and explain its correctness.
 * <p>
 * Examples:
 * <p>
 * input: arr = [-8,0,2,5]
 * output: 2 # since arr[2] == 2
 * <p>
 * input: arr = [-1,0,3,6]
 * output: -1 # since no index in arr satisfies arr[i] == i.
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * <p>
 * [input] array.integer arr
 * <p>
 * 1 ≤ arr.length ≤ 100
 * [output] integer
 */
class ArrayIndexElementEquality {

    static int indexEqualsValueSearch(int[] arr) {

        int beg = 0, end = arr.length - 1;

        int res = -1;
        for (int mid; beg <= end; ) {
            mid = (beg + end) / 2;
            if (arr[mid] == mid
                    && ((mid == 0) || (arr[mid - 1] - (mid - 1) < 0))
            ) {

                return mid;                 // element unique and sorted, O(log N)
            } else if (arr[mid] < mid) {
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
}
