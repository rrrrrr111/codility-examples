package ru.roman.certification.cycle;

/**
 *
 */
class CyclesExample {


    public static void main(String[] args) {

        int i = 0;

        for (
            //int i = 0;       // illegal
                int j = 0, k = 0, l;
                i < args.length; i++) {
            String s = args[i];

        }

        out:
        if (true) {

        }
        out:
        for (
            //String i    // illegal
                String str
                : args) {

            break out;
        }

        http://hi.there.com

        if (true) {
            for (;;);
        } else {
            //for (;;);;       // illegal
        }
    }

    int foo (int b) {

        //for (int i = 0; i < 1; i++) int some = 1;   // illegal, statement

        for(;;) {
            if (b > 0) return 1;
        }
        //;                                             // illegal
    }
}
