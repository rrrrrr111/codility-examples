package ru.roman.certification.classes.method;

public class StaticMethodCallExample {

    public static void main(String[] args) {
        ((StaticMethodCallExample) null).call();
    }

    static void call() {
        System.out.println("Hello");
    }
}
