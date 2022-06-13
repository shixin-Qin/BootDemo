package com.fzm.dynamictest.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fzm.dynamictest.mapper.ProductMapper;
import com.fzm.dynamictest.po.Product;
import com.fzm.dynamictest.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
