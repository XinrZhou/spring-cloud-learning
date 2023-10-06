package com.example.page.controller;

import com.example.common.pojo.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("page")
public class PageController {

    /**
     * RestTemplate是SpringMVC的一个类。用来实现Controller调用
     */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("product/{id}")
    public Products getProduct(@PathVariable Integer id) {
        // product模块的controller层
        String url = "http://localhost:9000/products/product/" + id;
        // 获取目标url地址对应请求方法的返回值
        return restTemplate.getForObject(url, Products.class);
    }
}
