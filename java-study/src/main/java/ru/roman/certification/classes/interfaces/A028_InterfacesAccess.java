/*
 *
 */
package ru.roman.certification.classes.interfaces;

import java.lang.reflect.InvocationTargetException;

/**
 * 1. Общее правило доступа:
 *
 * - Если нужно получить ссылку на статический класс, то достаточно указать
 * полную ссылку на эту сущность с учетом всех классов в которые он вложен
 * - для создания интсанса статического класса пишем в самом начале new
 * далее также перечисляем через точку все классы в которые он вложен и указываем к конце
 * имя этого класса и скобки.
 * - для получения инстанса не статического класса нужен интсанс класса
 * в который данный класс вложен
 */
class A028_InterfacesAccess {

    void foo() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {

        // доступ к обычному вложенному классу
        // вложенный класс
        //new A028_Interfaces.A028_Classes1().new A028_Classes2();

        // не статический метод не статического класса
        new A028_Interfaces.A028_Classes1().foo();


        // класс статический
        new A028_Interfaces.A028_Classes1();
        new A028_Interfaces.A028_Classes2();


        // доступ к статическому методу статического класса  через объект
        // или ссылку на класс

        A028_Interfaces.A028_Classes2.foo();                // допустимо
        new A028_Interfaces.A028_Classes2().foo();           // допустимо
        //A028_Interfaces.new A028_Classes2().foo();           // не допустимо


        // пример рефлексии
        A028_Interfaces.A028_Classes2.class.getDeclaredMethod("foo1").invoke(A028_Interfaces.A028_Classes2.class.newInstance());


        // можно наследовать любые классы
        class A028_InterfacesAccess1 extends A028_Interfaces.A028_Classes1 {
        }

        class A028_InterfacesAccess2 extends A028_Interfaces.A028_Classes2 {
        }

        class A028_InterfacesAccess3 extends A028_Interfaces.A028_Classes3 {
        }

        class A028_InterfacesAccess4 extends A028_Interfaces.A028_Classes4 {
        }

        // досту к статическому методу абстрактного класса.
        A028_Interfaces.A028_Classes4.foo();

        // все интерфейсы доступны.
        // если класс абстрактный, он может не реализовывать методы интерфейса
        abstract class A028_ClassesAccess3 implements A028_Interfaces.A028_Interface1 {
        }
        abstract class A028_ClassesAccess4 implements A028_Interfaces.A028_Interface2 {
        }
        abstract class A028_ClassesAccess5 implements A028_Interfaces.A028_Interface3 {
        }


        // доступ ко второму классу в исходнике и другим сущностям так же
        // как и обычным классам
        new A028_Classes1().toString();

        class A028_ClassesAccess6 extends A028_Classes3 implements A028_Interface1 {
        }

        class A028_ClassesAccess7 implements A028_Interface2, A028_Interfaces.A028_Interface3 {

            @Override
            public void foo() {
            }

            @Override
            public void foo1() {
                System.out.println("Хай , я реализовал static и abstract интерфейсы");
            }
        }
        new A028_ClassesAccess7().foo1();

    }

    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {

        new A028_InterfacesAccess().foo();


    }


}


class A028_Classes1 {

}
