package com.bf.bambooforest.repository;

import com.bf.bambooforest.entity.Message;
import com.bf.bambooforest.entity.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {


    List<Message> findByUserIdAndStatus(Long userId, MessageStatus status);

}
