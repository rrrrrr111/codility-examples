package ru.roman.certification.classes.shadowing;

/**
 *
 */
public class ShadowingExample {


}

class Test1 {
    static int x;
    public static void main(String[] args) {
        //int x = x;
        int x = (x = 2) * 2;

        System.out.println(Test1.x);
        System.out.println(x);
    }
}
