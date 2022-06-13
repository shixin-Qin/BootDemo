package com.fzm.dynamictest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fzm.dynamictest.mapper.UserMapper;
import com.fzm.dynamictest.po.User;

public interface UserService extends IService<User> {

    void addOne(User user);
}
