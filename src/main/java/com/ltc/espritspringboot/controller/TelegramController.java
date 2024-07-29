package com.ltc.espritspringboot.controller;

import com.ltc.espritspringboot.dto.telegramDto.TelegramRoot;
import com.ltc.espritspringboot.dto.telegramDto.TelegramSendDto;
import com.ltc.espritspringboot.service.TelegramService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telegram")
public class TelegramController {

    private final TelegramService  telegramService;

    public TelegramController(TelegramService telegramService) {
        this.telegramService = telegramService;
    }


    @GetMapping("/son-mesajlar")
    public TelegramRoot getMesaj(){
       return telegramService.getMessageService();
    }

    @PostMapping("/mesaj-gonder")
    public void sendMesaj(@RequestBody TelegramSendDto telegramSendDto){
        telegramService.sendMessageService(telegramSendDto);
    }
}
