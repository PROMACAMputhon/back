package com.dongguk.campton.service;

import com.dongguk.campton.domain.Room;
import com.dongguk.campton.dto.request.MemberIdRequestDto;
import com.dongguk.campton.dto.response.RoomResponseDto;
import com.dongguk.campton.exception.ApiException;
import com.dongguk.campton.exception.ErrorDefine;
import com.dongguk.campton.respository.MemberRepository;
import com.dongguk.campton.respository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final MemberRepository memberRepository;

    public Map<String, Object> getList(MemberIdRequestDto memberIdRequestDto) {

        if(!memberRepository.existsMemberById(memberIdRequestDto.getMemberId())) {
            throw new ApiException(ErrorDefine.NOT_EXIST_MEMBER);
        }

        List<Room> rooms = roomRepository.findAllByMemberId(memberIdRequestDto.getMemberId());
        System.err.println("이부분 잘 들어오나?1 " + rooms);

        List<RoomResponseDto> roomResponseDtos = rooms.stream()
                .map(room -> RoomResponseDto.builder()
                        .room_id(room.getId())
                        .room_title(room.getRoomTitle())
                        .room_type(room.getRoomType())
                        .build())
                .collect(Collectors.toList());

        System.err.println("이부분 잘 들어오나? " + roomResponseDtos);


        Map<String, Object> response = new HashMap<>();
        response.put("selectChatting", roomResponseDtos);
        System.err.println("이부분 잘 들어오나?3 " + response);
        return response;

    }
}
