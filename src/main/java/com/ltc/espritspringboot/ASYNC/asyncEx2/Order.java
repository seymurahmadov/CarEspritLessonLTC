package com.ltc.espritspringboot.ASYNC.asyncEx2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private Long id;
    private Long userId;
    private String productName;
}