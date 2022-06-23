package com.example.redis_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.redis_demo.po.Man;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManMapper extends BaseMapper<Man> {

}