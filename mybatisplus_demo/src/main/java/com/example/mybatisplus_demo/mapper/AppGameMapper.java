package com.example.mybatisplus_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus_demo.po.AppGame;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppGameMapper extends BaseMapper<AppGame> {

}