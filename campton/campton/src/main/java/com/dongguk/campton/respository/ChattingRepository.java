package com.dongguk.campton.respository;

import com.dongguk.campton.domain.Chatting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChattingRepository extends JpaRepository<Chatting, Long> {
}
