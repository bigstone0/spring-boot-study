package com.example.musiclist.Dto;

import com.example.musiclist.domain.Music;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class MusicDto {
    @NotNull
    private long music_id;
    @NotBlank
    private String name;
    @NotNull
    private long list_id;

    public MusicDto(Music music) {
        this.music_id = music.getId();
        this.name = music.getName();
        this.list_id = music.getList().getId();
    }
}
