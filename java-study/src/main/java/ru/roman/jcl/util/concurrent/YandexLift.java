package ru.roman.jcl.util.concurrent;

import java.util.SortedSet;
import java.util.TreeSet;

class Lift {

    private SortedSet<Integer> floors = new TreeSet<>();
    private int currentHeight = 5;

    private int maxHeight = 0;
    private LiftState liftState = LiftState.STOPPED;
    private int stepTime;
    private int floorsHeight;
    private int floorsCount;
    private int florTimeout;

    void init(int floorsCount, int floorsHeight, int speed, int florTimeout) {
        this.floorsCount = floorsCount;
        this.floorsHeight = floorsHeight;
        this.florTimeout = florTimeout;
        stepTime = floorsHeight / speed;
        maxHeight = floorsHeight * floorsCount;
    }

    void start() {
        new Thread() {
            @Override
            public void run() {

                while (true) {
                    if (!isMoving())
                        continue;
                    move();
                    visitFloor();
                }
            }
        }.start();
    }

    private boolean isMoving() {
        timeout(0);

        if (floors.isEmpty()) {
            liftState = LiftState.STOPPED;
            return false;
        }
        int currentFlor = currentFlor(currentHeight);
        if (floors.headSet(currentFlor).isEmpty()) {
            liftState = LiftState.UP;
        } else {
            liftState = LiftState.DOWN;
        }
        return true;
    }

    private void move() {
        timeout(stepTime * 300);
        if (liftState == LiftState.UP) {
            currentHeight += floorsHeight;
        } else {
            currentHeight -= floorsHeight;
        }
    }

    private void visitFloor() {
        int currentFlor = currentFlor(currentHeight);
        if (floors.contains(currentFlor)) {
            System.out.println("Лифт проезжает " + currentFlor);
            System.out.println("Лифт открыл двери");
            timeout(florTimeout);
            System.out.println("Лифт закрыл двери");
            floors.remove(currentFlor);
        } else {

            System.out.println("Лифт проезжает " + currentFlor);
        }
    }

    private int currentFlor(int currentHeight) {
        return currentHeight / floorsHeight;
    }

    void addFloor(int flor) {
        floors.add(flor);
    }

    private static void timeout(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private enum LiftState {
        UP, DOWN, STOPPED;
    }
}


public class YandexLift {

    public static void main(String[] args) throws InterruptedException {

        Lift subj = new Lift();
        subj.init(10, 1, 1, 500);

        subj.start();
        subj.addFloor(7);
        subj.addFloor(9);
        subj.addFloor(1);

        Thread.sleep(200_000);
    }
}