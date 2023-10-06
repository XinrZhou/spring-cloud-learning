package com.example.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Products {

    @Id
    private long id;
    private String name;
    private  double price;
    private String flag;
    private String goodsDesc;
    private String images;
    private long goodsStock;
    private String goodsType;
}
