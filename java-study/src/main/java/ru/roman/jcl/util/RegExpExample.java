package ru.roman.jcl.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 *
 */
class RegExpExample {

    public static void main(String[] args) {

        "_Julia007".matches("[A-Za-z][\\w]{7,29}");

        "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>"
                .matches("<([A-Za-z][\\sA-Za-z0-9]*)\\b[^>]*>(.*?)</\\1>");



    }
}
