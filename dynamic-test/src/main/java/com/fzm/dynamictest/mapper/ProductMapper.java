package com.fzm.dynamictest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fzm.dynamictest.po.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}