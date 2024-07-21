package com.dongguk.campton.service;

import com.dongguk.campton.domain.Member;
import com.dongguk.campton.dto.request.SigninRequestDto;
import com.dongguk.campton.dto.request.SignupRequestDto;
import com.dongguk.campton.dto.response.SigninResponseDto;
import com.dongguk.campton.exception.ApiException;
import com.dongguk.campton.exception.ErrorDefine;
import com.dongguk.campton.respository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Boolean signUp(SignupRequestDto signupRequestDto) {

        if(memberRepository.existsMemberByLoginId(signupRequestDto.getMemberLoginId())) {
            throw new ApiException(ErrorDefine.ALREADY_EXIST_MEMBER);
        }

        Member member = Member.builder()
                .name(signupRequestDto.getMemberName())
                .loginId(signupRequestDto.getMemberLoginId())
                .password(signupRequestDto.getMemberPassword())
                .build();

        memberRepository.save(member);
        return true;
    }

    public SigninResponseDto signIn(SigninRequestDto signinRequestDto) {
        Member member = memberRepository.findByLoginId(signinRequestDto.getMemberLoginId())
                .orElseThrow(() -> new ApiException(ErrorDefine.NOT_EXIST_MEMBER));

        if(!member.getPassword().equals(signinRequestDto.getMemberPassword())) {
            throw new ApiException(ErrorDefine.WRONG_PASSWORD);
        }
        member.login();

        return SigninResponseDto.builder()
                .id(member.getId())
                .name(member.getName())
                .build();
    }
}
