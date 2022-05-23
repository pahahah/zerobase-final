package com.example.zerobase.member.service;
import com.example.zerobase.member.model.FindIdInput;
import com.example.zerobase.member.model.MemberInput;
import com.example.zerobase.member.model.ResetPasswordInput;
import org.springframework.security.core.userdetails.UserDetailsService;
public interface MemberService extends UserDetailsService{

    /**
     *회원가입
     */
    boolean register(MemberInput memberInput);

    /**
     * 아이디찾기
     */
    boolean findId(FindIdInput findIdInput);

    /**
     * 비밀번호 변경 요청
     */
    boolean resetPassword(ResetPasswordInput resetPasswordInput);
    /**
     * 비밀번호 요청 및 업데이트
     */
    boolean updatePassword(String userId, String password);
    /**
     * 개인정보 변경
     */
    boolean changeUserInfo(MemberInput memberInput);
}
