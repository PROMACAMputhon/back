package com.dongguk.campton.controller;

import com.dongguk.campton.dto.request.MemberIdRequestDto;
import com.dongguk.campton.dto.request.SaveChatRequestDto;
import com.dongguk.campton.dto.response.ResponseDto;
import com.dongguk.campton.dto.response.SaveChatResponseDto;
import com.dongguk.campton.service.ChattingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chatting")
public class ChattingController {
    private final ChattingService chattingService;

    @PostMapping("/save")
    public ResponseDto<SaveChatResponseDto> saveChat(
            @RequestBody SaveChatRequestDto saveChatRequestDto
            ) {
        return new ResponseDto<>(chattingService.saveChat(saveChatRequestDto));
    }

    @GetMapping("/list/{roomId}")
    public ResponseDto<Map<String, Object>> getChatList(
            @PathVariable Long roomId,
            @RequestBody MemberIdRequestDto memberIdRequestDto
    ){

        System.err.println("memberIdRequestDto = " + memberIdRequestDto.getMemberId());
        return new ResponseDto<>(chattingService.getChatList(roomId, memberIdRequestDto));
    }

}
