package com.andy.example.completablefuturedemo;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example04 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Random rand = new Random();
        
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + rand.nextInt(1000));
                System.out.println("future1 -> " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "future1 is done";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + rand.nextInt(1000));
                System.out.println("future2 -> " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "future2 is done";
        });

        CompletableFuture<String> future3 = future1.applyToEitherAsync(future2, message -> {
            return "future3 -> " + message;
        });
        
        System.out.println(future3.get());  
    }
}
