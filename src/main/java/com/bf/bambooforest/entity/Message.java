package com.bf.bambooforest.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Message {

    @Id @GeneratedValue
    @Column(name="MESSAGE_ID")
    private int id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(
            name="USER_ID",
            foreignKey = @ForeignKey(name="FK_message_TO_user_1")
    )
    @NotNull
    private User user;

    @Column(
            columnDefinition = "NVARCHAR2(50)"
    )
    @NotNull
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(
            columnDefinition = "VARCHAR(20)"
    )
    @NotNull
    private MessageStatus status;

}
