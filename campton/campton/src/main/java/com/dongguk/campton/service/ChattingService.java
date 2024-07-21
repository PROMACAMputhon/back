package com.dongguk.campton.service;

import com.dongguk.campton.domain.Chatting;
import com.dongguk.campton.domain.Member;
import com.dongguk.campton.domain.Room;
import com.dongguk.campton.dto.request.MemberIdRequestDto;
import com.dongguk.campton.dto.request.MemberLoginIdRequestDto;
import com.dongguk.campton.dto.request.SaveChatRequestDto;
import com.dongguk.campton.dto.response.ChatListResponseDto;
import com.dongguk.campton.dto.response.SaveChatResponseDto;
import com.dongguk.campton.exception.ApiException;
import com.dongguk.campton.exception.ErrorDefine;
import com.dongguk.campton.respository.ChattingRepository;
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
public class ChattingService {
    private final ChattingRepository chattingRepository;
    private final RoomRepository roomRepository;
    private final MemberRepository memberRepository;

    public SaveChatResponseDto saveChat(SaveChatRequestDto saveChatRequestDto) {
        Member member = memberRepository.findById(saveChatRequestDto.getMemberId())
                .orElseThrow(() -> new ApiException(ErrorDefine.NOT_EXIST_MEMBER));
        Integer count = roomRepository.countByIdAndRoomTitleLike(member.getId(), saveChatRequestDto.getRoomTitle());
        // roomTitle을 빌드 할때 saveChatRequestDto.getRoomTitle()에 count값을 String으로 붙이고 싶음

        Room newRoom = Room.builder()
                .roomTitle(saveChatRequestDto.getRoomTitle()+count.toString()+1)
                .roomType(saveChatRequestDto.getRoomType())
                .member(member)
                .build();
        roomRepository.save(newRoom);

        return SaveChatResponseDto.builder()
                .roomId(newRoom.getId())
                .build();
    }


    public Map<String, Object> getChatList(Long roomId, MemberIdRequestDto memberIdRequestDto){

        Member member = memberRepository.findById(memberIdRequestDto.getMemberId())
                .orElseThrow(() -> new ApiException(ErrorDefine.NOT_EXIST_MEMBER));

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ApiException(ErrorDefine.NOT_EXIST_ROOM));
        if(!roomRepository.existsRoomById(roomId)) {
            throw new ApiException(ErrorDefine.NOT_EXIST_ROOM);
        }

        if(!member.getId().equals(room.getMember().getId())){
            throw new ApiException(ErrorDefine.NOT_ALLOW_ROOM);
        }



        List<Chatting> chattings = chattingRepository.findAllByRoomIdOrderByCreateAtAsc(roomId);


        List<ChatListResponseDto> chatListResponseDtos = chattings.stream()
                .map(chatting -> ChatListResponseDto.builder()
                        .chat_id(chatting.getId())
                        .answer(chatting.getAnswer())
                        .question(chatting.getQuestion())
                        .room_id(roomId)
                        .createAt(chatting.getCreateAt())
                        .build())
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("selectChat", chatListResponseDtos);

        return response;

    }
}
