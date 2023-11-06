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
    private String list_name;
    private int list_size;

    public ListDto(List list){
        this.list_id=list.getList_id();
        this.user_id=list.getUser().getUser_id();
        this.list_name=list.getList_name();
        this.list_size=list.getList_size();
    }
}
