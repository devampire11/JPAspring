package com.cg.service;

import com.cg.bean.User;
import com.cg.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service("userService")
public class UserImpl implements  UserInterface{
     @Autowired
     UserDao userDao;

    @Transactional
    @Override
    public User addUser(User u) {

        return userDao.save(u);
    }

    @Transactional
    @Override
    public User updateUser(User newAccount, BigInteger userId) {
        Optional<User> optac=userDao.findById(userId);
        User u=optac.get();
        if(u==null){
            //Exception
        }

            u.setUserId(newAccount.getUserId());
            u.setUserName(newAccount.getUserName());
            u.setUserPassword(newAccount.getUserPassword());
            u.setEmail(newAccount.getEmail());
            u.setUserPhone(newAccount.getUserPhone());
            u.setUserType(newAccount.getUserType());
            User u1 = userDao.save(u);

        return  u1;


    }
    @Transactional
    @Override
    public void deleteUser(BigInteger userId) {

        userDao.deleteById(userId);

    }

    @Transactional
    @Override
    public User viewUser(BigInteger userId) {

        Optional<User> o=userDao.findById(userId);
        User user=o.get();
        if(user==null){
            //Exception
        }
        return  user;
    }
    @Transactional
    @Override
    public List<User> viewUser() {
        return userDao.findAll();

    }

    @Override
    public void validateUser(User user) {
        BigInteger phoneNo=user.getUserPhone();
        Pattern p= Pattern.compile("^[1-9][0-9]{9}$");
        Matcher m=p.matcher(phoneNo.toString());
        String email=user.getEmail();
        Pattern p1=Pattern.compile("^[A-Za-z0-9]*@[a-zA-Z]+[.][a-zA-Z]{2,3}$");
        Matcher m1=p1.matcher(email);
        if(!m.find() && !m1.find()){
            //Exception
        }
         else if(!m1.find() && m.find()){
            //Exception
        } else if (m1.find() && !m.find()) {
             //Exception
         }


    }



}
