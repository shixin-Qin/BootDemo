package com.example.redis_demo.service;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class DcService {

    @Autowired
    private RedissonClient redissonClient;

    private RLock lock;

    @PostConstruct
    public void init(){
        RLock rLock = redissonClient.getLock("666");
        lock = rLock;
    }


    public void doSomething(int n) {
        try {
            //进入递归第一件事：加锁
            lock.lock();
            log.info("--------lock()执行后，getState()的值：{} lock.isLocked():{}", lock.getHoldCount(), lock.isLocked());
            log.info("--------递归{}次--------", n);
            if (n <= 2) {
                this.doSomething(++n);
            } else {
                return;
            }
        } finally {
            lock.unlock();
            log.info("--------unlock()执行后，getState()的值：{} lock.isLocked():{}", lock.getHoldCount(), lock.isLocked());
        }
    }
}
