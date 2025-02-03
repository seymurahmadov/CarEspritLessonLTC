package com.ltc.espritspringboot.ASYNC.asyncEx2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class OrderService {

    @Async
    public CompletableFuture<List<Order>> getOrders(Long userId) {
        log.info("Siparişler getiriliyor: " + userId + " " +Thread.currentThread().getName());

        try {
            Thread.sleep(3000); // Simülasyon için bekleme süresi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Order> orders = List.of(
                new Order(1L, userId, "Laptop"),
                new Order(2L, userId, "Telefon")
        );

        log.info("Siparişler getirildi: " + orders  + " " +Thread.currentThread().getName());
        return CompletableFuture.completedFuture(orders);
    }
}
