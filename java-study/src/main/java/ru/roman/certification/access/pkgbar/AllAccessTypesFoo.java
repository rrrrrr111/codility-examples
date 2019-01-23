/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.certification.access.pkgbar;

/**
 * @author myno 13.01.2008
 */
public class AllAccessTypesFoo {

    public String publicField = "publicField in AllAccessTypesFoo";
    protected String protectedField = "protectedField in AllAccessTypesFoo";
    String packagePrivateField = "packagePrivateField in AllAccessTypesFoo";
    private String privateField = "privateField in AllAccessTypesFoo";

    public void publicMethod() {
    }

    void packagePrivateMethod() {
    }

    protected void protectedMethod() {
    }

    private void privateMethod() {
    }
}
