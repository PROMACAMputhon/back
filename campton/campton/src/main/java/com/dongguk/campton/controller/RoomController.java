package com.dongguk.campton.controller;

import com.dongguk.campton.dto.request.MemberIdRequestDto;
import com.dongguk.campton.dto.response.RoomResponseDto;
import com.dongguk.campton.dto.response.ResponseDto;
import com.dongguk.campton.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chatting")
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/room/list/")
    public ResponseDto<Map<String, Object>> getChattingList(
            @RequestBody MemberIdRequestDto memberIdRequestDto){
        System.err.println("memberIdRequestDto = " + memberIdRequestDto.getMemberId());
        return new ResponseDto<>(roomService.getList(memberIdRequestDto));

    }
}
