package com.example.inovation.demo.controller;

import com.example.inovation.demo.contoller.UserController;
import com.example.inovation.demo.model.User;
import com.example.inovation.demo.service.UserService;
import com.example.inovation.demo.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    Collection<User> userCollection;
    User user;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
        userService = mock(UserService.class);

        userCollection = new ArrayList<>();
        user = new User();
        user.setAdresse("adresse");
        user.setAge("12");
        user.setNom("nom");
        user.setPrenom("prenom");
        user.set_id(BigInteger.valueOf(1));
        userCollection.add(user);
    }

    @Test
    public void getAllUserTest() throws Exception {
        Mockito.when(userService.getAllUsers()).thenReturn((List<User>) userCollection);

       mockMvc.perform(get("http://localhost:8080/api/v1/users"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }
}
