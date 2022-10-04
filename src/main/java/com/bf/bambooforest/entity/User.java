package com.bf.bambooforest.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id @GeneratedValue
    @Column(name="USER_ID")
    private Long id;

    @Column
    @NotNull
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private final List<Message> messages = new ArrayList<>();

    public User(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
