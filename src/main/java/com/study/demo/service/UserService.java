package com.study.demo.service;

import com.study.demo.entity.User;
import com.study.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
