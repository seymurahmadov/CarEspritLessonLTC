package com.ltc.espritspringboot.concurrency;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequiredArgsConstructor
public class ReportConcurrencyController {

    private final ReportConcurrencyService reportService;

    @GetMapping("/generate-report-con")
    public String generateReport() throws ExecutionException, InterruptedException {
        Future<String> future = reportService.generateReport();
        return "Rapor oluşturuluyor... Sonucu daha sonra kontrol edebilirsiniz.";
    }
}