package com.example.musiclist.service;

import com.example.musiclist.Dto.UserDto;
import com.example.musiclist.domain.User;
import com.example.musiclist.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    private final EntityManager em;

    public void register(@Valid UserDto userDto) {
        User user = User.builder()
                .id(userDto.getUser_id())
                .pw(userDto.getPw())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .name(userDto.getName())
                .build();
        userRepository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void update(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail());
        user.setPw(userDto.getPw());
        user.setPhone(userDto.getPhone());
        user.setName(userDto.getName());
    }

    public Page<User> userList(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Transactional
    public User login(String loginEmail, String password) {
        User user = userRepository.findByEmail(loginEmail);
        if (user.getPw().equals(password)) {
            return user;
        }
        return null;
    }
}
