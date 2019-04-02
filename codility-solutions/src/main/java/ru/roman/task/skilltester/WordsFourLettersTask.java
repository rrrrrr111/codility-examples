package ru.roman.task.skilltester;

/**
 * <p>Реализуйте метод <code>wordsFourLetters</code>, который принимает строковую переменную <code>sentence</code> и возвращает количество содержащихся в ней четырехбуквенных слов. Не беспокойтесь о пунктуации.</p>
 */
class WordsFourLettersTask {

    static class Skilltester {
        static int wordsFourLetters(String sentence) {
            String[] words = sentence.split("\\W+");
            int count = 0;
            for (String word : words) {
                if (word.length() == 4) {
                    count++;
                }
            }
            return count;
        }

        public static void main(String args[]) {
            assert Skilltester.wordsFourLetters("This sentence is fine") == 2;
            assert Skilltester.wordsFourLetters("So is this one") == 1;
            assert Skilltester.wordsFourLetters("Hello") == 0;

            System.out.println("Тесты успешно пройдены");
        }
    }
}
