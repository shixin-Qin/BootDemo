package com.example.mybatisplus_demo.po;

import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class AppGame {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer appId;

    private String name;

    /**
     * 1=棋牌 2=彩票 3=博彩 4=电玩城 5=捕鱼 6=麻将 7=百家乐 8=牛牛 9=德州 10=扫雷 11=骰子 12=红包 13=红包扫雷 14=老虎机 15=炸金花
     */
    private Integer type;

    /**
     * 1=正常 -1=删除
     */
    private Byte status;

    private LocalDateTime createTime;

    private LocalDateTime lastUpdateTime;
}