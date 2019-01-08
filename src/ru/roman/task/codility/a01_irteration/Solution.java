package ru.roman.task.codility.a01_irteration;

/**
 *
 */
class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        String strValue = Integer.toBinaryString(N);
        System.out.println("Input value: " + N + " -> "+ strValue);

        int maxGap = 0;
        int gap = 0;

        for (int i = 0; i < strValue.length(); i++) {

            if (strValue.charAt(i) == 1) {
                maxGap = Math.max(maxGap, gap);
                gap = 0;
            } else {
                gap++;
            }
        }
        return maxGap;
    }
}
