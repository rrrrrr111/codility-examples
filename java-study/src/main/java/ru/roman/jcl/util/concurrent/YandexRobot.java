package ru.roman.jcl.util.concurrent;

class Foot implements Runnable {
    private final String name;

    static volatile boolean isLeft = false;

    Foot(String name) {
        this.name = name;
    }

    public void run() {
        for (; ; ) {
            if (name.equals("left") && isLeft) {
                step();
            } else if (name.equals("right") && !isLeft) {
                step();
            }
            try {
                Thread.sleep(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void step() {
        synchronized (Foot.class) {
            System.out.println("Step by " + name);
            isLeft = !isLeft;
        }
    }
}

class YandexRobot {
    public static void main(String[] args) {
        new Thread(new Foot("left")).start();
        new Thread(new Foot("right")).start();
    }
}