package com.dongguk.campton.controller;

import com.dongguk.campton.dto.request.SaveChatRequestDto;
import com.dongguk.campton.dto.response.ResponseDto;
import com.dongguk.campton.service.ChattingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chatting")
public class ChattingController {
    private final ChattingService chattingService;

    @PostMapping("/save/{roomId}")
    public ResponseDto<Boolean> saveChat(
            @PathVariable Long roomId,
            @RequestBody SaveChatRequestDto saveChatRequestDto
            ) {
        return new ResponseDto<>(chattingService.saveChat(roomId, saveChatRequestDto));
    }
}
