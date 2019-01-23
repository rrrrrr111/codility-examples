/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.samples.diff;

/**
 * Java 5 Standard Edition
 *
 * @author дтоь 12.01.2008
 */
public class MixedClassFoo implements InterfaceFoo, InterfaceBar {

    public void foo() {
        System.out.println("method");
    }

    public static void main(String[] args) {

        System.out.println("Test N1");
        System.out.println(
                "Two interfaces have property with the same signature");

        MixedClassFoo mixedClass = new MixedClassFoo();
        Some mixedClass1 = new Some();

        /* reference to commonString is ambiguous,
        both variable commonString in InterfaceFoo
        and variable commonString in InterfaceBar match */

        //System.out.println(mixedClass.commonString);

        InterfaceFoo i = mixedClass;
        System.out.println(i.commonString);
        System.out.println(((InterfaceBar) mixedClass).commonString);

        mixedClass.foo();
    }

    public void fu() {
    }
}

interface InterfaceFoo {

    String commonString = "commonString from InterfaceFoo";

    void foo();
}

interface InterfaceBar {

    String commonString = "commonString from InterfaceBar";

    void fu();

    // В интерфейсе можно задать класс, только статический
    class Some {
        int i;

        void fu() {
            int y = ++i;
        }
    }
}
