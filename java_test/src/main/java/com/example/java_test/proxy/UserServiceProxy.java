package com.example.java_test.proxy;

public class UserServiceProxy implements UserService{

    private UserService target;

    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    @Override
    public void saveUser() {
        System.out.println("开启事务");
        target.saveUser();
        System.out.println("关闭事务");
    }
}
