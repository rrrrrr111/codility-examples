package ru.roman.certification.classes.constructor;

class StaticInitBlock {
    static {
        // System.out.println(ss);                     // illegal, forward reference
        System.out.println(StaticInitBlock.ss);   // но так можно, значение = 33, compile-time constant
        System.out.println(StaticInitBlock.dd);   // 0 - дефолтное т к еще не инициализировано
    }
    final static int ss = 33;
    final static int dd = foo();
    static int foo() {return 66;}

    static {
        System.out.println(StaticInitBlock.dd);   // 66 - инициализировалась
    }

    public static void main(String[] args) {

        System.out.println("kop = " + UseBeforeDeclaration.kop);
    }
}

class UseBeforeDeclaration {

    static int kop = new Object() {int run() { return jop;}}.run();
    public static final int jop = 1;
    static {
        x = 100;                              // ok - assignment
//       int y = x + 1;                      // illegal - read before declaration
        int v = x = 3;                        // ok - x at left hand side (LHS) of assignment
        int z = UseBeforeDeclaration.x * 2;   // ok - not accessed via simple name

        Object o = new Object() {
            void foo() { x++; }               // ok - occurs in a different class
            { x++; }                          // ok - occurs in a different class
        };
    }

    {
        j = 200;                              // ok - assignment
//       j = j + 1;                          // illegal - right hand side reads before declaration
//       int k = j = j + 1;                  // illegal forward reference to j
        int n = j = 300;                      // ok - j at left hand side of assignment
//       int h = j++;                        // illegal read before declaration
        int l = this.j * 3;                   // ok - not accessed via simple name

        Object o = new Object() {
            void foo(){ j++; }                // ok - occurs in a different class
            { j = j + 1; }                    // ok - occurs in a different class
        };
    }

    int w = x = 3;                            // ok - x at LHS, static x переинициализировано и присвоено в w
    int p = x;                                // ok - instance initializers may access static fields

    static int u =  (new Object() {           // ok - occurs in a different class
        int bar() { return x; }
    }).bar();
    static int x;

    int m = j = 4;                            // ok - j at LHS
    int o = (new Object() {
        int bar() { return j; }      // ok - occurs in a different class
    }).bar();
    int j;
}