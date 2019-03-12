/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.jcl.util.concurrent.app;

/**
 * @author העמ
 */
class ThreadFoo {

    class myThr extends Thread {


        myThr() {
        }

        myThr(String name) {
            super(name);
        }

        public void run() {
            for (int j = 0; j < 3; j++) {
                new myThr(Thread.currentThread().getName() + " " + j).start();
                print();
                yield();
            }
        }

        void print() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            new Thread(new ThreadFoo().new myThr(), "Thread- " + i).start();
        }
    }
}
