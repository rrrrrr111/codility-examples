package ru.roman.certification.classes.interfaces;

/**
 *
 */
interface InterfaceExample {   // implicitly abstract, but not public

    int CONST = 2;             // implicitly public static final
    // static {}               // illegal
    //{}                       // illegal
    //InterfaceExample(){}     // illegal

    void foo();                // implicitly public abstract
    default void foo1() {}     // implicitly public
    static void foo2() {       // implicitly public
        new Papu();
    }

    interface Doo {}            // implicitly public static abstract, interfaces always static abstract only
    class Papu {                // implicitly public static
        class Panu {            // normal inner class, not implicitly public static
            // static void foof(){}  // illegal
        }
        protected interface Fafu{} // implicitly static abstract
    }
    abstract class Papua {}     // implicitly public static
    enum Ennu {}                // implicitly public static, enums always static only
}
