package com.andy.example.completablefuturedemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example03 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("future1 -> " + Thread.currentThread().getName());

                throw new RuntimeException("future1 is failure");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "future1 is done";
        });

        CompletableFuture<String> future2 = future1.exceptionally(e -> {
            System.out.println("exceptionally -> " + e.getMessage());
            return "future1 occur exception";
        });
        
        System.out.println(future2.get());  
    }

}
