package com.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.demo.pojo.Order;
import com.demo.service.OrderService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("{id}")
    public Order queryOrderById(@PathVariable("id")Integer id){
        return orderService.getById(id);
    }

    @GetMapping("queryByUserId/{userId}")
    public List<Order> queryOrderByUserId(@PathVariable(name = "userId") Integer userId){
        return orderService.queryByUserId(userId);
    }

}
