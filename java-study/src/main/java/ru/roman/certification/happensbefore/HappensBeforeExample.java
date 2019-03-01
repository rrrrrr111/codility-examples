package ru.roman.certification.happensbefore;

/**
 *
 */
class HappensBeforeExample {

    public static void main(String[] args) throws InterruptedException {

        var e = new HappensBeforeExample();
        System.out.println("Start");

        e.start();
        Thread.sleep(3_000);
        e.stop();
        Thread.sleep(3_000);

        System.out.println("Finish");
    }

    //private boolean stopHint = false;
    private volatile boolean stopHint = false;


    private void stop() {
        stopHint = true;
    }

    private void start() {

        new Thread("bus") {
            { setDaemon(true); }

            public void run() {
                System.out.println("Starting the bus...");
                while (!stopHint) {
                }
                stopHint = false;
                System.out.println("bus stopped");
            }
        }.start();
    }
}
