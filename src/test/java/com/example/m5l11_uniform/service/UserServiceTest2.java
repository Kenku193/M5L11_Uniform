package com.example.m5l11_uniform.service;

import com.example.m5l11_uniform.entity.User;
import com.example.m5l11_uniform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@RequiredArgsConstructor
@ExtendWith(MockitoExtension.class)
class UserServiceTest2 {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void findById() {
        // Я ПОЛЬЗОВАТЕЛЬ, КОТОРОГО ЯКОБЫ ПОЛУЧИЛИ ИЗ БД
        User buildedUser = User.builder()
                .id(1L)
                .login("buildedLogin")
                .password("buildedPassword")
                .build();

        // Я ВСТАВЛЯЮ ОТВЕТ - buildedUser - В ЗАМОКИРОВАННЫЙ РЕПОЗИТОРИЙ
        Mockito.doAnswer(invocationOnMock -> Optional.of(buildedUser))
                // КОГДА НА МОК-ОБЪЕКТЕ
                .when(userRepository)
                // ВЫЗЫВАЕТСЯ МЕТОД С АРГУМЕНТОМ
                .findById(1L);

        // ВЫЗОВ МЕТОДА
        Optional<User> byId = userService.findById(1L);

        // САМИ ПРОВЕРКИ - ТО ЕСТЬ АССЕРТОВ ПОКА НЕТ НИЖЕ

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