package com.ltc.espritspringboot.ASYNC.asyncEx1;

import com.ltc.espritspringboot.entity.CarEntity;
import com.ltc.espritspringboot.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class MigrationService {
    private final CarRepository carRepository;

    @Async
    public CompletableFuture<String> sendEmail(String email){
        log.info("İşlem yapılıyor: " + email + " " + System.nanoTime());

        CarEntity carEntity = new CarEntity();
        carEntity.setCarName(email);
        carRepository.save(carEntity);

        return CompletableFuture.completedFuture("Başarıyla işlem yapıldı: " + email);


    }

}
