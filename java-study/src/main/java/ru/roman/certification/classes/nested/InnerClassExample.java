package ru.roman.certification.classes.nested;


import java.util.Arrays;

public class InnerClassExample {

    private void foo() {}
    private void foo1(long param1) {

        for (Integer i : Arrays.asList(1, 2, 3, 4, 5, 6)) {


            class Local {

                static final String FAREWELL = "Bye bye";
                //static {}             // illegal
                //static int l;             // illegal

                public int i1;
                protected int i2;
                int i3;
                private int i4;

                public void f1() {}
                protected void f2() {}
                void f3() {}
                private void f4() {

                    fooStatic1();
                    foo();

                    double p = param1;
                }

                //static void ff() {}     // illegal
            }

            //interface Bazz {}             // illegal
            //enum Bazz {}             // illegal

            var v = new SimpleInner() {
                static final String FAREWELL = "Bye bye";
                int p = 9;
                {
                    t = 0;
                }

                @Override
                void f4() {

                }
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
    }

    class SimpleInner {
        static final String FAREWELL = "Bye bye";
        int t;

        void f4() {

            fooStatic1();
            foo();
        }
    }
}
