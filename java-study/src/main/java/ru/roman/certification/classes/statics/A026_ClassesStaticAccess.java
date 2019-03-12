/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.classes.statics;

import ru.roman.certification.classes.A025_Classes;

import java.lang.reflect.InvocationTargetException;

/**
 * @author churganov_r 16.03.2011
 */
class A026_ClassesStaticAccess {


    class A026_Classes1 {

    }

    void foo() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {

        // к методам свободно
        A026_ClassesStatic.foo1();
        new A026_ClassesStatic().foo1();

        // к не статическому вложенному классу только через объект
        new A026_ClassesStatic().new A026_Classes1();

        // через ссылку не канает как это работает для класса вложенного в интерфейс
        //A026_ClassesStatic.new A026_Classes1();   // ошибка
        //new A026_ClassesStatic.A026_Classes1();   // ошибка

        // к статическому канает
        A026_ClassesStatic.A026_Classes2.foo();
        // но через объекты к статическому нельзя
        //new A026_ClassesStatic().new A026_Classes2().foo();  // ошибка

        // запуск не доступного метода
        A026_ClassesStatic.A026_Classes2.class.getDeclaredMethod("foo1").invoke(A026_ClassesStatic.A026_Classes2.class.newInstance());
        new A026_ClassesStatic.A026_Classes2().foo1();

        // а тут не удастся создать инстанс
        //A026_ClassesStatic.A026_Classes1.class.getDeclaredMethod("foo1").invoke(A026_ClassesStatic.A026_Classes1.class.newInstance());


        // не статик внутренний класс нельзя наследовать извне, а статик можно
        class A026_ClassesStaticAccess1 extends A026_ClassesStatic.A026_Classes2 {
        }

        class A026_ClassesStaticAccess2 extends A026_ClassesStatic.A026_Classes4 {
        }

        A026_ClassesStatic.A026_Classes4.foo();

        abstract class A025_ClassesAccess3 implements A026_ClassesStatic.A026_Interface1 {
        }
        abstract class A025_ClassesAccess4 implements A026_ClassesStatic.A026_Interface2 {
        }
        abstract class A025_ClassesAccess5 implements A026_ClassesStatic.A026_Interface3 {
        }

        new A026_Classes1().toString();

        class A026_ClassesAccess6 extends A026_Classes3 implements A026_Interface1 {
        }
        // здесь иногда подглючивает NetBeans не находит нужного интерфейса
        class A026_ClassesAccess7 implements A026_Interface2, A025_Classes.A025_Interface3 {

            @Override
            public void foo() {
            }

            @Override
            public void foo1() {
                System.out.println("Хай , я реализовал static и abstract интерфейсы");
            }
        }
        new A026_ClassesAccess7().foo1();


    }

    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {

        new A026_ClassesStaticAccess().foo();


    }
}
