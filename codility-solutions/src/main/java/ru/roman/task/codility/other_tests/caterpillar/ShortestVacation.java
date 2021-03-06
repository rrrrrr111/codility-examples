package ru.roman.task.codility.other_tests.caterpillar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <div class="task-description-content task-description__TaskContentWrapper-sc-380ibo-1 iVZZWO">
 * <p>
 * <meta http-equiv="content-type" content="text/html; charset=utf-8">
 *
 *
 * <div id="brinza-task-description">
 * <p>You want to spend your next vacation in a foreign country. In the summer you are free for N consecutive days. You have consulted Travel Agency and learned that they are offering a trip to some interesting location in the country every day. For simplicity, each location is identified by a number from 0 to N − 1. Trips are described in a non-empty array A: for each K (0 ≤ K &lt; N), A[K] is the identifier of a location which is the destination of a trip offered on day K. Travel Agency does not have to offer trips to all locations, and can offer more than one trip to some locations.</p>
 * <p>You want to go on a trip every day during your vacation. Moreover, you want to visit all locations offered by Travel Agency. You may visit the same location more than once, but you want to minimize duplicate visits. The goal is to find the shortest vacation (a range of consecutive days) that will allow you to visit all the locations offered by Travel Agency.</p>
 * <p>For example, consider array A such that:</p>
 * <pre style="white-space:pre-wrap">    A[0] = 7
 * A[1] = 3
 * A[2] = 7
 * A[3] = 3
 * A[4] = 1
 * A[5] = 3
 * A[6] = 4
 * A[7] = 1</pre>
 * <p>Travel Agency offers trips to four different locations (identified by numbers 1, 3, 4 and 7). The shortest vacation starting on day 0 that allows you to visit all these locations ends on day 6 (thus is seven days long). However, a shorter vacation of five days (starting on day 2 and ending on day 6) also permits you to visit all locations. On every vacation shorter than five days, you will have to miss at least one location.</p>
 * <p>Write a function:</p>
 * <blockquote><p style="font-family: monospace; font-size: 9pt; display: block; white-space: pre-wrap"><tt>class Solution { public int solution(int[] A); }</tt></p></blockquote>
 * <p>that, given a non-empty array A consisting of N integers, returns the length of the shortest vacation that allows you to visit all the offered locations.</p>
 * <p>For example, given array A shown above, the function should return 5, as explained above.</p>
 * <p>Given A = [2, 1, 1, 3, 2, 1, 1, 3], the function should return 3. One of the shortest vacations that visits all the places starts on day 3 (counting from 0) and lasts for 3 days.</p>
 * <p>Given A = [7, 5, 2, 7, 2, 7, 4, 7], the function should return 6. The shortest vacation that visits all the places starts on day 1 (counting from 0) and lasts for 6 days.</p>
 * <p>Write an <b><b>efficient</b></b> algorithm for the following assumptions:</p>
 * <blockquote><ul style="margin: 10px;padding: 0px;"><li>N is an integer within the range [<span class="number">1</span>..<span class="number">100,000</span>];</li>
 * <li>each element of array A is an integer within the range [<span class="number">0</span>..<span class="number">N − 1</span>].</li>
 * </ul>
 * </blockquote></div>
 * <div style="margin-top:5px">
 * </div>
 *
 * </div>
 */
class ShortestVacation {
    public int solution(int[] A) {
        System.out.printf("On input: %s%n", Arrays.toString(A));

        Set<Integer> all = Arrays.stream(A).boxed()
                .collect(Collectors.toSet());

        //return recursionAlg(A, 0, A.length - 1, all);
        return caterpillarAlg(A, all);
    }

    private int caterpillarAlg(int[] arr, Set<Integer> all) {

        Map<Integer, Integer> tmp = new HashMap<>(all.size());  // value to it's cardinality
        int minLength = arr.length;
        int lastTailIdx = arr.length - all.size();

        for (int t = 0, h = 0; t <= lastTailIdx; t++) {

            for (; tmp.size() < all.size() && h < arr.length; h++)
                tmp.put(arr[h], tmp.getOrDefault(arr[h], 0) + 1);

            if (tmp.size() != all.size())          // h reached end of array
                break;

            minLength = Math.min(minLength, h - t);

            int tail = arr[t], tailCount = tmp.get(tail);
            if (tailCount == 1)
                tmp.remove(tail);
            else if (tailCount > 1)
                tmp.put(tail, tailCount - 1);
            else
                throw new IllegalStateException();

            if (minLength == all.size())            // just optimisation
                break;
        }
        return minLength;
    }

    private int recursionAlg(int[] arr, int from, int to, Set<Integer> all) {

        if (from > to)
            return Integer.MAX_VALUE;
        if (!containsAll(arr, from, to, all))
            return Integer.MAX_VALUE;

        return Math.min(to - from + 1,
                Math.min(
                        recursionAlg(arr, from + 1, to, all),
                        recursionAlg(arr, from, to - 1, all)
                )
        );
    }

    private boolean containsAll(int[] arr, int from, int to, Set<Integer> all) {

        Set<Integer> t = new HashSet<>(all.size());
        for (int i = from; i <= to; i++) {
            t.add(arr[i]);
            if (t.size() == all.size())
                return true;
        }
        return false;
    }
}
