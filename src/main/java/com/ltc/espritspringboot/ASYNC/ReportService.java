package com.ltc.espritspringboot.ASYNC;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ReportService {

    @Async // Asenkron çalışmasını sağlar
    public CompletableFuture<String> generateReport() {
        try {
            System.out.println("Rapor oluşturuluyor... " + Thread.currentThread().getName());
            Thread.sleep(500000); // 5 saniyelik gecikme (Uzun süren işlem)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Rapor oluşturuldu: " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture("Rapor başarıyla oluşturuldu!");
    }
}