/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.classes.statics;

/**
 * 1.  static - доступен только для вложенных классов, это сделано лдя того
 * чтобы такие класссы иницировались на садии компиляции и были доступны
 * по сслыке на класс
 * у обычных классов модификатор static не доступен, обычный класс считается
 * статическим если все его методы статические
 *
 * 2. Обычно в статическом классе все методы объявляют статическими,
 * сам класс делают final, а конструкторы private , тогда получается
 * просто набор методов - функций.
 *
 * @author churganov_r 21.03.2011
 */
public final class A026_ClassesStatic {


    public class A026_Classes1 {

        void foo() {
            class A026_Classes2 {
                //static void foo(){               //ошибка
                //}
            }
        }

        void foo1() {
            System.out.println("Привет");
        }

        class A026_Classes2 {
        }
    }

    public static class A026_Classes2 {

        static void foo() {
        }

        void foo1() {
            System.out.println("Привет");
        }
    }

    public abstract class A026_Classes3 {

        void foo() {
        }
    }

    public static abstract class A026_Classes4 {

        static void foo() {
        }
    }

    public interface A026_Interface1 {

        void foo();
    }

    public abstract interface A026_Interface2 {

        abstract void foo();
    }

    public static abstract interface A026_Interface3 {

        abstract void foo();
    }

    static void foo1() {

        //class A027_Classes1 extends A026_Classes3 {       // ошибка классы внутри метода грузятся по порядку
        //}                                                 // и поэтому нельзя наследовать класс который еще не загружен

        abstract class A026_Classes3 {
        }

        class A026_Classes1 extends A026_Classes3 {
        }

    }


}

class A026_Classes1 {
}

abstract class A026_Classes3 {
}

interface A026_Interface1 {
}

abstract interface A026_Interface2 {

    void foo();

    abstract void foo1();
}
