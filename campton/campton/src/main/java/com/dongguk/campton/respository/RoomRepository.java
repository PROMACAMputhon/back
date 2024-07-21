package com.dongguk.campton.respository;

import com.dongguk.campton.domain.Member;
import com.dongguk.campton.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findAllByMemberId(Long memberId);
    Boolean existsRoomById(Long id);

}
