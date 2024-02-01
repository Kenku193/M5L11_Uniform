package com.example.m5l11_uniform.service;

import com.example.m5l11_uniform.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest1 {

    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
    private final UserService userService = new UserService(userRepository);

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByLoginAndPassword() {
    }
}