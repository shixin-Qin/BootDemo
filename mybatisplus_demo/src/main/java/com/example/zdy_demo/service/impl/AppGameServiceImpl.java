package com.example.zdy_demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.Data;
import org.springframework.stereotype.Service;
import com.example.zdy_demo.mapper.AppGameMapper;
import com.example.zdy_demo.po.AppGame;
import com.example.zdy_demo.service.AppGameService;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
@Data
public class AppGameServiceImpl extends ServiceImpl<AppGameMapper, AppGame> implements AppGameService {
    
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 16, 2, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10000));
    
}
