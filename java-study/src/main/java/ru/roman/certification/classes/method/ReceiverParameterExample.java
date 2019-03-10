package ru.roman.certification.classes.method;

/**
 *
 */
class ReceiverParameterExample {

    void foo(ReceiverParameterExample this) {}
    //void foo() {}                               // illegal
    void foo(ReceiverParameterExample thin) {}

    static void bab() {
        class Inner {
            // Inner(ReceiverParameterExample ReceiverParameterExample.this) {} // illegal, static context
        }
    }

    class Inner {
        Inner(ReceiverParameterExample ReceiverParameterExample.this) {}
        void foo(Inner this) {}

        class InnerInner {
            //InnerInner(ReceiverParameterExample ReceiverParameterExample.this) {}  // illegal, not enclosing
            InnerInner(Inner Inner.this) {}
        }
    }

    interface Intf {
        void foo(Intf this);
        //void foo();                             // illegal
        private void def(Intf this) {}
        default void def1(Intf this) {}
    }

    enum Ggg {
        TRT; void foo(Ggg this){}
    }
}
