package ru.roman.certification.exception;

/**
 *
 */
class SubBar implements Bar { // компилятор не требует никаких throws при имплементации

    @Override
    public void foo1() {
    }

    @Override
    public void foo2() {
    }

    @Override
    public void foo3() {
    }

    @Override
    public void foo4() {
    }

    //public void foo5() throws Exception { // illegal, однако если мы объявляем екзепш, он должен быть таким же либо ковариантным
    //}

    @Override
    public void foo5() throws MyRuntimeException, YourRuntimeException { // любые unchecked можно расставляь как угодно, компилятор никак не запрещает
    }

    @Override
    public void foo6() throws YourRuntimeException {
    }

    @Override
    public void foo7() throws YourRuntimeException, MyRuntimeException, YourRuntimeException { // можно дублировать
    }

    @Override
    public void foo8() throws MyRuntimeException {

    }

    @Override
    public void foo9() throws MyRuntimeException {

    }

    @Override
    public void foo10() throws MyRuntimeException, YourRuntimeException {
    }
}