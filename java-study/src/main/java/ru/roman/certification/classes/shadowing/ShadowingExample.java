package ru.roman.certification.classes.shadowing;
import java.util.Vector;

/**
 *
 */
class ShadowingExample {
    int foo;
    int bar;

    void balu() {

        int x = 0;

        class Inner {
            int x;
            void x(){}
            class x{}
            void barabu () {

                class x{}
                System.out.println(x);
            }
        }

        //for (int j = 0;;) {}      // компилятор понимает бесконечные циклы, если расскомменнтить ругается на остаток
                                    // unreachable statement
        for (int j = 0; 0 == x;) {}
        for (int j = 0; 0 == x;) {}
    }

}

class Test1 {
    static int x;
    public synchronized final strictfp static <T extends String> void main(String... args) {
        //int x = x;
        int x = (x = 2) * 2;

        System.out.println(Test1.x);
        System.out.println(x);
    }
}

//class Vector {}