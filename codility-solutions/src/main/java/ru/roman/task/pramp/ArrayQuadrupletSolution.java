package ru.roman.task.pramp;

import java.util.Arrays;

/**
 *
 */
class ArrayQuadrupletSolution {

    static int[] findArrayQuadruplet(int[] arr, int s) {
        Arrays.sort(arr);

        // o(n^3)
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {

                int sum = arr[i] + arr[j];
                int diff = s - sum;

                int k = j + 1, l = arr.length - 1;
                while (k < l) {
                    if (arr[k] + arr[l] == diff) {
                        return new int[]{arr[i], arr[j], arr[k], arr[l]};
                    } else if (arr[k] + arr[l] > diff) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
    }
}
