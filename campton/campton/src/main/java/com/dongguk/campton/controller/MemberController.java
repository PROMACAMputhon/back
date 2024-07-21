package com.dongguk.campton.controller;

import com.dongguk.campton.dto.request.MemberIdRequestDto;
import com.dongguk.campton.dto.request.SigninRequestDto;
import com.dongguk.campton.dto.request.SignupRequestDto;
import com.dongguk.campton.dto.response.ResponseDto;
import com.dongguk.campton.dto.response.SigninResponseDto;
import com.dongguk.campton.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
            @RequestBody SignupRequestDto signupRequestDto
            ) {
        return new ResponseDto<>(memberService.newSignIn(signupRequestDto));
    }

    @PostMapping("/signout")
    public ResponseDto<Boolean> signout(
            @RequestBody MemberIdRequestDto memberIdRequestDto
            ) {
        return new ResponseDto<>(memberService.signOut(memberIdRequestDto));
    }
}
