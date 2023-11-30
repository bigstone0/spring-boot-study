package com.example.musiclist.Dto;

import com.example.musiclist.domain.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ListDto {
    @NotNull
    private long list_id;
    @NotNull
    private long user_id;
    @NotBlank
    private String name;
    @NotNull
    private int size;

    public ListDto(List list) {
        this.list_id = list.getId();
        this.user_id = list.getUser().getId();
        this.name = list.getName();
        this.size = list.getSize();
    }
}
