package com.example.zdy_demo.controller;

import org.example.annotions.HandleType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * [一句话描述该类的功能]
 *
 * @author qinshixin
 * @version 1.0.0
 * @createTime 2021/12/16 17
 */
@RestController
public class SourceController {

    @HandleType(handle = "select")
    @GetMapping("/source/select/{source_name}")
    public String sourceSelect(@PathVariable("source_name") String sourceName) {
        return "访问source资源";
    }

    @HandleType(handle = "delete")
    @DeleteMapping("/source/delete/{source_name}")
    public String sourceDelete(@PathVariable("source_name") String sourceName) {
        return "删除source资源";
    }

    @GetMapping("/source/heihei/{source_name}")
    public String sourceHeihei(@PathVariable("source_name") String sourceName) {
        return "heihei资源";
    }
}
