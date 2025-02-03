package com.ltc.espritspringboot.ASYNC.asyncEx2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
}