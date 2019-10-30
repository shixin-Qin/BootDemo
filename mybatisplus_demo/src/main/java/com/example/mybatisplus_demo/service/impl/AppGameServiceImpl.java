package com.example.mybatisplus_demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.example.mybatisplus_demo.mapper.AppGameMapper;
import com.example.mybatisplus_demo.po.AppGame;
import com.example.mybatisplus_demo.service.AppGameService;
@Service
public class AppGameServiceImpl extends ServiceImpl<AppGameMapper,AppGame> implements AppGameService{
}
