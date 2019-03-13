package ru.roman.certification.classes.constructor;

class ConstructorHelperExample {
}


class Foo {
    Foo(int i) {
    }
}

class Bar extends Foo {

    int i;

    Bar() {
        //super(foo());
        this(foo());
    }

    private Bar(int i) {
        super(i);
        this.i = i;
    }

    static int foo() {
        return 0;
    }
}