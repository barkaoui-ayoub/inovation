package com.example.inovation.demo.contoller;

import com.example.inovation.demo.model.User;
import com.example.inovation.demo.service.UserService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Method to fetch all users from the db
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<User> getAllUser(){
        System.out.println("=======> : getAllUser");
        logger.debug("Getting all user");
        return  userService.getAllUsers();
    }

    /**
     * Method to fetch user by id.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable(value= "user-id") int id) {
        logger.debug("Getting users with user-id= {}.", id);
        return userService.findUserById(id);
    }

    /**
     * Method to update user by id.
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@PathVariable(value= "id") BigInteger id, @RequestBody User user) {
        logger.debug("Updating user with user-id= {}.", id);
        user.set_id(id);
        userService.updateUser(user);
        return "user record for user-id= " + id + " updated.";
    }

    /**
     * Method to delete user by id.
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable(value= "id") int id) {
        logger.debug("Deleting user with user-id= {}.", id);
        userService.deleleteUserById(id);
        return "user record for user-id= " + id + " deleted.";
    }

    /**
     * Method to delete all users from the db.
     * @return
     */
    @DeleteMapping(value= "/deleteall")
    public String deleteAll() {
        logger.debug("Deleting all users.");
        userService.deleteAllUsers();
        return "All users records deleted.";
    }
}
