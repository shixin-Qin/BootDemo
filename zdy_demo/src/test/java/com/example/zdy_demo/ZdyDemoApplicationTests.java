package com.example.zdy_demo;

import org.example.pojo.SimpleBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZdyDemoApplication.class)
public class ZdyDemoApplicationTests {

    @Autowired
    private SimpleBean simpleBean;

    @Test
    public void name() {
        System.out.println(simpleBean.toString());
    }
}
