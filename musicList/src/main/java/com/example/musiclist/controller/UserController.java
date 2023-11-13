package com.example.musiclist.controller;

import com.example.musiclist.Dto.UserDto;
import com.example.musiclist.Dto.UserSignInDto;
import com.example.musiclist.domain.User;
import com.example.musiclist.repository.UserRepository;
import com.example.musiclist.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@OpenAPIDefinition(info = @Info(title = "study 프로젝트 API 명세서", description = "study 프로젝트에 사용되는 API 명세서", version = "v1"))
@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    private final UserRepository userRepository;

    @PostMapping("register")
    public void register(@RequestBody User user) {
        UserDto userDto = new UserDto(user);
        userService.register(userDto);
    }

    @GetMapping("delete")
    public void delete(@RequestParam("id") Long deleteId) {
        userService.delete(deleteId);
    }

    @PutMapping ("update")
    public void update(@RequestBody User user) {
        UserDto userDto = new UserDto(user);
        userService.update(userDto);
    }

    @GetMapping("list")
    public String index(Model model, @PageableDefault(size = 10, sort = "user_id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("userList", userService.userList(pageable));
        return "index";
    }

    @PostMapping("login")
    public String login(@RequestBody UserSignInDto sign, HttpServletRequest request) {
        User user = userService.login(sign.getEmail(), sign.getPw());
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", user);

        return "login";
    }

}
