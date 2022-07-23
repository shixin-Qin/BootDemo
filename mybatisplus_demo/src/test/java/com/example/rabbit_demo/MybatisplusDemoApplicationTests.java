package com.example.rabbit_demo;

import com.example.rabbit_demo.po.AppGame;
import com.example.rabbit_demo.service.AppGameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
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

    @Test
    public void name2() {
        AppGame appGame = new AppGame();
        appGame.setName("aa");
        appGameService.save(appGame);
    }

    @Test
    public void name3() {
        AppGame appGame = new AppGame();
        appGame.setId(389);
        appGame.setName("zzzz");
        appGame.setCreateTime(LocalDateTime.now());
        appGameService.updateById(appGame);
    }

    @Test
    public void name4() {
        AppGame byId = appGameService.getById(389);
        System.out.println(byId);
    }
}
