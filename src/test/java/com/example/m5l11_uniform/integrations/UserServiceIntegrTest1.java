package com.example.m5l11_uniform.integrations;

import com.example.m5l11_uniform.entity.User;
import com.example.m5l11_uniform.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceIntegrTest1 {

    @Autowired
    private UserService userService;

    @Test
    void findById() {
        User user = userService.findById(29L).orElseThrow();
        Assertions.assertEquals(29L, user.getId());

        // ПИШЕМ ПРОВЕРКИ НА ДРУГИЕ ПОЛЯ
    }

}
