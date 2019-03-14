/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.certification.classes.access.pkgbar.subpkg;

import ru.roman.certification.classes.access.pkgbar.AllAccessTypesFoo;

/**
 * @author myno 13.01.2008
 */
class NeighbourInSubPackage extends AllAccessTypesFoo {

    public String publicField = "publicField in NeighbourInSubPackage";            // hiding
    protected String protectedField = "protectedField in NeighbourInSubPackage";   // hiding
    String packagePrivateField = "packagePrivateField in NeighbourInSubPackage";
    private String privateField = "privateField in NeighbourInSubPackage";

    @Override
    public void publicMethod() {
        super.publicMethod();
    }

    @Override
    protected void protectedMethod() {
        super.protectedMethod();
    }

    //@Override                         // not overridable
    void packagePrivateMethod() {
        //super.packagePrivateMethod(); // not accessible
    }

    //@Override                         // not overridable
    private void privateMethod() {
        //super.privateMethod();        // not accessible
    }

    public static void main(String[] args) {
        new AllAccessTypesFoo().publicMethod();            // accessible everywhere
        //new AllAccessTypesFoo().protectedMethod();       // not accessible in subpackage
        //new AllAccessTypesFoo().packagePrivateMethod();  // not accessible in subpackage
        //new AllAccessTypesFoo().privateMethod();         // accessible in own class only

        //new NestedProtected();  // illegal, класс protected и DC protected
    }
}
