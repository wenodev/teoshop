package com.demo.demo0612.controller.api;

import com.demo.demo0612.entity.User;
import com.demo.demo0612.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
public class UserApiController {

    private UserService userService;
    // 회원가입 처리
    @PostMapping("/register")
    public User signUp(@RequestBody User user) {
         return userService.saveUser(user);
    }
}
