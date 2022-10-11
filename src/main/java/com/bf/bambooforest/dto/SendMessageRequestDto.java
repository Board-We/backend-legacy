package com.bf.bambooforest.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class SendMessageRequestDto {

    @NotNull
    @Size(min = 10, max = 11)
    @Pattern(regexp = "[0-9]+")
    private String phoneNumber;

    @NotEmpty
    @Size(max = 50)
    private String message;

}
