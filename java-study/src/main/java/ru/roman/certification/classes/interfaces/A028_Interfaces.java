/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.classes.interfaces;

/**
 *
 *
 * 2. Интерфейс и его методы могут принимать модификаторы public и abstract
 * но если эти модификаторы не указаны, они используются по умолчанию
 *
 * 3. Конструкторы и блоки не допустимы в интерфейсе.
 *
 * 4. Интерфейс может содержать в себе все тоже самое, что обычный класс
 * за исключением того что его методы не определены и все его поля имеют не
 * явно модификаторы public static final, тоесть если модификаторы не
 * объявлены, по умолчанию они все равно устанавливаются в public static final
 * Это называется константы
 *
 * 5. Если класс реализовал 2 интерфейса с одинаковыми константами, то
 * доступ к ним будет осуществляться в зависимости от типа ссылки на класс
 *
 * 6. 5. Если класс реализовал 2 интерфейса с одинаковыми методами, то
 * в результате будет реализован один общий метод
 *
 * 7. Интерфейс нельзя создать внутри метода, конструктора или блока.
 *
 * 8. ограничения именования интерфейсов такие же как у классов
 *
 * 9. Интерфейс нельзя создать внутри не статического вложенного класса, т к
 * интерфейс - это статическая сущность, в остальном интерфейсы можно класть
 * куда угодно
 *
 * 12. Класс не может реализовать свой внутренний интерфейс, ошибка
 * циклического наследования
 *
 * 13. Если вложенный класс реализует вложенный на том же уровне интерфейс,
 * то его имя можно указать без префиксного указания внешнего класса,
 * либо с указнием прификсного имени.
 * Если же в этом случае нужно указать именно интерфейс самого верхнего уровня, с
 * таким же именем то нужно будет указать его полное имя вместе с именем пакета..
 *
 * @author churganov_r 15.03.2011
 */
interface A028_Interfaces {

    public static final int i = 0;

    public class A028_Classes1 {
        public static final int с = 0;

        void foo() {
            class A028_Classes2 {
                class A028_Classes3 {
                }
            }
        }
    }

    public static class A028_Classes2 {

        static int i = 0;

        static {
        }

        static void foo() {
        }

        void foo1() {
            System.out.println("Привет");
        }

        interface A028_Interfaces1 {
        }
    }

    public abstract class A028_Classes3 {

        void foo() {
        }

        public static abstract class A028_Classes5 {
            interface A028_Interfaces1 {}
        }

        interface A028_Interfaces1 {
        }
    }

    public static abstract class A028_Classes4 {

        static void foo() {
        }

        interface A028_Interfaces1 {
        }
    }

    public interface A028_Interface1 {

        void foo();

        interface A028_Interfaces1 {
        }
    }

    public abstract interface A028_Interface2 {
        public static final int INT = 2;

        abstract void foo();

        interface A028_Interfaces1 {
        }
    }

    public static abstract interface A028_Interface3 {
        public static final int INT = 3;

        void foo();

        abstract void foo1();

        interface A028_Interfaces1 {
        }
    }

    abstract class A028_TwoInterfaces implements A028_Interface2, A028_Interface3 {
        public static void main() {
            //System.out.println(INT);                  // компилятор требует какую конкретно константу
            System.out.println(A028_Interface2.INT);
        }
    }

    void foo1();

    public void foo2();

    abstract void foo3();
}

abstract class A028_Classes3 {

    interface A028_Interfaces1 {
    }
}

interface A028_Interface1 {

    interface A028_Interfaces1 {
    }
}

abstract interface A028_Interface2 {

    interface A028_Interfaces1 {
    }
}