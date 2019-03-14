package ru.roman.certification.classes.obscuring;

import ru.roman.certification.classes.obscuring.X.Y;

class X {

    static class Y { static String Z = "Black"; }
    static C Y = new C();
}
class C {    String Z = "White"; }

class ShadesOfGray {
    public static void main(String[] args){
        System.out.println(X.Y.Z);
        System.out.println(Y.Z);
        System.out.println(((X.Y)null).Z);
    }
}

