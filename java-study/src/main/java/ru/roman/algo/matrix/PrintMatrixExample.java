package ru.roman.algo.matrix;

/**
 *
 */
public class PrintMatrixExample {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 56, 7, 8, 90},
                {1, 1, 2, 3, 4, 5, 6, 7, 8,},
                {1, 1, 2, 334, 54, 56, 6, 78, 8,}
        };

        String res = matrixToString(matrix, 3);
        System.out.println(res);
    }

    private static String matrixToString(int[][] matrix, int leftPad) {
        StringBuilder b = new StringBuilder("  [");
        for (int[] arr : matrix) {
            if (b.length() == 3) b.append("[");
            else b.append("   [");

            for (int a : arr) {
                String str = String.valueOf(a);
                for(int i = 1; str.length() + i <= leftPad; i++)
                    b.append(" ");
                b.append(str)
                        .append(", ");
            }

            b.delete(b.length() - 2, b.length())
                    .append("]").append(System.lineSeparator());
        }
        b.delete(b.length() - System.lineSeparator().length(), b.length()).append("]");
        return b.toString();
    }
}
