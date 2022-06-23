package com.example.java_test;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * [一句话描述该类的功能]
 *
 * @author qinshixin
 * @version 1.0.0
 * @createTime 2022/6/8 21
 */
@SpringBootTest
public class ListTest {

    @Test
    public void name1() {
        int[] arrs = new int[3];
        arrs[0] = 4;
        arrs[1] = 5;
        System.out.println(arrs.length);
        arrs[2] = 6;

        List<String> arrayList = new ArrayList<>();
        arrayList.add("ee");
        arrayList.add("ee");
        arrayList.add("ee");
        System.out.println(arrayList);
        arrayList.add(1, "999");
        System.out.println(arrayList);
    }

    @Test
    void name2() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("ee");
        arrayList.add("ea");
        arrayList.add("ez");
        System.out.println(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == 1) {
                arrayList.remove(i);
            }
            System.out.println("i:" + i + "...:" + arrayList.get(i));
        }
        System.out.println(arrayList);
    }

    @Test
    void name3() {
        ArrayList<String> list = new ArrayList<>(11);
        list.add("888");
        list.add("888");
        list.add("888");
        list.add("888");
        list.add("888");
        list.add("888");
        list.add("888");
        list.add("888");
        list.add("888");
        list.add("888");
        list.add("888");
        list.add("888");
        System.out.println(list);
        System.out.println(list.size());
    }

    @Test
    void name4() {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        System.out.println(objectObjectHashMap.size());
    }

    @Test
    void name5() {
        int i = 5;
    }
}
