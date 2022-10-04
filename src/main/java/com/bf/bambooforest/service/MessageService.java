package com.bf.bambooforest.service;

import com.bf.bambooforest.dto.GetMessagesResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {


    public GetMessagesResponseDto getMessageDto(String phoneNumber) {
                return GetMessagesResponseDto.builder()
                .messages(List.of("hello", "world"))
                .build();
    }

    public void sendMessage(String phoneNumber, String message) {
        System.out.println("phoneNumber = " + phoneNumber);
        System.out.println("message = " + message);
    }
}
