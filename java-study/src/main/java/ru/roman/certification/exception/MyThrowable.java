package ru.roman.certification.exception;

/**
 *
 */
class MyThrowable extends Throwable { // наследование Throwable legal

    MyThrowable() {
        // конструктор без stacktrace, выброс в 5 раз быстрее
        super(null, null, false, false);
    }
}
