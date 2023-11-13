package com.example.musiclist.Dto;

import com.example.musiclist.domain.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ListDto {
    private long list_id;
    private long user_id;
    private String name;
    private int size;

    public ListDto(List list) {
        this.list_id = list.getId();
        this.user_id = list.getUser().getId();
        this.name = list.getName();
        this.size = list.getSize();
    }
}
