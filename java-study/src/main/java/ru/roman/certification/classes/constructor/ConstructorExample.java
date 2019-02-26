package ru.roman.certification.classes.constructor;

class ConstructorExample {

    public static void main(String[] args) {
        new Sub(0);
    }
}

class Sub extends Parent {
    static {
        System.out.println("sub 2 static 0");
    }

    {
        System.out.println("sub 2 init 1");
    }

    public Sub(int x) {
        super(x);
        System.out.println("sub 2 constr 2");
    }

    {
        System.out.println("sub 2 init 3");
    }

    static {
        System.out.println("sub 2 static 4");
    }

    public int foo() {
        return 666;
    }
}

class Parent extends AbsParent {
    static {
        System.out.println("sub 1 static 0");
    }

    {
        System.out.println("sub 1 init 1");
    }

    public Parent(int x) {
        super(0);
        System.out.println("sub 1 constr 2");
    }

    {
        System.out.println("sub 1 init 3");
    }

    static {
        System.out.println("sub 1 static 4");
    }
}

class AbsParent {
    static {
        System.out.println("static 0");
    }

    {
        System.out.println("init 1");
        d = 0;
    }

    int x;
    final int d;
    final int f = foo();

    public int foo() {
        return 33;
    }

    public AbsParent(int x) {
        this.x = x;
        System.out.println("constr 2");
    }

    {
        System.out.println("init 3");
    }

    static {
        System.out.println("static 4");
    }
}
