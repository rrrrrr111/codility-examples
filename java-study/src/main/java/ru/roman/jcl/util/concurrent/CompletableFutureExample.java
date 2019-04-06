package ru.roman.jcl.util.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * JCL API Examples
 */
class CompletableFutureExample {

    public static void main(String[] args) throws Exception {
        {
            var cf = CompletableFuture.completedFuture("Message")
                    .thenApply(String::toUpperCase)
                    .thenCompose(upper ->
                            CompletableFuture.completedFuture("Message")
                                    .thenApply(String::toLowerCase)
                                    .thenApply(s -> upper + s));

            System.out.printf("%s %s%n", Thread.currentThread(), cf.getNow(null));   // "MESSAGEmessage" - sync
            System.out.printf("%s %s%n", Thread.currentThread(), cf.join());   // "MESSAGEmessage" - sync
        }

        {
            var cf = new CompletableFuture<Integer>()
                    .thenApply(i -> i + 10)
                    .orTimeout(100, TimeUnit.MILLISECONDS);

            //Thread.sleep(200);

            System.out.printf("%s %s%n", Thread.currentThread(), cf.complete(33));   // true
            System.out.printf("%s %s%n", Thread.currentThread(), cf.complete(666));   // false

            System.out.printf("%s %s%n", Thread.currentThread(), cf.join());   // 33
            System.out.printf("%s %s%n", Thread.currentThread(), cf.getNow(null));   // 33
            System.out.printf("%s %s%n", Thread.currentThread(), cf.get());   // 33

            System.out.printf("%s %s%n", Thread.currentThread(), cf.completeOnTimeout(66,0, TimeUnit.MILLISECONDS).get());   //
            System.out.printf("%s %s%n", Thread.currentThread(), cf.completeExceptionally(new Throwable()));   // false
        }
    }
}
