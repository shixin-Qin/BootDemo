package com.example.zdy_demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zdy_demo.po.Man;

import java.util.Collection;

public interface ManService extends IService<Man> {
    
    void bathTest();
    
    boolean saveOrUpdateBatchTest(Collection<Man> entityList, int batchSize);
}
