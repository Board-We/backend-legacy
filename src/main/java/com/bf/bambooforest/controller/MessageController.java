package com.bf.bambooforest.controller;

import com.bf.bambooforest.entity.Message;
import com.bf.bambooforest.entity.User;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/message")
@RestController
public class MessageController {

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody SendMessageRequestDto requestDto) {
        System.out.println(requestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Message>> getMessages(@RequestParam String phoneNumber) {
        System.out.println("phoneNumber = " + phoneNumber);
        List<Message> messages = List.of(Message.builder()
                .user(User.builder()
                        .phoneNumber(phoneNumber)
                        .build())
                .content("hi")
                .build());
        return ResponseEntity.ok(messages);
    }

    @Data
    private static class SendMessageRequestDto {
        private String phoneNumber;
        private String message;
    }

}
