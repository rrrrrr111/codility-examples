package ru.roman.certification.classes.hiding;

import java.io.IOException;

class IllegalHidingExample {
}

class Base {
    public static final String className = "Base";
    public final static String st = "Base";
    protected static Number foo() { return 1;}
}

class Derived extends Base {
    String className = "Derived";
    private String st = "Base";
    //static void foo() {}                                // illegal
    //public final static Integer foo() throws IOException { return 1;}   // illegal
    public final static Integer foo()  { return 1;}
}

class DerDerived extends Derived {
    //public final static void foo() {}                   // illegal
}

class PrivateMatter {
    public static void main(String[] args) {
        System.out.println(new Derived().className);
        //System.out.println(Derived.st);                 // illegal
        System.out.println(Base.st);
        System.out.println(new Derived().foo());
    }
}