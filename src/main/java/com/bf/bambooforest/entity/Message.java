package com.bf.bambooforest.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Message {

    @Id @GeneratedValue
    @Column(name="MESSAGE_ID")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(
            name="MEMBER_ID",
            foreignKey = @ForeignKey(name="FK_message_TO_member_1")
    )
    @NotNull
    private Member member;

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

    @Builder
    public Message(Member member, String content) {
        this.member = member;
        this.content = content;
        this.status = MessageStatus.UNREAD;
    }

    public void read() {
        this.status = MessageStatus.READ;
    }

}
