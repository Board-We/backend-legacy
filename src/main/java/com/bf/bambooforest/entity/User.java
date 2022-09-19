package com.bf.bambooforest.entity;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @Column(name="USER_ID")
    private Long id;

    @Column
    @NotNull
    private String phoneNumber;

}
