/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.certification.classes.access.pkgfoo;

import ru.roman.certification.classes.access.pkgbar.AllAccessTypesFoo;

/**
 * 1. Внутри самого класса можем все
 * <p>
 * 2. Нет такого отдельного понятия как права на доступ для переопределения, переопределить
 * , точнее объявить можно любой класс, но некоторые методы суперкласса доступны
 * внутри нашего класса и если мы создаем метод с такими же параметрами то счита
 * ется что мы переопределили метод
 * <p>
 * 3. Порядок сужжаемости прав
 * <p>
 * public
 * protected
 * package
 * private
 * <p>
 * 4. При наследовании , если происходит переопределение метода можно
 * расширять права модификатором, но не сужжать
 * <p>
 * 5. Аннотация @Override для того чтобы четко обозначить что метод именно переопределен,
 * а не просто метод, если метод не переопределен компилятор бросит исключение
 * <p>
 * 6. метод private, даже если доступен, это уже не переорпеделение, а объявление
 * такого же метода
 * <p>
 * 7. В наследнике в другом пакете можем все кроме вызова метода private и package private
 *
 * @author myno 13.01.2008
 */
class NeighbourInOtherPackage extends AllAccessTypesFoo {

    public String publicField = "publicField in NeighbourInOtherPackage";               // hiding
    protected String protectedField = "protectedField in NeighbourInOtherPackage";      // hiding
    String packagePrivateField = "packagePrivateField in NeighbourInOtherPackage";      // duplicates but not hiding
    private String privateField = "privateField in NeighbourInOtherPackage";            // duplicates

    @Override
    public void publicMethod() {
        super.publicMethod();
        new AllAccessTypesFoo().publicMethod();
    }

    @Override
    protected void protectedMethod() {
        super.protectedMethod();
        //new AllAccessTypesFoo().protectedMethod();       // illegal !!!
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
            System.out.println(new NeighbourInOtherPackage().publicField);
            System.out.println(new NeighbourInOtherPackage().protectedField);
            System.out.println(new NeighbourInOtherPackage().packagePrivateField);
            System.out.println(new NeighbourInOtherPackage().privateField);

            //System.out.println(publicField);            // fields not accessible
            //System.out.println(protectedField);
            //System.out.println(packagePrivateField);
            //System.out.println(privateField);
        }
    }

    static class NestedStaticClass {  // аналогично как в енуме
        NestedStaticClass() {
            System.out.println(new NeighbourInOtherPackage().publicField);
            System.out.println(new NeighbourInOtherPackage().protectedField);
            System.out.println(new NeighbourInOtherPackage().packagePrivateField);
            System.out.println(new NeighbourInOtherPackage().privateField);

            //System.out.println(publicField);            // fields not accessible
            //System.out.println(protectedField);
            //System.out.println(packagePrivateField);
            //System.out.println(privateField);
        }
    }

    class NonStaticNestedClass {
        NonStaticNestedClass() {
            System.out.println(new NeighbourInOtherPackage().publicField);
            System.out.println(new NeighbourInOtherPackage().protectedField);
            System.out.println(new NeighbourInOtherPackage().packagePrivateField);
            System.out.println(new NeighbourInOtherPackage().privateField);

            System.out.println(publicField);
            System.out.println(protectedField);
            System.out.println(packagePrivateField);
            System.out.println(privateField);
        }

        class NonStaticNestedInNonStaticNestedClass {
            NonStaticNestedInNonStaticNestedClass() {
                NeighbourInOtherPackage o = new NeighbourInOtherPackage();
                System.out.println(o.publicField);
                System.out.println(o.protectedField);
                System.out.println(o.packagePrivateField);
                System.out.println(o.privateField);

                System.out.println(publicField);
                System.out.println(protectedField);
                System.out.println(packagePrivateField);
                System.out.println(privateField);

                System.out.println(NeighbourInOtherPackage.this.publicField);
                System.out.println(NeighbourInOtherPackage.this.protectedField);
                System.out.println(NeighbourInOtherPackage.this.packagePrivateField);
                System.out.println(NeighbourInOtherPackage.this.privateField);

                System.out.println(((AllAccessTypesFoo) o).publicField);   // доступ к hidden после приведения к типу
                //System.out.println(((AllAccessTypesFoo)o).protectedField);   // illegal, у protected особая смантик
                // его можно переопределить или обратиться через super
                // но через инстанс можно обращаться только из того же пакета
                //System.out.println(((AllAccessTypesFoo)o).packagePrivateField);         // illegal
                //System.out.println(((AllAccessTypesFoo)o).privateField);                // illegal

                System.out.println(NeighbourInOtherPackage.super.publicField);
                System.out.println(NeighbourInOtherPackage.super.protectedField);
                //System.out.println(NeighbourInOtherPackage.super.packagePrivateField);  // illegal
                //System.out.println(NeighbourInOtherPackage.super.privateField);         // illegal

            }
        }
    }


    public static void main(String[] args) {

        new AllAccessTypesFoo().publicMethod();            // accessible everywhere
        //new AllAccessTypesFoo().protectedMethod();       // illegal
        //new AllAccessTypesFoo().packagePrivateMethod();  // illegal
        //new AllAccessTypesFoo().privateMethod();         // illegal

        new NeighbourInOtherPackage().publicMethod();
        new NeighbourInOtherPackage().packagePrivateMethod();
        new NeighbourInOtherPackage().protectedMethod();
        new NeighbourInOtherPackage().privateMethod();

        System.out.println(NestedEnum.HAMPA);
    }
}
