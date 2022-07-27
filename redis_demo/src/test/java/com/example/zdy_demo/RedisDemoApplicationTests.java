package com.example.zdy_demo;


import com.example.zdy_demo.service.DcService;
import com.example.zdy_demo.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisDemoApplication.class)
public class RedisDemoApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private DcService dcService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void name1() {
        redisUtil.set("hello","000");
    }


    @Test
    public void name2() {
        dcService.doSomething(1);
    }
}
