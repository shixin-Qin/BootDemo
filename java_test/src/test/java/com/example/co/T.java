package com.example.co;

import lombok.Data;

@Data
public class T {

    private int i;

    {
        System.out.println("普通代码块");
        System.out.println("i：" + i);
        i = 2;
        System.out.println("i：" + i);
    }

    public T(int i) {
        System.out.println("构造代码快");
        this.i = i;
        System.out.println("i：" + i);
    }

}
