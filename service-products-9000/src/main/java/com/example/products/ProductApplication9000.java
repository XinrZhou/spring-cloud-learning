package com.example.products;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.products.mapper")
@SpringBootApplication
public class ProductApplication9000 {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication9000.class, args);
    }
}
