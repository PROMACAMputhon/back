package com.dongguk.campton.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupRequestDto {
    private String memberName;
    private String memberLoginId;
    private String memberPassword;
}
