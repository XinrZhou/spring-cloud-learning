package com.example.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.user.domain.dto.LoginFormDTO;
import com.example.user.domain.po.User;
import com.example.user.domain.vo.UserLoginVO;


public interface IUserService extends IService<User> {

    UserLoginVO login(LoginFormDTO loginFormDTO);

    void deductMoney(String pw, Integer totalFee);
}
