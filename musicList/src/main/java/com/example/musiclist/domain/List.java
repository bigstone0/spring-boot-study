package com.example.musiclist.domain;

import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Getter
@Setter
@Table(name="List")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class List {
    @Id
    @Column(name="list_id",length = 50)
    private long list_id;

    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    @Column(name="list_name",length = 50)
    private String list_name;

    @Column(name="list_size",length=50)
    private Integer list_size;

    @CreationTimestamp
    private Timestamp created_at;

    @CreationTimestamp
    private Timestamp updated_at;
}
