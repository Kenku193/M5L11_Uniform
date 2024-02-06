package com.example.m5l11_uniform.controller;

import com.example.m5l11_uniform.integrations.TestContext;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestContext
@RequiredArgsConstructor
class UserControllerTest {
    private final WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void showAllUsers() throws Exception {
        mockMvc.perform(get("/users/"))
                .andExpectAll(
                        status().isOk()
                );
    }

    @Test
    void apiTest() throws Exception {
        mockMvc.perform(get("/json/9"))
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }
}