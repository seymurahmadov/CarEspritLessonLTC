package com.ltc.espritspringboot.ASYNC.asyncEx1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
public class ASYNCController {

    private final ExcelService excelService;
    private final MigrationService migrationService;

    @GetMapping("/check")
    public String checkAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> allDoneFuture = excelService.processExcel("C:/Users/Seymur.Ahmadov/Desktop/accounts_2024-12-10.xlsx");

        // İşlemlerin tamamlanmasını beklemek isterseniz:
        allDoneFuture.join();

        return "İşlem başlatıldı, sonuçlar için logları kontrol edin.";

    }
}
