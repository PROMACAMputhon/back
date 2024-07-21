package com.dongguk.campton.service;

import com.dongguk.campton.domain.Room;
import com.dongguk.campton.dto.request.MemberIdRequestDto;
import com.dongguk.campton.dto.response.RoomResponseDto;
import com.dongguk.campton.exception.ApiException;
import com.dongguk.campton.respository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;


    public List<RoomResponseDto> getList(MemberIdRequestDto memberIdRequestDto) {

        List<Room> rooms = roomRepository.findAllByMemberId(memberIdRequestDto.getMemberId());

        return rooms.stream()
                .map(room -> RoomResponseDto.builder()
                        .room_id(room.getId())
                        .room_type(room.getRoomType())
                        .build())
                .collect(Collectors.toList());
    }
}
