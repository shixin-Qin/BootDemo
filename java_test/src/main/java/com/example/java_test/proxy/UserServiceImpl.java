package com.example.java_test.proxy;

public class UserServiceImpl implements UserService{
    @Override
    public void saveUser() {
        System.out.println("保存用户");
    }
}
