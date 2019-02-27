/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.certification.classes.access.pkgbar;

/**
 * @author myno 13.01.2008
 */
public class NeighbourInPackage extends AllAccessTypesFoo {

    public String publicField = "publicField in NeighbourInPackage";            // hiding
    protected String protectedField = "protectedField in NeighbourInPackage";   // hiding
    String packagePrivateField = "packagePrivateField in NeighbourInPackage";   // hiding
    private String privateField = "privateField in NeighbourInPackage";

    @Override
    public void publicMethod() {
        super.publicMethod();
    }

    @Override
    protected void protectedMethod() {
        super.protectedMethod();
    }

    @Override
    void packagePrivateMethod() {
        super.packagePrivateMethod();
    }

    private void privateMethod() {     // not overridable
        //super.privateMethod();       // not accessible
    }

    public static void main(String[] args) {
        new AllAccessTypesFoo().publicMethod();          // accessible everywhere
        new AllAccessTypesFoo().protectedMethod();       // accessible in static context in same package
        new AllAccessTypesFoo().packagePrivateMethod();  // accessible in package only
        //new AllAccessTypesFoo().privateMethod();         // accessible in own class only
    }
}
