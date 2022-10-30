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
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void dbInit1() {
            Member member = new Member("01012345678");
            Member member2 = new Member("01098765432");
            em.persist(member);
            em.persist(member2);

            Message message1 = Message.builder()
                    .member(member)
                    .content("Hello")
                    .build();
            Message message2 = Message.builder()
                    .member(member2)
                    .content("쎄상")
                    .build();

            em.persist(message1);
            em.persist(message2);

        }
    }
}
