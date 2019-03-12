/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.classes;

import java.lang.reflect.InvocationTargetException;

/**
 * @author churganov_r 15.03.2011
 */
class A027_ClassesAbstractAccess {

    void foo() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {

        // доступ к абстрактному классу не возможен
        //new A027_Classes().foo1();

        // доступ к статическому методу абстрактного класса возможен
        A027_ClassesAbstract.foo2();
        //new A027_ClassesAbstract().foo2();


        // доступ к вложенному не статическому классу не возможен т к
        // досту к не статическим сущностям можно получить только через
        // интсанс класса, создать инстанс абстрактного класса не  возможно . .

        //A027_ClassesAbstract.new A027_Classes1();

        // доступ к вложенному статическому классу через ссылку
        A027_ClassesAbstract.A027_Classes2.foo();
        //A027_Classes.new A027_Classes2().foo();           // не допустимо
        //new A027_Classes().A027_Classes2.foo();           // не допустимо
        //new A027_Classes().new A027_Classes2().foo();     // не допустимо


        // доступ к не статическому методу вложенного статического класса
        // через рефлексию, не статические члены и сущности внутри
        // статического класса не доступны напрямую, но доступны через
        // рефлексию ... .
        //A027_Classes.A027_Classes2.foo1();            // не допустимо
        A027_ClassesAbstract.A027_Classes2.class.getDeclaredMethod("foo1").invoke(A027_ClassesAbstract.A027_Classes2.class.newInstance());


        // можно наследовать только статические вложенные классы
        // не статические нельзя наследовать так как их инстансы
        // создаются только при создании объекта класса.., а статические
        // создаются при инициализации.., но не статические вложенные
        // можно наследовать внутри внутри класса который содержит эти
        // вложенные классы .. .

        // не допустимо
        //class A027_ClassesAccess1 extends A027_ClassesAbstract.A027_Classes1 {
        //}
        class A027_ClassesAccess2 extends A027_ClassesAbstract.A027_Classes2 {
        }
        // не допустимо
        //class A027_ClassesAccess3 extends A027_ClassesAbstract.A027_Classes3 {
        //}
        class A027_ClassesAccess4 extends A027_ClassesAbstract.A027_Classes4 {
        }

        // досту к статическому методу статического абстрактного класса вложенного
        // в абстрактный класс.
        A027_ClassesAbstract.A027_Classes4.foo();
        //A027_Classes.new A027_Classes4().foo();           // не допустимо
        //new A027_Classes().A027_Classes4.foo();           // не допустимо
        //new A027_Classes().new A027_Classes4().foo();     // не допустимо


        // все интерфейсы доступны.
        // если класс абстрактный, он может не реализовывать методы интерфейса
        abstract class A027_ClassesAccess3 implements A027_ClassesAbstract.A027_Interface1 {
        }
        abstract class A027_ClassesAccess6 implements A027_ClassesAbstract.A027_Interface2 {
        }
        abstract class A027_ClassesAccess5 implements A027_ClassesAbstract.A027_Interface3 {
        }


        // доступ ко второму классу в исходнике и другим сущностям так же
        // как и обычным классам
        new A027_Classes1().toString();

        class A027_ClassesAccess7 extends A027_Classes3 implements A027_Interface1 {
        }

        class A027_ClassesAccess8 implements A027_Interface2, A027_ClassesAbstract.A027_Interface3 {

            @Override
            public void foo() {
            }

            @Override
            public void foo1() {
                System.out.println("Хай , я реализовал static и abstract интерфейсы");
            }
        }
        new A027_ClassesAccess8().foo1();

    }

    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {

        new A027_ClassesAbstractAccess().foo();

    }
}
