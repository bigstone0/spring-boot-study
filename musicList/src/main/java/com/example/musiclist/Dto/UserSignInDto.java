package com.example.musiclist.Dto;

import com.example.musiclist.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserSignInDto {
    private String email;
    private String pw;

    public UserSignInDto(User user) {
        this.pw = user.getPw();
        this.email = user.getEmail();
    }
}
