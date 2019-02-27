/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.certification.classes.access.pkgfoo;

import ru.roman.certification.classes.access.pkgbar.AllAccessTypesFoo;

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

        new NeighbourInOtherPackage().publicMethod();
        new NeighbourInOtherPackage().packagePrivateMethod();
        new NeighbourInOtherPackage().protectedMethod();
        //new NeighbourInOtherPackage().privateMethod();  // not accessible

        System.out.println(NeighbourInOtherPackage.NestedEnum.HAMPA);
        System.out.println(new NeighbourInOtherPackage.NestedStaticClass());
        System.out.println(new NeighbourInOtherPackage().new NonStaticNestedClass());
        System.out.println(new NeighbourInOtherPackage().new NonStaticNestedClass().new NonStaticNestedInNonStaticNestedClass());
    }
}
