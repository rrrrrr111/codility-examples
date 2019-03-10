package ru.roman.certification.classes.constructor;

import java.io.IOException;

class StaticInitException {

    public static void main(String[] args) throws Exception {
        try {
            new StaticInitException();
        } catch (Throwable e) {
            System.out.println("Got it: " + e);
            throw e;
        }
    }

    //private static final int HHH1 = foo();      // illegal
    private int hh1 = foo();
    private static final int HHH = foo1();
    private int hh = foo1();
    //private StaticInitException internalInstance = new StaticInitException(); // StackOverflowError

    Fgoo fgoo = new Fgoo();

    private StaticInitException() throws Exception {
    }

    {
        //throw new InterruptedException();    // illegal
        if (true) throw new InterruptedException();
    }

    public static int foo() throws InterruptedException {
        return 0;
    }

    public static int foo1() throws RuntimeException {
        return 0;
    }
}

class Fgoo {
    static {
        //throw new RuntimeException();             // illegal

        if (true) try {
            throw new Exception();
        } catch (Throwable e) {
            //throw new RuntimeException(e);
        }
        if (true) throw new RuntimeException();
        //if (true) throw new IOException();       // illegal
    }
}
