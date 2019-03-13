package ru.roman.jcl.lang;

import java.nio.charset.Charset;

class SystemPropertyExample {

    public static void main(String[] args) {

        System.out.println(Charset.defaultCharset());
        System.out.println(System.getProperty("file.encoding"));
    }
}
