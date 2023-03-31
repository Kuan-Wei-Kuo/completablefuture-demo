package com.andy.example.completablefuturedemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example02 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("future1 -> " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "future1 is done";
        });

        future1.thenAcceptAsync(message -> {
            System.out.println("thenAccept1 -> " + message);
        });

        future1.thenAcceptAsync(message -> {
            System.out.println("thenAccept2 -> " + message);
        });

        String message = future1.get();
        System.out.println(message);
    }
}
