package ru.roman.task.projectEuler.dp;

/**
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 * <p>
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 * <p>
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins?
 */
public class Euler031CoinSums {

    public static void main(String[] a) {

        final int total = 200;
        final int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        int[][] ways = new int[coins.length + 1][total + 1];

        ways[0][0] = 1;

        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];

            for (int j = 0; j <= total; j++)
                ways[i + 1][j] = ways[i][j] + (j >= coin ? ways[i + 1][j - coin] : 0);
        }

        System.out.println(matrixToString(ways, 10));
        System.out.println(ways[coins.length][total]);
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
