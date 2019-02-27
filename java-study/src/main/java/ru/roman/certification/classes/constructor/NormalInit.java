package ru.roman.certification.classes.constructor;

class NormalInit {
    public static void main(String[] args) {
        new NormalInit();
    }

    NormalInit() {
        this.cc = 18;
        this.mm = 28;
    }
    {
        //System.out.println(cc);            // illegal, forward reference
    }
    int cc;
    final int mm;
    final int ss = 38;
    final int dd = foo();
    {
        System.out.println(cc);              // 0  - конструктор еще не отработал
        //System.out.println(mm);            // illegal, variable cc might not have been initialized
        System.out.println(ss);              // 38
        System.out.println(dd);              // 68
    }
    int foo() {return 68; }
}
