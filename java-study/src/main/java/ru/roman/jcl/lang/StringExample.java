package ru.roman.jcl.lang;

import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

class StringExample {

    private static final String STR = "s".replace("s", "r");

    public static void main(String[] args) {


        var s = new String(new char[]{'h', 'e', 'l', 'l', 'o'});  // у String 13 конструкторов
        int l = s.length();
        char c = s.charAt(0);
        byte[] b = s.getBytes(StandardCharsets.ISO_8859_1);
        String sub = "abc".substring(2,3);

        var r1 = "rape ".concat("me");                        // "rape me"
        var r2 = String.format("The %s", "beatles");          // "The beatles"
        var r21 = MessageFormat.format("The {0}", "beatles");      // "The beatles"
        var r3 = "r".replace('r', 's');       // "s"
        var r4 = "s".replace("s", "r");      // "r"
        var r41 = "r";

        var r5 = "ab" == "a" + "b";                            // true, что попало под компилятор считай интернировано
        var r6 = "r" == r4;                                    // false, что вычеслено в runtime не интернировано
        var r7 = "r".equals(r4);                               // true, всегда сравнивает побайтно
        var r8 = "r" == r41;                                   // true, compile-time константа
        var r9 = "r" == r4.intern();                           // true, native метод делает всю магию
        var rf = "r" == new String("r");               // false
        var rg = "r" == new String("r").intern();      // true
        var rh = "r" == STR;                                   // false
        var rk = "r" == String.valueOf(STR);                   // false  - для объекта просто делает toString()
        var rt = "rtts".regionMatches(1,"1tt1", 1, 2);   // true
        var r = "rtts".matches("\\b\\wtt\\w\\b");        // true

        System.out.println(r);
    }
}
