package ru.roman.task.skillTester;

/**
 * <p>Реализуйте метод <code>palindrome</code> который возвращает количество ошибок (символов, которые не совпадают) в палиндроме при сравнении исходной и обратной строки. </p>
 */
class Palindrome {

    static class Skilltester {
        static int palindrome(String inputString) {
            String reverse = new StringBuilder(inputString).reverse().toString();
            int count = 0;
            for (int i = 0; i < inputString.length(); i++) {
                if (inputString.charAt(i) != reverse.charAt(i)) {
                    count++;
                }
            }
            return count;
        }

        public static void main(String args[]) {
            assert Skilltester.palindrome("abba") == 0;
            assert Skilltester.palindrome("abcdcaa") == 2;
            assert Skilltester.palindrome("aaabbb") == 6;

            System.out.println("Тесты успешно пройдены");
        }
    }
}
