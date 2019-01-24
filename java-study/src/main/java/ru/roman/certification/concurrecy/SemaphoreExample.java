package ru.roman.certification.concurrecy;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

/**
 *
 */
public class SemaphoreExample {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(5); // permit only 5, others go father
        int[] counter = new int[1];

        Callable<?> task = () -> {
            boolean permit = false;
            try {
                permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
                if (permit) {
                    System.out.printf("%s Semaphore acquired%n", ++counter[0]);
                    sleep(5_000);
                } else {
                    System.out.printf("%s Could not acquire semaphore%n", ++counter[0]);
                }
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            } finally {
                if (permit) {
                    semaphore.release();
                }
            }
            return null;
        };

        IntStream.range(0, 10).forEach(i -> executor.submit(task));
        executor.shutdown();
    }
}
