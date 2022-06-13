package com.fzm.dynamictest.service.serviceImpl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fzm.dynamictest.mapper.UserMapper;
import com.fzm.dynamictest.po.User;
import com.fzm.dynamictest.service.UserService;
import org.springframework.stereotype.Service;

@Service
@DS("duser")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void addOne(User user) {
        save(user);
    }
}
