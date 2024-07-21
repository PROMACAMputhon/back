package com.dongguk.campton.service;

import com.dongguk.campton.domain.Member;
import com.dongguk.campton.dto.request.MemberIdRequestDto;
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

    public SigninResponseDto newSignIn(SignupRequestDto signupRequestDto){
        // 이미 회원 가입이 된 회원
        if(memberRepository.existsMemberByLoginId(signupRequestDto.getMemberLoginId())) {
            Member member = memberRepository.findByLoginId(signupRequestDto.getMemberLoginId())
                    .orElseThrow(() -> new ApiException(ErrorDefine.NOT_EXIST_MEMBER));
            System.err.println("로그인 존재하는데 " + member.getPassword());
            if(!member.getPassword().equals(signupRequestDto.getMemberPassword())) {
                throw new ApiException(ErrorDefine.WRONG_PASSWORD);
            }

            member.login();
            return SigninResponseDto.builder()
                    .id(member.getId())
//                    .name(member.getName())
                    .build();
        }else{ // 회원 가입이 안되어있어 새로 가입을 하고, 로그인까지 되는
            Member member = Member.builder()
//                    .name(signupRequestDto.getMemberName())
                    .loginId(signupRequestDto.getMemberLoginId())
                    .password(signupRequestDto.getMemberPassword())
                    .build();

            memberRepository.save(member);
            member.login();
            return SigninResponseDto.builder()
                    .id(member.getId())
//                    .name(member.getName())
                    .build();
        }



    }

    public Boolean signUp(SignupRequestDto signupRequestDto) {

        if(memberRepository.existsMemberByLoginId(signupRequestDto.getMemberLoginId())) {
            throw new ApiException(ErrorDefine.ALREADY_EXIST_MEMBER);
        }

        Member member = Member.builder()
//                .name(signupRequestDto.getMemberName())
                .loginId(signupRequestDto.getMemberLoginId())
                .password(signupRequestDto.getMemberPassword())
                .build();

        memberRepository.save(member);
        return true;
    }

//    public SigninResponseDto signIn(SigninRequestDto signinRequestDto) {
////        Member member = memberRepository.findByLoginId(signinRequestDto.getMemberLoginId())
////                .orElseThrow(() -> new ApiException(ErrorDefine.NOT_EXIST_MEMBER));
//
//        if(!member.getPassword().equals(signinRequestDto.getMemberPassword())) {
//            throw new ApiException(ErrorDefine.WRONG_PASSWORD);
//        }
//        member.login();
//
//        return SigninResponseDto.builder()
//                .id(member.getId())
////                .name(member.getName())
//                .build();
//    }

    public Boolean signOut(MemberIdRequestDto memberIdRequestDto) {
        Member member = memberRepository.findById(memberIdRequestDto.getMemberId())
                .orElseThrow(() -> new ApiException(ErrorDefine.NOT_EXIST_MEMBER));

        member.logout();
        return true;
    }
}
