package com.dongguk.campton.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SaveChatRequestDto {

    //"memberId": Long,
    //	"roomType": Long 1(유정), 2(하나), 3(이종석), 4(하나더?)
    //	"answer": "String",
    //	"question": "String"
    private Long memberId;
    private Long roomType;
    private String answer;
    private String question;

}
