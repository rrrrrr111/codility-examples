package ru.roman.certification.variable;

import java.io.IOException;

/**
 *
 */
public class DefiniteAssignmentExample {

    public static void main(String[] args) throws IOException {

        int k, v = 3, n = 1;
        if (v > 0 && (k = System.in.read()) >= 0)
            System.out.println(k);                         // ok, т к выполнится только если было присвоение

        int k2;
        while (true) {                                  // если заменить на while (n < 4) { то illegal,
            k2 = n;                                      // на строке ... println(k) - k is not "definitely assigned"
            if (k2 >= 5) break;
        }
        System.out.println(k2);                           // ok

        final int p1;
        try {
            p1 = 1;
        } finally {
            //System.out.print(">>> " + p1);                   // illegal
        }

        int k4;
        if (foo()) k4 = 3;
        else k4 = 4;
        System.out.println(k4);


        boolean flag = foo();
        final int k1;
        if (flag) k1 = 3;
        //if (!flag) k1 = 4;                // illegal variable might already have been assigned

    }

    private static boolean foo() {
        return false;
    }
}
