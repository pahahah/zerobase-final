package com.example.zerobase.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Member {
    @Id
    private String userId;
    private String uuid;
    private String userType;
    private String userName;
    private String password;
    private String phoneNumber;
    private String userEmail;

    private long studNumber;
    private String studState;
    private String major;
    private boolean matriculationYn;
    private String position;

    private String zipcode;
    private String address;
    private String addressDetail;

    private String job;

    private boolean receiveInfoYn;
    private boolean tuitionYn;
}
