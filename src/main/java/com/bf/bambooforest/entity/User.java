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
public class User {

    @Id @GeneratedValue
    @Column(name="USER_ID")
    private Long id;

    @Column
    @NotNull
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private final List<Message> messages = new ArrayList<>();

    @Builder
    public User(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
