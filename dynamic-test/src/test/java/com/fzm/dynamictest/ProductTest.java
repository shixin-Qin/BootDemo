package com.fzm.dynamictest;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.fzm.dynamictest.po.Product;
import com.fzm.dynamictest.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductTest extends DynamicTestApplicationTests{

    @Autowired
    ProductService productService;

    @Test
    @DS("dproduct")
    void name() {
        Product product = new Product();
        product.setName("咖啡豆");
        productService.save(product);
    }
}
