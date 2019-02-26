package ru.roman.certification.classes.constructor;

class StaticInit {
    static {
        // System.out.println(ss);                     // illegal, forward reference
        System.out.println(StaticInit.ss);   // но так можно, значение = 33, compile-time constant
        System.out.println(StaticInit.dd);   // 0 - дефолтное т к еще не инициализировано
    }
    final static int ss = 33;
    final static int dd = foo();
    static int foo() {return 66;}

    static {
        System.out.println(StaticInit.dd);   // 66 - инициализировалась
    }

    public static void main(String[] args) {
    }
}
