package com.dongguk.campton.service;

import com.dongguk.campton.domain.Chatting;
import com.dongguk.campton.domain.Member;
import com.dongguk.campton.domain.Room;
import com.dongguk.campton.dto.request.SaveChatRequestDto;
import com.dongguk.campton.exception.ApiException;
import com.dongguk.campton.exception.ErrorDefine;
import com.dongguk.campton.respository.ChattingRepository;
import com.dongguk.campton.respository.MemberRepository;
import com.dongguk.campton.respository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChattingService {
    private final ChattingRepository chattingRepository;
    private final RoomRepository roomRepository;
    private final MemberRepository memberRepository;

    public Boolean saveChat(Long roomId, SaveChatRequestDto saveChatRequestDto) {
        Member member = memberRepository.findById(saveChatRequestDto.getMemberId())
                .orElseThrow(() -> new ApiException(ErrorDefine.NOT_EXIST_MEMBER));
        if(roomId != 0){
            Room room = roomRepository.findById(roomId)
                    .orElseThrow(() -> new ApiException(ErrorDefine.NOT_EXIST_ROOM));
            Chatting chatting = Chatting.builder()
                    .room(room)
                    .question(saveChatRequestDto.getQuestion())
                    .answer(saveChatRequestDto.getAnswer())
                    .build();
            chattingRepository.save(chatting);
            return true;
        }
        Room newRoom = Room.builder()
                .roomTitle(saveChatRequestDto.getRoomTitle())
                .roomType(saveChatRequestDto.getRoomType())
                .member(member)
                .build();
        roomRepository.save(newRoom);

        Chatting chatting = Chatting.builder()
                .room(newRoom)
                .question(saveChatRequestDto.getQuestion())
                .answer(saveChatRequestDto.getAnswer())
                .build();
        chattingRepository.save(chatting);

        return true;
    }
}
