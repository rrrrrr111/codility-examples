package ru.roman.certification.exception;

/**
 *
 */
interface Bar {

    void foo1() throws Exception, Exception;  // дублирование не запрещается, ничего не даёт

    void foo2() throws RuntimeException;

    void foo3() throws Throwable;

    void foo4() throws MyThrowable;

    void foo5() throws MyException;

    void foo6() throws MyRuntimeException;

    void foo7() throws Error;

    void foo8() throws MyError;

    void foo9() throws YourRuntimeException;

    void foo10();
}
