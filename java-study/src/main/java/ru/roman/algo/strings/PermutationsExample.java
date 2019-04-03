package ru.roman.algo.strings;

public class PermutationsExample {

    public static void main(String[] args) {
        String str = "ABC";
        permute(str.toCharArray(), 0, str.length() - 1);
    }

    /**
     * Recursive
     */
    private static void permute(char[] arr, int fromIdx, int toIdx) {
        if (fromIdx == toIdx) {
            System.out.println(String.valueOf(arr));
        } else {
            for (int i = fromIdx; i <= toIdx; i++) {
                swapChars(arr, fromIdx, i);
                permute(arr, fromIdx + 1, toIdx);
                swapChars(arr, fromIdx, i);
            }
        }
    }

    private static String swapChars(String str, int x, int y) {
        return String.valueOf(swapChars(str.toCharArray(), x, y));
    }

    private static char[] swapChars(char[] arr, int x, int y) {
        char t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
        return arr;
    }
}
