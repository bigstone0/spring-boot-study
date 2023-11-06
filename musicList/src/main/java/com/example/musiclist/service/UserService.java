package com.example.musiclist.service;

import com.example.musiclist.Dto.UserDto;
import com.example.musiclist.domain.User;
import com.example.musiclist.domain.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    @Transactional
    public User register(User user){
//        validateDuplicateUser(user);
        userRepository.save(user);
        return user;
    }

    @Transactional
    public User delete(User user){
//        invalidateDuplicateUser(user);
        userRepository.deleteById(user.getUser_id());
        return user;
    }

    @Transactional
    public void update(long id, String name){
         userRepository.update(name,id);
    }

//    private void validateDuplicateUser(User user){
//        User findUsers=userRepository.findById(user.getUser_id());
//        if(findUsers.getUser_id().equals(user.getUser_id())){
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }
//    }

//    private void invalidateDuplicateUser(User user){
//        List<User> findUsers=userRepository.findAllByUser_name(user.getUser_name());
//        if(findUsers.isEmpty()){
//            throw new IllegalStateException("존재하지 않는 회원입니다.");
//        }
//    }
}
