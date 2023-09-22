package com.demo.controller;

import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${server.port}")
    private String port;

    @GetMapping("{id}")
    public User queryUserById(@PathVariable("id")Integer id){
        return userService.getById(id);
    }

    @GetMapping("/getOrder/{id}")
    public String getOrders(@PathVariable ("id") Integer id){
        List list = restTemplate.getForObject("http://order-service/order/queryByUserId/" + id, List.class);

        return "port:"+port+"  list:"+list.toString();
    }

}
