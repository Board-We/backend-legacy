package com.bf.bambooforest.service;

import com.bf.bambooforest.dto.GetMessagesResponseDto;
import com.bf.bambooforest.entity.Message;
import com.bf.bambooforest.entity.User;
import com.bf.bambooforest.repository.MessageRepository;
import com.bf.bambooforest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final UserRepository userRepository;

    private final MessageRepository messageRepository;

    public void sendMessage(String phoneNumber, String message) {
        System.out.println("phoneNumber = " + phoneNumber);
        System.out.println("message = " + message);
    }

    public GetMessagesResponseDto getMessageDto(String phoneNumber) {
        List<String> messages = new ArrayList<>();
        Optional<User> userOptional = userRepository.findByPhoneNumber(phoneNumber);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Message> foundMessages = messageRepository.findAllByUserId(user.getId());
            for (Message message : foundMessages) {
                messages.add(message.getContent());
            }
        }
        return GetMessagesResponseDto.builder()
                .messages(messages)
                .build();
    }
}
