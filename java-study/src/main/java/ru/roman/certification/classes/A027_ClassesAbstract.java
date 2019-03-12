/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.classes;

/**
 * 1. В абстрактном классе все также как и в обычном только нельзя создать его
 * экземпляр
 *
 * 2. В абстрактном классе абстрактный метод можно дернуть из не абстрактного
 */
public abstract class A027_ClassesAbstract {

    class A027_Classes1 {

        //static void foo1(){     // ОШИБКА - класс внутри абстрактного класса
        //}                         // считается вложенным

        void foo() {
            class A027_Classes2 {
                //class A027_Classes1 {            //ошибка
                //}
                //static void foo(){               //ошибка
                //}
            }
        }

        class A027_Classes2 {
        }
    }

    public static class A027_Classes2 {

        static int i = 0;

        static {
        }

        static void foo() {
        }

        void foo1() {
            System.out.println("Привет");
        }
    }

    public abstract class A027_Classes3 {

        void foo() {
        }

    }

    public static abstract class A027_Classes4 {

        static void foo() {
        }
    }

    public interface A027_Interface1 {

        void foo();
    }

    public abstract interface A027_Interface2 {

        abstract void foo();
    }

    public static abstract interface A027_Interface3 {

        void foo();

        abstract void foo1();
    }

    void foo1() {

        class A027_Classes1 {
        }

        abstract class A027_Classes3 {
        }

    }

    static void foo2() {

        class A027_Classes1 {
        }

        abstract class A027_Classes3 {
        }

    }

    abstract void foo3();

    void foo4() {
        foo3();        // абстрактный метод можно дернуть из не абстрактного
    }

    static void foo5() {
        //foo3();         // ошибка - из статического метода нельзя дернуть
        // абстрактный, поскольку это статический контект,
        // абстрактный метод нельзя сделать статическим
    }

    public static void main(String[] args) {
        class A027_ClassesAbstract1 extends A027_ClassesAbstract {

            @Override
            void foo3() {
                System.out.println("I'am abstract method");
            }
        }
        new A027_ClassesAbstract1().foo4();
    }
}

class A027_Classes1 {
}

abstract class A027_Classes3 {
}

interface A027_Interface1 {
}

abstract interface A027_Interface2 {
}
