package ru.roman.jcl.util;

import java.util.Scanner;

/**
 * JCL API Examples
 */
class ScannerExample {

    public static void main(String[] args) {

        {                                                          // read 3 values from user input and print
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter first, string: ");
            String s = scanner.nextLine();                     // read whole line, .next() - reads only part before delimiter
            System.out.println(s);

            System.out.print("Enter second, double: ");
            System.out.println(scanner.nextDouble());
            System.out.print("Enter third, integer: ");
            System.out.println(scanner.nextInt());
        }
    }
}
