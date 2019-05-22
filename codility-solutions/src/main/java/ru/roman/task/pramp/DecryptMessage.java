package ru.roman.task.pramp;

/**
 * Decrypt Message
 * An infamous gang of cyber criminals named “The Gray Cyber Mob”, which is behind many hacking attacks and drug trafficking, has recently become a target for the FBI. After intercepting some of their messages, which looked like complete nonsense, the agency learned that they indeed encrypt their messages, and studied their method of encryption.
 * <p>
 * Their messages consist of lowercase latin letters only, and every word is encrypted separately as follows:
 * <p>
 * Convert every letter to its ASCII value. Add 1 to the first letter, and then for every letter from the second one to the last one, add the value of the previous letter. Subtract 26 from every letter until it is in the range of lowercase letters a-z in ASCII. Convert the values back to letters.
 * <p>
 * For instance, to encrypt the word “crime”
 * <pre>
 * Decrypted message:	c	r	i	m	e
 * Step 1:	99	114	105	109	101
 * Step 2:	100	214	319	428	529
 * Step 3:	100	110	111	116	113
 * Encrypted message:	d	n	o	t	q</pre>
 * The FBI needs an efficient method to decrypt messages. Write a function named decrypt(word) that receives a string that consists of small latin letters only, and returns the decrypted word.
 * <p>
 * Explain your solution and analyze its time and space complexities.
 * <p>
 * Examples:
 * <p>
 * input:  word = "dnotq"
 * output: "crime"
 * <p>
 * input:  word = "flgxswdliefy"
 * output: "encyclopedia"
 * Since the function should be used on messages with many words, make sure the function is as efficient as possible in both time and space. Explain the correctness of your function, and analyze its asymptotic runtime and space complexity.
 * <p>
 * Note: Most programing languages have built-in methods of converting letters to ASCII values and vica versa. You may search the internet for the appropriate method.
 * <p>
 * Constraints:
 * <p>
 * [time limit] 5000ms
 * <p>
 * [input] string word
 * <p>
 * The ASCII value of every char is in the range of lowercase letters a-z.
 * [output] string
 */
class DecryptMessage {
    public String solution(String word) {
        System.out.printf("On input: %s%n", word);

        if (word.length() == 0) {
            return word;
        }

        char[] chars = word.toCharArray();

        int prev = chars[0];
        chars[0] = (char) (chars[0] - 1);

        for (int i = 1; i < chars.length; i++) {

            int c = chars[i] - prev;
            while (c < 97)
                c += 26;

            prev = chars[i];
            chars[i] = (char) (c);
        }

        return new String(chars);
    }
}
