package ru.roman.certification.exception;

/**
 *
 */
class Bazz {

    void foo1() throws Exception {
        if (true) throw new MyException();   // checked родительское прокинуто

        try {
        } catch (Exception e) {  // компилятор не ругается если Exception никто не кидает, хотя он checked
        }
    }

    void foo2() throws RuntimeException {
        try {
        } catch (RuntimeException e) {
        }
    }

    void foo3() throws Throwable {
        try {
        } catch (Throwable e) {  // компилятор не ругается если Throwable никто не кидает, хотя он checked
        }
    }

    void foo4() throws MyThrowable {  // throws .. для checked не заперщается если даже его не кидают
        try {
        //} catch (MyThrowable e) { // illegal, checked никто не кидает
        } finally {
        }
    }

    void foo5() throws YourException, MyException {

        if (true) throw new YourException(); // legal, checked прокинуто
        if (true) throw new MyException();   // legal, checked прокинуто
        //throw new Exception();     // illegal, checked не прокинуто и не перехвачено

        try {
        //} catch (YourException e) { // illegal, checked никто не кидает
        //} catch (MyException e) {  // illegal, checked никто не кидает
        } finally {
        }
    }

    void foo6() throws MyRuntimeException {
        try {
        } catch (MyRuntimeException e) { // legal, любые unchecked можно ловить
        }
    }

    void foo7() throws Error {
        try {
        } catch (Error e) {
        }
    }

    void foo8() throws MyError {
        try {
        } catch (MyError e) {
        }
    }

    void foo9() throws YourRuntimeException {
        try {
        } catch (YourRuntimeException e) {
        }
    }

    void foo10() {
        try {
            throw new MyException();   // legal, checked перехвачено
        } catch (Exception e) {
        }
    }
}
