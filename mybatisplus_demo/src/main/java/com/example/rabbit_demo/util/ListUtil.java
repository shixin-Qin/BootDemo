package com.example.rabbit_demo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * [一句话描述该类的功能]
 *
 * @author qinshixin
 * @version 1.0.0
 * @createTime 2021/6/3 19
 */
public class ListUtil {
    
    public static <T> List<List<T>> partition(final List<T> list, final int size) {
        Integer limit = (list.size() + size - 1) / size;
        List<List<T>> mglist = new ArrayList<List<T>>();
        Stream.iterate(0, n -> n + 1).limit(limit).forEach(i -> {
            mglist.add(list.stream().skip(i * size).limit(size).collect(Collectors.toList()));
        });
        return mglist;
    }
    
}
