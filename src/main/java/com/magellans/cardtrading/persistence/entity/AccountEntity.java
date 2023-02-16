package com.magellans.cardtrading.persistence.entity;

import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Getter(AccessLevel.NONE)
    private Integer id;
    private String name;
    private String nickName;
    private String phoneNumber;
    private String email;
    private String password;
    private String appId;
    private String total;
}
