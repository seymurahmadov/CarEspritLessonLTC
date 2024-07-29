package com.ltc.espritspringboot.service;

import com.ltc.espritspringboot.client.TelegramClient;
import com.ltc.espritspringboot.dto.telegramDto.TelegramRoot;
import com.ltc.espritspringboot.dto.telegramDto.TelegramSendDto;
import com.ltc.espritspringboot.entity.CarEntity;
import com.ltc.espritspringboot.repository.CarRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelegramService {

    private final TelegramClient telegramClient;
    private final CarRepository carRepository;

    public TelegramService(TelegramClient telegramClient, CarRepository carRepository) {
        this.telegramClient = telegramClient;
        this.carRepository = carRepository;
    }


    public TelegramRoot getMessageService() {
        TelegramRoot message = telegramClient.getMessage(0);
        int updateId = message.result.get(message.getResult().size() - 1).getUpdate_id();
        return telegramClient.getMessage(updateId);
    }


    public void sendMessageService(TelegramSendDto dto) {
        telegramClient.sendMessage(dto);
    }


//    @Scheduled(fixedRate = 10000)
    public void sendAllStudent() {
        TelegramRoot messageService = getMessageService();
        int chatId = messageService.getResult().get(0).getMessage().getChat().getId();
        String text = messageService.getResult().get(0).getMessage().getText();

        TelegramSendDto dto = new TelegramSendDto();
        dto.setChat_id(chatId);

        List<CarEntity> all = carRepository.findAll();

        if (text.equals("getAll")) {


            for (CarEntity carEntity : all) {

                dto.setText(carEntity.getCarName() + " " + carEntity.getCarYear());
                sendMessageService(dto);
            }
        }


    }

}
