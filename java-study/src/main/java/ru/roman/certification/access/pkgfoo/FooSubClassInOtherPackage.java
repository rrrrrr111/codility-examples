/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.certification.access.pkgfoo;

import ru.roman.certification.access.pkgbar.AllAccessTypesFoo;

/**
 * 1. Внутри самого класса можем все
 *
 * 2. Нет такого отдельного понятия как права на доступ для переопределения, переопределить
 * , точнее объявить можно любой класс, но некоторые методы суперкласса доступны
 * внутри нашего класса и если мы создаем метод с такими же параметрами то счита
 * ется что мы переопределили метод
 *
 * 3. Порядок сужжаемости прав
 *
 * public
 * protected
 * package
 * private
 *
 * 4. При наследовании , если происходит переопределение метода можно
 * расширять права модификатором, но не сужжать
 *
 * 5. Аннотация @Override для того чтобы четко обозначить что метод именно переопределен,
 * а не просто метод, если метод не переопределен компилятор бросит исключение
 *
 * 6. метод private, даже если доступен, это уже не переорпеделение, а объявление
 * такого же метода
 *
 * 7. В наследнике в другом пакете можем все кроме вызова метода private и package private
 *
 *
 * @author myno 13.01.2008
 */
public class FooSubClassInOtherPackage extends AllAccessTypesFoo {

    public String publicField = "publicField in FooSubClassInOtherPackage";               // hiding
    protected String protectedField = "protectedField in FooSubClassInOtherPackage";      // hiding
    String packagePrivateField = "packagePrivateField in FooSubClassInOtherPackage";      // duplicates but not hiding
    private String privateField = "privateField in FooSubClassInOtherPackage";

    @Override
    public void publicMethod() {
        super.publicMethod();
    }

    @Override
    protected void protectedMethod() {
        super.protectedMethod();
    }

    void packagePrivateMethod() {           // not overridable
        //super.packagePrivateMethod();     // not accessible
    }

    private void privateMethod() {     // not overridable
        //super.privateMethod();       // not accessible
    }

    enum NestedEnum {      // приватные поля доступны во внутренних классах и енумах через инстанс
        HAMPA,                     // а в не статических внутррених классах также и напрямую
        HAMSU;

        NestedEnum() {
            System.out.println(new FooSubClassInOtherPackage().publicField);
            System.out.println(new FooSubClassInOtherPackage().packagePrivateField);
            System.out.println(new FooSubClassInOtherPackage().protectedField);
            System.out.println(new FooSubClassInOtherPackage().privateField);

            //System.out.println(publicField);            // fields not accessible
            //System.out.println(packagePrivateField);
            //System.out.println(protectedField);
            //System.out.println(privateField);
        }
    }

    static class NestedStaticClass {  // аналогично как в енуме
        NestedStaticClass() {
            System.out.println(new FooSubClassInOtherPackage().publicField);
            System.out.println(new FooSubClassInOtherPackage().packagePrivateField);
            System.out.println(new FooSubClassInOtherPackage().protectedField);
            System.out.println(new FooSubClassInOtherPackage().privateField);

            //System.out.println(publicField);            // fields not accessible
            //System.out.println(packagePrivateField);
            //System.out.println(protectedField);
            //System.out.println(privateField);
        }
    }

    class NonStaticNestedClass {
        NonStaticNestedClass() {
            System.out.println(new FooSubClassInOtherPackage().publicField);
            System.out.println(new FooSubClassInOtherPackage().packagePrivateField);
            System.out.println(new FooSubClassInOtherPackage().protectedField);
            System.out.println(new FooSubClassInOtherPackage().privateField);

            System.out.println(publicField);            // all accessible
            System.out.println(packagePrivateField);
            System.out.println(protectedField);
            System.out.println(privateField);
        }

        class NonStaticNestedInNonStaticNestedClass {
            NonStaticNestedInNonStaticNestedClass() {
                System.out.println(new FooSubClassInOtherPackage().publicField);
                System.out.println(new FooSubClassInOtherPackage().packagePrivateField);
                System.out.println(new FooSubClassInOtherPackage().protectedField);
                System.out.println(new FooSubClassInOtherPackage().privateField);

                System.out.println(publicField);
                System.out.println(packagePrivateField);
                System.out.println(protectedField);
                System.out.println(privateField);

                System.out.println(FooSubClassInOtherPackage.super.publicField); // super still accessible, same as in FooSubClassInOtherPackage
                //System.out.println(FooSubClassInOtherPackage.super.packagePrivateField);  // not legal
                System.out.println(FooSubClassInOtherPackage.super.protectedField);
                //System.out.println(FooSubClassInOtherPackage.super.privateField);         // not legal

                //System.out.println(AllAccessTypesFoo.super.publicField);              // not legal
                //System.out.println(AllAccessTypesFoo.super.packagePrivateField);
                //System.out.println(AllAccessTypesFoo.super.protectedField);
                //System.out.println(AllAccessTypesFoo.super.privateField);
            }
        }
    }


    public static void main(String[] args) {

        new AllAccessTypesFoo().publicMethod();            // accessible everywhere
        //new AllAccessTypesFoo().protectedMethod();       // accessible in package and in subclasses, but not in static context of subclasses
        //new AllAccessTypesFoo().packagePrivateMethod();  // accessible in package only
        //new AllAccessTypesFoo().privateMethod();         // accessible in own class only

        new FooSubClassInOtherPackage().publicMethod();
        new FooSubClassInOtherPackage().packagePrivateMethod();
        new FooSubClassInOtherPackage().protectedMethod();
        new FooSubClassInOtherPackage().privateMethod();

        System.out.println(NestedEnum.HAMPA);
    }
}
