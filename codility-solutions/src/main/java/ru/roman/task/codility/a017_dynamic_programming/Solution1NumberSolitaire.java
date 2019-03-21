package ru.roman.task.codility.a017_dynamic_programming;

import java.util.Arrays;

/**
 * A game for one player is played on a board consisting of N consecutive squares, numbered from 0 to N − 1. There is a number written on each square. A non-empty array A of N integers contains the numbers written on the squares. Moreover, some squares can be marked during the game.
 * <p>
 * At the beginning of the game, there is a pebble on square number 0 and this is the only square on the board which is marked. The goal of the game is to move the pebble to square number N − 1.
 * <p>
 * During each turn we throw a six-sided die, with numbers from 1 to 6 on its faces, and consider the number K, which shows on the upper face after the die comes to rest. Then we move the pebble standing on square number I to square number I + K, providing that square number I + K exists. If square number I + K does not exist, we throw the die again until we obtain a valid move. Finally, we mark square number I + K.
 * <p>
 * After the game finishes (when the pebble is standing on square number N − 1), we calculate the result. The result of the game is the sum of the numbers written on all marked squares.
 * <p>
 * For example, given the following array:
 * <pre>
 * A[0] = 1
 * A[1] = -2
 * A[2] = 0
 * A[3] = 9
 * A[4] = -1
 * A[5] = -2</pre>
 * one possible game could be as follows:
 * <p>
 * the pebble is on square number 0, which is marked;
 * we throw 3; the pebble moves from square number 0 to square number 3; we mark square number 3;
 * we throw 5; the pebble does not move, since there is no square number 8 on the board;
 * we throw 2; the pebble moves to square number 5; we mark this square and the game ends.
 * The marked squares are 0, 3 and 5, so the result of the game is 1 + 9 + (−2) = 8. This is the maximal possible result that can be achieved on this board.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the maximal result that can be achieved on the board represented by array A.
 * <p>
 * For example, given the array
 * <pre>
 * A[0] = 1
 * A[1] = -2
 * A[2] = 0
 * A[3] = 9
 * A[4] = -1
 * A[5] = -2</pre>
 * the function should return 8, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */
class Solution1NumberSolitaire {
    public int solution(int[] A) {
        System.out.printf("On input: %s%n", Arrays.toString(A));

        int dieSides = 6;
        int[] last = new int[dieSides];
        Arrays.fill(last, A[0]);       // fill with first value, for the first max search if A[0] < 0, to avoid 0 selection

        for (int i = 1; i < A.length; i++) {
            last[i % dieSides] = max(last) + A[i];

        }
        return last[(A.length - 1) % dieSides];
    }

    private int max(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++)
            if (max < a[i])
                max = a[i];
        return max;
    }
}
