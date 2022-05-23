package com.example.zerobase.member.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResetPasswordInput {
    private String userId;
    private String userName;
    private String phoneNumber;
    private String userEmail;

}
