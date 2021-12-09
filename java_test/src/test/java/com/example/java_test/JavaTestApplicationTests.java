package com.example.java_test;

import com.example.co.T;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaTestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void name() {

    }
    
    @Test
    void name2() {
        T t = new T(4);
        System.out.println("创建完 i:"+t.getI());
    }
}
