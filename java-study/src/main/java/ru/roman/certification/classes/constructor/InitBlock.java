package ru.roman.certification.classes.constructor;

class InitBlock {
    public static void main(String[] args) {
        new InitBlock();
    }

    InitBlock(boolean b) {
        this.mm = 28;
    }
    InitBlock() {
        this(false);                    // this для консруктора
        this.foo();                         // this для метода
        this.cc = 18;
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
