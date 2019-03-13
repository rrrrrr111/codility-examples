package ru.roman.certification.classes.classloading;

class ClassLoadingDeadlock {

    public static void main(String[] args) {
        Foo.foo(1);
    }
}

class Foo {
    static {
        Thread t = new Thread(() -> foo(2));
        t.setName("Manana");
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void foo(int i) {
        System.out.println(Thread.currentThread().getName() + " >> " + i);
    }
}