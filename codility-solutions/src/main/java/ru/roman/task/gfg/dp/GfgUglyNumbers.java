package ru.roman.task.gfg.dp;

import java.util.Arrays;

/**
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.
 * <p>
 * Given a number n, the task is to find n’th Ugly number.
 * <p>
 * Examples:
 * <p>
 * Input  : n = 7
 * Output : 8
 * <p>
 * Input  : n = 10
 * Output : 12
 * <p>
 * Input  : n = 15
 * Output : 24
 * <p>
 * Input  : n = 150
 * Output : 5832
 */
class GfgUglyNumbers {

    int test(int n) {

        if (n == 1)
            return 1;

        int d2 = 0, d3 = 0, d5 = 0;
        int nextOf2 = 2, nextOf3 = 3, nextOf5 = 5;

        int[] ugly = new int[n];
        ugly[0] = 1;

        System.out.println("Indexes : " + d2 + ", " + d3 + ", " + d5);

        for (int i = 1; i < n; i++) {

            ugly[i] = Math.min(nextOf2, Math.min(nextOf3, nextOf5));
            System.out.println(Arrays.toString(ugly));

            if (ugly[i] == nextOf2) {

                nextOf2 = ugly[++d2] * 2;
                System.out.print("Indexes : " + d2 + ", " + d3 + ", " + d5 + " >>> ");
                System.out.println(nextOf2 + " = " + ugly[d2] + "*" + 2 + ", ");
            }
            if (ugly[i] == nextOf3) {

                nextOf3 = ugly[++d3] * 3;
                System.out.print("Indexes : " + d2 + ", " + d3 + ", " + d5 + " >>> ");
                System.out.println(nextOf3 + " = " + ugly[d3] + "*" + 3 + ", ");
            }
            if (ugly[i] == nextOf5) {

                nextOf5 = ugly[++d5] * 5;
                System.out.print("Indexes : " + d2 + ", " + d3 + ", " + d5 + " >>> ");
                System.out.println(nextOf5 + " = " + ugly[d5] + "*" + 5 + ", ");
            }
        }

        return ugly[ugly.length - 1];
    }
}
