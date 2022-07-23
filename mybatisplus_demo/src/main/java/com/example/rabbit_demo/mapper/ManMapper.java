package com.example.rabbit_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.rabbit_demo.po.Man;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManMapper extends BaseMapper<Man> {

}