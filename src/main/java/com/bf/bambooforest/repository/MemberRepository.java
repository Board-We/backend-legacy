package com.bf.bambooforest.repository;

import com.bf.bambooforest.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findByPhoneNumber(String phoneNumber);

}
