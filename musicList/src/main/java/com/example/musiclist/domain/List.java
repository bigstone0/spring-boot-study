package com.example.musiclist.domain;

import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "List")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class List {
    @Id
    @Column(name = "list_id", length = 50)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "size", length = 50)
    private Integer size;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
}
