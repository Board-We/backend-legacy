package com.bf.bambooforest.controller;

import com.bf.bambooforest.dto.GetMessagesResponseDto;
import com.bf.bambooforest.dto.SendMessageRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<GetMessagesResponseDto> getMessages(@RequestParam String phoneNumber) {
        System.out.println("phoneNumber = " + phoneNumber);
        GetMessagesResponseDto responseDto = GetMessagesResponseDto.builder()
                .messages(List.of("hello", "world"))
                .build();
        return ResponseEntity.ok(responseDto);
    }

}
