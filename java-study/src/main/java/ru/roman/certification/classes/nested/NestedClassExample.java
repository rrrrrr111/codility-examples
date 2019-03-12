package ru.roman.certification.classes.nested;


class NestedClassExample {

    private void foo() {}
    private void foo1(long param1) {}
    private static void fooStatic() {}
    private static void fooStatic1() {}

    static class SimpleNested {
        static final String FAREWELL = "Bye bye";
        int t;

        void f4() {

            fooStatic1();
            //foo();                    // illegal
        }

        static class Bbb<T> {
        }
    }

    static class SimpleNested1 {
        static class Bbb<T> {
        }

        class Boo<T> {
        }
    }

    interface Intf{}
}
