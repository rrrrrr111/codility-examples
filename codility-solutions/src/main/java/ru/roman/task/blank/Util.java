package ru.roman.task.blank;

import java.math.BigInteger;

/**
 *
 */
public class Util {

    public static String matrixToString(BigInteger[][] matrix, int leftPad) {
        StringBuilder b = new StringBuilder("  [");
        for (BigInteger[] arr : matrix) {
            if (b.length() == 3) b.append("[");
            else b.append("   [");

            for (BigInteger a : arr) {
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
