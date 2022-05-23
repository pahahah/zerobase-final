package com.example.zerobase.member.repository;

import com.example.zerobase.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findById(String userId);

    Optional<Member> findByUserNameAndEmailAndPhone(String userName, String userEmail, String phoneNumber);
}
