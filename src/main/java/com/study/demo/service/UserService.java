package com.study.demo.service;

import com.study.demo.dto.CreateUserRequestDto;
import com.study.demo.dto.UserResponseDto;
import com.study.demo.entity.User;
import com.study.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(CreateUserRequestDto requestDto) {
        User user = User.builder()
                .id(requestDto.getId())
                .email(requestDto.getEmail())
                .status(requestDto.isStatus())
                .note(requestDto.getNote())
                .createdBy(requestDto.getCreateBy())
                .build();

      return userRepository.save(user);
    }

    public List<UserResponseDto> getUserList() {
        return userRepository.findAll().stream()
                .map(user -> UserResponseDto.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .status(user.isStatus())
                        .note(user.getNote())
                        .createdBy(user.getCreatedBy())
                        .updatedBy(user.getUpdatedBy())
                        .createdAt(user.getCreatedAt())
                        .updatedAt(user.getUpdatedAt())
                        .build())
                .collect(Collectors.toList());
    }

    // ToDo: ID 없을 때 에러 처리 추가하기
    public Optional<UserResponseDto> getUser(String id) {
        return userRepository.findById(id)
                .map(user -> UserResponseDto.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .status(user.isStatus())
                        .note(user.getNote())
                        .createdBy(user.getCreatedBy())
                        .updatedBy(user.getUpdatedBy())
                        .createdAt(user.getCreatedAt())
                        .updatedAt(user.getUpdatedAt())
                        .build());
    }
}
