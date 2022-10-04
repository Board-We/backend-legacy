package com.bf.bambooforest.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetMessagesResponseDto {

    private List<String> messages;

}
