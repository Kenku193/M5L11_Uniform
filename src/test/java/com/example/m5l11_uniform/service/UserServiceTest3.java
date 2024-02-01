package com.example.m5l11_uniform.service;

import com.example.m5l11_uniform.entity.User;
import com.example.m5l11_uniform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@RequiredArgsConstructor
@ExtendWith(MockitoExtension.class)
class UserServiceTest3 {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    // Я ПОЛЬЗОВАТЕЛЬ, КОТОРОГО ЯКОБЫ ПОЛУЧИЛИ ИЗ БД
    private User buildedUser;

    @BeforeEach
    void setup(){
    buildedUser = User.builder()
            .id(1L)
            .login("buildedLogin")
            .password("buildedPassword")
            .build();
    }

    @Test
    void findById() {
        // Я ВСТАВЛЯЮ ОТВЕТ - buildedUser - В ЗАМОКИРОВАННЫЙ РЕПОЗИТОРИЙ
        Mockito
                .doAnswer(invocationOnMock -> Optional.of(buildedUser))
                // КОГДА НА МОК-ОБЪЕКТЕ
                .when(userRepository)
                // ВЫЗЫВАЕТСЯ МЕТОД С АРГУМЕНТОМ
                .findById(1L);

        // ВЫЗОВ МЕТОДА
        Optional<User> byId = userService.findById(1L);

        // ПРОВЕРКИ
        Assertions.assertTrue(byId.isPresent());

        Mockito.verify(userRepository, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(userRepository);
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
    void findByLoginAndPassword() {
    }
}