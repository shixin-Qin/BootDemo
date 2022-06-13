package com.fzm.dynamictest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fzm.dynamictest.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}