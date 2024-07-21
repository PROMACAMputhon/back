package com.dongguk.campton.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SigninRequestDto {
    private String memberLoginId;
    private String memberPassword;
}
