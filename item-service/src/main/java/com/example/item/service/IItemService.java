package com.example.item.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.api.dto.ItemDTO;
import com.example.api.dto.OrderDetailDTO;
import com.example.item.domain.po.Item;

import java.util.Collection;
import java.util.List;


public interface IItemService extends IService<Item> {

    void deductStock(List<OrderDetailDTO> items);

    List<ItemDTO> queryItemByIds(Collection<Long> ids);
}
