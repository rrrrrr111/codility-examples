package ru.roman.jcl.util.concurrent;

class ThreadInterruptExample {

    public static void main(String[] args) throws InterruptedException {

        var t = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1_000);
                    System.out.println("Still executing...");

                } catch (InterruptedException e) {
                    System.out.println(e + " catch ");
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();

        Thread.sleep(5_000);
        t.interrupt();
        Thread.sleep(5_000);
    }
}
