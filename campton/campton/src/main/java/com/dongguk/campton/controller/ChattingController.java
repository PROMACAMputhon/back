package com.dongguk.campton.controller;

import com.dongguk.campton.dto.request.SaveChatRequestDto;
import com.dongguk.campton.dto.response.ChatListResponseDto;
import com.dongguk.campton.dto.response.ResponseDto;
import com.dongguk.campton.dto.response.RoomResponseDto;
import com.dongguk.campton.service.ChattingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/list/{roomId}")
    public ResponseDto<Map<String, Object>> getChatList(@PathVariable Long roomId){
        return new ResponseDto<>(chattingService.getChatList(roomId));
    }

}
