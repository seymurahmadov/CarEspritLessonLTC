package com.ltc.espritspringboot.ASYNC.asyncEx1;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ExcelService {


    private final  MigrationService migrationService;

    public ExcelService(MigrationService migrationService) {
        this.migrationService = migrationService;
    }

    @Async
    public CompletableFuture<Void> processExcel(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            List<CompletableFuture<String>> futures = new ArrayList<>();

            for (Row row : sheet) {
                Cell cell = row.getCell(1);
                if (cell != null) {
                    String email = cell.getStringCellValue();
                    System.out.println(System.nanoTime() + " Excelden okundu: " + email);

                    // Email işlemini asenkron başlatıyoruz
                    CompletableFuture<String> future = migrationService.sendEmail(email);
                    futures.add(future);
                }
            }

            // Tüm işlemlerin tamamlanmasını bekliyoruz (Eğer gerekiyorsa)
            return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        } catch (IOException e) {
            System.out.println("Excel hatası: " + e.getMessage());
            return CompletableFuture.completedFuture(null);
        }
    }



}
