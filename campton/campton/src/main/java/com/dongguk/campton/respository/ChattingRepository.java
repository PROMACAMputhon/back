package com.dongguk.campton.respository;

import com.dongguk.campton.domain.Chatting;
import com.dongguk.campton.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChattingRepository extends JpaRepository<Chatting, Long> {
    List<Chatting> findAllByRoomIdOrderByCreateAtAsc(Long roomId);

}
