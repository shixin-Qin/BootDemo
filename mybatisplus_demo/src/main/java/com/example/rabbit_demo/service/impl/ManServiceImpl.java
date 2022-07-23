package com.example.rabbit_demo.service.impl;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.example.rabbit_demo.mapper.ManMapper;
import com.example.rabbit_demo.po.Man;
import com.example.rabbit_demo.service.ManService;
import org.apache.ibatis.binding.MapperMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ManServiceImpl extends ServiceImpl<ManMapper, Man> implements ManService {
    
    @Override
    @Transactional
    public void bathTest() {
        for (int i = 0; i < 100000; i++) {
            Man man = new Man("哈哈" + i, i);
            save(man);
        }
    }
    
    @Override
    public boolean saveOrUpdateBatchTest(Collection<Man> entityList, int batchSize) {
        TableInfo tableInfo = TableInfoHelper.getTableInfo(this.entityClass);
        Assert.notNull(tableInfo, "error: can not execute. because can not find cache of TableInfo for entity!",
                new Object[0]);
        String keyProperty = tableInfo.getKeyProperty();
        Assert.notEmpty(keyProperty, "error: can not execute. because can not find column for id from entity!",
                new Object[0]);
        return SqlHelper.saveOrUpdateBatch(this.entityClass, this.mapperClass, this.log, entityList, batchSize,
                (sqlSession, entity) -> {
                    Object idVal = ReflectionKit.getFieldValue(entity, keyProperty);
                    return StringUtils.checkValNull(idVal) || CollectionUtils
                            .isEmpty(sqlSession.selectList(this.getSqlStatement(SqlMethod.SELECT_BY_ID), entity));
                }, (sqlSession, entity) -> {
                    MapperMethod.ParamMap<Man> param = new MapperMethod.ParamMap();
                    param.put("et", entity);
                    sqlSession.update(this.getSqlStatement(SqlMethod.UPDATE_BY_ID), param);
                });
    }
}
