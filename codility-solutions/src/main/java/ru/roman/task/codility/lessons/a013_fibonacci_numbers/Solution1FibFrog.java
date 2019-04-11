package ru.roman.task.codility.lessons.a013_fibonacci_numbers;

import java.util.LinkedList;

/**
 * The Fibonacci sequence is defined using the following recursive formula:
 * <p>
 * F(0) = 0
 * F(1) = 1
 * F(M) = F(M - 1) + F(M - 2) if M >= 2
 * A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.
 * <p>
 * The leaves on the river are represented in an array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:
 * <p>
 * 0 represents a position without a leaf;
 * 1 represents a position containing a leaf.
 * The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 0
 * A[1] = 0
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * A[5] = 0
 * A[6] = 1
 * A[7] = 0
 * A[8] = 0
 * A[9] = 0
 * A[10] = 0
 * The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 0
 * A[1] = 0
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * A[5] = 0
 * A[6] = 1
 * A[7] = 0
 * A[8] = 0
 * A[9] = 0
 * A[10] = 0
 * the function should return 3, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 */
class Solution1FibFrog {
    public int solution(int[] A) {
       // System.out.printf("On input: %s%n", Arrays.toString(A));

        int[] fibonacci = prepareFibonacciNumbers();

        int maxJump = 100_000 + 2;
        boolean[] fibonacciCounters = new boolean[maxJump];
        for (int f : fibonacci) {
            if (f < maxJump) fibonacciCounters[f] = true;
        }

        if (fibonacciCounters[A.length + 1]) {
            return 1;
        }

        int leafsCount = 0;
        for (int a : A) {
            if (a == 1) {
                leafsCount++;
            }
        }
        int[] points = new int[leafsCount];
        int[] pointRecords = new int[leafsCount];
        int fullPath = A.length + 1;
        int pointLength = 0;
        int pointIndex = 0;
        for (int a : A) {
            pointLength++;
            if (a == 1) {
                points[pointIndex] = pointLength;
                pointRecords[pointIndex] = Integer.MAX_VALUE;
                pointIndex++;
            }
        }
        //System.out.printf("Points : %s, fullPath: %s%n", Arrays.toString(points), fullPath);

        LinkedList<Integer> stack = new LinkedList<>();

        int jumpsAttempt = 0;
        while (jumpsAttempt <= A.length + 1) {
            ++jumpsAttempt;

          //  System.out.printf("%nAttempt with jumps: %s%n", jumpsAttempt + 1);

            int jump = 0;
            int length = 0;
            int index = points.length;
            int lastIndex = -1;
            stack.clear();

            while (lastIndex < index - 1) {
                index--;
                int p = points[index];

                if (fibonacciCounters[p - length]) {

                    if (fibonacciCounters[fullPath - p]) {
            //            System.out.printf("Path finalised, length is %s, jump %s, rest path %s, point %s(%s) %n",
              //                  length, jump, (fullPath - p), p, index);
                        return jump + 2;
                    }

                    if (jump + 1 < jumpsAttempt
                            && jump + 1 <= pointRecords[index]
                    ) {

                        stack.push(index);
                        jump++;
                        pointRecords[index] = jump;

                        lastIndex = index;
                        index = points.length;
                        length = p;
                //        System.out.printf("Restarting the points cycle to [%s, %s], length %s jump %s stack %s%n",
                  //              lastIndex, (index - 1), length, jump, stack);
                    }
                }

                while (index - 1 == lastIndex && !stack.isEmpty()) {
                    index = stack.pop();
                    lastIndex = stack.isEmpty() ? -1 : stack.peek();
                    length = stack.isEmpty() ? 0 : points[stack.peek()];
                    jump--;

            //        System.out.printf("End of cycle reached, restart to [%s, %s], length %s jump %s stack %s%n",
              //              lastIndex - 1, (index - 1), length, jump, stack);
                }
            }
        }
        return -1;
    }

    private static int[] prepareFibonacciNumbers() {
        int max = 26;
        int[] result = new int[max];
        result[1] = 1;

        for (int i = 2; i < result.length; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }
}
