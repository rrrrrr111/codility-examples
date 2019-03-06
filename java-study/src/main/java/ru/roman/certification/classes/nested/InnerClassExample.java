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
            Integer f = 0;
            var v = new SimpleInner(2) {
                static final String FAREWELL = "Bye bye";
                int p = 9;
                {
                    t = 0;
                    class Baaz {}
                }

                @Override
                void f4(int vari) {
                    var f = "";
                    var v = "";
                    //int v = vari;   // shadowing разрешен
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

        class Local{}
        void f4(int vari) {

            fooStatic1();
            foo();

            {
                new Local();
                class Local{}

                {
                    //class Inner{}  // illegal
                }
            }
            {
                class Local{}
                //class Inner extends Inner{}    // cyclic
            }

        }
    }
}

class Outer {
    int outerVar;
    static void classMethod() {
        final int localVar = 0;
        class LocalInStaticContext {
            //int i = outerVar;  // illegal
            int i = localVar;
        }
    }
}

//class Buzzy extends Buzzy.Inner {         // illegal, cyclic inheritance, свой inner нельзя
class Buzzy {
    class Inner {}                          // 1
    void foo() {
        {
            new Inner();                    // инстанс 1, т к следующее объявление идет позже
            class Inner {}                  // 2
            new Buzzy.Inner();              // инстанс 1, более полное имя, похоже на nested класс но это inner
            new Inner();                    // инстанс 2, не 1
            {
                //class Inner{}             // illegal
            }
        }
        {
            class Inner {}                  // 3
            class MoreLocal {
                void bar() {
                    class Inner {           // 4
                        //class MoreLocal{} // illegal, в одной линии вложенности нельзя дублить имя
                        //class Buzzy{}     // illegal
                    }
                }
            }
            new Inner();                    // инстанс 3
        }
        //class Inner extends Inner{}       // illegal cyclic inheritance, сам себя нельзя
        class Localy extends Inner {}       // ok
        class Inner {}                      // 5, ok т к в этом скоупе еще нет Inner, но если перенести его
                                            // в начало метода, то 2 и 3 не смогут скомпилиться, но 4 сможет
    }
}