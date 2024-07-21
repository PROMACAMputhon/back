package com.dongguk.campton.controller;

import com.dongguk.campton.dto.request.SigninRequestDto;
import com.dongguk.campton.dto.request.SignupRequestDto;
import com.dongguk.campton.dto.response.ResponseDto;
import com.dongguk.campton.dto.response.SigninResponseDto;
import com.dongguk.campton.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseDto<Boolean> signUp(
            @RequestBody SignupRequestDto signupRequestDto
            ) {
        return new ResponseDto<>(memberService.signUp(signupRequestDto));
    }

    @PostMapping("/signin")
    public ResponseDto<SigninResponseDto> signIn(
            @RequestBody SigninRequestDto signinRequestDto
            ) {
        return new ResponseDto<>(memberService.signIn(signinRequestDto));
    }
}