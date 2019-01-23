/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.naming;

/**
 * 1. Два класса на одном уровне нельзя задать в одном файле Java
 * 2. не Public интерфейс задать в листинге класса можно
 * - protected и private модификаторы для интерфейса не используются
 * 3. Класс внутри интерфейса - без проблем, причем этот класс
 * может реализовать интерфейс в котором находится и он только static
 *
 * @author дтоь 12.01.2008
 */
public class Foo {

    public static void main(String[] args) {

        Bar.NestedInBar.main(new String[0]);
        Bar.BazzNestedInBarExtendingBar.main(new String[0]);
    }
}

interface Bar {

    class NestedInBar {
        public static void main(String[] args) {  // main внутри nested класса
            System.out.println("1");
        }
    }

    static class BazzNestedInBarExtendingBar extends NestedInBar implements Bar {  // static keyword not necessary
        public static void main(String[] args) {
            System.out.println("2");
        }
    }
}











