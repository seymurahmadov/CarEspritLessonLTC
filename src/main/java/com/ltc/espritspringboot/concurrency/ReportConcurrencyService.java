package com.ltc.espritspringboot.concurrency;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
public class ReportConcurrencyService {

    private final ExecutorService executorService;

    public Future<String> generateReport() {
        return executorService.submit(() -> {
            System.out.println("Rapor oluşturuluyor... Thread: " + Thread.currentThread().getName());
            try {
                System.out.println("Yatmamisdan evvel  " + Thread.currentThread().getName() );
                Thread.sleep(2000); // 5 saniyelik gecikme (Uzun süren işlem)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Rapor başarıyla oluşturuldu!";
        });
    }
}