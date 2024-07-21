package com.dongguk.campton.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatListResponseDto {

    private Long chat_id;
    private Long room_id;
    private String answer;
    private LocalDate createAt;
    private String question;


}
