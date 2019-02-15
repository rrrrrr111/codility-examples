package ru.roman.certification.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 */
class SubFoo extends Foo {  // компилятор не требует никаких throws при переопределении

    @Override
    void foo1() throws IOException, FileNotFoundException, MyException { // можно бъявить больше чем у родителя, но только ковариантыне
    }

    @Override
    void foo2() {
    }

    @Override
    void foo3() {
    }

    @Override
    void foo4() {
    }

    @Override
    void foo5() throws YourException, MyException { // можно не в том порядке как у родителя, можно убрать один или обоих, можно добавить ковариантных
    }

    @Override
    void foo6() {
    }

    @Override
    void foo7() {
    }

    @Override
    void foo8() {
    }

    @Override
    void foo9() {
    }

    @Override
    void foo10() {
    }
}
