package com.example.mybatisplus_demo;

import com.example.mybatisplus_demo.po.AppGame;
import com.example.mybatisplus_demo.po.Man;
import com.example.mybatisplus_demo.service.AppGameService;
import com.example.mybatisplus_demo.service.ManService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * [一句话描述该类的功能]
 *
 * @author qinshixin
 * @version 1.0.0
 * @createTime 2021/5/21 10
 */
public class SqlSessionTest extends MybatisplusDemoApplicationTests {
    
    @Autowired
    private ManService manService;
    
    @Autowired
    private AppGameService appGameService;
    
    @Test
    //@Transactional
    public void selectTest() {
        //Man byId = manService.getById(1);
        // System.out.println(byId);
        //Man byId2 = manService.getById(1);
        //System.out.println(byId2);
        
        //AppGame app1 = appGameService.getById(1);
        //System.out.println(app1);
        for (int i = 0; i < 2; i++) {
            manService.getById(i);
        }
    }
    
    @Test
    // @Transactional
    public void insertTest() {
        long start = System.currentTimeMillis();
        manService.bathTest();
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) / 1000);
    }
    
    @Test
    public void insertBatchTest() {
        long start = System.currentTimeMillis();
        ArrayList<Man> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Man man = new Man("哈哈" + i, i);
            list.add(man);
        }
        manService.saveBatch(list);
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) / 1000);
    }
    
    @Test
    @Transactional
    public void updateTest() {
        for (long i = 1; i < 4; i++) {
            Man man = new Man(i, "哈哈", (int) (i + 10));
            manService.updateById(man);
        }
    }
    
    @Test
    public void updateBatchTest() {
        ArrayList<Man> list = new ArrayList<>();
        for (long i = 1; i < 4; i++) {
            Man man = new Man(i, "哈哈", (int) (i + 10));
            list.add(man);
        }
        manService.updateBatchById(list);
    }
    
    @Test
    public void saveupdateBatchTest() {
        ArrayList<Man> list = new ArrayList<>();
        for (long i = 1; i < 6; i++) {
            Man man = new Man(i, "哈哈o", (int) (i + 10));
            list.add(man);
        }
        manService.saveOrUpdateBatchTest(list,list.size());
    }
}
