package ru.roman.certification.classes.classloading;

import static ru.roman.certification.classes.classloading.Helper.*;

class LoadOrderExample {

    public static void main(String[] args) {
        One o = null;
        Two t = new Two();
        One.foo();
        System.out.println();

        System.out.print(SubPuper.taxi);
        System.out.println();

        System.out.print(J.i);
        System.out.print(K.j);
        System.out.println();
    }
}

class Super { One one;    static { System.out.print("Super "); }                     }
class One {               static { System.out.print("One "); }   static void foo(){} }
class Two extends Super { static { System.out.print("Two "); }                       }

class ZazoPuper {                                            static { System.out.print("ZazoPuper ");} }
class SuperPuper extends ZazoPuper { static int taxi = 1729; static { System.out.print("SuperPuper ");}}
class SubPuper extends SuperPuper {                          static { System.out.print("SubPuper ");}  }

class Helper {
    static int foo()         { return 32;                                     }
    static String out(String s) { System.out.print(s); return s; }
}

interface I           { String i = "1 ",         ii = out("ii "); }
interface J extends I { String j = out("j "), jj = out("jj "); }
interface K extends J { String k = out("k ");                     }
