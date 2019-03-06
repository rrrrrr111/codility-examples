package ru.roman.certification.classes.constructor;

import ru.roman.certification.classes.access.Child;

public class ClassLoadingDeadLockExample {

    public static void main(String[] args) {
        System.out.println(new ParentFoo());    // 33 и далее StackOverflowError
    }
}

class ParentFoo { static { System.out.println(ChildFoo.c); } { new ChildFoo(); } }
class ChildFoo extends ParentFoo {  static int c = 33;}