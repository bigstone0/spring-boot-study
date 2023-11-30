package com.example.musiclist.Dto;

import com.example.musiclist.domain.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSignInDto {
    @NotBlank
    private String email;
    @NotBlank
    private String pw;
}
