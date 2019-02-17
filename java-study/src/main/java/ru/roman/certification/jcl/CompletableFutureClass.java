package ru.roman.certification.jcl;

import java.util.concurrent.CompletableFuture;

/**
 *
 */
public class CompletableFutureClass {

    public static void main(String[] args) {

        CompletableFuture<String> cf = CompletableFuture.completedFuture("Message")
                .thenApply(String::toUpperCase)
                .thenCompose(upper ->
                        CompletableFuture.completedFuture("Message")
                                .thenApply(String::toLowerCase)
                                .thenApply(s -> upper + s));

        System.out.printf("%s %s%n", Thread.currentThread(), cf.getNow(null));   // "MESSAGEmessage" - sync
        System.out.printf("%s %s%n", Thread.currentThread(), cf.join());   // "MESSAGEmessage" - sync
    }
}
