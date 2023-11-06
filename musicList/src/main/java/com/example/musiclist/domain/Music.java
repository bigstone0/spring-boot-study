package com.example.musiclist.domain;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Getter
@Setter
@Table(name="Music")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Music {
    @Id
    @Column(name="music_id",length=50)
    private long music_id;

    @Column(name="music_name", length = 50)
    private String music_name;

    @ManyToOne
    @JoinColumn(name="list_id")
    private List list;

    @CreationTimestamp
    private Timestamp created_at;

    @CreationTimestamp
    private Timestamp updated_at;
}
