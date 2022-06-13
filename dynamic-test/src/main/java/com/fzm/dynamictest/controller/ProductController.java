package com.fzm.dynamictest.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.fzm.dynamictest.po.Product;
import com.fzm.dynamictest.po.User;
import com.fzm.dynamictest.service.ProductService;
import com.fzm.dynamictest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@DS("dproduct")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(Product product) {
        return productService.save(product);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public boolean modify(Product product) {
        return productService.updateById(product);
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public void addUser(User user) {
        Product product = new Product();
        product.setName("芝士");
        productService.save(product);
        userService.addOne(user);
    }
}
