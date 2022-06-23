package com.example.redis_demo.run;

import com.example.redis_demo.po.AppGame;
import com.example.redis_demo.service.AppGameService;

import java.util.List;

/**
 * [一句话描述该类的功能]
 *
 * @author qinshixin
 * @version 1.0.0
 * @createTime 2021/6/9 15
 */
public class BatchInsertRunnable implements Runnable {
    
    private AppGameService appGameService;
    
    private List<AppGame> appGameList;
    
    public BatchInsertRunnable(AppGameService appGameService, List<AppGame> appGameList) {
        this.appGameService = appGameService;
        this.appGameList = appGameList;
    }
    
    @Override
    public void run() {
        appGameService.saveBatch(appGameList);
    }
}
