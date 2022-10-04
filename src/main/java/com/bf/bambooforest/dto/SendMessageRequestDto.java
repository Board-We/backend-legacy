package com.bf.bambooforest.dto;

import lombok.Data;

@Data
public class SendMessageRequestDto {

    private String phoneNumber;
    private String message;

}
