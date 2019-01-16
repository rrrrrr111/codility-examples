package ru.roman.task.codility.a090_2015_challenge;

import java.util.StringJoiner;

/**
 * You are helping a geologist friend investigate an area with mountain lakes. A recent heavy rainfall has flooded these lakes and their water levels have reached the highest possible point. Your friend is interested to know the maximum depth in the deepest part of these lakes.
 * <p>
 * We simplify the problem in 2-D dimensions. The whole landscape can be divided into small blocks and described by an array A of length N. Each element of A is the altitude of the rock floor of a block (i.e. the height of this block when there is no water at all). After the rainfall, all the low-lying areas (i.e. blocks that have higher blocks on both sides) are holding as much water as possible. You would like to know the maximum depth of water after this entire area is flooded. You can assume that the altitude outside this area is zero and the outside area can accommodate infinite amount of water.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 2
 * A[3] = 1
 * A[4] = 2
 * A[5] = 1
 * A[6] = 5
 * A[7] = 3
 * A[8] = 3
 * A[9] = 4
 * A[10] = 2
 * The following picture illustrates the landscape after it has flooded:
 * <p>
 * <p>
 * <p>
 * The gray area is the rock floor described by the array A above and the blue area with dashed lines represents the water filling the low-lying areas with maximum possible volume. Thus, blocks 3 and 5 have a water depth of 2 while blocks 2, 4, 7 and 8 have a water depth of 1. Therefore, the maximum water depth of this area is 2.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the maximum depth of water.
 * <p>
 * Given array A shown above, the function should return 2, as explained above.
 * <p>
 * For the following array:
 * <p>
 * A[0] = 5
 * A[1] = 8
 * the function should return 0, because this landscape cannot hold any water.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..100,000,000].
 */
class Solution3MeasureLakes {
    public int solution(int[] A) {
        //System.out.println("On input: " + Arrays.toString(A));

        if (A.length < 3) {
            return 0;
        }

        Point graph = prepareGraph(A);
        //System.out.println("Graph prepared: " + graph);

        clean(graph);
        //System.out.println("Graph after cleaning: " + graph);

        return findDeepest(graph);
    }

    private Point prepareGraph(int[] A) {

        final Point first = new Point();
        Point prevPoint = first;
        prevPoint.height = -1;
        prevPoint.top = true;
        prevPoint.index = -1;

        boolean top;

        for (int i = 0; i < A.length; i++) {
            int height = A[i];

            if (height == prevPoint.height) {
                continue;
            }

            top = height > prevPoint.height;
            if (top == prevPoint.top) {
                prevPoint.height = height;
                prevPoint.index = i;
            } else {
                Point point = new Point();
                point.top = top;
                point.height = height;
                point.index = i;
                point.prev = prevPoint;

                prevPoint.next = point;
                prevPoint = point;
            }
        }
        return first;
    }

    private void clean(Point graph) {
        Point p = graph.next;
        while (p != null) {
            if (p.next == null) {
                break;
            }
            if (isNeedToRemoveTop(p)) {
                removeTop(p);
                p = p.getPrevTop();

            } else {
                p = p.next;
            }
        }
    }

    private int findDeepest(Point graph) {
        Point p = graph;
        int maxHeight = 0;
        while (p != null) {
            if (!p.top
                    && p.prev != null
                    && p.next != null) {

                int nextDepth = p.next.height - p.height;
                int prevDepth = p.prev.height - p.height;
                int h = prevDepth < nextDepth ? prevDepth : nextDepth;
                maxHeight = Math.max(maxHeight, h);
            }
            p = p.next;
        }
        return maxHeight;
    }

    private void removeTop(Point p) {
        Point bottom = p.next.height < p.prev.height ? p.next : p.prev;
        Point prevTop = p.getPrevTop();
        Point nextTop = p.getNextTop();

        prevTop.next = bottom;
        bottom.prev = prevTop;
        nextTop.prev = bottom;
        bottom.next = nextTop;
    }

    private boolean isNeedToRemoveTop(Point p) {
        if (!p.top) {
            return false;
        }
        Point nextTop = p.getNextTop();
        Point prevTop = p.getPrevTop();
        return nextTop != null && nextTop.height >= p.height
                && prevTop != null && prevTop.height >= p.height;
    }

    private static class Point {
        private Point prev;
        private Point next;
        private Boolean top;
        private int height;
        private int index;

        Point getNextTop() {
            return next != null ? next.next : null;
        }

        Point getPrevTop() {
            return prev != null ? prev.prev : null;
        }

        @Override
        public String toString() {
            StringJoiner joiner = new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
                    .add("top=" + top)
                    .add("index=" + index)
                    .add("height=" + height);
            Point p = this.next;
            while (p != null) {
                joiner.add("\nNext[top=" + p.top)
                        .add("index=" + p.index)
                        .add("height=" + p.height + "]");
                p = p.next;
            }
            return joiner.toString();
        }
    }
}
