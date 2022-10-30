package com.bf.bambooforest.service;

import com.bf.bambooforest.dto.GetMessagesResponseDto;
import com.bf.bambooforest.entity.Message;
import com.bf.bambooforest.entity.MessageStatus;
import com.bf.bambooforest.entity.Member;
import com.bf.bambooforest.repository.MessageRepository;
import com.bf.bambooforest.repository.MemberRepository;
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

    private final MemberRepository memberRepository;

    private final MessageRepository messageRepository;

    @Transactional
    public void sendMessage(String phoneNumber, String messageBody) {

        Optional<Member> memberOptional = memberRepository.findByPhoneNumber(phoneNumber);
        Member member;
        if (memberOptional.isPresent()) {
            member = memberOptional.get();

        } else {
            member = new Member(phoneNumber);
            memberRepository.save(member);
        }

        messageRepository.save(Message.builder()
                .member(member)
                .content(messageBody)
                .build());

    }

    @Transactional
    public GetMessagesResponseDto getMessageDto(String phoneNumber) {
        List<String> messages = new ArrayList<>();
        Optional<Member> memberOptional = memberRepository.findByPhoneNumber(phoneNumber);
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            List<Message> foundMessages = messageRepository.findByMemberIdAndStatus(member.getId(), MessageStatus.UNREAD);
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
