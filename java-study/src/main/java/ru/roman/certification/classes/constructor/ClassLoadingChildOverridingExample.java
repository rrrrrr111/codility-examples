package ru.roman.certification.classes.constructor;

class ClassLoadingChildOverridingExample {

    public static void main(String[] args) {
        System.out.println(new ChildZoo());
    }
}

class ParentZoo {

    static {
        new ChildZoo().printThree();
    }

    ParentZoo() {
        printThree();
    }

    void printThree() {
        System.out.println("three");
    }
}

class ChildZoo extends ParentZoo {
    //static int three = (int) Math.PI;        // 3
    //static int three = 3;                    // 3  из static контекста родительского класса даст 0
    //static int three = foo();                // 3

    //final int three = 3;                     // 3
    final int three = (int) Math.PI;           // 3  final & compile-time
    //final int three = foo();                 // 0

    //int three = (int) Math.PI;               // 0
    //int three = 3;                           // 0
    //int three = foo();                       // 0

    @Override
    void printThree() {
        System.out.println(three);
    }

    static int foo() {
        return 3;
    }
}