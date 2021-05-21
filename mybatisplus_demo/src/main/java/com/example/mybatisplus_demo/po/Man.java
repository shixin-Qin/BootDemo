package com.example.mybatisplus_demo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Man {
    
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;
    
    private String name;
    
    private Integer age;
    
    public Man(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}