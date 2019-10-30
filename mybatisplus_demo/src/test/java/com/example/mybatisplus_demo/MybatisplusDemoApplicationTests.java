package com.example.mybatisplus_demo;

import com.example.mybatisplus_demo.po.AppGame;
import com.example.mybatisplus_demo.service.AppGameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisplusDemoApplication.class)
public class MybatisplusDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    AppGameService appGameService;

    @Test
    public void name() {
        List<AppGame> list = appGameService.list();
        System.out.println("mm");
    }
}
