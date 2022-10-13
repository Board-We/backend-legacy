package com.bf.bambooforest.service;

import com.bf.bambooforest.dto.GetMessagesResponseDto;
import com.bf.bambooforest.entity.Message;
import com.bf.bambooforest.entity.MessageStatus;
import com.bf.bambooforest.entity.User;
import com.bf.bambooforest.repository.MessageRepository;
import com.bf.bambooforest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class MessageService {

    private final UserRepository userRepository;

    private final MessageRepository messageRepository;

    @Transactional
    public void sendMessage(String phoneNumber, String messageBody) {

        Optional<User> userOptional = userRepository.findByPhoneNumber(phoneNumber);
        User user;
        if (userOptional.isPresent()) {
            user = userOptional.get();

        } else {
            user = new User(phoneNumber);
            userRepository.save(user);
        }

        messageRepository.save(Message.builder()
                .user(user)
                .content(messageBody)
                .build());

    }

    @Transactional
    public GetMessagesResponseDto getMessageDto(String phoneNumber) {
        List<String> messages = new ArrayList<>();
        Optional<User> userOptional = userRepository.findByPhoneNumber(phoneNumber);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Message> foundMessages = messageRepository.findByUserIdAndStatus(user.getId(), MessageStatus.UNREAD);
            for (Message message : foundMessages) {
                message.read();
                messages.add(message.getContent());
            }
        }
        return GetMessagesResponseDto.builder()
                .messages(messages)
                .build();
    }
}
