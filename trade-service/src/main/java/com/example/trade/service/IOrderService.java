package com.example.trade.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.trade.domain.dto.OrderFormDTO;
import com.example.trade.domain.po.Order;


public interface IOrderService extends IService<Order> {

    Long createOrder(OrderFormDTO orderFormDTO);

    void markOrderPaySuccess(Long orderId);
}
