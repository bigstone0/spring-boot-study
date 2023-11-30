package com.example.musiclist.Dto;

import com.example.musiclist.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    @NotNull
    private Long user_id;
    @NotBlank
    private String pw;
    @NotBlank
    private String name;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;

    public UserDto(User user) {
        this.user_id = user.getId();
        this.pw = user.getPw();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.email = user.getEmail();
    }
}
