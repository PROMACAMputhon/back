package com.dongguk.campton.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SigninRequestDto {
    private String memberLoginId;
    private String memberPassword;
}
