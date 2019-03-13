package ru.roman.jcl.io;

import java.nio.charset.Charset;

class SystePropertyExample {

    public static void main(String[] args) {

        System.out.println(Charset.defaultCharset());
        System.out.println(System.getProperty("file.encoding"));
    }
}
