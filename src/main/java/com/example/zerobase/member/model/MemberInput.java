package com.example.zerobase.member.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberInput {
    private String userId;
    private String userType;
    private String userName;
    private String password;
    private String userEmail;
    private String userAddress;

}
