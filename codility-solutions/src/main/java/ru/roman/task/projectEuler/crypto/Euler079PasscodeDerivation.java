package ru.roman.task.projectEuler.crypto;

import java.util.Arrays;

/**
 * A common security method used for online banking is to ask the user for three random characters from a passcode. For example, if the passcode was 531278, they may ask for the 2nd, 3rd, and 5th characters; the expected reply would be: 317. Each character in unique in the password.
 * <p>
 * The text file, keylog.txt, contains fifty successful login attempts.
 * <p>
 * Given that the three characters are always asked for in order, analyse the file so as to determine the shortest possible secret passcode of unknown length.
 */
public class Euler079PasscodeDerivation {

    private static String[] SUBSEQS = {"319", "680", "180", "690", "129", "620", "762", "689", "762", "318", "368", "710", "720", "710", "629", "168", "160", "689", "716", "731", "736", "729", "316", "729", "729", "710", "769", "290", "719", "680", "318", "389", "162", "289", "162", "718", "729", "319", "790", "680", "890", "362", "319", "760", "316", "729", "380", "319", "728", "716"};


    public static void main(String[] a) {

        char[] packedSubseqs = new char[SUBSEQS.length * 3];
        for (int i = 0; i < packedSubseqs.length; i++)
            packedSubseqs[i] = SUBSEQS[i / 3].charAt(i % 3);    //

        System.out.println(">>>" + Arrays.toString(packedSubseqs));

        // Try ascending lengths
        for (int len = 3; len <= 10; len++) {
            int end = (int) Math.pow(10, len);
            for (int guess = 0; guess < end; guess++) {
                char[] guessChars = toChars(guess, len);
                if (isConsistent(packedSubseqs, guessChars)) {
                    System.out.println(guessChars);
                    return;
                }
            }
        }
        throw new RuntimeException("Not found");
    }

    private static boolean isConsistent(char[] packedSubseqs, char[] guess) {
        // For each string 's' in SUBSEQS, test if 's' is a subsequence of 'guess'
        for (int i = 0; i < packedSubseqs.length; i += 3) {
            int j = 0;  // Index in 's'
            for (int k = 0; k < guess.length && j < 3; k++) {  // Index in 'guess'
                if (guess[k] == packedSubseqs[i + j])
                    j++;
            }
            if (j < 3)  // Not all characters consumed, fail
                return false;
        }
        return true;
    }


    // Converts integer to string with zero padding, in little endian.
    // Since we're trying all combinations, the order doesn't matter.
    private static char[] toChars(int n, int len) {
        char[] result = new char[len];
        int i = 0;
        for (; i < result.length; i++, n /= 10)
            result[i] = (char)('0' + (n % 10));
        if (n != 0)
            throw new IllegalArgumentException();
        for (; i < result.length; i++)
            result[i] = '0';
        return result;
    }
}
