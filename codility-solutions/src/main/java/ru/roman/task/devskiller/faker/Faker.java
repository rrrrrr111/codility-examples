package ru.roman.task.devskiller.faker;


import java.util.Random;

class Faker {

    private static Random RANDOM = new Random();
    private static char[] ALL_CHARS = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public String letterify(String letterString) {
        if (letterString == null || letterString.length() == 0) {
            return letterString;
        }

        String result = letterString;
        while (result.indexOf('?') > -1) {

            String character = String.valueOf(ALL_CHARS[RANDOM.nextInt(ALL_CHARS.length)]);
            result = result.replaceFirst("\\?", character);
        }
        return result;
    }

    public String numerify(String numberString) {
        if (numberString == null || numberString.length() == 0) {
            return numberString;
        }
        String result = numberString;
        while (result.indexOf('#') > -1) {

            String digit = String.valueOf(RANDOM.nextInt(10));
            result = result.replaceFirst("#", digit);
        }
        return result;
    }

    public String bothify(String string) {

        String result = letterify(string);
        return numerify(result);
    }
}
