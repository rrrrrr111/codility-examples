package ru.roman.algo.strings;

public class PermutationsExample {

    public static void main(String[] args) {
        String str = "ABCD";
        permute(str.toCharArray(), 0, str.length() - 1);
        
        System.out.println();
        permute("", str);
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


    /**
     * Recursive method which actually prints all permutations
     * of given String, but since we are passing an empty String
     * as current permutation to start with
     */
    private static void permute(String perm, String word) {
        if (word.isEmpty()) {
            System.err.println(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permute(
                        perm + word.charAt(i),
                        word.substring(0, i) + word.substring(i + 1, word.length())
                );
            }
        }
    }
}
