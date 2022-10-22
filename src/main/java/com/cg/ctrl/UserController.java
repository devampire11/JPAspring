package com.cg.ctrl;

import com.cg.bean.User;
import com.cg.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserInterface userInterface;

    @GetMapping("/users")
    public List<User> showAllUser(){
        List<User> list =userInterface.viewUser();
        return  list;
    }

    @PostMapping("/users")
    public User newUser(@RequestBody User user){
        return  userInterface.addUser(user);
    }
    @GetMapping("/users/{userId}")
    public User showById(@PathVariable BigInteger userId){
        return  userInterface.viewUser(userId);
    }
    @PutMapping("/users/{userId}")
    public User updateAccount(@RequestBody User newU,@PathVariable BigInteger userId){
        return userInterface.updateUser(newU,userId);
    }

    public  void deleteUser(@PathVariable BigInteger userId){
        userInterface.deleteUser(userId);
    }



    }
