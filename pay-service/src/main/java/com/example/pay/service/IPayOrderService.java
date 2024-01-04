package com.example.pay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pay.domain.dto.PayApplyDTO;
import com.example.pay.domain.dto.PayOrderFormDTO;
import com.example.pay.domain.po.PayOrder;

public interface IPayOrderService extends IService<PayOrder> {

    String applyPayOrder(PayApplyDTO applyDTO);

    void tryPayOrderByBalance(PayOrderFormDTO payOrderFormDTO);
}
