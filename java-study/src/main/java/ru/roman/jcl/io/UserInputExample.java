package ru.roman.jcl.io;

import java.io.Console;
import java.util.Scanner;

/**
 * JCL API Examples
 */
class UserInputExample {

    public static void main(String[] args) {

        {
            Console console = System.console();
            for (int i = 0; i < 3; i++) {                        // read three user inputs
                String str = console.readLine();
            }
        }
        {
            Scanner s = new Scanner(System.in);
            for (;;) {                                         // read all user inputs
                if (!s.hasNext()) break;
                String str = s.nextLine();
            }

        }
        {
        }
        {
        }
    }
}
