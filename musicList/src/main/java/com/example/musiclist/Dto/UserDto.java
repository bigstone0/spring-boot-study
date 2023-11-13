package com.example.musiclist.Dto;

import com.example.musiclist.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long user_id;
    private String pw;
    private String name;
    private String phone;
    private String email;

    public UserDto(User user) {
        this.user_id = user.getId();
        this.pw = user.getPw();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.email = user.getEmail();
    }
}
