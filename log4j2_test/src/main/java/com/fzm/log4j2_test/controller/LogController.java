package com.fzm.log4j2_test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/info")
    public void log(){
        logger.info("普通info信息右键单击Windows消息，然后选择“ 系统”。\n" +
                "\n" +
                "如果您使用的不是受支持的版本，则可以考虑升级操作系统。\n" +
                "\n" +
                "如果您使用的是较新的系统，尤其是带有Enterprise and Education的64位Windows 10 Pro（1607周年更新，Build 14393或更高版本），请考虑使用Docker Desktop for Windows。它在Windows上本地运行，因此不需要预先配置的Docker QuickStart shell。它还使用Hyper-V进行虚拟化，因此以下检查虚拟化的说明对于较新的Windows系统而言已过时。Windows的Docker桌面主题中提供了完整安装的先决条件，安装前的基本知识。");
    }

    @RequestMapping("/error")
    public void error(){
        logger.error("严重error信息");
    }

}
