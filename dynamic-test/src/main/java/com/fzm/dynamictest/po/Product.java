package com.fzm.dynamictest.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Product {

    /**
     * 自增id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;
}