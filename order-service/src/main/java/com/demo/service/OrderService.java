package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.pojo.Order;

import java.util.List;

public interface OrderService extends IService<Order> {
    List<Order> queryByUserId(Integer userId);
}
