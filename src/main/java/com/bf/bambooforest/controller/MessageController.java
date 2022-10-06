package com.bf.bambooforest.controller;

import com.bf.bambooforest.dto.GetMessagesResponseDto;
import com.bf.bambooforest.dto.SendMessageRequestDto;
import com.bf.bambooforest.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/message")
    public ResponseEntity<Void> sendMessage(@RequestBody SendMessageRequestDto requestDto) {

        String phoneNumber = requestDto.getPhoneNumber();
        String message = requestDto.getMessage();
        messageService.sendMessage(phoneNumber, message);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/messages")
    public ResponseEntity<GetMessagesResponseDto> getMessages(@RequestParam String phoneNumber) {

        GetMessagesResponseDto responseDto = messageService.getMessageDto(phoneNumber);

        return ResponseEntity.ok(responseDto);
    }

}
