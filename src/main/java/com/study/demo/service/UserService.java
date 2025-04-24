package com.study.demo.service;

import com.study.demo.dto.CreateUserRequestDto;
import com.study.demo.entity.User;
import com.study.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
