package com.dongguk.campton.controller;

import com.dongguk.campton.dto.request.MemberIdRequestDto;
import com.dongguk.campton.dto.response.RoomResponseDto;
import com.dongguk.campton.dto.response.ResponseDto;
import com.dongguk.campton.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;


    @GetMapping("/list")
    public ResponseDto<List<RoomResponseDto>> getChattingList(
            @Valid @RequestBody MemberIdRequestDto memberIdRequestDto){
        return new ResponseDto<>(roomService.getList(memberIdRequestDto));

    }
}
