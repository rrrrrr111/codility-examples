package ru.roman.certification.classes.nested;


import java.io.Serializable;
import java.util.Arrays;

public class InnerClassExample {

    private void foo() {}
    private <S extends Serializable> void foo1(long param1, int vari) {

        for (Integer i : Arrays.asList(1, 2, 3, 4, 5, 6)) {


            class Local {

                static final String FAREWELL = "Bye bye";
                //static {}             // illegal
                //static int l;             // illegal

                S p;

                public S i1;
                protected int i2;
                int i3;
                private int i4;

                public S f1() { return null; }
                protected void f2() {}
                void f3() {}
                private void f4() {
                    S c;
                    fooStatic1();
                    foo();

                    double p = param1;
                }

                //static void ff() {}     // illegal
            }

            //interface Bazz {}             // illegal
            //enum Bazz {}             // illegal

            var v = new SimpleInner(2) {
                static final String FAREWELL = "Bye bye";
                int p = 9;
                {
                    t = 0;
                    class Baaz {}
                }

                @Override
                void f4(int vari) {
                    int v = vari;   // shadowing разрешен
                }

                abstract strictfp class InnInn {}
            };
        }
    }
    private static void fooStatic() {}
    private static void fooStatic1() {

        class Local {
            private void f4() {

                fooStatic1();
                //foo();                   // illegal
            }
        }

        //  static class Local1 {}          // illegal
    }

    class SimpleInner {
        static final String FAREWELL = "Bye bye";
        int t;

        SimpleInner(int i) {
            t = i;
        }


        void f4(int vari) {

            fooStatic1();
            foo();
        }
    }
}
