package com.example.musiclist.Dto;

import com.example.musiclist.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private long user_id;
    private String user_pw;
    private String user_name;
    private String user_phone;
    private String user_email;

    public UserDto(User user){
        this.user_id=user.getUser_id();
        this.user_pw=user.getUser_pw();
        this.user_name=user.getUser_name();
        this.user_phone=user.getUser_phone();
        this.user_email=user.getUser_email();
    }
}
