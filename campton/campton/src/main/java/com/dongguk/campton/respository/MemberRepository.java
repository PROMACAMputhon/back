package com.dongguk.campton.respository;

import com.dongguk.campton.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Boolean existsMemberByLoginId(String loginId);

    Boolean existsMemberById(Long id);
    Optional<Member> findByLoginId(String loginId);
}
