/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.certification.classes.access.pkgbar;

/**
 * @author myno 13.01.2008
 */
public class AllAccessTypesFoo {

    public static String publicStaticField = "static publicField in AllAccessTypesFoo";
    protected static String protectedStaticField = "static protectedField in AllAccessTypesFoo";
    static String packageStaticPrivateField = "static packagePrivateField in AllAccessTypesFoo";
    private static String privateStaticField = "static privateField in AllAccessTypesFoo";

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

    public class IndirectAccessor {
        protected String fo() {
            return privateField;
        }
    }

    private static class PrivateMamber {
        public void foo() {
            System.out.println("Private call");
        }
    }
}
