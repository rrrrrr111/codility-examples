package ru.roman.task.projecteuler.geometry;

/**
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
 * <p>
 * {20,48,52}, {24,45,51}, {30,40,50}
 * <p>
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */
public class Euler039 {

    public static void main(String[] a) {

        int maxPerimeter = 0;
        int maxTriangles = 0;
        for (int p = 1; p <= 1000; p++) {
            int triangles = countSolutions(p);

            if (triangles > maxTriangles) {
                maxTriangles = triangles;
                maxPerimeter = p;
            }
        }

        System.out.println(maxPerimeter);
    }

    private static int countSolutions(int p) {
        int count = 0;
        for (int a = 1; a <= p; a++) {
            for (int b = a; b <= p; b++) {
                int c = p - a - b;
                if (b <= c && a * a + b * b == c * c)
                    count++;
            }
        }
        return count;
    }
}
