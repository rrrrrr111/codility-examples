package ru.roman.task.codility.a007_stacks_and_queues;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.
 * <p>
 * The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] H); }
 * <p>
 * that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.
 * <p>
 * For example, given array H containing N = 9 integers:
 * <p>
 * H[0] = 8    H[1] = 8    H[2] = 5
 * H[3] = 7    H[4] = 9    H[5] = 8
 * H[6] = 7    H[7] = 4    H[8] = 8
 * the function should return 7. The figure shows one possible arrangement of seven blocks.
 * <p>
 * <p>
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array H is an integer within the range [1..1,000,000,000].
 */
class Solution3StoneWall {
    public int solution(int[] H) {
        System.out.printf("On input: %s\n", Arrays.toString(H));

        final Deque<Integer> stack = new LinkedList<>();

        int prev = 0;
        int blocks = 0;
        for (int curr : H) {
            if (prev < curr) {
                stack.push(curr);
                blocks++;

            } else if (curr < prev) {
                int level = Integer.MAX_VALUE;
                while (level > curr) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        level = 0;
                        break;
                    }
                    level = stack.peek();
                }
                if (level < curr) {
                    stack.push(curr);
                    blocks++;
                }
            }
            prev = curr;
        }
        return blocks;
    }
}
