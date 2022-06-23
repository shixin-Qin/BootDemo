package com.example.java_test;

import com.example.java_test.proxy.DataDao;
import com.example.java_test.proxy.UserService;
import com.example.java_test.proxy.UserServiceImpl;
import com.example.java_test.proxy.UserServiceProxy;
import com.example.java_test.proxy.cglb.CglibProxyFactory;
import com.example.java_test.proxy.jdk.ProxyFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class ProxyTest {

    @Test
    public void name1() {
        UserServiceProxy userServiceProxy = new UserServiceProxy(new UserServiceImpl());
        userServiceProxy.saveUser();
    }

    @Test
    void name2() {
        UserService userService = (UserService) new ProxyFactory(new UserServiceImpl()).getProxyInstance();
        userService.saveUser();
    }

    @Test
    void name3() {
        DataDao dataDao = (DataDao) new CglibProxyFactory(new DataDao()).getProxyInstance();
        dataDao.saveData();
    }
}
