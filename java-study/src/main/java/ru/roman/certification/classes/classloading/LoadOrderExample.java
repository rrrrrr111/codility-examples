package ru.roman.certification.classes.classloading;

import ru.roman.certification.classes.classloading.One;

public class LoadOrderExample {

    public static void main(String[] args) {
        One o = null;
        Two t = new Two();
        One.foo();
    }
}

class Super {
    One one;
    static { System.out.print("Super "); }
}
class One {
    static { System.out.print("One "); }
    static void foo(){}
}
class Two extends Super {
    static { System.out.print("Two "); }
}
