package com.cg.bean;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import java.math.BigInteger;
import  javax.persistence.Id;



@Entity
public class User {



    private String userType;

    @Id
    private BigInteger userId;
    private String userName;
    private String userPassword;
    private BigInteger userPhone;
    private String email;


    // unparameterized constructor
    public User() {

    }

    //parameterized constructor
    public User(String userType, BigInteger userId, String userName, String userPassword, BigInteger userPhone,
                String email) {
        super();
        this.userType = userType;
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public BigInteger getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(BigInteger userPhone) {
        this.userPhone = userPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





}
