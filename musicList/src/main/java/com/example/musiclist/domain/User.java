package com.example.musiclist.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Getter
@Setter
@Table(name="User")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @Column(name="user_id",length = 50)
    private Long user_id;

    @Column(name="user_pw",nullable = false,length = 50)
    private String user_pw;

    @Column(name="user_name",nullable = false,length = 50)
    private String user_name;

    @Column(name="user_phone",nullable = false,length = 50)
    private String user_phone;

    @Column(name="user_email",length = 50)
    private String user_email;

    @CreationTimestamp
    private Timestamp created_at;

    @CreationTimestamp
    private Timestamp updated_at;
}
