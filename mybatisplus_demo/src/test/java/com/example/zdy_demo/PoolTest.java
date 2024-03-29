package com.example.zdy_demo;

import com.example.zdy_demo.service.impl.AppGameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * [一句话描述该类的功能]
 *
 * @author qinshixin
 * @version 1.0.0
 * @createTime 2021/6/9 15
 */
public class PoolTest extends MybatisplusDemoApplicationTests {
    
    @Autowired
    private AppGameServiceImpl appGameService;
    
  /*  @Test
    public void save() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            ArrayList<AppGame> list = new ArrayList<>();
            for (int j = 0; j < 1000; j++) {
                AppGame appGame = new AppGame();
                appGame.setName("ccc");
                list.add(appGame);
            }
            appGameService.saveBatch(list);
        }
        long end = System.currentTimeMillis();
    
       *//* System.out.println("生成对象耗时:" + (endfor - start) / 1000);
        System.out.println("插入耗时:" + (end - endfor) / 1000);*//*
        System.out.println("耗时：" + (end - start));
    }

    @Test
    public void saveNormal() {
        long start = System.currentTimeMillis();
        ArrayList<AppGame> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            AppGame appGame = new AppGame();
            appGame.setName("ccc");
            list.add(appGame);
        }
        long endfor = System.currentTimeMillis();
        appGameService.saveBatch(list);
        long end = System.currentTimeMillis();
    
       *//* System.out.println("生成对象耗时:" + (endfor - start) / 1000);
        System.out.println("插入耗时:" + (end - endfor) / 1000);*//*
        System.out.println("耗时：" + (end - start));
    }
    
    @Test
    public void savePool() {
        long start = System.currentTimeMillis();
        ArrayList<AppGame> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            AppGame appGame = new AppGame();
            appGame.setName("ccc");
            list.add(appGame);
        }
        List<List<AppGame>> listList = ListUtil.partition(list, 1000);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 16, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10000));
        for (List<AppGame> gameList : listList) {
            BatchInsertRunnable runnable = new BatchInsertRunnable(appGameService, gameList);
            threadPoolExecutor.execute(runnable);
        }
        threadPoolExecutor.shutdown();
        while (true) {
            if (threadPoolExecutor.isTerminated()) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) / 1000);
    }
    
    @Test
    public void name20() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }*/
}
