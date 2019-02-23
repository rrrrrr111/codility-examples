package ru.roman.certification.conditional;

/**
 *
 */
public class CyclesExample {


    public static void main(String[] args) {

        int i = 0;

        for (
            //int i = 0;       // illegal
                int j = 0, k = 0, l;
                i < args.length; i++) {
            String s = args[i];

        }

        for (
                //String i    // illegal
                String str
                : args) {
        }
    }
}
