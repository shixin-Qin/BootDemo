package com.example.mybatisplus_demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus_demo.po.Man;

import java.util.ArrayList;
import java.util.Collection;

public interface ManService extends IService<Man> {
    
    void bathTest();
    
    boolean saveOrUpdateBatchTest(Collection<Man> entityList, int batchSize);
}
