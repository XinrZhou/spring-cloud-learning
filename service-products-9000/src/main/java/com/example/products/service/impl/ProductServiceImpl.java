package com.example.products.service.impl;

import com.example.products.mapper.ProductMapper;
import com.example.common.pojo.Products;
import com.example.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Products findById(Integer id) {
        return productMapper.selectById(id);
    }
}
