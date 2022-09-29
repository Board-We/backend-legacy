package com.bf.bambooforest.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{
        private final EntityManager em;

        public void dbInit1(){
            User user = new User("01012345678");
            User user2 = new User("01098765432");
            em.persist(user);
            em.persist(user2);

            Message message1 = new Message(user,"Hello",MessageStatus.UNREAD);
            Message message2 = new Message(user2,"쎄상",MessageStatus.UNREAD);

            em.persist(message1);
            em.persist(message2);

        }
    }
}
