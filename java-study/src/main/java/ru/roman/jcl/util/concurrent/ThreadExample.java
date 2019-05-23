package ru.roman.jcl.util.concurrent;

class ThreadExample {

    public static void main(String[] args) {
        var t = new Thread() {
            public void run() {
                pong();
                //sleep();                   // illegal попытка вызвать метод из outer класса, т к тред зашадовил его своим методом
            }                               // кроме того sleep() кидает checked InterruptedException
        };
        t.run();                            // выполняет тред, а не запускает его
    }
    static void pong() {}
    static void sleep() {}
}
