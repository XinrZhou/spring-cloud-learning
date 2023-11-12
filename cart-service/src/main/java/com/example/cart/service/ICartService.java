package com.example.cart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.cart.domain.dto.CartFormDTO;
import com.example.cart.domain.po.Cart;
import com.example.cart.domain.vo.CartVO;

import java.util.Collection;
import java.util.List;

public interface ICartService extends IService<Cart> {

    void addItem2Cart(CartFormDTO cartFormDTO);

    List<CartVO> queryMyCarts();

    void removeByItemIds(Collection<Long> itemIds);
}
