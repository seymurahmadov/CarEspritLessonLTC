package com.ltc.espritspringboot.ASYNC;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/generate-report")
    public String generateReport() {
        // Rapor oluşturma işlemi asenkron başlatılıyor
        reportService.generateReport();

        // Kullanıcıya hemen yanıt dönülüyor
        return "Rapor oluşturuluyor... Sonucu daha sonra kontrol edebilirsiniz.";
    }
}