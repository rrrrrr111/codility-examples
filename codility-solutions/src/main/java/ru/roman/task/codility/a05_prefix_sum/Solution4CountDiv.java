package ru.roman.task.codility.a05_prefix_sum;

/**
 *
 */
class Solution4CountDiv {
    public int solution(int A, int B, int K) {
        System.out.printf("On input: %s %s %s\n", A, B, K);

        return (B / K) - (A / K) + (A % K == 0 ? 1 : 0);
    }
}
