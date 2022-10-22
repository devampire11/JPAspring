package com.cg.service;

import com.cg.bean.User;

import java.math.BigInteger;
import java.util.List;

public interface UserInterface {
    public  User addUser(User u);
    public User updateUser(User newAccount, BigInteger userId);
    public void deleteUser(BigInteger userId);
    public User viewUser(BigInteger userId);
    public List<User> viewUser();



    void validateUser(User user);
}
