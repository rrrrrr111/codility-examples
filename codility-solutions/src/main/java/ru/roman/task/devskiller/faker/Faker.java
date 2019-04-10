package ru.roman.task.devskiller.faker;

import java.util.Random;

class Faker {

    public String letterify(String letterString) {
        return bothify(letterString);
    }

    public String numerify(String numberString) {
        return bothify(numberString);
    }

    public String bothify(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }
        Random random = new Random();
        String chars = "abcdefghijklmnopqrstuvwxyz";

        while (string.indexOf('?') > -1 || string.indexOf('#') > -1) {
            String ch = String.valueOf(chars.charAt(random.nextInt(chars.length())));
            String digit = random.nextInt(10) + "";

            string = string.replaceFirst("\\?", ch);
            string = string.replaceFirst("#", digit);
        }
        return string;
    }
}
