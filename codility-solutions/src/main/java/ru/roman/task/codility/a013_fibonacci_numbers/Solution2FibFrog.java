package ru.roman.task.codility.a013_fibonacci_numbers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringJoiner;

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
class Solution2FibFrog {
    public int solution(int[] A) {
        System.out.printf("On input: %s%n", Arrays.toString(A));

        int[] fibonacci = prepareFibonacciNumbers();

        int maxJump = 100_000 + 2;
        boolean[] fibonacciCounters = new boolean[maxJump];
        for (int f : fibonacci) {
            fibonacciCounters[f] = true;
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
        LinkedList<Point> queue = new LinkedList<>();

        int fullPath = A.length + 1;
        int pointLength = 0;
        int pointIndex = 0;
        for (int a : A) {
            pointLength++;
            if (a == 1) {
                points[pointIndex] = pointLength;
                pointRecords[pointIndex] = Integer.MAX_VALUE;

                if (fibonacciCounters[pointLength]) {
                    queue.push(new Point(pointIndex, pointLength, 1));
                    pointRecords[pointIndex] = 1;

                    if (fibonacciCounters[fullPath - pointLength]) {
                        System.out.printf("Path finalised on first collect %n");
                        return 2;
                    }
                }
                pointIndex++;
            }
        }
        System.out.printf("Points : %s, fullPath: %s%n", Arrays.toString(points), fullPath);


        int jump;
        int length;
        while (!queue.isEmpty()) {

            Point pt = queue.pollFirst();
            System.out.printf("%nGot new point %s%n", pt);

            length = pt.length;
            jump = pt.jump + 1;

            for (int index = pt.index + 1; index < points.length; index++) {
                int p = points[index];

                if (fibonacciCounters[p - length]) {

                    if (fibonacciCounters[fullPath - p]) {
                        System.out.printf("Path finalised, length is %s, jump %s, rest path %s, point %s(%s) %n",
                                length, jump, (fullPath - p), p, index);
                        return jump + 1;
                    }

                    if (jump < pointRecords[index]) {

                        Point newPoint = new Point(index, p, jump);
                        queue.addLast(newPoint);
                        pointRecords[index] = newPoint.jump;

                        System.out.printf("Found point for jump %s%n", newPoint);
                    } else {
                        System.out.printf("Point missed in record favor %s(%s)%n", p, index);
                    }
                }
            }
        }

        return -1;
    }

    private static int[] prepareFibonacciNumbers() {
        int max = 21;
        int[] result = new int[max];
        result[1] = 1;

        for (int i = 2; i < result.length; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }

    private static class Point {
        final int index;
        final int length;
        final int jump;

        Point(int index, int length, int jump) {
            this.index = index;
            this.length = length;
            this.jump = jump;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
                    .add("index=" + index)
                    .add("length=" + length)
                    .add("jump=" + jump)
                    .toString();
        }
    }
}
