package com.example.rabbit_demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.rabbit_demo.po.AppGame;
import com.example.rabbit_demo.service.AppGameService;
import com.example.rabbit_demo.service.ManService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    
/*    @Test
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
    }*/
    
    @Test
    public void insertBatchTest() {
        long start = System.currentTimeMillis();
        ArrayList<AppGame> list = new ArrayList<>();
        for (int i = 0; i < 2000000; i++) {
            AppGame appGame = new AppGame();
            appGame.setName("ccc");
            list.add(appGame);
        }
        long endfor = System.currentTimeMillis();
        appGameService.saveBatch(list);
        long end = System.currentTimeMillis();
        
        System.out.println("生成对象耗时:" + (endfor - start) / 1000);
        System.out.println("插入耗时:" + (end - endfor) / 1000);
    }
    
    @Test
    public void insertForTest() {
        long start = System.currentTimeMillis();
        ArrayList<AppGame> list = new ArrayList<>();
        for (int i = 0; i < 200000; i++) {
            AppGame appGame = new AppGame();
            appGame.setName("ccc");
            appGameService.save(appGame);
        }
        long end = System.currentTimeMillis();
        
        System.out.println("插入耗时:" + (end - start) / 1000);
    }
    
    @Test
    public void selectAllTest() {
        long start = System.currentTimeMillis();
        QueryWrapper<AppGame> queryWrapper = new QueryWrapper<>();
        queryWrapper.last("limit 1000000");
        List<AppGame> list = appGameService.list(queryWrapper);
        long end = System.currentTimeMillis();
        System.out.println("size:" + list.size());
        System.out.println("耗时:" + (end - start) / 1000);
        
    }
    
    @Test
    public void updateForTest() {
        long start = System.currentTimeMillis();
        ArrayList<AppGame> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            AppGame appGame = new AppGame();
            appGame.setId(i + 1);
            appGame.setName("ddd");
            appGameService.updateById(appGame);
        }
        long end = System.currentTimeMillis();

        System.out.println("耗时:" + (end - start) / 1000);
    }
    
    @Test
    public void updateListForTest() {
        long start = System.currentTimeMillis();
        ArrayList<AppGame> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            AppGame appGame = new AppGame();
            appGame.setId(i + 1);
            appGame.setName("eee");
            list.add(appGame);
        }
        List<List<AppGame>> partitionList = partition(list, 1500);
        for (List<AppGame> gameList : partitionList) {
            ArrayList<Integer> idList = new ArrayList<>();
            gameList.stream().forEach(one -> idList.add(one.getId()));
            UpdateWrapper<AppGame> updateWrapper = new UpdateWrapper<>();
            updateWrapper.in("id", idList);
            updateWrapper.setSql("status = status + 1");
            appGameService.update(updateWrapper);
        }
        long end = System.currentTimeMillis();
        
        System.out.println("耗时:" + (end - start) / 1000);
    }
    
    public static <T> List<List<T>> partition(final List<T> list, final int size) {
        Integer limit = (list.size() + size - 1) / size;
        List<List<T>> mglist = new ArrayList<List<T>>();
        Stream.iterate(0, n -> n + 1).limit(limit).forEach(i -> {
            mglist.add(list.stream().skip(i * size).limit(size).collect(Collectors.toList()));
        });
        return mglist;
    }
}
