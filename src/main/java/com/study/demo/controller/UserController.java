package com.study.demo.controller;

import com.study.demo.dto.CreateUserRequestDto;
import com.study.demo.dto.UserResponseDto;
import com.study.demo.entity.User;
import com.study.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody @Valid CreateUserRequestDto user) {
        return userService.createUser(user);
    }

    // 목록 조회
    // ToDo : 페이지네이션 및 필터도 하기
    @GetMapping
    public List<UserResponseDto> getUserList() {
        return userService.getUserList();
    }

    // 상세 조회
    @GetMapping("/{id}")
    public Optional<UserResponseDto> getUser(@PathVariable String id) {
        return userService.getUser(id);
    }
}
