/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.samples.diff;

/**
 *
 *
 */
public class ExtendingWithClone implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        return new Object();
    }

    // public метод можно переопределить только как public
    public void foo1() {
    }

    // package метод можно переопределить как public или package
    void foo2() {
    }

    // protected метод можно переопределить как public или protected
    protected void foo3() {
    }

    // приватный метод нельзя переопределить
    private void foo4() {
    }

    private class Class2 extends ExtendingWithClone {

        @Override
        public void foo1() {
        }

        @Override
        public void foo2() {
        }

        @Override
        public void foo3() {
        }

        // метод определенный как private не переопределяется,
        // а просто реализуется новый метод 
        protected void foo4() {
            super.foo4();
        }
    }

    public static void main(String[] args) {
        new ExtendingWithClone().new Class2().foo4();
    }
}
