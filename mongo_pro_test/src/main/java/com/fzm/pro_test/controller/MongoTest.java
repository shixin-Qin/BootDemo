package com.fzm.pro_test.controller;

import com.fzm.pro_test.NewsCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongo")
public class MongoTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/one")
    public NewsCode findOne() {
        Query query = new Query(Criteria.where("id").is("5d9c3a00c587a71a78ee4c68"));
        NewsCode one = mongoTemplate.findOne(query, NewsCode.class);
        return one;
    }
}
