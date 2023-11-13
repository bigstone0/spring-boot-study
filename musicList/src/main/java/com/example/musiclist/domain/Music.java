package com.example.musiclist.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Music")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Music {
    @Id
    @Column(name = "music_id", length = 50)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private List list;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
}
