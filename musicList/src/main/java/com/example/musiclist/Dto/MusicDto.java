package com.example.musiclist.Dto;

import com.example.musiclist.domain.Music;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
public class MusicDto {
    private long music_id;
    private String music_name;
    private long list_id;

    public MusicDto(Music music){
        this.music_id=music.getMusic_id();
        this.music_name=music.getMusic_name();
        this.list_id=music.getList().getList_id();
    }
}
