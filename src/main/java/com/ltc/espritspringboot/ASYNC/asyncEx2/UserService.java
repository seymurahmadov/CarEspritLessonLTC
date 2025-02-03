package com.ltc.espritspringboot.ASYNC.asyncEx2;

import java.util.concurrent.CompletableFuture;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserService {


    @Async
    public CompletableFuture<User> getUserById(Long id) {
        log.info("Kullanıcı getiriliyor: " + id  + " " +Thread.currentThread().getName());

        try {
            Thread.sleep(2000); // Simülasyon için bekleme süresi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        User user = new User(id, "Seymur Ahmadov", "seymur@example.com");
        log.info("Kullanıcı getirildi: " + user + " " +Thread.currentThread().getName());
        return CompletableFuture.completedFuture(user);

    }
}
