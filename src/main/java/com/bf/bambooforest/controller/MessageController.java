package com.bf.bambooforest.controller;

import com.bf.bambooforest.dto.GetMessagesResponseDto;
import com.bf.bambooforest.dto.SendMessageRequestDto;
import com.bf.bambooforest.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@RestController
@RequiredArgsConstructor
@Validated
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/message")
    public ResponseEntity<Void> sendMessage(@RequestBody @Valid SendMessageRequestDto requestDto) {

        String phoneNumber = requestDto.getPhoneNumber();
        String message = requestDto.getMessage();
        messageService.sendMessage(phoneNumber, message);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/messages")
    public ResponseEntity<GetMessagesResponseDto> getMessages(
            @RequestParam @NotNull @Size(min = 10, max = 11) @Pattern(regexp = "[0-9]+") String phoneNumber) {

        GetMessagesResponseDto responseDto = messageService.getMessageDto(phoneNumber);

        return ResponseEntity.ok(responseDto);
    }

}
