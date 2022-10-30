package com.bf.bambooforest.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column
    @NotNull
    private String phoneNumber;

    @OneToMany(mappedBy = "member")
    private final List<Message> messages = new ArrayList<>();

    @Builder
    public Member(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
