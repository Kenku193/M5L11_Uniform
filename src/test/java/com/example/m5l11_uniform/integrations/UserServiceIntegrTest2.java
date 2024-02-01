package com.example.m5l11_uniform.integrations;

import com.example.m5l11_uniform.entity.User;
import com.example.m5l11_uniform.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@TestContext
public class UserServiceIntegrTest2 {

    private final UserService userService;

    @BeforeEach
    void be(){
        // start transaction
    }

    @AfterEach
    void ae() {
        // rollback
    }


    @Test
    void findById() {
        User user = userService.findById(29L).orElseThrow();
        Assertions.assertEquals(29L, user.getId());
        // ПИШЕМ ПРОВЕРКИ НА ДРУГИЕ ПОЛЯ
    }

    @Test
    void save(){
        User savedUser = userService.save(User
                .builder().login("999_login").password("999_password")
                .build());
        Assertions.assertEquals("999_login", savedUser.getLogin());
    }

    @Test
    void findAll(){
        List<User> all = userService.findAll();
        Assertions.assertEquals(6, all.size());
    }

    @Test
    void update(){}

    @Test
    void delete(){
        userService.deleteById(1L);
        List<User> all = userService.findAll();
        Assertions.assertEquals(5, all.size());
    }

    @Test
    @Sql(statements = "delete from users where id=9")
    void deleteById(){
        //userService.deleteById(9L);
        List<User> all = userService.findAll();
        Assertions.assertEquals(5, all.size());
    }


}
