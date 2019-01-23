/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.certification.access.pkgfoo;

import ru.roman.certification.access.pkgbar.AllAccessTypesFoo;

/**
 * В не наследнике в другом пакете можем вызвать только public
 *
 * @author myno 13.01.2008
 */
public class JustInPackage {

    public static void main(String[] args) {

        new AllAccessTypesFoo().publicMethod();            // accessible everywhere
        //new AllAccessTypesFoo().protectedMethod();       // accessible in package and in subclasses, but not in static context of subclasses
        //new AllAccessTypesFoo().packagePrivateMethod();  // accessible in package only
        //new AllAccessTypesFoo().privateMethod();         // accessible in own class only

        new FooSubClassInOtherPackage().publicMethod();
        new FooSubClassInOtherPackage().packagePrivateMethod();
        new FooSubClassInOtherPackage().protectedMethod();
        //new FooSubClassInOtherPackage().privateMethod();  // not accessible

        System.out.println(FooSubClassInOtherPackage.NestedEnum.HAMPA);
        System.out.println(new FooSubClassInOtherPackage.NestedStaticClass());
        System.out.println(new FooSubClassInOtherPackage().new NonStaticNestedClass());
        System.out.println(new FooSubClassInOtherPackage().new NonStaticNestedClass().new NonStaticNestedInNonStaticNestedClass());
    }
}
