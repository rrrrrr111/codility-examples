/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.classes;


import java.lang.reflect.InvocationTargetException;

/**
 * @author churganov_r 16.03.2011
 */
public class A025_ClassesAccess {

    void foo() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {

        // доступ к обычному классу
        new A025_Classes().foo1();

        // доступ к статическому методу этого же класса можно делать через
        // ссылку на класс, даже если класс не статический  или через объект класса
        A025_Classes.foo2();
        new A025_Classes().foo2();


        // доступ к вложенному классу
        new A025_Classes().new A025_Classes1();

        // доступ к вложенному статическому классу через ссылку
        A025_Classes.A025_Classes2.foo();
        //A025_Classes.new A025_Classes2().foo();           // не допустимо
        //new A025_Classes().A025_Classes2.foo();           // не допустимо
        //new A025_Classes().new A025_Classes2().foo();     // не допустимо
        // доступ к вложенному статическому классу через объект
        new A025_Classes.A025_Classes2().foo();


        // доступ к не статическому методу вложенного статического класса
        //A025_Classes.A025_Classes2.foo1();            // не допустимо
        new A025_Classes.A025_Classes2().foo1();    // допустимо

        // тоже самое через рефлексию
        A025_Classes.A025_Classes2.class.getDeclaredMethod("foo1").invoke(A025_Classes.A025_Classes2.class.newInstance());


        // можно наследовать только статические вложенные классы
        // не статические нельзя наследовать так как их инстансы
        // создаются только при создании объекта класса.., а статические
        // создаются при инициализации.., но не статические вложенные
        // можно наследовать внутри внутри класса который содержит эти
        // вложенные классы .. .
        class A025_ClassesAccess1 extends A025_Classes.A025_Classes2 {
        }

        class A025_ClassesAccess2 extends A025_Classes.A025_Classes4 {
        }

        // досту к статическому методу абстрактного класса.
        A025_Classes.A025_Classes4.foo();
        //A025_Classes.new A025_Classes4().foo();           // не допустимо
        //new A025_Classes().A025_Classes4.foo();           // не допустимо
        //new A025_Classes().new A025_Classes4().foo();     // не допустимо


        // все интерфейсы доступны.
        // если класс абстрактный, он может не реализовывать методы интерфейса
        abstract class A025_ClassesAccess3 implements A025_Classes.A025_Interface1 {
        }
        abstract class A025_ClassesAccess4 implements A025_Classes.A025_Interface2 {
        }
        abstract class A025_ClassesAccess5 implements A025_Classes.A025_Interface3 {
        }


        // доступ ко второму классу в исходнике и другим сущностям так же
        // как и обычным классам
        new A025_Classes1().toString();

        class A025_ClassesAccess6 extends A025_Classes3 implements A025_Interface1 {
        }

        // модификаторы static и abstract у интерфейсов и  не имеют смысла
        // модификатор abstract у метода интерфейса тоже не имеет смысла
        class A025_ClassesAccess7 implements A025_Interface2, A025_Classes.A025_Interface3 {

            @Override
            public void foo() {
            }

            @Override
            public void foo1() {
                System.out.println("Хай , я реализовал static и abstract интерфейсы");
            }
        }
        new A025_ClassesAccess7().foo1();

    }

    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {

        new A025_ClassesAccess().foo();


    }
}

