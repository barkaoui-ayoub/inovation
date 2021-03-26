package com.example.inovation.demo.service;

import com.example.inovation.demo.dao.UserDao;
import com.example.inovation.demo.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    UserDao userDao;
    @InjectMocks
    UserServiceImpl userService;
    Collection<User> userCollection;
    User user;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

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
    public void getAllUsers(){
        Mockito.when(userDao.findAll()).thenReturn((List<User>) userCollection);
        Collection<User>  result = userService.getAllUsers();
        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(),userCollection.size());
        Mockito.verify(userDao,Mockito.atLeast(1)).findAll();
        Mockito.verify(userDao,Mockito.atLeast(0)).findById(1);

    }

    @Test
    public void createUserTest(){
        Mockito.when(userDao.saveAll(userCollection)).thenReturn(userCollection.stream().collect(Collectors.toList()));
        Collection<User>  result = userService.createUser(userCollection.stream().collect(Collectors.toList()));
        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(),userCollection.size());
        Assert.assertEquals(((List<User>) result).get(0).getNom(),((List<User>) userCollection).get(0).getNom());
    }

    @Test
    public void findUserByIdTest(){
        Mockito.when(userDao.findById(1)).thenReturn(Optional.of(user));
        Optional<User> result = userService.findUserById(1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.get().getNom(),user.getNom());
        Mockito.verify(userDao).findById(Mockito.eq(1));

    }

    @Test
    public void deleleteUserById(){
        userService.deleleteUserById(1);
    }

    @Test
    public void updateUser(){
        userService.updateUser(user);
    }

    @Test
    public void deleteAllUsers(){
        userService.deleteAllUsers();
    }


}
