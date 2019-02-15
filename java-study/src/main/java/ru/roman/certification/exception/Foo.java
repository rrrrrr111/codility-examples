package ru.roman.certification.exception;

/**
 *
 */
class Foo {

    void foo1() throws Exception {
    }

    void foo2() throws RuntimeException {
    }

    void foo3() throws Throwable {
    }

    void foo4() throws MyThrowable {
    }

    void foo5() throws YourException, MyException { // компилятор не требует чтобы checked кидалось в коде
    }

    void foo6() throws MyRuntimeException {
    }

    void foo7() throws Error {
    }

    void foo8() throws MyError {
    }

    void foo9() throws YourRuntimeException {
    }

    void foo10() {
    }
}
