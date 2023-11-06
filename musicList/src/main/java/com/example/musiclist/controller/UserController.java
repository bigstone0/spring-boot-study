package com.example.musiclist.controller;

import com.example.musiclist.Dto.UserDto;
import com.example.musiclist.domain.User;
import com.example.musiclist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class UserController {
    private UserService userService;

    @PostMapping ("/user/register")
    public void register(@ModelAttribute UserDto userDto){
        User user=new User();
        user.setUser_id(userDto.getUser_id());
        user.setUser_pw(userDto.getUser_pw());
        user.setUser_name(userDto.getUser_name());
        user.setUser_phone(userDto.getUser_phone());
        user.setUser_email(userDto.getUser_email());
        userService.register(user);
    }

    @GetMapping("/user/delete")
    public void delete(@RequestParam UserDto userDto){
        User user=new User();
        user.setUser_id(userDto.getUser_id());
        user.setUser_pw(userDto.getUser_pw());
        user.setUser_name(userDto.getUser_name());
        user.setUser_phone(userDto.getUser_phone());
        user.setUser_email(userDto.getUser_email());
        userService.delete(user);
    }

    @GetMapping("/user/update")
    public void update(@RequestParam long id, String name){
        userService.update(id,name);
    }
}
