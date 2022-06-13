package com.example.po;

/**
 * [一句话描述该类的功能]
 *
 * @author qinshixin
 * @version 1.0.0
 * @createTime 2022/2/14 16
 */
public class BooTest {
    
    public static void main(String[] args) {
        Integer falg = 0;
        change(falg);
        System.out.println(falg);
        if (falg == 1) {
            System.out.println(falg);
        }
    }
    
    private static void change(Integer falg) {
        falg = 1;
    }
    
}
