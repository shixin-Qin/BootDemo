package com.example.rabbit_demo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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