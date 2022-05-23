package com.example.zerobase.member.service;

import com.example.zerobase.member.entity.Member;
import com.example.zerobase.member.model.FindIdInput;
import com.example.zerobase.member.model.MemberInput;
import com.example.zerobase.member.model.ResetPasswordInput;
import com.example.zerobase.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public boolean register(MemberInput memberInput) {
        Optional<Member> optionalMember = memberRepository.findById(memberInput.getUserId());
        if(optionalMember.isPresent()){
            return false;
        }
        String encPassword = BCrypt.hashpw(memberInput.getPassword(), BCrypt.gensalt());
        String uuid = UUID.randomUUID().toString();


        Member member = Member.builder()
                .userId(memberInput.getUserId())
                .password(encPassword)
                .uuid(uuid)
                .userName(memberInput.getUserName())
                .userType(memberInput.getUserType())
                .userEmail(memberInput.getUserEmail())
                .build();
        memberRepository.save(member);
        return true;
    }

    @Override
    public boolean findId(FindIdInput findIdInput) {
        Optional<Member> optionalMember = memberRepository.findByUserNameAndEmailAndPhone(findIdInput.getUserName(), findIdInput.getUserEmail(), findIdInput.getPhoneNumber());
        return optionalMember.isPresent();
    }

    @Override
    public boolean resetPassword(ResetPasswordInput resetPasswordInput) {
        Optional<Member> optionalMember = memberRepository.findById(resetPasswordInput.getUserId());
        if(!optionalMember.isPresent()){
            //throw exception cannot find user id
            return false;
        }

        return true;
    }

    @Override
    public boolean updatePassword(String userId, String password) {
        Optional<Member> optionalMember = memberRepository.findById(userId);
        if(!optionalMember.isPresent()){
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }
        Member member = optionalMember.get();
        String encPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        member.setPassword(encPassword);
        memberRepository.save(member);
        return true;
    }

    @Override
    public boolean changeUserInfo(MemberInput memberInput) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
