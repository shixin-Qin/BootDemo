package com.example.mybatisplus_demo.service.impl;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.TableInfoHelper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus_demo.mapper.ManMapper;
import com.example.mybatisplus_demo.po.Man;
import com.example.mybatisplus_demo.service.ManService;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

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
        Assert.notEmpty(entityList, "error: entityList must not be empty", new Object[0]);
        Class<?> cls = this.currentModelClass();
        TableInfo tableInfo = TableInfoHelper.getTableInfo(cls);
        Assert.notNull(tableInfo, "error: can not execute. because can not find cache of TableInfo for entity!", new Object[0]);
        String keyProperty = tableInfo.getKeyProperty();
        Assert.notEmpty(keyProperty, "error: can not execute. because can not find column for id from entity!", new Object[0]);
        SqlSession batchSqlSession = this.sqlSessionBatch();
        Throwable var7 = null;
    
        try {
            int i = 0;
    
            for (Man entity : entityList) {
                Object idVal = ReflectionKit.getMethodValue(cls, entity, keyProperty);
                if (!StringUtils.checkValNull(idVal) && !Objects.isNull(this.getById((Serializable)idVal))) {
                    MapperMethod.ParamMap<Man> param = new MapperMethod.ParamMap();
                    param.put("et", entity);
                    batchSqlSession.update(this.sqlStatement(SqlMethod.UPDATE_BY_ID), param);
                } else {
                    batchSqlSession.insert(this.sqlStatement(SqlMethod.INSERT_ONE), entity);
                }
    
                if (i >= 1 && i % batchSize == 0) {
                    batchSqlSession.flushStatements();
                }
            }
            /*for(Iterator var9 = entityList.iterator(); var9.hasNext(); ++i) {
                Man entity = var9.next();
                Object idVal = ReflectionKit.getMethodValue(cls, entity, keyProperty);
                if (!StringUtils.checkValNull(idVal) && !Objects.isNull(this.getById((Serializable)idVal))) {
                    MapperMethod.ParamMap<T> param = new MapperMethod.ParamMap();
                    param.put("et", entity);
                    batchSqlSession.update(this.sqlStatement(SqlMethod.UPDATE_BY_ID), param);
                } else {
                    batchSqlSession.insert(this.sqlStatement(SqlMethod.INSERT_ONE), entity);
                }
            
                if (i >= 1 && i % batchSize == 0) {
                    batchSqlSession.flushStatements();
                }
            }*/
        
            batchSqlSession.flushStatements();
            return true;
        } catch (Throwable var20) {
            var7 = var20;
            throw var20;
        } finally {
            if (batchSqlSession != null) {
                if (var7 != null) {
                    try {
                        batchSqlSession.close();
                    } catch (Throwable var19) {
                        var7.addSuppressed(var19);
                    }
                } else {
                    batchSqlSession.close();
                }
            }
        
        }
    }
}
