package com.example.musiclist.Dto;

import com.example.musiclist.domain.Music;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
public class MusicDto {
    private long music_id;
    private String name;
    private long list_id;

    public MusicDto(Music music) {
        this.music_id = music.getId();
        this.name = music.getName();
        this.list_id = music.getList().getId();
    }
}
