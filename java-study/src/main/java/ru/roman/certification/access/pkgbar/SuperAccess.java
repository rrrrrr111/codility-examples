/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.certification.access.pkgbar;

/**
 * 1. Через super нельзя тупо сослаться на родителский класс, но через
 * инстанс при наследовании можно.
 *
 * @author churganov_r
 */
class SuperAccess extends AllAccessTypesFoo {

    @Override
    public String toString() {
        return super.toString();
    }


    public void toString(String str) {
    }

    public static void main(String[] args) {
        // new SuperAccess().super.toString();  // illegal
    }
}
