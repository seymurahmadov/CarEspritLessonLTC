package com.ltc.espritspringboot.ASYNC.asyncEx2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;
    private final OrderService orderService;

    @GetMapping("/user/{id}")
    public CompletableFuture<String> getUserData(@PathVariable Long id) {

        CompletableFuture<User> userFuture = userService.getUserById(id);

        CompletableFuture<List<Order>> ordersFuture = orderService.getOrders(id);

        return CompletableFuture.allOf(userFuture, ordersFuture).thenApply(
                v ->
                {
                    User user = userFuture.join();
                    List<Order> orders = ordersFuture.join();

                    return "Kullanıcı: " + user.getName() + ", Siparişler: " + orders;
                }
        ).exceptionally(ex -> "Bir hata oluştu: " + ex.getMessage()); // Hataları yönet


    }

}
