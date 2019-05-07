package ru.roman.jcl.util;

/**
 * JCL API Examples
 */
class StringFormatExample {

    public static void main(String[] args) {

        {
            System.out.printf("%%%n");                      // print percent and new line char
            System.out.printf("%-15s %n", 11);              // right-justify up to 15 symbols (add on right)
            System.out.printf("%05d %n", 11);               // left-justify up to 5 symbols (add on left) with leading zeros


        }

    }
}
