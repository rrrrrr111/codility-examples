package ru.roman.certification.concurrency;

/**
 *
 */
class WordTearingExample extends Thread {
    private static final int LENGTH = 8;
    private static final long ITERS = 10_000_000L;
    private static byte[] counts = new byte[LENGTH];
    private static Thread[] threads = new Thread[LENGTH];

    private final int id;

    WordTearingExample(int i) {
        id = i;
    }

    @Override
    public void run() {
        byte v = 0;
        for (int i = 0; i < ITERS; i++) {
            byte v2 = counts[id];
            if (v != v2) {
                System.out.println("Word-Tearing found: " +
                        "counts[" + id + "] = " + v2 +
                        ", should be " + v);
                return;
            }
            v++;
            //Thread.yield();
            counts[id] = v;
        }
        System.out.println(Thread.currentThread().getName() + " id=" + id + " finished");
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < LENGTH; ++i)
            (threads[i] = new WordTearingExample(i)).start();

        //Thread.sleep(10_000);
    }
}
