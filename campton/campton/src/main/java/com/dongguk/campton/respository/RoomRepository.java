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

    // id이 같은 것 중에 roomTitle로 like 검색해서 그 값은 수를 찾아줘 반환값은 int
    Integer countByIdAndRoomTitleLike(Long id, String roomTitle);



}
